package com.tech.blog.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.tech.blog.dao.UserDao;
import com.tech.blog.entities.Message;
import com.tech.blog.entities.User;
import com.tech.blog.helper.ConnectionProvider;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		try(PrintWriter out = resp.getWriter())
		{
			String userEmail = req.getParameter("email");
			String userPassword = req.getParameter("password");
			
			UserDao dao = new UserDao(ConnectionProvider.getConnection());
			User u = dao.getUserByEmailAndPassword(userEmail, userPassword);
			
			System.out.println(u);
			
			if(u==null)//error hai koi null aaya hai to
			{
				Message msg = new Message("Invalid details ! Try with another", "error", "alert-danger ");
				HttpSession s = req.getSession();
				s.setAttribute("msg", msg);
				
				
				resp.sendRedirect("login_page.jsp");
			}
			else//in case of login success
			{
				HttpSession s = req.getSession();//session ka object aa gaya
				s.setAttribute("currentUser", u);
				resp.sendRedirect("profile.jsp");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	} 
	
}
