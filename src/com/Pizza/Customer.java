package com.Pizza;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * @author Ambar Pal, 2014012
 */
/**
 * Servlet implementation class Customer
 */
@WebServlet(description = "The Customer End", urlPatterns = { "/Customer" })
public class Customer extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Customer() {
        super();
    }
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter respWriter = resp.getWriter();
		try{
			String x = "<html><head><title>Customer</title></head><body><form method='get' action=\"trackOrder\"><input type=\"submit\" value=\"Track\"></form><br><form method='get' action=\"newOrder\"><input type=\"submit\" value=\"New Order\"></form></body></html>";
			respWriter.println(x);
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			respWriter.close();
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
