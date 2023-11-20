package fintech.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fintech.dao.InvestimentoDAO;
import fintech.models.Investimento;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;

@WebServlet("/investimentos")
public class InvestimentoServlet extends HttpServlet {
    private InvestimentoDAO investimentoDAO;

    @Override
    public void init() {
        investimentoDAO = new InvestimentoDAO();
        System.out.println("InvestimentoServlet init...");
    }

    @Override
    public void destroy() {
        System.out.println("InvestimentoServlet destroy...");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tipoInvestimento = req.getParameter("tipo-investimento");
        String descricaoInvestimento = req.getParameter("descricao-investimento");
        Float valorInvestimento = Float.valueOf(req.getParameter("valor-investimento"));
        Date dataInvestimento = Date.valueOf(req.getParameter("data-investimento"));
        Float valorRetorno = Float.valueOf(req.getParameter("valor-retorno"));

        Investimento investimento = new Investimento(tipoInvestimento,
                descricaoInvestimento,
                valorInvestimento,
                dataInvestimento,
                valorRetorno);

        boolean isCreated = investimentoDAO.insert(investimento);

        if (isCreated) {
            req.setAttribute("success", true);
        } else {
            req.setAttribute("success", false);
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/pages/cadastrar-investimento.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // @TODO: pegar do usuario buscado apartir do cpf no HttpSession
        int idUsuario = 1;

        ResultSet getAllInvestimentosResultSet = investimentoDAO.getQuantidadeDeInvestimentos(idUsuario);

        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode jsonResponse = objectMapper.createObjectNode();

        try {
            if (getAllInvestimentosResultSet.next()) {
                int investimentosCount = getAllInvestimentosResultSet.getInt("investimentos_count");
                jsonResponse.put("count", investimentosCount);
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
