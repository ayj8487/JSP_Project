package service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Order1Dao;
import dto.Order1;

public class OrderInfoAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			request.setCharacterEncoding("utf-8");

			String order_date = request.getParameter("order_date");
			int custcode = Integer.parseInt(request.getParameter("custcode"));

			Order1Dao order1Dao = Order1Dao.getInstance();

			Order1 order1 = order1Dao.oderSelect(order_date, custcode);
			request.setAttribute("order1", order1);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return "orderInfo.jsp";
	}

}
