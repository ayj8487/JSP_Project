package service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomDao;
import dto.Custom;

public class CustDelProAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			CustomDao customDao = CustomDao.getInstance();
		try {

			int custcode = Integer.parseInt(request.getParameter("custcode"));

			int result = customDao.custDel(custcode);
			request.setAttribute("result", result);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return "custDelPro.jsp";
	}

}
