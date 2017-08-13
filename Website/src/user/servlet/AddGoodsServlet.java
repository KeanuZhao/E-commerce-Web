package user.servlet;



import mybean.*;
//import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
//import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
public class AddGoodsServlet extends HttpServlet {

	private PrintWriter out;

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
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
        String cid=req.getParameter("cid");
		String cname=req.getParameter("cname");
		String number=req.getParameter("cnumber");
		String price=req.getParameter("cprice");
		String cintro=req.getParameter("cintro");
		//转换数量和价格的格式
		int cnumber=Integer.parseInt(number);
		int cprice=Integer.parseInt(price);
		GoodsBean goods=new GoodsBean();
		DBBean db=new DBBean();
		String info="";
		String forward="";
		PreparedStatement pstmt=null;
		Connection conn=null;		
 
//对象创建
try{

		int cmark=0;
		String sql="insert into goods(id,name,number,price,intro) values (?,?,?,?,?)";
		conn=db.createConn();
		conn.setAutoCommit(true);
		pstmt=conn.prepareStatement(sql);			
		pstmt.setString(1,cid);
		pstmt.setString(2,cname);
		pstmt.setInt(3,cnumber);
		pstmt.setFloat(4,cprice);
		pstmt.setString(5,cintro);
		cmark=pstmt.executeUpdate();
		if(cmark==1){
				out.println("<script>alert('Successfully add');</script>");
		}else{
				out.println("<script>alert('Fail to add');</script>");
		}
	
	
}catch(Exception e){
	e.printStackTrace();
	out.println("<script>alert('添加异常');</script>");
}finally{
	try {pstmt.close();}catch(Exception e){}
	try {conn.close();}catch(Exception e){}
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
	public void doPost(HttpServletRequest req, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the Post method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
			
	}

}
