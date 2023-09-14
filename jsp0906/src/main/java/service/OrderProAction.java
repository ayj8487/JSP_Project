package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Order1Dao;
import dto.Order1;

public class OrderProAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		Order1Dao order1Dao = Order1Dao.getInstance();
		try {
			Order1 order1 = new Order1();
			order1.setOrder_date(request.getParameter("order_date"));
			order1.setCustcode(Integer.parseInt(request.getParameter("custcode")));
			order1.setOrder_desc(request.getParameter("order_desc"));
			order1.setEmpno(Integer.parseInt(request.getParameter("empno")));

			int result = order1Dao.insertOrder(order1);

			request.setAttribute("result", result);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return "orderPro.jsp";
	}

}
