package service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;
import dto.Emp;

public class EmpList implements CommandProcess{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("EmpList start ...");

		//회원리스트 : 회원 전체 조회 
		
		EmpDao empDao = EmpDao.getInstance();
		
		try {
			
			List<Emp> list = empDao.empList();
			int empCnt = empDao.getEmpCnt();
			
			
			request.setAttribute("list", list);
			request.setAttribute("empCnt", empCnt);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		return "empList.jsp";
	}

	
	
}
