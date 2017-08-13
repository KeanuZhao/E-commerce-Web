<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<meta http-equiv="Content-Language" content="zh-cn" />
<meta name="robots" content="all" />
<meta name="author" content="Kindermusik" />
<meta name="Copyright" content="Copyright Kindermusik Corporate All Rights Reserved." />
<meta name="MSSmartTagsPreventParsing" content="true" />
<meta http-equiv="imagetoolbar" content="false" />
<meta charset="utf-8">
<title>Home</title>
<link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="css/14css.css" />

</script>
<script type="text/javascript" src="js/14js.js">
</script>
</head>

<body>

<div class="header">
     <div class="menu" id="firstpage"><a href="#" target="_blank" class="menutext" id="textoffirstpage">Home</a></div>
     <div class="menu"><a href="./GetAllGoodsServlet" target="_blank" class="menutext">Products </a></div>
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

<div class="show">
     <a href="./GetAllGoodsServlet" target="_blank">
          <img class="showimage" src="img/show1.jpg">
          <div class="insidetext">
          Our Product
          <div class="brtext">Enjoy The Music</div>          
          </div>
     </a>
</div><br><br><br><br>

     <div class="blocks" id="leftblock1">
          <a href="#" target="_blank" class="blockslink">
               <div class="blocksinsidetext">
               All Products
               </div>
               <div>
                   <img alt="test" src="img/1.jpg">
               </div>
          </a>
     </div>

     <div class="blocks" >
          <a href="#" target="_blank" class="blockslink">
               <div class="blocksinsidetext">
               More Products
               </div>
               <div>
                   <img alt="test" src="img/2.jpg">
               </div>
          </a>
     </div>

     <div class="blocks" >
          <a href="#" target="_blank" class="blockslink">
               <div class="blocksinsidetext">
               More Musics
               </div>
               <div>
                   <img alt="test" src="img/3.jpg">
               </div>
          </a>
     </div>

     <div class="blocks" >
          <a href="#" target="_blank" class="blockslink">
               <div class="blocksinsidetext">
            Other Service
               </div>
               <div>
                   <img alt="test" src="img/4.jpg">
               </div>
          </a>
     </div>
     

<div class="bottom">
     <div class="bottomtext" id="bottomtextleft1">
          <a href="javascript:window.location.href='fistpage.jsp'"><img src="img/logo.png" width="185" height="34"></a>
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
