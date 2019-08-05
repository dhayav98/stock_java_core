package com.demo.stc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.demo.stc.model.User;

public class UserDaoImpl {
	public static Connection connect() throws ClassNotFoundException, SQLException
	{
		
		Class.forName("com.mysql.jdbc.Driver"); 
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/stock","root","root");
		System.out.println("connect");
		return con;  
	}
	public static User insertUser(User user) throws Exception, ClassNotFoundException {
		Connection con=connect();
		PreparedStatement ps=con.prepareStatement("insert into user values(?,?,?,?,?,?,?);");
		ps.setInt(1,user.getId());
		ps.setString(2,user.getUserName());
		ps.setString(3, user.getPassword());
		ps.setString(4, user.getUserType());
		ps.setString(5, user.getEmail());
		ps.setLong(6,user.getMobileNumber());
		ps.setBoolean(7,user.isConfirmed());
		int no=ps.executeUpdate();
		if(no>0)
		{
			System.out.println("Successfully Inserted!!!");
		}
		else
		{
			System.out.println("Not Inserted!!!");
		}
		return null;
	}
	public User updateUser(User user) throws Exception,ClassNotFoundException{
		Connection con=connect();
		//PreparedStatement ps=con.prepareStatement("update table user set )
		return null;
		
	}
	public static void main(String[] args) throws ClassNotFoundException, Exception
	{
		User u1=new User();
		u1.setId(1);
		u1.setUserName("dhaya");
		u1.setPassword("dhaya@123");
		u1.setEmail("dhaya@gmail.com");
		u1.setUserType("admin");
		u1.setMobileNumber(8123456799L);
		u1.setConfirmed(false);
		insertUser(u1);
		
		
	}
	
}
