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


public class OrderDetailProAction implements CommandProcess{

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
			OrderDetailDao orderDetailDao = OrderDetailDao.getInstance();
			OrderDetail orderDetail = new OrderDetail();
			
			orderDetail.setOrder_date(request.getParameter("order_date"));
			orderDetail.setCustcode(Integer.parseInt(request.getParameter("custcode")));
			orderDetail.setItem_code(Integer.parseInt(request.getParameter("item_code")));
			orderDetail.setItem_order_desc(request.getParameter("item_order_desc"));
			orderDetail.setItem_count(Integer.parseInt(request.getParameter("item_count")));
			
			// 거래처제품 추가등록 실행 Insert
			orderDetailDao.orderDetailInsert(orderDetail);
			
			
			request.setAttribute("item", item);
			request.setAttribute("order1", order1);
			
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return "orderUpdateForm.do";
	}

}
