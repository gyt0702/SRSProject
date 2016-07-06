package sqliteDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.ProPasswordDao;
import model.Professor;
import model.ProPassword;
import util.DBUtil;

public class ProPasswordImpl implements ProPasswordDao {

	@Override
	public ProPassword getProPassword(String Pssn) {
		ProPassword pp = new ProPassword();
		Connection Conn = DBUtil.getSqliteConnection();
		String sql = "select * from Professor where Pssn='" + Pssn + "'";
		try {
			PreparedStatement pstmt = Conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String pwd = rs.getString("password");
				Professor professor = new Professor(rs.getString("professorName"), rs.getString("Pssn"),
						rs.getString("title"), rs.getString("department"));
				pp = new ProPassword(professor, pwd);
			}
			rs.close();
			pstmt.close();
			Conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pp;
	}

	@Override
	public void updatePasswordOfProfessor(String Pssn, String pwd) {
		Connection conn = DBUtil.getSqliteConnection();
		String sql = "update Professor set password='" + pwd + "' where Pssn='" + Pssn + "'";
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
