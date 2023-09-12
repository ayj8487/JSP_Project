package service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ItemDao;
import dto.Item;

public class ItemList implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("ItemList start ... ");
		try {

			ItemDao itemDao = ItemDao.getInstance();

			List<Item> list = itemDao.itemList();
			request.setAttribute("list", list);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return "itemList.jsp";
	}
}
