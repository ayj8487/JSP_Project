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

import dto.Emp;
// 사원
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

	// 사원 총 인원 count
	public int getEmpCnt() throws SQLException {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select COUNT(*) from emp";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = rs.getInt(1);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		System.out.println("empCnt : " + result);
		return result;

	}

	// 사원 전체 조회
	public List<Emp> empList() throws SQLException {

		List<Emp> list = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from emp order by empno desc";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Emp emp = new Emp();

				emp.setEmpno(rs.getInt("empno"));
				emp.setEmp_name(rs.getString("emp_name"));
				emp.setSal(rs.getInt("sal"));
				emp.setPhone(rs.getString("phone"));

				list.add(emp);
			}
		} catch (Exception e) {
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

	// 사원 등록
	public int empInsert(Emp emp) throws SQLException {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into emp VALUES(EMP_EMPNO_SEQ.nextval,?,?,?)";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, emp.getEmp_name());
			pstmt.setInt(2, emp.getSal());
			pstmt.setString(3, emp.getPhone());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		System.out.println("empInsert result : " + result);
		return result;
	}

	// 사원 상세 조회
	public Emp selectInfo(int empno) throws SQLException {
		Emp emp = new Emp();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from emp where empno = ?";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empno);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				emp.setEmpno(rs.getInt("empno"));
				emp.setEmp_name(rs.getString("emp_name"));
				emp.setSal(rs.getInt("sal"));
				emp.setPhone(rs.getString("phone"));

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());

		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		return emp;
	}

	// 사원 업데이트
	public int empUpdate(Emp emp) throws SQLException {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update emp set emp_name = ?, sal = ? , phone = ? where empno = ?";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, emp.getEmp_name());
			pstmt.setInt(2, emp.getSal());
			pstmt.setString(3, emp.getPhone());
			pstmt.setInt(4, emp.getEmpno());
			
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		System.out.println(result);
		return result;
	}
	// 사원 삭제
	public int empDelete(int empno) throws SQLException {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete emp where empno = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, empno);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
	
		}finally {
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}
		
		return result;
		
	}

}