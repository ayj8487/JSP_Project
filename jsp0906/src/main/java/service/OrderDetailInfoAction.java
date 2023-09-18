package service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDetailDao;
import dto.OrderDetail;

public class OrderDetailInfoAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		try {

			OrderDetailDao orderDetailDao = OrderDetailDao.getInstance();

			List<OrderDetail> list = orderDetailDao.orderDetailAll();
			request.setAttribute("list", list);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return "orderDetailInfo.jsp";
	}

}
