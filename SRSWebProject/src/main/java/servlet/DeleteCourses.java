package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CourseService;


@WebServlet("/DeleteCourses")
public class DeleteCourses extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DeleteCourses() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");

		int count = Integer.parseInt(request.getParameter("count"));
		CourseService cs=new CourseService();
		String courseNoList = request.getParameter("courseNo").substring(1);
		for (int i = 0; i < count; i++) {
			String courseNo = courseNoList.split(",")[i];
			cs.deleteCourse(courseNo);
		}

		response.sendRedirect("CourseList.html");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
