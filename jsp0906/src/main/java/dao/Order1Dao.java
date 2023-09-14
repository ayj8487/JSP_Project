package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.Order1;

public class Order1Dao {
// 주문
	private static Order1Dao instance;

	private Order1Dao() {
	}

	public static Order1Dao getInstance() {
		if (instance == null) {
			instance = new Order1Dao();
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

	// 주문 등록
	public int insertOrder(Order1 order1) throws SQLException {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into order1 values (?,?,?,?,0)";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, order1.getOrder_date());
			pstmt.setInt(2, order1.getCustcode());
			pstmt.setString(3, order1.getOrder_desc());
			pstmt.setInt(4, order1.getEmpno());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		return result;
	}

}
