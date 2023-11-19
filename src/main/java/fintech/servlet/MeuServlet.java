package fintech.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/exemplo")
public class MeuServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("Servlet is running...");
        super.init();
    }

    @Override
    public void destroy() {
        System.out.println("Servlet is destroyed...");
        super.destroy();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().write("Hello world");
    }
}
