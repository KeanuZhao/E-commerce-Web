package mybean;

import java.sql.ResultSet;

public class Users {
 private String username = "";
 private String password = "";
 public String getPassword() {
  return password;
 }
 public void setPassword(String password) {
  this.password = password;
 }
 public String getUsername() {
  return username;
 }
 public void setUsername(String username) {
  this.username = username;
 }
 public boolean validate(){
     DBBean db=new DBBean();
	 try{     
	    ResultSet rs=db.executeQuery("select * from userinfo where username='"+username+"'and password='"+password+"'");
	    if(rs!=null){
	        if(rs.next()) {
	           return true;
	        }
	        else{
	           return false;
	        }
	    }
	    else{
	        return false;
	    }
	 }catch(Exception e){
			System.out.print(e.toString());
			return false;
	 }
	
 }
}