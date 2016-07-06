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

public class SRSTest {
	public static List<Course> courseCatalog;
	public static ScheduleOfClasses scheduleOfClasses = new ScheduleOfClasses("2016-2");

	public static void main(String[] args) {
		Student s1, s2, s3;
		Course c1, c2, c3, c4, c5;
		Section sec1, sec2, sec3, sec4, sec5, sec6, sec7;

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
		s1.setTranscript(trans1);// s1宸查�塻ec2(c1)锛屽苟鏈塻ec6(CMP999)鍜宻ec7(ART101)鐨勬垚缁�
		Transcript trans2 = td.getTranscriptByStudent(s2);
		s2.setTranscript(trans2);
		Transcript trans3 = td.getTranscriptByStudent(s3);
		s3.setTranscript(trans3);// s2鍜宻3涓烘柊鐢燂紝鏃犳垚缁╁崟鍜岄�夎鏁版嵁

		// 鍒濆鍖� Courses
		CourseDao cd =  dataAcess.createCourseDao();
		courseCatalog = cd.getAllCourses();
		c1 = courseCatalog.get(0);// CMP101
		c2 = courseCatalog.get(1);// OBJ101
		c3 = courseCatalog.get(2);// CMP283
		c4 = courseCatalog.get(3);// CMP999
		c5 = courseCatalog.get(4);// ART101

		// 璁剧疆鍏堜慨椤哄簭
		setPrerequisites(cd, c1);// 鏃犲厛淇绋�
		setPrerequisites(cd, c2);// 鍏堜慨璇剧▼CMP999
		setPrerequisites(cd, c3);// 鍏堜慨璇剧▼OBJ101
		setPrerequisites(cd, c4);// 鍏堜慨璇剧▼CMP283
		setPrerequisites(cd, c5);// 鏃犲厛淇绋�

		// 鍒濆鍖� Sections(Professor瀵硅薄宸茬粡灏佽鍒板搴旂殑Section涓�)
		SectionDao scd =  dataAcess.createSectionDao();
		List<Section> sections = scd.getSectionsByCourse(c1.getCourseNo());// 鏁版嵁搴撲腑宸叉湁涓や釜鏁版嵁
		sec1 = sections.get(0);
		sec2 = sections.get(1);

		sections.clear();
		sections = scd.getSectionsByCourse(c2.getCourseNo());// 鏁版嵁搴撲腑宸叉湁涓や釜鏁版嵁
		sec3 = sections.get(0);
		sec4 = sections.get(1);

		sec5 = scd.getSectionsByCourse(c3.getCourseNo()).get(0);// 涓�涓暟鎹�
		sec6 = scd.getSectionsByCourse(c4.getCourseNo()).get(0);
		sec7 = scd.getSectionsByCourse(c5.getCourseNo()).get(0);

		// 鐢变簬娣诲姞浜嗗厛淇『搴忥紝閲嶆柊涓簊ection瀵硅薄璁剧疆representedCourse灞炴��
		sec1.setRepresentedCourse(c1);
		sec2.setRepresentedCourse(c1);
		sec3.setRepresentedCourse(c2);
		sec4.setRepresentedCourse(c2);
		sec5.setRepresentedCourse(c3);
		sec6.setRepresentedCourse(c4);
		sec7.setRepresentedCourse(c5);

		// 娣诲姞鍙�夌彮娆�
		scheduleOfClasses.addSection(sec1);
		scheduleOfClasses.addSection(sec2);
		scheduleOfClasses.addSection(sec3);
		scheduleOfClasses.addSection(sec4);
		scheduleOfClasses.addSection(sec5);
		scheduleOfClasses.addSection(sec6);
		scheduleOfClasses.addSection(sec7);

		System.out.println("===============================");
		System.out.println("瀛︾敓閫夎寮�濮嬶細");
		System.out.println("===============================");
		System.out.println();

		System.out.println("瀛︾敓 " + s1.getName() + " 灏濊瘯閫夋嫨鐝锛�" + sec1.getRepresentedCourse().getCourseNo() + "-"
				+ sec1.getSectionNo());

		// s1閫夋嫨sec1(c1)锛屾垚鍔�
		EnrollmentStatus status = sec1.enroll(s1);
		reportStatus(status);

		// s1閫夋嫨sec2(c1)锛屽け璐ワ紙宸查�夛級
		attemptToEnroll(s1, sec2);

		// s2閫夋嫨sec2(c1)锛屾垚鍔�
		attemptToEnroll(s2, sec2);

		// s2閫夋嫨sec3(c2)锛屽け璐ワ紝鍏堜慨璇剧▼c4
		attemptToEnroll(s2, sec3);

		// s2閫夋嫨sec7(c5)锛屾垚鍔�
		attemptToEnroll(s2, sec7);
		// s3閫夋嫨sec1(c1)锛屾垚鍔�
		attemptToEnroll(s3, sec1);

		System.out.println("===============================");
		System.out.println("閫夎娴嬭瘯缁撴潫");

		sec1.postGrade(s1, "C+");
		sec1.postGrade(s3, "A");
		sec2.postGrade(s2, "B+");
		sec7.postGrade(s2, "A-");
	}

	// 杩斿洖閫夎缁撴灉
	private static void reportStatus(EnrollmentStatus s) {
		System.out.println("result:" + s.value());
		System.out.println();
	}

	// 閫夎
	private static void attemptToEnroll(Student s, Section sec) {
		System.out.println(
				"瀛︾敓 " + s.getName() + " 灏濊瘯閫夋嫨鐝锛�" + sec.getRepresentedCourse().getCourseNo() + "-" + sec.getSectionNo());
		reportStatus(sec.enroll(s));
	}

	// 璁剧疆鍏堜慨璇剧▼
	private static void setPrerequisites(CourseDao cd, Course c) {
		List<Course> prerequisites = cd.getPrerequisites(c);
		if (prerequisites.size() != 0) {
			c.setPrerequisites(prerequisites);
		}
		prerequisites.clear();
	}
}
