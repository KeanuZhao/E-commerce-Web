package user.servlet;

import mybean.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class GetAllGoodsServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//第一步：获取用户提交的页码信息
		int pageNo=1;
		String strPageNo=request.getParameter("pageNo");
		if(strPageNo!=null){
			pageNo=Integer.parseInt(strPageNo);
		}
		
		//第二步：调用GoodsBean
		GoodsBean g=new GoodsBean();
		ArrayList<GoodsBean> goodslist=new ArrayList<GoodsBean>();
		goodslist=g.getGoodsByPage(pageNo);
		int pageCount=g.getPageCount();
		
		request.setAttribute("goodslist",goodslist);
		request.setAttribute("pageNo",pageNo);
		request.setAttribute("pageCount",pageCount);			
		
		String forward="productdetials.jsp";
		RequestDispatcher rd=request.getRequestDispatcher(forward);
		rd.forward(request,response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
