package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.Custom;

public class CustomDao {
// 거래처
	private static CustomDao instance;

	private CustomDao() {
	}

	public static CustomDao getInstance() {
		if (instance == null) {
			instance = new CustomDao();
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

	// 거래처 전체 조회
	public List<Custom> customList() throws SQLException {
		List<Custom> list = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from custom order by custcode desc";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Custom custom = new Custom();

				custom.setCustcode(rs.getInt("custcode"));
				custom.setCustname(rs.getString("custname"));
				custom.setCust_tel(rs.getString("cust_tel"));
				custom.setCust_gubun(rs.getString("cust_gubun"));
				custom.setCust_ceo(rs.getString("cust_ceo"));

				list.add(custom);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}

		return list;
	}

	// 거래처 등록
	public int customInsert(Custom custom) throws SQLException {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "insert into custom values(CUSTCODE_SEQ.nextval,?,?,?,?)";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, custom.getCustname());	
			pstmt.setString(2, custom.getCust_tel());
			pstmt.setString(3, custom.getCust_gubun());
			pstmt.setString(4, custom.getCust_ceo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}

		return result;
	}
	// 거래처 상세조회
	public Custom custSelect(int custcode) throws SQLException {
		Custom custom = new Custom();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql ="select * from custom where custcode=?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, custcode);

			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				custom.setCustcode(rs.getInt("custcode"));
				custom.setCustname(rs.getString("custname"));
				custom.setCust_tel(rs.getString("cust_tel"));
				custom.setCust_gubun(rs.getString("cust_gubun"));
				custom.setCust_ceo(rs.getString("cust_ceo"));
			}
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		
		return custom;
	}
	
	// 거래처 수정
	public int custUpdate(Custom custom) throws SQLException {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update custom set custname = ?, cust_tel = ?, cust_gubun = ? ,cust_ceo =? where custcode = ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, custom.getCustname());
			pstmt.setString(2, custom.getCust_tel());
			pstmt.setString(3, custom.getCust_gubun());
			pstmt.setString(4, custom.getCust_ceo());
			pstmt.setInt(5, custom.getCustcode());

			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		
		return result;
	}
	// 거래처 삭제
	public int custDel(int custcode) throws SQLException {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete custom where custcode=?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, custcode);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		
		return result;
	}

}
