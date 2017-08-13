package user.servlet;


import mybean.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class BuyServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//response.setContentType("text/html");
		//PrintWriter out = response.getWriter();
		HttpSession session=request.getSession();
		//获取当前的时间
		java.util.Date day=new java.util.Date();	
		SimpleDateFormat format=new SimpleDateFormat("yyyyMMdd");
		String orderdate=format.format(day);			
		String username=(String)session.getAttribute("username");		
		String receivename=request.getParameter("receivename");
		String tele=request.getParameter("tele");
		String zipcode=request.getParameter("zipcode");
		String address=request.getParameter("address");
		String paymode=request.getParameter("paymode");
		int orderstate=0; 
		
		//生成订单号
		String now=(String)(day.toLocaleString());
		String sql="select count(*) from ordertable where orderdate='"+orderdate+"'";
		DBBean db=new DBBean();
		ResultSet rs=null;
		int i=0;
		try{
			rs=db.executeQuery(sql);
			if(	rs!=null){
			rs.next();
			i=rs.getInt(1);
			}
			i++;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close();
		}
		String str_i=String.valueOf(i);
		while(str_i.length()<3){
			str_i="0"+str_i;
		}
		String orderid=now+str_i;
		orderid=orderid.replace("-","");
		orderid=orderid.replace(" ","");
		orderid=orderid.replace(":","");

		
		OrderBean order=new OrderBean();
		order.setOrderid(orderid);
		order.setUsername(username);
		order.setOrderdate(orderdate);
		order.setOrderstate(orderstate);
		order.setAddress(address);
		order.setReceivename(receivename);
		order.setTele(tele);
		order.setZipcode(zipcode);
		order.setPaymode(paymode);
		//生成订单和订单信息		
		ArrayList cart=(ArrayList)session.getAttribute("cart");	
		boolean mark=order.add(cart);	
		String forward;
		if(mark) {
			request.setAttribute("info","订单添加成功");
			session.setAttribute("cart",null);
			forward="userinfo.jsp";
		}
		else{
			request.setAttribute("info","订单添加失败");
			forward="cart.jsp";
		}
		RequestDispatcher rd=request.getRequestDispatcher(forward);
		rd.forward(request,response);
	}

}
