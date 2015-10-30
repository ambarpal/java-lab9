package com.Pizza;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Pizza.utils.UIDGenerator;

/**
 * Servlet implementation class newOrder
 */
@WebServlet("/newOrder")
public class newOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public newOrder() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs = request.getSession();
		Integer uid = (Integer)hs.getAttribute("uid");
		if (uid == null){
			UIDGenerator uidGen = new UIDGenerator();
			hs.setAttribute("uid", new Integer(uidGen.genUID()));
		}
		response.sendRedirect("selectPizza");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
