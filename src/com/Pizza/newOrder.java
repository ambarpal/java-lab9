package com.Pizza;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Pizza.utils.UIDGenerator;
import com.Pizza.utils.UserPool;

/*
 * @author Ambar Pal 2014012
 */
@WebServlet("/newOrder")
public class newOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public newOrder() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs = request.getSession();
		Integer uid = (Integer)hs.getAttribute("uid");
		if (uid == null){
			Integer curUID = UIDGenerator.genUID();
			UserPool.addUser("", "", "", curUID);
			hs.setAttribute("uid", new Integer(curUID));
		}
		else if (uid != null && UserPool.getUser(uid) == null){
			response.setContentType("text/html");
			response.getWriter().println("Old Cookie Remaining: Please <b>refresh the page</b> to place the order again");
			hs.removeAttribute("uid");
			//hs = request.getSession(true);
		}
		else
			response.sendRedirect("selectPizza");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
