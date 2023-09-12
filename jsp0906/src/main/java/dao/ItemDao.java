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

import dto.Item;

public class ItemDao {

	private static ItemDao instance;

	private ItemDao() {
	}

	public static ItemDao getInstance() {
		if (instance == null) {
			instance = new ItemDao();
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
	
	// 제품 전체 조회
	public List<Item> itemList () throws SQLException{
		List<Item> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from item order by item_code desc";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Item item = new Item();
				item.setItem_code(rs.getInt("item_code"));
				item.setItem_name(rs.getString("item_name"));
				item.setItem_price(rs.getInt("item_price"));
				item.setItem_kind(rs.getString("item_kind"));
				item.setItem_desc(rs.getString("item_desc"));
				item.setItem_birth(rs.getDate("item_birth"));
				
				list.add(item);
			
			} 
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(rs != null) rs.close();
			if(pstmt != null)pstmt.close();
			if(conn != null) conn.close();
		}
		
		return list;
		
	}


}