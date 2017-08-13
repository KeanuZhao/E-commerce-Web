<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>Buy</title>
<link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="css/14css.css" />

</script>
<script type="text/javascript" src="img/14js.js">
</script>

</head>




<body>

<div class="header">
     <div class="menu" id="firstpage"><a href="javascript:window.location.href='fistpage.jsp'" target="_blank" class="menutext" id="textoffirstpage">Home</a></div>
     <div class="menu"><a href="./GetAllGoodsServlet"  class="menutext" >Products </a></div>
     <div class="menu"><a href="javascript:window.location.href='cart.jsp'" target="_blank" class="menutext">Cart
    </a></div>
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


<div class="register">
<form name="order"  method="post" action="get.jsp" >
<table border="0" align="center" >
        <tr>
          <td height="40" align="right">Receiver:</td>
          <td align="left">            <input name="receivename" type="text" class="cbox1" id="receivename" value="">          </td>
        </tr>
        <tr>
          <td align="right">Tel:</td>
          <td align="left"><input name="tele" type="text" class="cbox1" id="tele" value=""></td>
        </tr>
        <tr>
          <td align="right">Address:</td>
          <td align="left"><input name="address" type="text" class="cbox2" id="address" value=""></td>
        </tr>
        <tr>
          <td align="right">Postcode:</td>
          <td align="left"><input name="zipcode" type="text" class="cbox1" id="zipcode" value=""></td>
        </tr>
        <tr>
          <td align="right">Type of Payment:</td>
          <td align="left">            <select name="paymode" class="cbox1" id="paymode">
            <option value="Cash">Cash</option>
            <option value="VISA">VISA</option>
                                          </select>          </td>
        </tr>
        <tr>
          <td colspan="2" align="center"><input type="submit" name="Submit" value="buy">
            <input type="reset" name="Submit2" value="reset">    </td>
        </tr>
      </table>
      <div id="back">
        <p><a href="cart.jsp">return cart</a></p>
      </div>
      <p>&nbsp;</p>
</form>
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
