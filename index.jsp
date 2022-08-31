<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.data.Utility" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 
	<meta name="keywords" content="" />
	<meta name="description" content="" />

	<meta charset="utf-8">
	<meta name="viewport" content="initial-scale=1">
    
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/font-awesome.min.css">
	<link rel="stylesheet" href="css/templatemo_misc.css">
	<link rel="stylesheet" href="css/templatemo_style.css">
	
	<% int no=	Utility.parse(request.getParameter("no"));

System.out.print("no is >>>>>>>>>>>>>"+no); %>
	

	
</head>
<body>
  <form  action="<%=request.getContextPath()%>/Adminlogin" method="get">   
 <center></center><img src="<%=request.getContextPath() %>/title.png"  width="80%"  ></img></center>  

    <div class="responsive-navigation visible-sm visible-xs">
        <a href="#" class="menu-toggle-btn">
            <i class="fa fa-bars fa-2x"></i>
        </a>
        <div class="navigation responsive-menu">
            <ul>
                <li class="home"><a href="#templatemo">Home</a></li>
	            
	            <li class="contact"><a href="#contact">Admin Login</a></li>
            </ul> 
        </div>
    </div> 

	<div id="main-sidebar" class="hidden-xs hidden-sm">
		<div class="logo">
			<a href="#"><h1>PATIENT</h1></a>
			<span>MONITORING SYSTEM</span>
		</div> 

		<div class="navigation">
	        <ul class="main-menu">
	            <li class="home"><a href="#templatemo">Home</a></li>
	         
	            <li class="contact"><a href="#contact">Admin Login</a></li>
	        </ul>
		</div> 

	</div> 

	<div id="main-content">

		<div id="templatemo">
			<div class="main-slider">
				<div class="flexslider">
					<ul class="slides">
                    
						<li>
							<div class="slider-caption">
							
								<h2>NFC Technology</h2>
								 <p>Near Field Communication technology is used in Patient Monitoring system.</p>
								
							</div>
							<img src="images/toll.jpg" alt="Slide 1">
						</li>
                        
						<li>
							<div class="slider-caption">
								<h2>PATIENT MONITORING SYSTEM</h2>
								<p>Online Monitoring system for vehicle Card.</p> 
								
							</div>
							<img src="images/tollone.jpg" alt="Slide 2">
						</li>
                        
                       
                        
					</ul>
				</div>
			</div>
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-12">
						<div class="welcome-text">
							<h1>Welcome to Patient Monitoring System</h1>
							<p><font color="black"><b>The requirements for new web applications supporting 
different types of devices and purposes are continuously growing. 
The main advantages of web application development as well as 
popular development features covering integration with different 
technologies.</b></font></p>
						</div>
					</div>
				</div>
			</div>
		</div> <!-- /#sTop -->

		<div class="container-fluid">

		


			<div id="contact" class="section-content">
				<div class="row">
					<div class="col-md-12">
						<div class="section-title">
							<h2>ADMIN SESSION</h2>
						</div> <!-- /.section-title -->
					</div> <!-- /.col-md-12 -->
				</div> <!-- /.row -->
				
				<div class="row contact-form">
					<div class="col-md-4">
						<label for="name-id" class="required">Admin ID:</label>
						<input name="username" type="text" id="name-id" maxlength="40">
					</div>
					<div class="col-md-4">
						<label for="email-id" class="required">Password:</label>
						<input name="pass" type="password" id="email-id" maxlength="40">
					</div>
					
					<div class="col-md-12">
						<div class="submit-btn">
							<input  type="submit"  value="LOGIN" class="largeButton contactBgColor">
						</div> 
					</div> 
				</div>
				
			</div>

		</div> 


	</div> 
</form>
	<!-- JavaScripts -->
	<script src="js/jquery-1.10.2.min.js"></script>
	<script src="js/jquery.singlePageNav.js"></script>
	<script src="js/jquery.flexslider.js"></script>
	<script src="js/jquery.prettyPhoto.js"></script>
	<script src="js/custom.js"></script>
	<script>
		$(document).ready(function(){
			$("a[data-gal^='prettyPhoto']").prettyPhoto({hook: 'data-gal'});
		});

        function initialize() {
          var mapOptions = {
            zoom: 13,
            center: new google.maps.LatLng(40.7809919,-73.9665273)
          };

          var map = new google.maps.Map(document.getElementById('map-canvas'),
              mapOptions);
        }

        function loadScript() {
          var script = document.createElement('script');
          script.type = 'text/javascript';
          script.src = 'https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false&' +
              'callback=initialize';
          document.body.appendChild(script);
        }

        window.onload = loadScript;
    </script>
<!-- templatemo 394 sonic -->

</body>
 <% 



if(no==2)
{
	%>
	<script type="text/javascript">

	alert("Please Enter your Username and Password correctly")

	</script>
	<% 
}if(no==3)
{
	%>
	<script type="text/javascript">

	alert("Admin logout Successfully")

	</script>
	<% 
}
%> 
</html>