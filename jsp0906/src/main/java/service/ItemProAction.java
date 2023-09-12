package service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ItemDao;
import dto.Item;

public class ItemProAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			request.setCharacterEncoding("utf-8");

			Item item = new Item();
			item.setItem_name(request.getParameter("item_name"));
			item.setItem_price(Integer.parseInt(request.getParameter("item_price")));
			item.setItem_kind(request.getParameter("item_kind"));
			item.setItem_desc(request.getParameter("item_desc"));

			ItemDao itemDao = ItemDao.getInstance();

			int result = itemDao.itemInsert(item);
			request.setAttribute("item", item);
			request.setAttribute("result", result);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return "itemPro.jsp";
	}

}
