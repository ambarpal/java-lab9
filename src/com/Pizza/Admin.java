package com.Pizza;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Pizza.models.User;
import com.Pizza.utils.UserPool;

/**
 * Servlet implementation class Admin
 */
@WebServlet("/Admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Admin() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter respWriter = response.getWriter();
		try{
		    response.setContentType("text/html");
		    String htmlString = "<html><head><title>Admin View</title></head><body><h1></h1><table>";
		    for (User u : UserPool.users){
		    	htmlString += "<tr><td>" + u.getUid() + "</td><td>" + u.getOrderStatus() + "</td><td><form method='post' action=\"Admin\"> <input type=\"hidden\" name=\"reqUID\" value=\"" + u.getUid() + "\"> <input type=\"submit\" value=\"Update\"> </form></td></tr>";
		    }
		    htmlString += "</table></body></html>";
		    respWriter.write(htmlString);
		    // response.sendRedirect("selectPizzaHTML.html");
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			respWriter.close();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserPool.getUser(Integer.parseInt(request.getParameter("reqUID"))).incrementOrderStatus();
		doGet(request, response);
	}

}
