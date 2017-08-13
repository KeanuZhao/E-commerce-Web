<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    



    
    <div id="phoneCarousel">
    	<div class="previous arrow"></div>
        <div class="next arrow"></div>
        
        <div id="stage">
            <img id="a1" class="default" src="14pages1/WebRoot/img/ab.jpg" width="270" height="400" alt="1" />
            <img id="a2" src="14pages1/WebRoot/img/bc.jpg" width="270" height="400" alt="2" />
            <img id="a3" src="14pages1/WebRoot/img/cd.jpg" width="270" height="400" alt="3" />
            <img id="a4" src="14pages1/WebRoot/img/show1.jpg" width="270" height="400" alt="4" />
        </div>
    </div>

  


  </body>
</html>
