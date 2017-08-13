<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ page import = "java.sql.*" %>
<%@ page import="mybean.*" %>
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
<title>Cart</title>
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="css/14css.css" />

</script>
<script type="text/javascript" src="js/14js.js">
</script>

</head>
<body>

<div class="header">
     <div class="menu" id="firstpage"><a href="javascript:window.location.href='fistpage.jsp'" target="_blank" class="menutext" id="textoffirstpage">Home</a></div>
     <div class="menu"><a href="./GetAllGoodsServlet" target="_blank" class="menutext" >Products </a></div>
     <div class="menu"><a href="#none" target="_blank" class="menutext" id="productdetails">Cart</a></div>
     <div class="menu"><a href="aboutus.jsp" target="_blank" class="menutext" >About Us </a></div>
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

<div class="prodescribtion">
<c:if test="${!empty cart}">
	       <h1>Shopping Cart</h1> 
	    <hr>
	    <div><a href="./ClearCartServlet">Clear cart</a> <br> <a href="./GetAllGoodsServlet">Continue shopping</a> 
	    <form method="get" action="ProcessCartServlet"> 
	    <table border="1" align="center" >
	  	<tr><th>ID</th><th>Name</th><th>Price</th><th>Number</th><th>Operation</th></tr>
	  	<c:forEach items="${cart}" var="item">

		  <tr>
			  <td>${item.goods.cid}</td>
			  <td>${item.goods.cname}</td>
			  <td>${item.goods.cprice}</td>
			  <td><input name="quantity" type="text" value="${item.quantity}" size="5" /></td>
			  
			  <td><input type="submit" name="action" value="Modify" />
			      <input type="submit" name="action" value="Delete" /></td>	 
		  </tr>	 
	
		
	  	</c:forEach>  
	  </table>
	  		 </form> 
       <div><a href="buy.jsp">Buy</a> </div>	   
  </c:if>
  <c:if test="${empty cart}">
  
  <div class="bottomtext"><a href="./GetAllGoodsServlet">Click here to shopping</a></div>
  
  </c:if>
  
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
