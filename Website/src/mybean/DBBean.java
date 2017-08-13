package mybean;

//���봴��Ӧ������Ҫ�õ�����
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class DBBean {
	private String classname="com.mysql.jdbc.Driver";	//���ݿ�������·��
	private String url="jdbc:mysql://localhost:3306/users"; //���ݿ�URL
	private String user="root";	//��¼���ݿ���û���
	private String pwd="111111";	//��¼���ݿ������
	
	private Connection conn=null;	//����һ��Connection����
	private Statement stmt=null; //����һ��Statement����
	private ResultSet rs=null;
	private PreparedStatement pstmt=null;
	
	/*ͨ�����췽���������ݿ�����*/
	public DBBean(){	//DB��Ĺ��췽��
	/*	try{	//����ʹ��try catch��䲶��������ݿ�����ʱ���ܷ������쳣
			Class.forName(classname).newInstance();	//�������ݿ�����
			conn=DriverManager.getConnection(url, user, pwd);
		}catch (Exception e){
			e.printStackTrace();	//����쳣��Ϣ
			System.out.println("�������ݿ�����ʧ�ܣ���");
		}*/		
	}
	/*�������ݿ�����*/
	public Connection createConn(){
 		try{
			Class.forName(classname);	//�������ݿ�����
			conn=DriverManager.getConnection(url, user, pwd);
		}catch(SQLException e){
			//e.printStackTrace();
			System.out.println("��ȡ���ݿ�����ʧ�ܣ���");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("��ȡ���ݿ�����ʧ�ܣ���");
		} 
		return conn;
	}
	
	/*��ȡStatement����*/
	public void getStmt(){
		createConn();
		try{
			//����Connection��ʵ����createStatement()��������һ��Statement�����
			stmt=conn.createStatement();
		}catch(SQLException e){
			//e.printStackTrace();
			System.out.println("����Statement����ʧ�ܣ���");			
		}
	}
	

	
	/*���������ݿ���в��������ӡ�ɾ�����޸ĵ�executeUpdate()����*/
	public boolean executeUpdate(String sql){
		boolean mark=false;
		try{
			getStmt();	//����һ��Statement����
			int iCount=stmt.executeUpdate(sql);	//ִ�в���������ȡ��Ӱ��ļ�¼��
			if(iCount>0)	//�������ݿ�ɹ�
				mark=true;
			else			//����ʧ��
				mark=false;			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return mark;
	}
	
	/*��ѯ���ݿ�*/
	public ResultSet executeQuery(String sql){
		
		try{
			getStmt();
			try{
				rs=stmt.executeQuery(sql);
			}catch(Exception e){
			//	e.printStackTrace();
				System.out.println("��ѯ���ݿ�ʧ�ܣ���");
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
