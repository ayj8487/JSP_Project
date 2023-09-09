package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

//DBCP(커넥션풀) + 싱글톤
public class EmpDao {

	private static EmpDao instance;

	private EmpDao() {
	}

	public static EmpDao getInstance() {
		if (instance == null) {
			instance = new EmpDao();
		}
		return instance;
	}

	private Connection getConnection() {
		Connection conn = null;

		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/OracleDB");
			conn = ds.getConnection();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return conn;
	}
	
	// 회원 총 인원 count 
	public int getEmpCnt() throws SQLException {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select COUNT(*) from emp";
		
		try {
			conn = getConnection();
			pstmt =conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(rs != null) rs.close();
			if(pstmt != null)pstmt.close();
			if(conn != null)conn.close();
		}
		System.out.println("empCnt : " + result);
		return result;
		
	}
	


}