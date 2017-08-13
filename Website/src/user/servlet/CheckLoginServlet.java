package user.servlet;

import mybean.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class CheckLoginServlet extends HttpServlet {
 @Override
 protected void doGet(HttpServletRequest req, HttpServletResponse resp)
   throws ServletException, IOException {
  doPost(req,resp);
 }
 @Override
 public void doPost(HttpServletRequest req, HttpServletResponse resp)
   throws ServletException, IOException {
   HttpSession session = req.getSession();
   Users account = new Users();
   PrintWriter out = resp.getWriter();
   String username = req.getParameter("username");
   String pwd = req.getParameter("password"); 
   account.setPassword(pwd);
   account.setUsername(username);
   if(account.validate()) { 
      //记得把用户名写入session 
       session.setAttribute("username",account.getUsername()); 
      //提示登录成功
       out.println("<script> alert('Login Sucessful');/script>");
       resp.sendRedirect("firstpage.jsp");	   
   } 
   else{ 
      out.println("<script> alert('Please enter correct username and password');window.history.go(-1);</script>");
   }	  
	 
 }
}