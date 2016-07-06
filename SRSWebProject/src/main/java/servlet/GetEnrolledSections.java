package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import service.StudentService;


@WebServlet("/GetEnrolledSections")
public class GetEnrolledSections extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public GetEnrolledSections() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("utf-8");

		Student student=(Student) request.getSession().getAttribute("Student");
		
		PrintWriter out = response.getWriter();
		StudentService ss=new StudentService();
		String jsonData=ss.getEnrolledSections(student);
		out.print(jsonData);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
