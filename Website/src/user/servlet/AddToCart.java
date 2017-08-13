package user.servlet;


import mybean.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class AddToCart extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession();
		if(session.getAttribute("username")==null){			
			out.println("<script> alert('Please register first!');window.history.go(-1);</script>");
		}
		else{
			try{
				/*****第一步：获取将要添加到购物车的商品的ID*****/
				String cid=request.getParameter("id");
				//out.println("<script> alert('"+cid+"');window.history.go(-1);</script>");//检验
				/******第二步：准备好购物车********/
				//（1）创建管理每个用户的购物车的CartManager对象
				CartManager cartManager=new CartManager();	
				//(2)获取以Session方式保存的购物车对象cart，初始为null
				ArrayList<ItemBean> cart=(ArrayList<ItemBean>)session.getAttribute("cart");	
				//（3）将购物车用cartManager对象来管理
				cartManager.setCart(cart);
				/****第三步：根据商品ID号获取该商品的所有信息*******/
				GoodsBean g=new GoodsBean();
				g=g.findGoodsById(cid);
				/***第四步：将商品添加入购物车***/
				cartManager.addToCart(g,1);
				/***第五步：更新session对象中的购物车信息******/
				session.setAttribute("cart", cartManager.getCart());			
			}catch(Exception e){
				String error=e.toString();
				out.println(error);
			}
			response.sendRedirect("cart.jsp");
		}
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	
		
	}

}
