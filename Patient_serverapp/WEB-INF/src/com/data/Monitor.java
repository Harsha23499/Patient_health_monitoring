package com.data;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Monitor extends HttpServlet {
	
	
	public void service(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		
		
		
	String	pid = request.getParameter("pid");
		System.out.print("pid"+pid);
	
	
		PrintWriter out=response.getWriter();
	 ResultSet rs=CommonDAO.takepvalues(pid);
	 StringBuffer sb1 = new StringBuffer();
     try {
		while (rs.next())
		 {
		     
		  
		     String temp =  rs.getString(1);
		     String pulse =  rs.getString(2);
		     String tilt =  rs.getString(3);
		     String pidd =  rs.getString(4);
		     sb1.append("Temperature:"+temp).append("  ").append("Pulse:"+pulse).append("  ").append("Tilt:"+tilt).append("  ").append("Pid:"+pidd).append("~");
		 }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     out.print(sb1.toString());
     
     System.out.println("stringbuilder data i s>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+sb1.toString());
     out.flush();
	 
	 
	 
	 
	 
	 
	 
	 
	 
		
		
		
		
		
		
		
		
		
}
}