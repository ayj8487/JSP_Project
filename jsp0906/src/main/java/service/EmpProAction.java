package service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;
import dto.Emp;

public class EmpProAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			request.setCharacterEncoding("utf-8");

			Emp emp = new Emp();
			emp.setEmpno(Integer.parseInt(request.getParameter("empno")));
			emp.setEmp_name(request.getParameter("emp_name"));
			emp.setSal(Integer.parseInt(request.getParameter("sal")));
			emp.setPhone(request.getParameter("phone"));

			EmpDao empDao = EmpDao.getInstance();

			int result = empDao.empInsert(emp);
			
			request.setAttribute("emp", emp);
			request.setAttribute("result", result);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}


		return "empPro.jsp";
	}

}
