package com.tech.blog.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.tech.blog.entities.Message;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		try(PrintWriter out = resp.getWriter())
		{
			HttpSession s = req.getSession();//jsp mai session ka object implicitly milta hai but servlet mai nikalna padta hai
			s.removeAttribute("currentUser");
			Message m = new Message("Logout  Successfully", "success", "alert-success ");
			s.setAttribute("msg", m);
			resp.sendRedirect("login_page.jsp");	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}	
} 
 