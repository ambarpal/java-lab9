package com.Pizza;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.Pizza.models.User;
import com.Pizza.utils.UserPool;

/**
 * Servlet implementation class selectPizza
 */
@WebServlet("/selectPizza")
public class selectPizza extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public selectPizza() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter respWriter = response.getWriter();
		try{
			Integer curUid = (Integer)request.getSession().getAttribute("uid");
			if (curUid == null) respWriter.println("You must place an order first");
			else{
			   // response.setContentType("text/html");
			   response.sendRedirect("selectPizzaHTML.html");
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			respWriter.close();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter respWriter = response.getWriter();
		try{
			Integer curUid = (Integer)request.getSession().getAttribute("uid");
			if (curUid == null) respWriter.println("You must place an order first");
			else{
				HttpSession hs = request.getSession();
				String order = "";
				String p1 = request.getParameter("p1"); if (p1 != null) order += " p1: " + p1;
				String p2 = request.getParameter("p2"); if (p2 != null) order += " p2: " + p2;
				String p3 = request.getParameter("p3"); if (p3 != null) order += " p3: " + p3;
				hs.setAttribute("p1", p1);
				hs.setAttribute("p2", p2);
				hs.setAttribute("p3", p3);
				User curUser = UserPool.getUser(curUid);
				if (curUser != null) curUser.setOrder(order);
//				respWriter.println("UID: " + curUid);
//				respWriter.println("Order: " + order);
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			respWriter.close();
		}
	}

}
