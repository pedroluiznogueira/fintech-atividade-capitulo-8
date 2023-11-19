package fintech.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/usuarios")
public class UsuarioServlet extends HttpServlet {

    @Override
    public void init() {
        System.out.println("UsuarioServlet init...");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String nome = req.getParameter("nome");
        System.out.println("nome: " + nome);
        resp.getWriter().println("working fine...");
    }
}
