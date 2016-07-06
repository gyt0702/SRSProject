package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ProfessorService;


@WebServlet("/DeleteProfessors")
public class DeleteProfessors extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public DeleteProfessors() {
		super();
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");

		int count = Integer.parseInt(request.getParameter("count"));
		ProfessorService ps=new ProfessorService();
		String pssnList = request.getParameter("pssn").substring(1);
		for (int i = 0; i < count; i++) {
			String pssn = pssnList.split(",")[i];
			ps.deleteProfessor(pssn);
		}

		response.sendRedirect("ProfessorList.html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}

}
