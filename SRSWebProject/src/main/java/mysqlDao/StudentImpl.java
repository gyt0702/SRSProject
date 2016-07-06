package mysqlDao;

import java.util.List;

import dao.StudentDao;
import model.Section;
import model.Student;

public class StudentImpl implements StudentDao {

	@Override
	public List<Student> getAllStudents()
	{
		
		return null;
	}

	@Override
	public Student getStudent(String Sssn)
	{
		
		return null;
	}

	@Override
	public List<Section> getEnrolledSections(Student student)
	{
		
		return null;
	}

	@Override
	public void addStudent(Student student)
	{
		
		
	}

	@Override
	public void deleteStudent(Student student)
	{
		
		
	}

	@Override
	public void updateStudent(Student student)
	{
		
	}

	@Override
	public void addEnrolledSection(Student student, int sectionNo)
	{
		
		
	}

	@Override
	public void dropEnrolledSection(Student student, int sectionNo)
	{
	
	}
	
}