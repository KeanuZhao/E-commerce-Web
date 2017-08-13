package mybean;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;
import java.util.*;
import java.sql.SQLException;
public class OrderBean {
	private String orderid;
	private String username;
	private String orderdate;
	private int orderstate;
	private String address;
	private String tele;
	private String zipcode;
	private String receivename;
	private String paymode;
	
	public void setOrderid(String orderid){
		this.orderid=orderid;
	}
	public String getOrderid(){
		return this.orderid;
	}
	
	public void setUsername(String username){
		this.username=username;
	}
	public String getUsername(){
		return this.username;
	}
	
	public void setOrderdate(String orderdate){
		this.orderdate=orderdate;
	}
	public String getOrderdate(){
		return this.orderdate;
	}
	
	public void setOrderstate(int orderstate){
		this.orderstate=orderstate;
	}
	public int getOrderstate(){
		return this.orderstate;
	}
	public void setAddress(String address){
		this.address=address;
	}
	public String getAddress(){
		return this.address;
	}
	
	public void setTele(String tele){
		this.tele=tele;
	}
	public String getTele(){
		return this.tele;
	}
	
	public void setZipcode(String zipcode){
		this.zipcode=zipcode;
	}
	public String getZipcode(){
		return this.zipcode;
	}
	
	public void setReceivename(String receivename){
		this.receivename=receivename;
	}
	public String getReceivename(){
		return this.receivename;
	}
	
	public void setPaymode(String paymode){
		this.paymode=paymode;
	}
	public String getPaymode(){
		return this.paymode;
	}
//--------------------------------------------------------------------------------------------------------------------
	public boolean add(ArrayList cart){
		boolean mark=false;
		StringBuffer sql=new StringBuffer();
		sql.append("insert into ordertable values('");
		sql.append(orderid);
		sql.append("','");
		sql.append(username);
		sql.append("','");
		sql.append(orderdate);
		sql.append("',");
		sql.append(orderstate);
		sql.append(",'");
		sql.append(address);
		sql.append("','");
		sql.append(tele);
		sql.append("','");
		sql.append(zipcode);
		sql.append("','");
		sql.append(receivename);
		sql.append("','");
		sql.append(paymode);
		sql.append("')");
		DBBean db=new DBBean();	
		Connection conn=db.createConn();
		Statement stmt=null;	
		Iterator icart=cart.iterator();
		try{
			//事务处理
			conn.setAutoCommit(false);
			stmt=conn.createStatement();
			//生成订单
			stmt.executeUpdate(sql.toString());
			//生成订单信息
			while(icart.hasNext()){
				ItemBean temp=(ItemBean)icart.next();
				//OrderlistBean orderlist=new OrderlistBean();
				String cid=temp.getGoods().getCid();
				int quantity=temp.getQuantity();
				StringBuffer sql2=new StringBuffer();
				sql2.append("insert into orderlist values('");
				sql2.append(orderid);
				sql2.append("','");
				sql2.append(cid);
				sql2.append("',");
				sql2.append(quantity);			
				sql2.append(")");				
				stmt.executeUpdate(sql2.toString());
			}
			conn.commit();			
			conn.close();
			mark=true;
		}catch(SQLException e){
			try{
				conn.rollback();
			}catch(SQLException ee){
				ee.printStackTrace();
			}
			e.printStackTrace();		
		}
		return mark;
//----------------------------------------------------------------------------------------------------------------				
	
	}
	public ArrayList findOrderByName(String name){
		String sql="select * from ordertable where username='"+name+"'";
		DBBean db=new DBBean();
		ResultSet rs=null;
		ArrayList myorders=new ArrayList();
		try{
			rs=db.executeQuery(sql);
			while(rs.next()){
				String tmpOrderid=rs.getString(1);
				String tmpOrderdate=rs.getString(3);
				int tmpOrderstate=rs.getInt(4);
				String tmpReceivename=rs.getString(8);
				String tmpAddress=rs.getString(5);
				String tmpTele=rs.getString(6);
				String tmpPaymode=rs.getString(9);
				OrderBean thisorder=new OrderBean();
				thisorder.setAddress(tmpAddress);
				thisorder.setOrderid(tmpOrderid);
				thisorder.setOrderdate(tmpOrderdate);
				thisorder.setReceivename(tmpReceivename);
				thisorder.setOrderstate(tmpOrderstate);
				thisorder.setTele(tmpTele);
				thisorder.setPaymode(tmpPaymode);
				myorders.add(thisorder);				
			}			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close();
		}
		return myorders;
		
	}

}
