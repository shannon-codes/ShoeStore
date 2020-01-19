package a3;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class CsrCustomerDAO {

		 String connectionUrl;
		 String connectionUser;
		 String connectionPassword;
	    Connection con;
	     
	    public CsrCustomerDAO(String connectionUrl, String connectionUser, String connectionPassword) {
	    	this.connectionUrl=connectionUrl;
	    	this.connectionUser=connectionUser;
	   	 	this.connectionPassword=connectionPassword;
	    }
	    
	    public ArrayList<CustomerBean> listCustomers(){
	    	ArrayList<CustomerBean> customersList=new ArrayList<>();
	    	try {
	    		Class.forName("com.mysql.jdbc.Driver").newInstance();     
	   		 	con = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
	   		 	String query="Select * from customers";
	   		 	Statement st = con.createStatement();
	   	        ResultSet rs = st.executeQuery(query);
	   	         
	   	        while (rs.next()) {
	   	        	int id=rs.getInt("customerId");
	   	    		String in=rs.getString("userName");
	   	    		String pw=rs.getString("password");
	   	    		String fn=rs.getString("firstname");
	   	    		String ln=rs.getString("lastname");
	   	    		String ad=rs.getString("address");
	   	    		String c=rs.getString("city");
	   	    		String pc=rs.getString("postalCode");
	   	    		
	   	           CustomerBean bean = new CustomerBean();
	   	           bean.setCustomerId(id);
	   	           bean.setUserName(in);
	   	           bean.setPassword(pw);
	   	           bean.setFirstname(fn);
	   	           bean.setLastname(ln);
	   	           bean.setAddress(ad);
	   	           bean.setCity(c);
	   	           bean.setPostalCode(pc);
	   	        
	   	            customersList.add(bean);
	   	            
	   	        }
	   	         
	   	     if(rs!=null) {
					rs.close();}
	   	     if(st!=null) {
					st.close();}
					if(con!=null) {
						con.close();}
	       	
	    	}catch (Exception e){
	    		e.getMessage();
	    	}
	    	return customersList;
	    }
	    
	    public boolean addCustomer(CustomerBean customerBean) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
	    	int numAffected = 0;
	    	 boolean isSuccess=false;
			 try {
				 Class.forName("com.mysql.jdbc.Driver").newInstance();     
				con = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
				String insertQuery = "Insert into customers values (?,?,?,?,?,?,?,?)"; 
			    PreparedStatement pst = con.prepareStatement(insertQuery);
			    pst.setInt(1, customerBean.getCustomerId());
			    pst.setString(2, customerBean.getUserName());
				pst.setString(3, customerBean.getPassword());
				pst.setString(4, customerBean.getFirstname());
				pst.setString(5, customerBean.getLastname());
				pst.setString(6, customerBean.getAddress());
				pst.setString(7, customerBean.getCity());
				pst.setString(8, customerBean.getPostalCode());
				
				numAffected=pst.executeUpdate();
			 isSuccess=numAffected>0;
			 
			 if(pst!=null) {
					pst.close();}
					if(con!=null) {
						con.close();}
			 
			 } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 return isSuccess;
	    }
	    
	    public boolean editCustomer(CustomerBean customerBean) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
	    	int numAffected = 0;
	    	 boolean isSuccess=false;
			 try {
				 Class.forName("com.mysql.jdbc.Driver").newInstance();     
				con = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
				String updateQuery = "Update customers set userName=?,password=?,firstname=?, lastname=?, address=?, city=?, postalCode=? where customerId=?"; 
			    PreparedStatement pst = con.prepareStatement(updateQuery);
				
			    pst.setString(1, customerBean.getUserName());
				pst.setString(2, customerBean.getPassword());
				pst.setString(3, customerBean.getFirstname());
				pst.setString(4, customerBean.getLastname());
				pst.setString(5, customerBean.getAddress());
				pst.setString(6, customerBean.getCity());
				pst.setString(7, customerBean.getPostalCode());
				pst.setInt(8, customerBean.getCustomerId());
				numAffected=pst.executeUpdate();
			 isSuccess=numAffected>0;
			 
			if(pst!=null) {
					pst.close();}
					if(con!=null) {
						con.close();}
			 
			 } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 return isSuccess;
	    }
	    
	    public boolean deleteCustomer(CustomerBean customerBean) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
	    	int numAffected = 0;
	    	 boolean isSuccess=false;
			 try {
				 Class.forName("com.mysql.jdbc.Driver").newInstance();     
				con = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
				String childQuery = "Delete from orders where customerId=?"; 
				String parentQuery = "Delete from customers where customerId=?"; 
			    PreparedStatement pst1 = con.prepareStatement(childQuery);
			    PreparedStatement pst2 = con.prepareStatement(parentQuery);
				pst1.setInt(1, customerBean.getCustomerId());
				pst2.setInt(1, customerBean.getCustomerId());
				pst1.executeUpdate();
				numAffected=pst2.executeUpdate();
				
			 isSuccess=numAffected>0;
			 
			if(pst1!=null) {
					pst1.close();
					pst2.close();}
					if(con!=null) {
						con.close();}
			 
			 } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 return isSuccess;
	    }
	    
	    public CustomerBean getCustomerBean(String userName){
		   	CustomerBean bean=new CustomerBean();
		   	try {
		   		Class.forName("com.mysql.jdbc.Driver").newInstance();     
		  		 	con = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
		  		 	String query="Select * from customers where userName=?";
		  		 	PreparedStatement pst = con.prepareStatement(query);
		  		 	pst.setString(1, userName);
		  	        ResultSet rs = pst.executeQuery();
		  	         
		  	      while (rs.next()) {
		   	        	int id=rs.getInt("customerId");
		   	    		String un=rs.getString("userName");
		   	    		String pw=rs.getString("password");
		   	    		String fn=rs.getString("firstname");
		   	    		String ln=rs.getString("lastname");
		   	    		String ad=rs.getString("address");
		   	    		String c=rs.getString("city");
		   	    		String pc=rs.getString("postalCode");
		   	    		
		   	           bean.setCustomerId(id);
		   	           bean.setUserName(un);
		   	           bean.setPassword(pw);
		   	           bean.setFirstname(fn);
		   	           bean.setLastname(ln);
		   	           bean.setAddress(ad);
		   	           bean.setCity(c);
		   	           bean.setPostalCode(pc);
		   	           
		   	           System.out.println(id+" "+un);
		   	        }
		  	      
		  	     if(rs!=null) {
						rs.close();}
		  	     if(pst!=null) {
						pst.close();}
						if(con!=null) {
							con.close();}
		      	
		   	}catch (Exception e){
		   		e.getMessage();
		   	}
		   	return bean;
		   }
	    public int getCustomerId(String userName){
		  
		   	System.out.print("inside get id method");
		   	int id=0;
		   	try {
		   		Class.forName("com.mysql.jdbc.Driver").newInstance();     
		  		 	con = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
		  		 	String query="Select customerId from customers where userName=?";
		  		 	PreparedStatement pst = con.prepareStatement(query);
		  		 	pst.setString(1, userName);
		  	        ResultSet rs = pst.executeQuery();
		  	         
		  	      while (rs.next()) {
		   	        	id=rs.getInt("customerId");
		   	        	System.out.println(id);
		   	        }
		  	    
		      	
		   	}catch (Exception e){
		   		e.getMessage();
		   	}
		   	return id;
		   }
	    


	}
