package service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomDao;
import dao.EmpDao;
import dto.Custom;
import dto.Emp;

public class OderFormAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("OderFormAction start ...");
		try {

			CustomDao customDao = CustomDao.getInstance();
			EmpDao empDao = EmpDao.getInstance();
			
			List<Custom> customList = customDao.customList();
			List<Emp> empList = empDao.empList();
			
			request.setAttribute("customList", customList);
			request.setAttribute("empList", empList);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return "oderForm.jsp";
	}

}
