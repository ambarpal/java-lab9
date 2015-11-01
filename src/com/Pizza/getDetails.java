package com.Pizza;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Pizza.models.User;
import com.Pizza.utils.UserPool;

/*
 * @author Ambar Pal 2014012
 * @author Palash Bansal 2014072
 */
@WebServlet("/getDetails")
public class getDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public getDetails() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter respWriter = response.getWriter();
		try{
			Integer curUid = (Integer)request.getSession().getAttribute("uid");
			if (curUid == null) respWriter.println("You must place an order first");
			else{
				HttpSession hs = request.getSession();
				User curUser = UserPool.getUser(curUid);
				if (curUser == null)
					respWriter.println("Some internal error occurred");
				else if(curUser != null && curUser.getOrderStatus() == null){
					String order = curUser.getOrder();
					response.setContentType("text/html");
					String htmlString = "<!DOCTYPE html><html><head><meta charset=\"UTF-8\"><title>Contact Details</title></head><body>" + "<h2>UID: " + curUid + "</h2>\n" + "<h2>Order: " + order + "</h2>\n" +"<form method='post' action=\"getDetails\"><table><tr><td>Name*:</td><td> <input type='text' name='name' required/> <br/> </td> </tr><tr><td>Address*:</td><td> <input type='text' name='address' required/> <br/> </td> </tr><tr><td>Mobile Number*:</td><td> <input type='text' name='contact' required/> <br/> </td> </tr><tr><td><input type=\"submit\" value=\"Submit\" /></td></tr></table></form></body></html>";
					respWriter.print(htmlString);
				}
				else if (curUser != null && curUser.getOrderStatus() != null){
					String htmlString = "<!DOCTYPE html><html><head><meta charset=\"UTF-8\"><title>Order Status</title></head><body><h2>Order ID " + curUser.getUid() + "</h2><br><h2>Order: " + curUser.getOrder() + "</h2><br><h3>Name: " + curUser.getName() + "</h3><br><h3>Address:" + curUser.getAddress() + " </h3><br><h3>Contact:"+ curUser.getContact() +" </h3><br><h1>Order Status:"+ curUser.getOrderStatus() +" </h1><br></body></html>";
					respWriter.print(htmlString);
				}
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
			if (curUid == null) respWriter.println("Some Internal Error Occurred(2)");
			else{
				HttpSession hs = request.getSession();
				String name = request.getParameter("name");
				String address = request.getParameter("address");
				String contact = request.getParameter("contact");
				User curUser = UserPool.getUser(curUid);
				if (curUser != null && curUser.getOrderStatus() == null){
					curUser.setName(name);
					curUser.setAddress(address);
					curUser.setContact(contact);
					curUser.setOrderStatus("ordered");
					response.setContentType("text/html");
					String htmlString = "<!DOCTYPE html><html><head><meta charset=\"UTF-8\"><title>Order Status</title></head><body><h2>Order ID " + curUser.getUid() + "</h2><br><h2>Order: " + curUser.getOrder() + "</h2><br><h3>Name: " + curUser.getName() + "</h3><br><h3>Address:" + curUser.getAddress() + " </h3><br><h3>Contact:"+ curUser.getContact() +" </h3><br><h1>Order Status:"+ curUser.getOrderStatus() +" </h1><br></body></html>";
					respWriter.print(htmlString);
				}
				else respWriter.println("User not found");
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			respWriter.close();
		}
	}

}
