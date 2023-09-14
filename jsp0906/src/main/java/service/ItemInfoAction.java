package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ItemDao;
import dto.Item;

public class ItemInfoAction implements CommandProcess{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		System.out.println("ItemInfoAction start ...");
		try {
			request.setCharacterEncoding("utf-8");
			
			int item_code = Integer.parseInt(request.getParameter("item_code"));
			ItemDao itemDao = ItemDao.getInstance();
			Item item = itemDao.selectInfo(item_code);

			request.setAttribute("item", item);
			request.setAttribute("item_code", item_code);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return "itemInfo.jsp";
	}

	
	
}
