package mybean;

public class OrderlistBean {
	private String orderid;
	private String cid;
	private int quantity;
	
	public void setOrderid(String orderid){
		this.orderid=orderid;
	}
	public String getOrderid(){
		return this.orderid;
	}
	public void setCid(String cid){
		this.cid=cid;
	}
	public String getCid(){
		return this.cid;
	}
	public void setQuantity(int quantity){
		this.quantity=quantity;
	}
	public int getQuantity(){
		return this.quantity;
	}
	public boolean add(){
		boolean mark=false;
		StringBuffer sql=new StringBuffer();
		sql.append("insert into orderlist values('");
		sql.append(orderid);
		sql.append("','");
		sql.append(cid);
		sql.append("',");
		sql.append(quantity);			
		sql.append(")");
		DBBean db=new DBBean();
		try{
			mark=db.executeUpdate(sql.toString());
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close();
		}
		return mark;
	}
}
