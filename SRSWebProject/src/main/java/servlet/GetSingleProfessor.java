package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ProfessorService;


@WebServlet("/GetSingleProfessor")
public class GetSingleProfessor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public GetSingleProfessor() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("utf-8");

		PrintWriter out = response.getWriter();
		ProfessorService ps=new ProfessorService();
		String Pssn=request.getParameter("pssn");
		out.print(ps.getProfessorJSON(Pssn));
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
