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
import dto.OrderDetail;

public class OrderDetailDao {
	// 주문상세
		private static OrderDetailDao instance;

		private OrderDetailDao() {
		}

		public static OrderDetailDao getInstance() {
			if (instance == null) {
				instance = new OrderDetailDao();
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
		
		// 주문상세 추가
		public int orderDetailInsert(OrderDetail orderDetail) throws SQLException {
			int result = 0;
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "insert into order1_detail values(?,?,?,?,0,?)";

			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, orderDetail.getOrder_date());
				pstmt.setInt(2, orderDetail.getCustcode());
				pstmt.setInt(3, orderDetail.getItem_code());
				pstmt.setString(4, orderDetail.getItem_order_desc());
				pstmt.setInt(5, orderDetail.getItem_count());
				
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} finally {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}
			
			return result;
		}
		// 주문상세 추가 리스트
		public List<OrderDetail> orderDetilList() throws SQLException{
			List<OrderDetail> oderDetailList = new ArrayList<>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "select d.order_date,  c.custcode, c.custname, "
								+ " i.item_name, i.item_code, "
								+ " d.item_order_desc,d.item_count"
						+ " from custom c "
							+ " join order1_detail d  on c.custcode = d.custcode "
							+ " join item i on i.item_code = d.item_code";
			
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					OrderDetail orderDetail = new OrderDetail();
					orderDetail.setOrder_date(rs.getString("order_date"));
					orderDetail.setCustcode(rs.getInt("custcode"));
					orderDetail.setCustname(rs.getString("custname"));
					orderDetail.setItem_name(rs.getString("item_name"));
					orderDetail.setItem_code(rs.getInt("item_code"));
					orderDetail.setItem_order_desc(rs.getString("item_order_desc"));
					orderDetail.setItem_count(rs.getInt("item_count"));
				
					oderDetailList.add(orderDetail);
				}
			
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} finally {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}
			
			return oderDetailList;
		}
		// 주문상세 삭제
		public int orderDetailDel(String order_date, int custcode) throws SQLException {
			int result = 0;
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			String sql = "delete from order1_detail where order_date= ? and custcode = ?";
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, order_date);
				pstmt.setInt(2, custcode);
				
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}finally {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}
			
			return result;
		}
}
