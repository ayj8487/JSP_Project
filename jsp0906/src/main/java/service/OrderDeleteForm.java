package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OrderDeleteForm implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String order_date = request.getParameter("order_date");
		int custcode =  Integer.parseInt(request.getParameter("custcode"));
		String custname = request.getParameter("custname");
		
		request.setAttribute("order_date", order_date);
		request.setAttribute("custcode", custcode);
		request.setAttribute("custname", custname);

		return "orderDeleteForm.jsp";
	}

}
