package fintech.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fintech.controller.utils.HttpSessionUtils;
import fintech.dao.DespesaDAO;
import fintech.dao.UsuarioDAO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;

@WebServlet("/despesas")
public class DespesaServlet extends HttpServlet {
    private DespesaDAO despesaDAO;
    private UsuarioDAO usuarioDAO;

    @Override
    public void init() {
        despesaDAO = new DespesaDAO();
        usuarioDAO = new UsuarioDAO();
        System.out.println("DespesaServlet init...");
    }

    @Override
    public void destroy() {
        System.out.println("DespesaServlet destroy...");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int idUsuario = HttpSessionUtils.getUsuarioIdUsingHttpSessionCpf(req, usuarioDAO);

        ResultSet getQuantidadeDeDespesasResultSet = despesaDAO.getQuantidadeDeDespesas(idUsuario);

        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode jsonResponse = objectMapper.createObjectNode();

        try {
            if (getQuantidadeDeDespesasResultSet.next()) {
                int despesasCount = getQuantidadeDeDespesasResultSet.getInt("despesas_count");
                jsonResponse.put("count", despesasCount);
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
