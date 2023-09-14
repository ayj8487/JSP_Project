package service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ItemDao;

public class ItemDelProAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int item_code = Integer.parseInt(request.getParameter("item_code"));

			ItemDao itemDao = ItemDao.getInstance();

			int result = itemDao.itemDelete(item_code);
			request.setAttribute("result", result);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return "itemDelPro.jsp";
	}

}
