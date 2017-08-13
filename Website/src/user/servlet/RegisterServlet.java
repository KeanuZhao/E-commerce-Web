package user.servlet;

import mybean.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegisterServlet extends HttpServlet {
 @Override
 protected void doGet(HttpServletRequest req, HttpServletResponse resp)	throws ServletException, IOException {
	 doPost(req,resp);
 }
 
 @Override
 public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 HttpSession session = req.getSession();
	 PrintWriter out = resp.getWriter();
	 String username = req.getParameter("t3");
	 String pwd = req.getParameter("t4");
	 String pwd1 = req.getParameter("t5");
	 boolean flag=true;
	 Users account=new Users(); 
	 account.setPassword(pwd);
	 account.setUsername(username);
	 if(pwd==pwd1||pwd==null||username==null){
		 out.println("<script> alert('ERROR!');window.history.go(-1);</script>");
	 }	  
	 else{	     
		 try{
			 DBBean db=new DBBean();
			 Connection conn=db.createConn();		
			 ResultSet rs = db.executeQuery("select * from userinfo") ; 
			 while(rs.next()) {
				 if(username.equals(rs.getString(1))){
					 out.println("<script>alert('Sorry,usernae"+username+"had existed');location.replace('register.jsp');</script>");
					 flag=false; 
					 break;
				 }
			 }
			 if (flag){
				 PreparedStatement stat=conn.prepareStatement("insert userinfo values(?,?)");
				 stat.setString(1,username);
				 stat.setString(2,pwd);
				 stat.executeUpdate();
				 stat.close();
				 String name_reged=null;
				 session.setAttribute("username",username);
				 out.println("<script>alert('Successfully Register');location.replace('firstpage.jsp')</script>");
			 }
			 rs.close();
			 conn.close(); 
			 db.close();
		 }
		 catch(Exception e){
			 out.println(e);
		 } 
	 }   
 	}
}