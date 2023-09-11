package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;
import dto.Emp;

public class EmpInfoAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("EmpInfoAction start ...");
		try {
			request.setCharacterEncoding("utf-8");
			
			int empno = Integer.parseInt(request.getParameter("empno"));
			EmpDao empDao = EmpDao.getInstance();
			Emp emp = empDao.selectInfo(empno);

			request.setAttribute("emp", emp);
			request.setAttribute("empno", empno);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return "empInfo.jsp";
	}

}
