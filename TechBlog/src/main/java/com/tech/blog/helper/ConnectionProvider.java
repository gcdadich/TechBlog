//package com.tech.blog.helper;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//
//public class ConnectionProvider {
//	private static Connection con;
//
//	public static Connection getConnection() {
//		try {
//			if (con == null) { // connection tabhi banana hai jab con null ho means pahala sa connection bana
//								// hua nahi hai
//				// Driver class Load
//				Class.forName("com.mysql.cj.jdbc.Driver");// Driver class ko load and register kara raha hai
//
//				// Create a connection
//				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techblog", "root", "Gautamgci12@");// Creating connection with the database
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return con;
//	}
//}


package com.tech.blog.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionProvider {

    private static Connection con;

    public static Connection getConnection() {
        try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techblog", "root", "Gautamgci12@");

        } catch (Exception e) {
            e.printStackTrace();        }

        return con;
    }
}
