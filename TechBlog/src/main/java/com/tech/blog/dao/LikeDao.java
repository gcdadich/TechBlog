package com.tech.blog.dao;
import java.sql.*;

public class LikeDao {
	Connection con;
	// constructor
	public LikeDao(Connection con) {
		super();
		this.con = con;
	}


	// insert a row in the table
	public boolean insertLike(int pid, int uid)
	{
		boolean f = false;
		try
		{
			String q = "insert into likes(pid, uid) values(?, ?)";
			PreparedStatement p = this.con.prepareStatement(q);
			// values set
			p.setInt(1, pid);
			p.setInt(2, uid);
			p.executeUpdate();
			f = true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return f;
	}
	
	//count the like on post
	public int countLikeOnPost(int pid)
	{
		int count = 0;
		try 
		{
			String q = "select count(*) from likes where pid=?";
			PreparedStatement p = this.con.prepareStatement(q);
			p.setInt(1, pid);
			ResultSet set  = p.executeQuery();
			if(set.next())
			{
				count = set.getInt("count(*)");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return count;
	}
	
	// to check if the user has liked the post or not if so he cannot like the same post again
	public boolean isLikedByUser(int pid, int uid)
	{
		boolean f = false;
		
		try
		{
			String q = "select * from likes where pid=? and uid=?";
			PreparedStatement p = this.con.prepareStatement(q);
			p.setInt(1, pid);
			p.setInt(2, uid);
			ResultSet set = p.executeQuery();
			if(set.next())
			{
				f = true;//means that this user na pahala sa like kiya hai so iska like like button disable kar do
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return f;
	}
	
	// delete the like done by the user
	public boolean deleteLike(int pid, int uid)
	{
		boolean f = false;
		
		try
		{
			PreparedStatement p = this.con.prepareStatement("delete from likes where pid=? and uid=?");
			p.setInt(1, pid);
			p.setInt(2, uid);
			p.executeUpdate();
			f = true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return f;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
