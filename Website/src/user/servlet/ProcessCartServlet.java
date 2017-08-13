package user.servlet;

import mybean.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class ProcessCartServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String action=request.getParameter("action");
		String cid=request.getParameter("cid");
		
		String quantity=null;
		//创建JavaBean对象
		CartManager cartManager=new CartManager();
		HttpSession session=request.getSession(true);
		//得到购物车对象
		ArrayList<ItemBean> cart=(ArrayList<ItemBean>)session.getAttribute("cart");
		cartManager.setCart(cart);
		
		if("Modify".equals(action)){
			quantity=request.getParameter("quantity");
			cartManager.update(cid,Integer.parseInt(quantity));
			out.println("<script> alert('Successfully Modify!');</script>");
		}else{
			cartManager.delete(cid);
			out.println("<script> alert('Sucessfully Delete!');</script>");
		}
		session.setAttribute("cart",cartManager.getCart());
		RequestDispatcher rd=request.getRequestDispatcher("cart.jsp");
		rd.forward(request,response);
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
