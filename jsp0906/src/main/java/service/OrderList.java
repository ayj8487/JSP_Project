package service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Order1Dao;
import dto.Order1;

public class OrderList implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Order1Dao order1Dao = Order1Dao.getInstance();

		try {
			List<Order1> list = order1Dao.orderList();
			request.setAttribute("list", list);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return "orderList.jsp";
	}

}
