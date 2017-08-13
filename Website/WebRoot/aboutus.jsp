<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

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
<title>About Us</title>
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="css/14css.css" />


<script type="text/javascript" src="js/14js.js">
</script>

</head>
<body>

<div class="header">
     <div class="menu" id="firstpage" bgcolor="black"><a href="javascript:window.location.href='fistpage.jsp'" target="_blank" class="menutext" id="textoffirstpage">Home</a></div>
     <div class="menu"><a href="./GetAllGoodsServlet" target="_blank" class="menutext" >Products </a></div>
     <div class="menu"><a href="cart.jsp" target="_blank" class="menutext">Cart</a></div>
     <div class="menu"><a href="#none" target="_blank" class="menutext" id="aboutus">About Us </a></div>
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


<div class="register">
<pre class="preus">
<span>Hardware</span>	
------------------------------------------
   SN            Name               Class      
2014213141       Jing Wu           2014215110   
     2014213008	      Shuaipeng Yang    2014215106        
   2014212927       Fanya Kong        2014215103      
2014212913	 Anbin Li          2014212103   
2014212942       Yao Xiao          2014215104   

   
Software
------------------------------------------
  2014213296       Rui Hou           2014215115     
        2014213441       Xinming Dong      2014215120	        
 2014213477	  Yu Luo            2014215121	  
2014213440       Yifei Yang        2014215120   
2014213305       Chen Cai          2014215116   
2014213283       Jing Liang        2014215115   


</pre>
<!-- <img src="img/group.jpg" width="600px"> -->
<h1>Our Company </h1>
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
