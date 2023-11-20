package fintech.controller;

import fintech.dao.UsuarioDAO;
import fintech.models.Usuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/usuarios/login")
public class LoginServlet extends HttpServlet {
    private UsuarioDAO usuarioDAO;

    @Override
    public void init() {
        usuarioDAO = new UsuarioDAO();
        System.out.println("LoginServlet init...");
    }

    @Override
    public void destroy() {
        System.out.println("LoginServlet destroy...");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String cpf = req.getParameter("cpf");
        String senhaInserida = req.getParameter("senha");

        ResultSet resultSet = usuarioDAO.getByCpf(cpf);

        try {
            if (resultSet.next()) {
                String senhaExistente = resultSet.getString("SENHA");

                if (senhaExistente.equals(senhaInserida)) {
                    req.setAttribute("success", true);
                    resp.sendRedirect(req.getContextPath() + "/pages/home.jsp");
                    HttpSession httpSession = req.getSession();
                    httpSession.setAttribute("cpf", cpf);
                    return;
                } else {
                    req.setAttribute("success", false);
                }
            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/pages/login.jsp");
        requestDispatcher.forward(req, resp);
    }
}
