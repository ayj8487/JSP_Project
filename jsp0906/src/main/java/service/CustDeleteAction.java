package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustDeleteAction implements CommandProcess{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int custcode = Integer.parseInt(request.getParameter("custcode"));
		
		request.setAttribute("custcode", custcode);
		
		return "custDeleteForm.jsp";
	}

	
	
}
