package fintech.controller;

import fintech.dao.UsuarioDAO;
import fintech.models.Usuario;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/usuarios")
public class UsuarioServlet extends HttpServlet {
    private UsuarioDAO usuarioDAO;

    @Override
    public void init() {
        usuarioDAO = new UsuarioDAO();
        System.out.println("UsuarioServlet init...");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String nome = req.getParameter("nome");
        String cpf = req.getParameter("cpf");
        String senha = req.getParameter("senha");
        String email = req.getParameter("email");
        String emailRecuperacao = req.getParameter("email");

        Usuario usuario = new Usuario(nome, cpf, senha, email, emailRecuperacao);

        usuarioDAO.insert(usuario);

        // @TODO: delegar para um jsp de cadastro feito com sucesso
        resp.getWriter().println("Usuario cadastrado com sucesso");
    }
}
