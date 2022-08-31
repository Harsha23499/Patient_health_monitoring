package com.data;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class TollPayment extends HttpServlet {
	
	
	public void service(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		try {
		boolean flag=false;
		String	vtype="",	cardnum="",tollname="",strDaet="", tim="",vregnum="";
		cardnum = request.getParameter("cardnum");
		StringBuffer sb=new StringBuffer();
		 String  remainingbalance="";
		System.out.print("cardnum>>>>>>>>>>>>>>>>"+cardnum);
	String	vehiclenum = request.getParameter("vehiclenum");
		System.out.print("vehiclenum>>>>>>>>>>>>>>>>"+vehiclenum);
		
		
	vregnum=CommonDAO.getvehiclenum(cardnum);
		
		
		
		tim = request.getParameter("tim");
		System.out.print("tim>>>>>>>>>>>>>>>>"+tim);
		strDaet = request.getParameter("strDae");
		System.out.print("vehiclenum>>>>>>>>>>>>>>>>"+vehiclenum);
		vtype = request.getParameter("vtype");
			System.out.print("vtype>>>>>>>>>>>>>>>>"+vtype);
			tollname = request.getParameter("tollname");
			System.out.print("tollname>>>>>>>>>>>>>>>>"+tollname);
			
	
		PrintWriter out=response.getWriter();
	 flag=CommonDAO.Checkcardnum(cardnum);
		System.out.println("flag value is "+flag);
		String twowheeler="",fourwheelr="",van="",bus="",truck="";
		if(flag)
		{
			
				/*out.println(flag);
				System.out.println("correct change password status");
				*/
			System.out.println("its came indside first if block>>>>>>>>>>>>>>>");	
			 String cardbalance=CommonDAO.Takecardamount(cardnum);
				
			System.out.println("card balance is >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+cardbalance);	
			 ResultSet rs=CommonDAO.fetchtolldetails(tollname);
				
			
				while(rs.next())
				{
					
					twowheeler=	rs.getString(5);
					
					System.out.println(""+twowheeler);
					fourwheelr=	rs.getString(6);
					
					System.out.println(""+fourwheelr);
					van=	rs.getString(7);
					
					System.out.println(""+van);
					bus=	rs.getString(8);
					
					System.out.println(""+bus);
					truck=	rs.getString(9);
					System.out.println(""+truck);
				
			
				
				if(vtype.equals("Two wheeler"))
				{
					System.out.println("twowheeler block>>>>>>>>>>>");	
					 //String twofare=CommonDAO.fetchtollamount(tollname);
					System.out.println("Two wheeler block>>>>>>>>>>>"+Integer.parseInt(cardbalance));	
					System.out.println("Two wheeler block>>>>>>>>>>>"+Integer.parseInt(twowheeler ));	
					
					
					if(Integer.parseInt(cardbalance)>Integer.parseInt(twowheeler))
					{
						
				      int remainingamount=		Integer.parseInt(cardbalance)-Integer.parseInt(twowheeler);
					System.out.println("remaining amount is>>>>>>>>>>>>>>>>"+remainingamount);	
						
					  remainingbalance=CommonDAO.updateremaingamount(cardnum,""+remainingamount);	
					  
					  
			boolean flgg=CommonDAO.inserttolltransactions(tollname,strDaet,tim,vregnum,vtype,twowheeler);
					  
					  System.out.println("paid block>>>>>>>>>>>"+remainingbalance);	
					  String success="success";
						sb.append(success);
						sb.append("~");
						sb.append(remainingbalance);
						out.println(sb.toString());	
						
					  
					  
					  
					  
						
					}else
					{
						
						System.out.println("insufficient block>>>>>>>>>>>");	
						String insufficient="insufficient";
						

						sb.append(insufficient);
						sb.append("~");
						
						sb.append("data");
						out.println(sb.toString());	
							  
						
						
						System.out.println("your card is having insufficient balance>>>>>>>>>>>>>>>>");
						
					}
					
					
				}
				
				
				if(vtype.equals("Four wheeler"))
				{
					
					// String fourfare=CommonDAO.fetchtollamount1(tollname);
					System.out.println("Four wheeler block>>>>>>>>>>>");	
					if(Integer.parseInt(cardbalance)>Integer.parseInt(fourwheelr))
					{
						
				      int remainingamount=		Integer.parseInt(cardbalance)-Integer.parseInt(fourwheelr);
					System.out.println("remaining amount is>>>>>>>>>>>>>>>>"+remainingamount);	
						
					  remainingbalance=CommonDAO.updateremaingamount(cardnum,""+remainingamount);	
					  
					  System.out.println("paid block>>>>>>>>>>>"+remainingbalance);	
					  
						boolean flgg=CommonDAO.inserttolltransactions(tollname,strDaet,tim,vregnum,vtype,twowheeler);
					  String success="success";
						sb.append(success);
						sb.append("~");
						sb.append(remainingbalance);
						out.println(sb.toString());	
						
					}else
					{
						System.out.println("insufficient block>>>>>>>>>>>");	
						String insufficient="insufficient";

						sb.append(insufficient);
						sb.append("~");
						
						sb.append("data");
						out.println(sb.toString());	
							  
						
						System.out.println("your card is having insufficient balance>>>>>>>>>>>>>>>>");
						
					}
					
					
				}
				
				
				
				if(vtype.equals("Van"))
				{
					System.out.println("Van block>>>>>>>>>>>");	
					// String fourvan=CommonDAO.fetchtollamount2(tollname);
					if(Integer.parseInt(cardbalance)>Integer.parseInt(van))
					{
						
				      int remainingamount=		Integer.parseInt(cardbalance)-Integer.parseInt(van);
					System.out.println("remaining amount is>>>>>>>>>>>>>>>>"+remainingamount);	
						
					  remainingbalance=CommonDAO.updateremaingamount(cardnum,""+remainingamount);	
					  
					  System.out.println("paid block>>>>>>>>>>>"+remainingbalance);	
					  
						boolean flgg=CommonDAO.inserttolltransactions(tollname,strDaet,tim,vregnum,vtype,twowheeler);
					  String success="success";
						sb.append(success);
						sb.append("~");
						sb.append(remainingbalance);
						out.println(sb.toString());	
						
					}else
					{
						System.out.println("insufficient block>>>>>>>>>>>");	
						String insufficient="insufficient";

						sb.append(insufficient);
						sb.append("~");
						
						sb.append("data");
						out.println(sb.toString());	
							  
						
						
						System.out.println("your card is having insufficient balance>>>>>>>>>>>>>>>>");
						
					}
				}
				
				
				if(vtype.equals("Bus"))
				{
					System.out.println("Bus block>>>>>>>>>>>");	
					 //String fourbus=CommonDAO.fetchtollamount3(tollname);
					if(Integer.parseInt(cardbalance)>Integer.parseInt(bus))
					{
						
				      int remainingamount=		Integer.parseInt(cardbalance)-Integer.parseInt(bus);
					System.out.println("remaining amount is>>>>>>>>>>>>>>>>"+remainingamount);	
						
					  remainingbalance=CommonDAO.updateremaingamount(cardnum,""+remainingamount);	
					  
					  System.out.println("paid block>>>>>>>>>>>"+remainingbalance);	
					  
						boolean flgg=CommonDAO.inserttolltransactions(tollname,strDaet,tim,vregnum,vtype,twowheeler);
					  String success="success";
						sb.append(success);
						sb.append("~");
						sb.append(remainingbalance);
						out.println(sb.toString());	
							
					}else
					{
						System.out.println("insufficient block>>>>>>>>>>>");	
						String insufficient="insufficient";

						sb.append(insufficient);
						sb.append("~");
						
						sb.append("data");
						out.println(sb.toString());	
							  
						
						System.out.println("your card is having insufficient balance>>>>>>>>>>>>>>>>");
						
					}	
				}
				
				if(vtype.equals("Truck"))
				{
					System.out.println("Truck>>>>>>>>>>>");	
					// String fourtruck=CommonDAO.fetchtollamount4(tollname);
					
					if(Integer.parseInt(cardbalance)>Integer.parseInt(truck))
					{
						
				      int remainingamount=		Integer.parseInt(cardbalance)-Integer.parseInt(truck);
					System.out.println("remaining amount is>>>>>>>>>>>>>>>>"+remainingamount);	
						
					  remainingbalance=CommonDAO.updateremaingamount(cardnum,""+remainingamount);
					  
					  
					  
					  System.out.println("paid block>>>>>>>>>>>"+remainingbalance);	
					  
						boolean flgg=CommonDAO.inserttolltransactions(tollname,strDaet,tim,vregnum,vtype,twowheeler);
					  String success="success";
						sb.append(success);
						sb.append("~");
						sb.append(remainingbalance);
						out.println(sb.toString());	
						
					}else
					{
						System.out.println("insufficient block>>>>>>>>>>>");	
						String insufficient="insufficient";

						
						sb.append(insufficient);
						sb.append("~");
						
						sb.append("data");
						out.println(sb.toString());	
							  
						
						
						System.out.println("your card is having insufficient balance>>>>>>>>>>>>>>>>");
						
					}	
					
				}
				

			}
		
		
		}
		
		
		else
			
			
			{
			
			
			System.out.println("its came indside last else block for invalid card>>>>>>>>>>>>>>>");	

			String ff="false";
			sb.append(ff);
			sb.append("~");
			
			sb.append("data");
			out.println(sb.toString());	
				  
			}
			
		
			
		
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
					
		
		
		
		
}
}