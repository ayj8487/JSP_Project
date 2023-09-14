package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ItemDao;
import dto.Item;

public class ItemUpdateAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("ItemUpdateAction start ...");

		try {
			request.setCharacterEncoding("utf-8");
			Item item = new Item();
			
			item.setItem_code(Integer.parseInt(request.getParameter("item_code")));
			item.setItem_name(request.getParameter("item_name"));
			item.setItem_price(Integer.parseInt(request.getParameter("item_price")));
			item.setItem_kind(request.getParameter("item_kind"));
			item.setItem_desc(request.getParameter("item_desc"));
			
			ItemDao itemDao = ItemDao.getInstance();
			int result = itemDao.itemUpdate(item);
			
			request.setAttribute("result", result);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return "itemUpdate.jsp";
	}

}
