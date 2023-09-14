package service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomDao;
import dto.Custom;

public class CustInfoAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CustomDao customDao = CustomDao.getInstance();
		try {

			int custcode = Integer.parseInt(request.getParameter("custcode"));

			Custom custom = customDao.custSelect(custcode);
			request.setAttribute("custom", custom);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return "custInfo.jsp";
	}

}
