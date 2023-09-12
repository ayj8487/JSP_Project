package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;

public class EmpDeletProeAction implements CommandProcess{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("EmpDeletProeAction start ...");
	
		try {
		int empno = Integer.parseInt(request.getParameter("empno"));
		
		EmpDao empDao = EmpDao.getInstance();
		
		int result = empDao.empDelete(empno);
		
		request.setAttribute("result", result);
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return "empDelPro.jsp";
	}

	
}
