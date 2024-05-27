package com.tech.blog.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.tech.blog.dao.LikeDao;
import com.tech.blog.helper.ConnectionProvider;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LikeServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		try(PrintWriter out = resp.getWriter())
		{
			String operation = req.getParameter("operation");
			int uid = Integer.parseInt(req.getParameter("uid"));
			int pid = Integer.parseInt(req.getParameter("pid"));
			
			// out.println("data from server");
			// out.println(operation);
			// out.println(pid);
			// out.println(uid);
			
 			LikeDao ldao = new LikeDao(ConnectionProvider.getConnection());
			if(operation.equals("like"))
			{
				boolean f = ldao.insertLike(pid, uid);
				out.println(f);
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
}
 