
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ page import="mybean.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="Kindermusik" />
<meta name="Copyright" content="Copyright Kindermusik Corporate All Rights Reserved." />
<title>Product Details</title>
<link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon" />

<link rel="stylesheet" type="text/css" href="css/14css.css" />
<script type="text/javascript" src="js/14js.js"></script>
</head>
<body>

<div class="header">
     <div class="menu" id="firstpage"><a href="javascript:window.location.href='firstpage.jsp'" target="_blank" class="menutext" id="textoffirstpage">Home</a></div>
     <div class="menu"><a href="#none" target="_blank" class="menutext" id="productdetails">Products </a></div>
     <div class="menu"><a href="cart.jsp" target="_blank" class="menutext">Cart</a></div>
     <div class="menu"><a href="javascript:window.location.href='aboutus.jsp'" target="_blank" class="menutext">About Us </a></div>
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

<div id="aaa" >
</div>
<script>
aaa.innerHTML="<iframe src='3d.html' frameborder='no' width=850 height=600 ></iframe>";
</script>
<!--
    <div id="phoneCarousel">
    	<div class="previous arrow"> </div>
        <div class="next arrow"></div>
        
        <div id="stage">
            <img id="1" class="default" src="img/1.jpg" width="270" height="400" alt="1" />
            <img id="2" src="img/2.jpg" width="270" height="400" alt="2" />
            <img id="3" src="img/3.jpg" width="270" height="400" alt="3" />
            <img id="4" src="img/4.jpg" width="270" height="400" alt="4" />
        </div>
    </div>
-->
 
  

 
 
 <div class="prodescribtion">
     Product Details<br>
  <table border="1" align="center" >
  <tr><th>ID</th><th>Product Name</th><th>Price</th><th>Operation</th></tr>
  <c:forEach items="${goodslist}" var="g">
	  <tr>
		  <td>${g.cid}</td>
		  <td><a href="product.jsp?id=${g.cid}">${g.cname}</a></td>
		  <td>${g.cprice}</td>
		  <td><a href="./AddToCart?id=${g.cid}" class="opera">Add</a></td> 
	  </tr>
  </c:forEach>  
  </table>
  <div id="back">
  <c:if test="${pageNo==1}">Last Next  </c:if>
  <c:if test="${pageNo!=1}">
  	<a href="./GetAllGoodsServlet?pageNo=1">First</a> 
  	<a href="./GetAllGoodsServlet?pageNo=${pageNo-1}">Last</a>
  </c:if>
  <c:if test="${pageNo==pageCount}">Next End  </c:if>
  <c:if test="${pageNo!=pageCount}">
  	<a href="./GetAllGoodsServlet?pageNo=${pageNo+1}">Next</a> 
  	<a href="./GetAllGoodsServlets?pageNo=${pageCount}">End</a>
  </c:if>
  <form action="./GetAllGoodsServlet">
  	Jump to<input type="text" name="pageNo" />Page<input type="submit" value="Jump" />
  </form> 
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
