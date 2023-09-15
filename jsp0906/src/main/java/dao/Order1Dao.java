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
	// 주문조회 + custom, emp 테이블 join
	public List<Order1> orderList () throws SQLException{
		List<Order1> list = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select o.order_date, c.custcode, c.custname, o.order_desc,  e.emp_name "
				+ "from custom c "
				+ "inner join order1 o  on c.custcode = o.custcode "
				+ "inner join emp e on o.empno = e.empno";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Order1 order1 = new Order1();
				order1.setOrder_date(rs.getString("order_date"));
				order1.setCustcode(rs.getInt("custcode"));
				order1.setCustname(rs.getString("custname"));
				order1.setOrder_desc(rs.getString("order_desc"));
				order1.setEmp_name(rs.getString("emp_name"));	
				
				list.add(order1);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		return list;
	}
	
	// 주문 거래처 내역 
	public Order1 oderSelect(String order_date, int custcode) throws SQLException {
		Order1 order1 = new Order1();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select o.order_date, c.custcode, c.custname,"
						+ " o.order_desc, e.empno, e.emp_name,"
						+ " o.order_status "
					+ "from custom c "
					+ "inner join order1 o on c.custcode = o.custcode "
					+ "inner join emp e on o.empno = e.empno "
					+ "where o.order_date = ? and c.custcode = ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, order_date);
			pstmt.setInt(2, custcode);

			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				order1.setOrder_date(rs.getString("order_date"));
				order1.setCustcode(rs.getInt("custcode"));
				order1.setCustname(rs.getString("custname"));
				order1.setOrder_desc(rs.getString("order_desc"));
				order1.setEmpno(rs.getInt("empno"));
				order1.setEmp_name(rs.getString("emp_name"));
				order1.setOrder_status(rs.getString("order_status"));
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		
		
		return order1;
	}
}
