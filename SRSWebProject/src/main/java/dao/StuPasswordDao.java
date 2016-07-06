package dao;

import model.StuPassword;

public interface StuPasswordDao {
	StuPassword getStuPassword(String Sssn);

	void updatePasswordOfStudent(String Sssn, String pwd);
}
