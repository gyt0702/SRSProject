package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import service.StudentService;


@WebServlet("/DropSectionServlet")
public class DropSectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public DropSectionServlet() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		int sectionNo=Integer.parseInt(request.getParameter("registered"));
		Student student=(Student) request.getSession().getAttribute("Student");
		
		StudentService ss=new StudentService();
		ss.dropEnrolledSection(student, sectionNo);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
