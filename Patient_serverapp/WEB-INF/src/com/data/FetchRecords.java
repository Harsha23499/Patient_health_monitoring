package com.data;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FetchRecords extends HttpServlet
{
 protected void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException
 {
	 String temp=request.getParameter("temp");
	 String pulse=request.getParameter("pulse");
	 String tilt=request.getParameter("tilt");
	 String p_id=request.getParameter("p_uid");
	 boolean flag=false;
	 flag=CommonDAO.FetchRecords(temp, pulse, tilt, p_id);
	 if(flag)
	 {
		 System.out.println("records inserted");
	 }
	 else
	 {
		 System.out.println("record not inserted");
	 }
 }

}
