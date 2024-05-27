package com.tech.blog.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.tech.blog.dao.UserDao;
import com.tech.blog.entities.User;
import com.tech.blog.helper.ConnectionProvider;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@MultipartConfig
public class RegisterServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		try(PrintWriter out = resp.getWriter())
		{	
			String check = req.getParameter("check");
			if(check==null)// matlab ki usna checkbox to check nahi kiya hai
			{
				out.println("Please accept terms and conditions");
			}
			else // bakki ka data ko yaha process karna hai
			{
				// get parameter using the getParameter method of req object
				String name = req.getParameter("user_name");
				String email = req.getParameter("user_email");
				String password = req.getParameter("user_password");
				String gender = req.getParameter("gender");
				String about = req.getParameter("about");
			
				// create user object and set all data to that object
				User user = new User(name, email, password, gender, about);
			
				// creating a Userdao object
				UserDao dao = new UserDao(ConnectionProvider.getConnection());
				if(dao.saveUser(user))
				{
					out.print("done");
				}
				else
				{
					out.println("error occued");
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
