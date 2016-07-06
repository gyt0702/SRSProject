package mysqlDao;

import java.util.HashMap;
import java.util.List;

import dao.SectionDao;
import model.Section;
import model.Student;
import model.TranscriptEntry;

public class SectionImpl implements SectionDao {

	@Override
	public List<Section> getAllSections()
	{
		
		return null;
	}

	@Override
	public Section getSection(int sectionNo)
	{
		
		return null;
	}

	@Override
	public List<Student> getEnrolledStudents(int sectionNo)
	{
		
		return null;
	}

	@Override
	public HashMap<Student, TranscriptEntry> getAssignedGrades(Section section)
	{
		
		return null;
	}

	@Override
	public void addSection(Section section)
	{
		
		
	}

	@Override
	public void deleteSection(Section section)
	{
		
		
	}

	@Override
	public void updateSection(Section section)
	{
		
		
	}

	@Override
	public List<Section> getSectionsByCourse(String courseNo)
	{
		
		return null;
	}
	
}
