package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	
	public static void main(String[] args)
	{
		Connection conn = DBUtil.getSqliteConnection();
		// tester.add();
		System.out.println(conn);// ≤‚ ‘¡¥Ω”
	}
	public static Connection getSqliteConnection(){
		String driver="org.sqlite.JDBC";
		String conStr="jdbc:sqlite://e:/srs.db";
		Connection conn=null;
		try{
			Class.forName(driver);
			conn = DriverManager.getConnection(conStr);
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;			
	}

	
	public static Connection getMySqlConnection(){
		String driver="com.mysql.jdbc.Driver";
		String conStr="jdbc:mysql://localhost:3306/SRS-System";
		Connection conn=null;
		try{
			Class.forName(driver);
			conn = DriverManager.getConnection(conStr,"root","root");
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;			
	}
	
}
