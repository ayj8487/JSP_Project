package service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomDao;
import dto.Custom;

public class CustomList implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("CustomList start ...");
		
		CustomDao customDao = CustomDao.getInstance();

		try {
			List<Custom> list = customDao.customList();
			
			request.setAttribute("list", list);
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return "customList.jsp";
	}

}
