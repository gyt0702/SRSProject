package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Professor;
import service.ProfessorService;


@WebServlet("/UpdateProfessor")
public class UpdateProfessor extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public UpdateProfessor() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		Professor p=new Professor(request.getParameter("professorName"),request.getParameter("pssn"),request.getParameter("title"),request.getParameter("department"));
		ProfessorService ps=new ProfessorService();
		ps.updateProfessor(p);
		response.sendRedirect("ProfessorList.html");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
