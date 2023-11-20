package fintech.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fintech.dao.DespesaDAO;
import fintech.dao.ReceitaDAO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;

@WebServlet("/receitas")
public class ReceitaServlet extends HttpServlet {
    private ReceitaDAO receitaDAO;

    @Override
    public void init() {
        receitaDAO = new ReceitaDAO();
        System.out.println("ReceitaServlet init...");
    }

    @Override
    public void destroy() {
        System.out.println("ReceitaServlet destroy...");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // @TODO: pegar do usuario buscado apartir do cpf no HttpSession
        int idUsuario = 1;

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
