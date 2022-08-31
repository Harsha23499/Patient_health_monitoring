


<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*"%>
<%@page import="java.sql.*"%>
<%!String oldpass = "";
	String tollid = "";
	String pass = "";
	String confirmusr = "";

	boolean flag = false;

	StringBuffer sb = null;
	String info = "Opps,Something Went Wrong Try Again..";%>

<%
	sb = new StringBuffer();

tollid = request.getParameter("pid");
System.out.print("tollid>>>>>>>>>>>"+tollid);
pass = request.getParameter("passs");
System.out.print("pass>>>>>>>>>>>>>>"+pass);
Class.forName("com.mysql.jdbc.Driver");

Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/db_patient_monitoring", "root", "admin");

Statement stmt=(Statement) con.createStatement();


ResultSet rs=	stmt.executeQuery("select * from m_doctor where d_uid='"+tollid+"' and d_password='"+pass+"'");

if(rs.next())
{
	
	sb.append("true");	
	
}
else
{


sb.append("false");

}
	System.out.println(sb.toString());

	out.println(sb.toString()); //Sending Response to Android App
	
	
	
%>

