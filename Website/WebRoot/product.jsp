<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<meta http-equiv="Content-Language" content="zh-cn" />
<meta name="robots" content="all" />
<meta name="author" content="Kindermusik" />
<meta name="Copyright" content="Copyright Kindermusik Corporation All Rights Reserved." />
<meta name="MSSmartTagsPreventParsing" content="true" />
<meta http-equiv="imagetoolbar" content="false" />
<meta charset="utf-8">
<title>Product Introduction</title>
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="css/14css.css" />

</script>
<script type="text/javascript" src="js/14js.js">
</script>
<script src="Scripts/swfobject_modified.js" type="text/javascript"></script>
</head>
<body>

<div class="header">
     <div class="menu" id="firstpage"><a href="javascript:window.location.href='fistpage.jsp'" target="_blank" class="menutext" id="textoffirstpage">Home</a></div>
     <div class="menu"><a href="./GetAllGoodsServlet" target="_blank" class="menutext" id="aboutus" >Products </a></div>
    
     <div class="menu"><a href="cart.jsp" target="_blank" class="menutext">Cart</a></div>
     <div class="menu"><a href="#none" target="_blank" class="menutext" >About Us </a></div>
      <%
      if(session.getAttribute("username")==null)
      	out.print("<div class=\"menu\" id=\"login\"><a href=\"login.jsp\" target=\"_blank\" class=\"menutext\"> login</a></div>");
	 %>
      <%
   
       
  	  if(session.getAttribute("username")==null){
  	  	out.print("<div class=\"menu\" id=\"register\"><a href=\"register.jsp\" target=\"_blank\" class=\"menutext\" >register</a></div>");
     
      }	
      else{
      //	out.print("<div class=\"menu\" id=\"login\"><a href=\"#none\" class=\"menutext\"> ");
	  	out.print("welcome, "+session.getAttribute("username"));
	  }
     %>
     </a></div>

     </div>
</div>
<div id="aaa">
</div>
<script>
aaa.innerHTML="<iframe src='productss.jsp' frameborder='no' width=700 height=300 ></iframe>";
</script>


    
<div class="register">
  <div id="page">
   <a href="./AddToCart?id=11005" class="opera"><img class="availableAppStore" src="img/available_on_the_appstore.png" width="230" height="80" alt="BUY" />
			</a>
    <div class="text">
    	<h3><img src="img/thumb.jpg" alt="Intro" width="143" height="131" class="thumb" />A Wonderful Product</h3>
        <p>Thank you for choosing this Kindermusik Intelligent Lamp!</p>
        <p>Before installation and use of the Intelligent Lamp, please be sure to read the random distribution of all materials carefully, this will bring you a better experience of this product, a comprehensive understanding of the Intelligent Lamp and appreciation of the perfect function and simple operation.</p>
        <p>This Intelligent Lamp provide the basic function of illumination, also gives you the alarm, the clock display and other practical function, in order to adjust the lighting environment,  create comfortable environment, in addition, the LCD backlight can be controlled . The perfect function design can satisfy your different needs.</p>
        <p>The Intelligent Lamp in conformity with the technical specifications obtains the domestic and international authoritative organization certification.</p>
    <p>The company reserves the right to modify the contents in this manual without any prior notice.</p>
    </div>
    
    <div class="text">
    	<h3><img src="img/thumb1.jpg" alt="Intruc" width="138" height="143" class="thumb" />More Awesome Facts</h3>
        <br>
        <p>1.	The LCD display’s backlight can be adjusted, moderate eye.
<br>
2.	Different types of lighting mode can be set. 
<br>
3.	Time display function, the alarm can remind the user to get up or just show the time.
<br>
4.	Beautiful appearance can be used as decorations, hanging on the wall or putting on the table, also can be used as a mobile phone holder. </p>
    </div>
    
</div>
</div>

<div class="bottom">
     <div class="bottomtext" id="bottomtextleft1">
          <a href="javascript:window.location.href='fistpage.jsp'"><img src="img/logo.png" width="185" height="35"></a>
     </div>
      <div class="bottomtext">
          <a href="#">Communicate Us</a>
     </div>
     <div class="bottomtext">
          <a href="#">Privacy Policy</a>
     </div>
     <div class="bottomtext">
          <a href="#">About Us</a>
     </div>
      <div class="bottomtext">
          <a href="#">Website Policy</a>
     </div>
     <br>
     <div class="bottomtext" id="rightbottomtext1">
          <a href="#">China Change Country</a>
     </div>
     <br>
     <div class="bottomtext" id="bottomtextleft2">
        Copyright 2016 Kindermusik Corporation |NO. 268132183886 | International School of BUPT
     </div>
</div>

</body>
</html>
