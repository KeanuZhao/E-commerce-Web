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
				/*****��һ������ȡ��Ҫ��ӵ����ﳵ����Ʒ��ID*****/
				String cid=request.getParameter("id");
				//out.println("<script> alert('"+cid+"');window.history.go(-1);</script>");//����
				/******�ڶ�����׼���ù��ﳵ********/
				//��1����������ÿ���û��Ĺ��ﳵ��CartManager����
				CartManager cartManager=new CartManager();	
				//(2)��ȡ��Session��ʽ����Ĺ��ﳵ����cart����ʼΪnull
				ArrayList<ItemBean> cart=(ArrayList<ItemBean>)session.getAttribute("cart");	
				//��3�������ﳵ��cartManager����������
				cartManager.setCart(cart);
				/****��������������ƷID�Ż�ȡ����Ʒ��������Ϣ*******/
				GoodsBean g=new GoodsBean();
				g=g.findGoodsById(cid);
				/***���Ĳ�������Ʒ����빺�ﳵ***/
				cartManager.addToCart(g,1);
				/***���岽������session�����еĹ��ﳵ��Ϣ******/
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
