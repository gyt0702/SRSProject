package dao;

import model.ProPassword;

public interface ProPasswordDao {
	ProPassword getProPassword(String Pssn);

	void updatePasswordOfProfessor(String Pssn, String pwd);
}
