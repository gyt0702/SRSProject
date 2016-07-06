package sqliteDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.StuPasswordDao;
import model.Student;
import model.StuPassword;
import util.DBUtil;

public class StuPasswordImpl implements StuPasswordDao {
	@Override
	public StuPassword getStuPassword(String Sssn) {
		StuPassword sp = new StuPassword();
		Connection Conn = DBUtil.getSqliteConnection();
		String sql = "select * from Student where Sssn='" + Sssn + "'";
		try {
			PreparedStatement pstmt = Conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			String pwd = rs.getString("password");
			Student student = new Student(rs.getString("studentName"), Sssn, rs.getString("major"),
			rs.getString("degree"));
			sp = new StuPassword(student, pwd);
			pstmt.close();
			Conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sp;
	}

	@Override
	public void updatePasswordOfStudent(String Sssn, String pwd) {
		Connection conn = DBUtil.getMySqlConnection();
		String sql = "update Student set password='" + pwd + "' where Sssn='" + Sssn + "'";
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("失败" + e.getMessage());
		}
	}
}
