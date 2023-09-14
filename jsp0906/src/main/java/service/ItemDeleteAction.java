package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;
import dao.ItemDao;
import dto.Item;

public class ItemDeleteAction implements CommandProcess{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	System.out.println("ItemDeleteAction start ...");
		
	try {
		int item_code = Integer.parseInt(request.getParameter("item_code"));
		String item_name = request.getParameter("item_name");
		
		
		request.setAttribute("item_code", item_code);
		request.setAttribute("item_name", item_name);
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
		return "itemDelete.jsp";
	}

	
	
	
}
