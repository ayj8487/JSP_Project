package service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDetailDao;

public class OrderDetailDelPro implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			String order_date = request.getParameter("order_date");
			int custcode = Integer.parseInt(request.getParameter("custcode"));
			int item_code = Integer.parseInt(request.getParameter("item_code"));
			
			// 주문상세만 삭제 
			OrderDetailDao orderDetailDao = OrderDetailDao.getInstance();
			int result = orderDetailDao.orderDetailDelPro(order_date, custcode, item_code);
			
			request.setAttribute("result", result);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return "orderDetailForm.do";
	}

}
