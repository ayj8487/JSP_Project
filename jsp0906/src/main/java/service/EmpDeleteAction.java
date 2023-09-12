package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmpDeleteAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("EmpDeleteAction start ...");
		
		try {
			int empno = Integer.parseInt(request.getParameter("empno"));
			System.out.println(request.getParameter("empno"));
			
			request.setAttribute("empno", empno);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return "empDelete.jsp";
	}

}
