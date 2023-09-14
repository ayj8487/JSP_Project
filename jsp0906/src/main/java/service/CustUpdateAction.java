package service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomDao;
import dto.Custom;

public class CustUpdateAction implements CommandProcess{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		CustomDao customDao = CustomDao.getInstance();
		try {
		Custom custom = new Custom();
		
		custom.setCustcode(Integer.parseInt(request.getParameter("custcode")));
		custom.setCustname(request.getParameter("custname"));
		custom.setCust_tel(request.getParameter("cust_tel"));
		custom.setCust_gubun(request.getParameter("cust_gubun"));
		custom.setCust_ceo(request.getParameter("cust_ceo"));
		
		int result = customDao.custUpdate(custom);
		request.setAttribute("result", result);

		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return "custUpdate.jsp";
	}

}
