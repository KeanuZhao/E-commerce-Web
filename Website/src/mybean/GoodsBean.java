package mybean;

import java.sql.*;
import java.util.ArrayList;
public class GoodsBean {
	private String cid;
	private String cname;
	private int cnumber;
	private int cprice;
	private String cintro;
	private ArrayList<GoodsBean> goodslist=new ArrayList<GoodsBean>();
	
	public void setCid(String cid){
		this.cid=cid;
	}
	public String getCid(){
		return this.cid;
	}
	
	public void setCname(String cname){
		this.cname=cname;
	}
	public String getCname(){
		return this.cname;
	}
	
	public void setCnumber(int cnumber){
		this.cnumber=cnumber;
	}
	public int getCnumber(){
		return this.cnumber;
	}
	
	public void setCprice(int cprice){
		this.cprice=cprice;
	}
	public int getCprice(){
		return this.cprice;
	}
	
	public void setCintro(String cintro){
		this.cintro=cintro;
	}
	public String getCintro(){
		return this.cintro;
	}
	
//------------------------------------------------------------------------------------------------------------------------------
	public boolean add() throws Exception{
		boolean mark=false;
		DBBean db=new DBBean();
		String sql="insert into goods values (?,?,?,?,?)";
		PreparedStatement pstmt=null;
		Connection conn=null;
		
		try{
			conn=db.createConn();
			pstmt=conn.prepareStatement(sql);			
			pstmt.setString(1,cid);
			pstmt.setString(2,cname);
			pstmt.setInt(3,cnumber);
			pstmt.setFloat(4,cprice);
			pstmt.setString(5,cintro);
			mark=pstmt.execute();
		}catch(Exception e){
			System.out.println("有错误");
		}finally{
			try {
				pstmt.close();
				}
			catch(Exception e){
				System.out.println("有错误1");
			}
			//try {fis.close();}catch(Exception e){}
			try {
				conn.close();
				}
			catch(Exception e){
				System.out.println("有错误2");
			}
		}
		return mark;
		
	}
	//-----------------------------------------------------------------------------------------
	//获取所有的商品信息
	public ArrayList<GoodsBean> getGoodsByPage(int pageNo){
		
		DBBean db=new DBBean();
		int begin=(pageNo-1)*10+1;
		int end=pageNo*10;
		int index=0;
		String sql="select * from goods";
		ResultSet rs=null;
		try{
			rs=db.executeQuery(sql);
			while(rs.next()){
				index++;
				if(index<begin) 
					continue;
				if(index>end) 
					break;
				String tmpCid=rs.getString(1);
				String tmpCname=rs.getString(2);
				int tmpCprice=rs.getInt(4);
				
				//写入到JavaBean中
				GoodsBean g=new GoodsBean();
				g.setCid(tmpCid);
				g.setCname(tmpCname);
				g.setCprice(tmpCprice);
			
				goodslist.add(g);				
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close();
		}
		return goodslist;
	}
	//----------------------------------------------------------------------------------------------------------
	//获取页码总数
	public int getPageCount(){
		DBBean db=new DBBean();
		String sql="select count(*) from goods";
		ResultSet rs=null;
		int pageCount=1;
		try{
			rs=db.executeQuery(sql);
			rs.next();
			int n=rs.getInt(1);
			pageCount=(int)((n-1)/10+1);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close();
		}
		return pageCount;
	}
	//------------------------------------------------------------------------------------------------------------
	public GoodsBean findGoodsById(String cid){		
		try{
			String sql="select * from goods where cid = '"+cid+"'";
			DBBean db=new DBBean();
			ResultSet rs=null;
			rs=db.executeQuery(sql);
			if(rs.next()){
				String cname=rs.getString(2);
				int cprice=rs.getInt(4);
				GoodsBean temp=new GoodsBean();
				temp.setCname(cname);
				temp.setCid(cid);
				temp.setCprice(cprice);
				db.close();
				return temp;
			}else{
				return null;
			}
		}catch(Exception e){
			System.out.print(e.toString());
			return null;
		}
		
		
	}
	
}
