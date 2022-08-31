package com.data;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Changepass  extends HttpServlet{
	
	public void service(HttpServletRequest request,HttpServletResponse response)throws IOException
		{
		
		StringBuffer sb = null;
		sb = new StringBuffer();
		System.out.println("its came inside changepassword>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			
		String	oldpass = request.getParameter("CurrentPass");
		String	newpass = request.getParameter("NewPass");
		String	ConfirmPass = request.getParameter("ConfirmPass");
		
		System.out.println("old password is "+oldpass);
		
		System.out.println("new  password is "+newpass);
		
		System.out.println("ConfirmPass is "+ConfirmPass);

		
		PrintWriter out=response.getWriter();
		boolean flag=CommonDAO.Checkcurrentpass(oldpass);
		System.out.println("flag value is "+flag);
		
		if(flag)
		{
			boolean flag2 = CommonDAO.changePassad(newpass);
			if (flag2) {

				out.println("change");
				

			} else
			
			
			{

				
				   out.println("error");	
			}
			
		}
		else
		{
			
			
			 out.println("old");		
			
		}
		
		
		


		}
	
	
	
		}