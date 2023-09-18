package service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDetailDao;
import dto.OrderDetail;

public class OrderDetailInfoAction implements CommandProcess{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		OrderDetailDao orderDetailDao = OrderDetailDao.getInstance();
		
		List<OrderDetail> list = orderDetailDao.orderDetailAll();
		
		request.setAttribute("list", list);
		
		return "orderDetailInfo.jsp";
	}

}
