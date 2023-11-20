package fintech.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fintech.controller.utils.HttpSessionUtils;
import fintech.dao.DespesaDAO;
import fintech.dao.UsuarioDAO;
import fintech.models.Despesa;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idUsuario = HttpSessionUtils.getUsuarioIdUsingHttpSessionCpf(req, usuarioDAO);
        String categoriaDespesa = req.getParameter("categoria-gasto");
        String descricaoDespesa = req.getParameter("descricao-gasto");
        Float valorDespesa = Float.valueOf(req.getParameter("valor-gasto"));

        Despesa despesa = new Despesa(idUsuario,
                categoriaDespesa,
                descricaoDespesa,
                valorDespesa);

        boolean isCreated = despesaDAO.insert(despesa);

        if (isCreated) {
            req.setAttribute("success", true);
        } else {
            req.setAttribute("success", false);
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/pages/cadastrar-gasto.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int idUsuario = HttpSessionUtils.getUsuarioIdUsingHttpSessionCpf(req, usuarioDAO);

        String typeParam = req.getParameter("type");
        if ("count".equals(typeParam)) {
            getQuantidadeDeDespesas(resp, idUsuario);
        } else {
            getAllDespesas(resp, idUsuario);
        }
    }

    private void getAllDespesas(HttpServletResponse resp, int idUsuario) throws IOException {
        ResultSet despesasResultSet = despesaDAO.getDespesas(idUsuario);
        List<Despesa> despesasList = new ArrayList<>();

        try {
            while (despesasResultSet.next()) {
                Despesa despesa = new Despesa(
                        idUsuario,
                        despesasResultSet.getString("categoria"),
                        despesasResultSet.getString("descricao"),
                        despesasResultSet.getFloat("valor")
                );
                despesasList.add(despesa);
            }

            ObjectMapper objectMapper = new ObjectMapper();
            String jsonString = objectMapper.writeValueAsString(despesasList);

            resp.setContentType("application/json");
            resp.getWriter().write(jsonString);

        } catch (SQLException e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Internal Server Error");
        }
    }

    private void getQuantidadeDeDespesas(HttpServletResponse resp, int idUsuario) throws IOException {
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
