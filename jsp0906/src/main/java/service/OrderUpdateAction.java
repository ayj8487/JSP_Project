package service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ItemDao;
import dao.Order1Dao;
import dao.OrderDetailDao;
import dto.Item;
import dto.Order1;
import dto.OrderDetail;

public class OrderUpdateAction implements CommandProcess{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			request.setCharacterEncoding("utf-8");
			
			String order_date = request.getParameter("order_date");
			int custcode = Integer.parseInt(request.getParameter("custcode"));
			
			// 주문 거래처 내역
			Order1Dao order1Dao = Order1Dao.getInstance();
			Order1 order1 = order1Dao.oderSelect(order_date, custcode);
			
			// 주문 상세 입력(제품리스트)
			ItemDao itemDao = ItemDao.getInstance();
			List<Item>  item = itemDao.itemList();
			
			// 주문 상세리스트
			OrderDetailDao detailDao = OrderDetailDao.getInstance();
			List<OrderDetail> list = detailDao.orderInfoList(order_date,custcode);
			
			
			request.setAttribute("order_date", order_date);
			request.setAttribute("custcode", custcode);
			
			request.setAttribute("order1", order1);
			request.setAttribute("item", item);
			request.setAttribute("list", list);
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return "orderDetailForm.jsp";
	}

}
