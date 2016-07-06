package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.SectionService;


@WebServlet("/GetAllSections")
public class GetAllSections extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public GetAllSections() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("utf-8");

		String courseNo=request.getParameter("courseNo");
		PrintWriter out = response.getWriter();
		SectionService ss=new SectionService();
		String jsonData=ss.getAllSectionsJSON(courseNo);
		out.print(jsonData);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
