package fintech.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fintech.controller.utils.HttpSessionUtils;
import fintech.dao.ReceitaDAO;
import fintech.dao.UsuarioDAO;
import fintech.models.Receita;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;

@WebServlet("/receitas")
public class ReceitaServlet extends HttpServlet {
    private ReceitaDAO receitaDAO;
    private UsuarioDAO usuarioDAO;

    @Override
    public void init() {
        receitaDAO = new ReceitaDAO();
        usuarioDAO = new UsuarioDAO();
        System.out.println("ReceitaServlet init...");
    }

    @Override
    public void destroy() {
        System.out.println("ReceitaServlet destroy...");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idUsuario = HttpSessionUtils.getUsuarioIdUsingHttpSessionCpf(req, usuarioDAO);
        String tipoRecebimento = req.getParameter("tipo-recebimento");
        String descricaoRecebimento = req.getParameter("descricao-recebimento");
        Float valorRecebimento = Float.valueOf(req.getParameter("valor-recebimento"));

        Receita receita = new Receita(idUsuario,
                tipoRecebimento,
                descricaoRecebimento,
                valorRecebimento);

        boolean isCreated = receitaDAO.insert(receita);

        if (isCreated) {
            req.setAttribute("success", true);
        } else {
            req.setAttribute("success", false);
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/pages/cadastrar-recebimento.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int idUsuario = HttpSessionUtils.getUsuarioIdUsingHttpSessionCpf(req, usuarioDAO);

        ResultSet getQuantidadeDeReceitasResultSet = receitaDAO.getQuantidadeDeReceitas(idUsuario);

        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode jsonResponse = objectMapper.createObjectNode();

        try {
            if (getQuantidadeDeReceitasResultSet.next()) {
                int receitasCount = getQuantidadeDeReceitasResultSet.getInt("receitas_count");
                jsonResponse.put("count", receitasCount);
            } else {
                jsonResponse.put("count", 0);
            }

            String jsonString = jsonResponse.toString();
            resp.setContentType("application/json");
            resp.getWriter().write(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Internal Server Error");
        }
    }
}
