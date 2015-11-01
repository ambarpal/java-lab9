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

/*
 * @author Ambar Pal 2014012
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
			    response.setContentType("text/html");
			    User curUser = UserPool.getUser(curUid);
			    String curOrder = "";
			    if (curUser != null) curOrder = curUser.getOrder();
			    String htmlString = "<html><head><title></title></head><body><h3>Your OrderID is: " + curUid + "</h3><br><h3>Your Current Order is: " + curOrder + "</h3><br><form method='post' action=\"selectPizza\"><table><tr><td>Double Cheese Margherita:</td><td><input type='radio' name='p1' value='Small'/>Small<input type='radio' name='p1' value='Medium'/>Medium<input type='radio' name='p1' value='Large'/>Large</td></tr><tr><td>Deluxe Veggie:</td><td><input type='radio' name='p2' value='Small'/>Small<input type='radio' name='p2' value='Medium'/>Medium<input type='radio' name='p2' value='Large'/>Large</td></tr><tr><td>Spicy Chicken:</td><td><input type='radio' name='p3' value='Small'/>Small<input type='radio' name='p3' value='Medium'/>Medium<input type='radio' name='p3' value='Large'/>Large</td></tr><tr><td>Paneer Overloaded:</td><td><input type='radio' name='p4' value='Small'/>Small<input type='radio' name='p4' value='Medium'/>Medium<input type='radio' name='p4' value='Large'/>Large</td></tr></table><input type=\"submit\" value=\"Order\"></form></body></html>";
			    respWriter.write(htmlString);
			    // response.sendRedirect("selectPizzaHTML.html");
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			respWriter.close();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter respWriter = response.getWriter();
		try{
			Integer curUid = (Integer)request.getSession().getAttribute("uid");
			if (curUid == null) respWriter.println("You must place an order first");
			else{
				HttpSession hs = request.getSession();
				String order = "";
				String p1 = request.getParameter("p1"); if (p1 != null) order += "<br>Double Cheese Margherita: " + p1;
				String p2 = request.getParameter("p2"); if (p2 != null) order += "<br>Deluxe Veggie: " + p2;
				String p3 = request.getParameter("p3"); if (p3 != null) order += "<br>Spicy Chicken: " + p3;
				String p4 = request.getParameter("p4"); if (p4 != null) order += "<br>Paneer Overloaded: " + p4;
				hs.setAttribute("p1", p1);
				hs.setAttribute("p2", p2);
				hs.setAttribute("p3", p3);
				hs.setAttribute("p4", p4);
				User curUser = UserPool.getUser(curUid);
				if (curUser != null){
					curUser.setOrder(order);
				}
//				respWriter.println("UID: " + curUid);
//				respWriter.println("Order: " + order);
				response.sendRedirect("getDetails");
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			respWriter.close();
		}
	}

}
