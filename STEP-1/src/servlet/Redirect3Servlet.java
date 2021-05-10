package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/redirect3")
public class Redirect3Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public Redirect3Servlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(" I AM REDIRECT3 SERVLET");
        response.sendRedirect("redirect.html");
    }
}
