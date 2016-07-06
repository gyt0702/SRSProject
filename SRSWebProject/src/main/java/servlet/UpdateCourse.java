package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Course;
import service.CourseService;


@WebServlet("/UpdateCourse")
public class UpdateCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UpdateCourse() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		Course c=new Course(request.getParameter("courseNo"),request.getParameter("courseName"),Double.parseDouble(request.getParameter("credits")));
		CourseService cs=new CourseService();
		
		String preCourseNo=request.getParameter("prerequisite");
		cs.updateCourse(c,preCourseNo);
		response.sendRedirect("CourseList.html");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
