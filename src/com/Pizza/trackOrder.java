package com.Pizza;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Pizza.models.User;
import com.Pizza.utils.UserPool;

@WebServlet("/trackOrder")
public class trackOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public trackOrder() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String x = "<html><head><title>Track Order</title></head><body><br><form method='post' action=\"trackOrder\"><input type=\"text\" name=\"uidReq\"><input type=\"submit\" value=\"Query\"></form></body></html>";
		response.getWriter().write(x);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u = UserPool.getUser(Integer.parseInt(request.getParameter("uidReq")));
		if (u != null)
			response.getWriter().write(u.getOrderStatus());
	}

}
