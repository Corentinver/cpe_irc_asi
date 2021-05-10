package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.PoneyDAO;
import model.PoneyBean;


@WebServlet("/byName")
public class RedirectByNameServlet extends HttpServlet {
	private static final String NPONEY = "nponey";
	private static final String NDAO = "DAO";
	private static final long serialVersionUID = 1L;
	private PoneyDAO dao;
       
    public RedirectByNameServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getDao();
		PoneyBean randPoney=this.dao.getPoneyByName(request.getParameter("name"));
		request.setAttribute(NPONEY, randPoney);
		this.getServletContext().getRequestDispatcher( "/WEB-INF/displayByName.jsp" ).forward( request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		//DO NOTHING
	}
	
	public void getDao(){
		if(this.getServletContext().getAttribute(NDAO)!=null){
			this.dao=(PoneyDAO)this.getServletContext().getAttribute(NDAO);
		}else{
			this.dao=new PoneyDAO();
			this.getServletContext().setAttribute(NDAO,this.dao);
		}
	}
}
