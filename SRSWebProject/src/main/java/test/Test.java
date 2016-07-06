package test;

import java.util.List;

import dao.CourseDao;
import dao.SectionDao;
import dao.StudentDao;
import dao.TranscriptDao;
import dao.dataAcess;
import model.Course;
import model.EnrollmentStatus;
import model.ScheduleOfClasses;
import model.Section;
import model.Student;
import model.Transcript;

public class Test {
	public static List<Course> courseCatalog;
	public static ScheduleOfClasses scheduleOfClasses = new ScheduleOfClasses("2016-2");

	public static void main(String[] args) {
		Student s1, s2, s3;
		Course c1, c2;
		Section sec1, sec2, sec3;

		StudentDao sd = dataAcess.createStudentDao();
		List<Student> students = sd.getAllStudents();
		s1 = students.get(0);
		s2 = students.get(1);
		s3 = students.get(2);

		List<Section> enrolledSections = sd.getEnrolledSections(s1);
		s1.setAttends(enrolledSections);
		enrolledSections.clear();
		enrolledSections = sd.getEnrolledSections(s2);
		s2.setAttends(enrolledSections);
		enrolledSections.clear();
		enrolledSections = sd.getEnrolledSections(s3);
		s3.setAttends(enrolledSections);

		TranscriptDao td =  dataAcess.createTranscriptDao();
		Transcript trans1 = td.getTranscriptByStudent(s1);
		s1.setTranscript(trans1);
		Transcript trans2 = td.getTranscriptByStudent(s2);
		s2.setTranscript(trans2);
		Transcript trans3 = td.getTranscriptByStudent(s3);
		s3.setTranscript(trans3);

		CourseDao cd =  dataAcess.createCourseDao();
		courseCatalog = cd.getAllCourses();
		c1 = courseCatalog.get(0);
		c2 = courseCatalog.get(1);

		SectionDao scd =  dataAcess.createSectionDao();
		List<Section> sections = scd.getSectionsByCourse(c1.getCourseNo());
		sec1 = sections.get(0);
		sec2 = sections.get(1);

		sections.clear();
		sections = scd.getSectionsByCourse(c2.getCourseNo());
		sec3 = sections.get(0);
		
		sec1.setRepresentedCourse(c1);
		sec2.setRepresentedCourse(c1);
		sec3.setRepresentedCourse(c2);

		
		scheduleOfClasses.addSection(sec1);
		scheduleOfClasses.addSection(sec2);
		scheduleOfClasses.addSection(sec3);
		
		System.out.println("aa");
		System.out.println();

		System.out.println(" aa " + s1.getName() + " aaaa" + sec1.getRepresentedCourse().getCourseNo() + "-"
				+ sec1.getSectionNo());

		


		System.out.println("aa");
		System.out.println("aa");

		sec1.postGrade(s1, "C+");
		sec1.postGrade(s3, "A");
		sec2.postGrade(s2, "B+");

	}
}

	
