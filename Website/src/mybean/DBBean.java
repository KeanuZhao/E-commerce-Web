package mybean;

//导入创建应用数据要用到的类
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class DBBean {
	private String classname="com.mysql.jdbc.Driver";	//数据库驱动类路径
	private String url="jdbc:mysql://localhost:3306/users"; //数据库URL
	private String user="root";	//登录数据库的用户名
	private String pwd="111111";	//登录数据库的密码
	
	private Connection conn=null;	//申明一个Connection对象
	private Statement stmt=null; //声明一个Statement对象
	private ResultSet rs=null;
	private PreparedStatement pstmt=null;
	
	/*通过构造方法加载数据库驱动*/
	public DBBean(){	//DB类的构造方法
	/*	try{	//必须使用try catch语句捕获加载数据库驱动时可能发生的异常
			Class.forName(classname).newInstance();	//加载数据库驱动
			conn=DriverManager.getConnection(url, user, pwd);
		}catch (Exception e){
			e.printStackTrace();	//输出异常信息
			System.out.println("加载数据库驱动失败！！");
		}*/		
	}
	/*创建数据库连接*/
	public Connection createConn(){
 		try{
			Class.forName(classname);	//加载数据库驱动
			conn=DriverManager.getConnection(url, user, pwd);
		}catch(SQLException e){
			//e.printStackTrace();
			System.out.println("获取数据库连接失败！！");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("获取数据库连接失败！！");
		} 
		return conn;
	}
	
	/*获取Statement对象*/
	public void getStmt(){
		createConn();
		try{
			//调用Connection类实例的createStatement()方法创建一个Statement类对象
			stmt=conn.createStatement();
		}catch(SQLException e){
			//e.printStackTrace();
			System.out.println("创建Statement对象失败！！");			
		}
	}
	

	
	/*创建对数据库进行操作的增加、删除和修改的executeUpdate()方法*/
	public boolean executeUpdate(String sql){
		boolean mark=false;
		try{
			getStmt();	//创建一个Statement对象
			int iCount=stmt.executeUpdate(sql);	//执行操作，并获取所影响的记录数
			if(iCount>0)	//更新数据库成功
				mark=true;
			else			//更新失败
				mark=false;			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return mark;
	}
	
	/*查询数据库*/
	public ResultSet executeQuery(String sql){
		
		try{
			getStmt();
			try{
				rs=stmt.executeQuery(sql);
			}catch(Exception e){
			//	e.printStackTrace();
				System.out.println("查询数据库失败！！");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return rs;
	}
	public void close(){
		try{
			if(rs!=null)
				rs.close();
			}
		catch(Exception e){
			
		}
		try {
			stmt.close();
			}
		catch(Exception e){
			
		}
		try {
			conn.close();
			}
		catch(Exception e){
			
		}
	}
	
	

}
