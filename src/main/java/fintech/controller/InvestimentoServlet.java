package fintech.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fintech.dao.InvestimentoDAO;
import fintech.dao.UsuarioDAO;
import fintech.models.Investimento;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/investimentos")
public class InvestimentoServlet extends HttpServlet {
    private InvestimentoDAO investimentoDAO;
    private UsuarioDAO usuarioDAO;

    @Override
    public void init() {
        investimentoDAO = new InvestimentoDAO();
        usuarioDAO = new UsuarioDAO();
        System.out.println("InvestimentoServlet init...");
    }

    @Override
    public void destroy() {
        System.out.println("InvestimentoServlet destroy...");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idUsuario = getLoggedUserId(req);

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

        boolean isCreated = investimentoDAO.insert(investimento, idUsuario);

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
        int idUsuario = getLoggedUserId(req);

        String typeParam = req.getParameter("type");

        if ("count".equals(typeParam)) {
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
        } else {
            ResultSet investimentosResultSet = investimentoDAO.getInvestimentos(idUsuario);

            List<Investimento> investimentosList = new ArrayList<>();

            try {
                while (investimentosResultSet.next()) {
                    Investimento investimento = new Investimento(
                            investimentosResultSet.getString("tipo"),
                            investimentosResultSet.getString("descricao"),
                            investimentosResultSet.getFloat("valor_investido"),
                            investimentosResultSet.getDate("data_investimento"),
                            investimentosResultSet.getFloat("retorno_estimado")
                    );
                    investimentosList.add(investimento);
                }

                ObjectMapper objectMapper = new ObjectMapper();
                String jsonString = objectMapper.writeValueAsString(investimentosList);

                resp.setContentType("application/json");
                resp.getWriter().write(jsonString);

            } catch (SQLException e) {
                e.printStackTrace();
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Internal Server Error");
            }
        }
    }

    private int getLoggedUserId(HttpServletRequest req) {
        HttpSession httpSession = req.getSession();
        String loggedUserCpf = (String) httpSession.getAttribute("cpf");
        ResultSet getByCpfResultSet = usuarioDAO.getByCpf(loggedUserCpf);

        try {
            if (getByCpfResultSet.next()) {
                return getByCpfResultSet.getInt("ID");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // Caso o fluxo de registro nao seja seguido, para evitar erros em tempo de execucao
        // retornando um id de usuario padrao
        return 1;
    }
}
