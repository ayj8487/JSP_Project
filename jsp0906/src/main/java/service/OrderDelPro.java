package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Order1Dao;
import dao.OrderDetailDao;

public class OrderDelPro implements CommandProcess{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
		String order_date = request.getParameter("order_date");
		int custcode =  Integer.parseInt(request.getParameter("custcode"));
		System.out.println(order_date);
		System.out.println(custcode);
		
		OrderDetailDao orderDetailDao = OrderDetailDao.getInstance();
		int orderDetilDel = orderDetailDao.orderDetailDel(order_date,custcode);
		
		Order1Dao order1Dao  = Order1Dao.getInstance();
		int orderDel = order1Dao.orderDel(order_date, custcode);
		
		request.setAttribute("orderDel", orderDel);
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return "order1List.do";
	}

}
