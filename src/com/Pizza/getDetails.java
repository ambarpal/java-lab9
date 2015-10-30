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

/**
 * Servlet implementation class getDetails
 */
@WebServlet("/getDetails")
public class getDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter respWriter = response.getWriter();
		try{
			Integer curUid = (Integer)request.getSession().getAttribute("uid");
			if (curUid == null) respWriter.println("You must place an order first");
			else{
				HttpSession hs = request.getSession();
				String order = UserPool.getUser(curUid).getOrder();
				respWriter.println("UID: " + curUid);
				respWriter.println("Order: " + order);
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			respWriter.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
