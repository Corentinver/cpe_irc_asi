package servlet;

import java.io.IOException;
import java.util.Map.Entry;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/redirect5")
public class Redirect5Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public Redirect5Servlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("redirect5");
        for( Entry<String, String[]> att_entry : request.getParameterMap().entrySet()) {
            System.out.println( "["+att_entry.getKey()+"]:"+att_entry.getValue()[0]);
        }
        
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("redirect.html");
        requestDispatcher.forward(request, response);
    }
}
