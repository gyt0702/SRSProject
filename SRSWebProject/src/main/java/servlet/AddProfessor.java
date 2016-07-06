package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ProfessorService;

@WebServlet("/AddProfessor")
public class AddProfessor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AddProfessor() {
        super();
       
    }

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		ProfessorService ps=new ProfessorService();
		ps.addProfessor(request.getParameter("professorName"),request.getParameter("pssn"),request.getParameter("title"),request.getParameter("department"));
		
		response.sendRedirect("ProfessorIndex.html");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
