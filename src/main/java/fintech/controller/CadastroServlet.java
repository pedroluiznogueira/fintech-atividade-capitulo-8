package fintech.controller;

import fintech.dao.UsuarioDAO;
import fintech.models.Usuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/usuarios/cadastro")
public class CadastroServlet extends HttpServlet {
    private UsuarioDAO usuarioDAO;

    @Override
    public void init() {
        usuarioDAO = new UsuarioDAO();
        System.out.println("CadastroServlet init...");
    }

    @Override
    public void destroy() {
        System.out.println("CadastroServlet destroy...");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String nome = req.getParameter("nome");
        String cpf = req.getParameter("cpf");
        String senha = req.getParameter("senha");
        String email = req.getParameter("email");
        String emailRecuperacao = req.getParameter("email");

        Usuario usuario = new Usuario(nome, cpf, senha, email, emailRecuperacao);

        boolean isCreated = usuarioDAO.insert(usuario);

        if (isCreated) {
            req.setAttribute("success", true);
        } else {
            req.setAttribute("success", false);
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/pages/cadastro.jsp");
        requestDispatcher.forward(req, resp);
    }
}
