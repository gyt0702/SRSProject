package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CourseService;


@WebServlet("/AddCourse")
public class AddCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AddCourse() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("utf-8");

		PrintWriter out = response.getWriter();
		
		CourseService cs=new CourseService();
		String courseNo=request.getParameter("courseNo");
		String courseName=request.getParameter("courseName");
		double credits=Double.parseDouble(request.getParameter("credits"));
		String preCourseNo=request.getParameter("prerequisite");
		String result=cs.addCourseResult(courseNo,courseName,credits,preCourseNo);
		
		out.print(result);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
