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
<title>Register</title>
<link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="css/14css.css" />

</script>
<script type="text/javascript" src="img/14js.js">
</script>

</head>




<body>

<div class="header">
     <div class="menu" id="firstpage"><a href="javascript:window.location.href='fistpage.jsp'" target="_blank" class="menutext" id="textoffirstpage">Home</a></div>
     <div class="menu"><a href="./GetAllGoodsServlet"  class="menutext" > Products </a></div>
     <div class="menu"><a href="javascript:window.location.href='cart.jsp'" target="_blank" class="menutext">Cart
    </a></div>
     <div class="menu"><a href="javascript:window.location.href='aboutus.jsp'" target="_blank" class="menutext">About Us </a></div>

</div>


<div class="register">
<form name="reg"  method="post" action="RegisterServlet">
<table class="regtable">
<tr>
<td align="right">Username</td>
<td align="left"><input name="t3" type="text" maxlength="20"></td>
</tr>
<tr>
<td align="right">Password</td>
<td align="left"><input name="t4" type="password" maxlength="20"></td>
</tr>
<tr>
<td align="right">Confirm Password</td>
<td align="left"><input name="t5" type="password" maxlength="20"></td>
</tr>
<tr>
<td align="right"><input name="submit" type="submit" value="register"></td>
<td align="left"><input name="reset" type="reset" value="reset"></td>
</tr>
</table>
</form>
</div>

     
     
     

<div class="bottom">
     <div class="bottomtext" id="bottomtextleft1">
          <a href="javascript:window.location.href='fistpage.jsp'"><img src="img/logo.png" width="185" height="35">
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
