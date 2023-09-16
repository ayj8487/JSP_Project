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

public class OrderDetailFormAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			request.setCharacterEncoding("utf-8");
			Order1Dao order1Dao = Order1Dao.getInstance();

			String order_date = request.getParameter("order_date");
			int custcode = Integer.parseInt(request.getParameter("custcode"));

			Order1 order1 = order1Dao.oderSelect(order_date, custcode);
			
			ItemDao itemDao = ItemDao.getInstance();
			
			List<Item>  item = itemDao.itemList();
			
			
			request.setAttribute("item", item);
			request.setAttribute("order1", order1);
			
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return "orderDetailForm.jsp";
	}

}
