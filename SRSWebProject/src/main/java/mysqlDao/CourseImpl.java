package mysqlDao;


import java.util.List;

import dao.CourseDao;
import model.Course;
import model.Section;

public class CourseImpl implements CourseDao {

	@Override
	public List<Course> getAllCourses()
	{
		
		return null;
	}

	@Override
	public Course getCourse(String courseNo)
	{
		
		return null;
	}

	@Override
	public List<Section> getAllOfferedAsSection(Course course)
	{
		
		return null;
	}

	@Override
	public List<Course> getPrerequisites(Course course)
	{
		
		return null;
	}

	@Override
	public void addCourse(Course course, String preCourseNo)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCourse(String courseNo)
	{
		
	}

	@Override
	public void updateCourse(Course course)
	{
		
		
	}

	@Override
	public void addPrerequisite(String courseNo, String preCourseNo)
	{
		
		
	}

	@Override
	public void updatePrerequisite(Course course, String preCourseNo)
	{
		
		
	}
	
	
}
