package com.tech.blog.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import com.tech.blog.dao.UserDao;
import com.tech.blog.entities.Message;
import com.tech.blog.entities.User;
import com.tech.blog.helper.ConnectionProvider;
import com.tech.blog.helper.Helper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

@MultipartConfig //to inform servlet that ther can be multiple types of data 
public class EditServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		try(PrintWriter out = resp.getWriter())
		{
			// fetch all the data required for the form 
			String userEmail = req.getParameter("user_email");
			String userName = req.getParameter("user_name");
			String userPassword = req.getParameter("user_password");
			String userAbout = req.getParameter("user_about");
			Part part = req.getPart("image");
			String imageName = part.getSubmittedFileName();
			
		 	// get the user from the session
			HttpSession s = req.getSession();
			User user = (User)s.getAttribute("currentUser");
			user.setEmail(userEmail);
			user.setName(userName);
			user.setPassword(userPassword);
			user.setAbout(userAbout);
			String oldFile = user.getProfile(); 
			user.setProfile(imageName);
			
			// upadte database
			UserDao userDao = new UserDao(ConnectionProvider.getConnection());
			boolean ans = userDao.updateUser(user);
			if(ans==true)
			{
				String path = req.getServletContext().getRealPath("/")+"pics"+File.separator+user.getProfile();
				
				
				String pathOldFile = req.getServletContext().getRealPath("/")+"pics"+File.separator+oldFile;
				//delete code 
				Helper.deleteFile(pathOldFile);
				
				
				if(Helper.saveFile(part.getInputStream(), path))
				{
					out.print("Profile Updated");
 					Message msg = new Message("Profile details Updated....."+path, "success", "alert-success ");
					s.setAttribute("msg", msg);
					resp.sendRedirect("profile.jsp");
				}
				else
				{   
					Message msg = new Message("Something went wrong....", "error", "alert-danger ");
					s.setAttribute("msg", msg); 
				}
			}
			else  
			{
				out.println("Not updated");
				Message msg = new Message("Something went wrong....", "error", "alert-danger ");
				s.setAttribute("msg", msg);
			}
			resp.sendRedirect("profile.jsp");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
}
