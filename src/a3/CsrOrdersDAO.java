package a3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;

public class CsrOrdersDAO {
	 String connectionUrl;
	 String connectionUser;
	 String connectionPassword;
   Connection con;
    
   public CsrOrdersDAO(String connectionUrl, String connectionUser, String connectionPassword) {
   	this.connectionUrl=connectionUrl;
   	this.connectionUser=connectionUser;
  	 	this.connectionPassword=connectionPassword;
   }
   
   public ArrayList<OrderBean> listOrders(){
   	ArrayList<OrderBean> orderList=new ArrayList<>();
   	try {
   		Class.forName("com.mysql.jdbc.Driver").newInstance();     
  		 	con = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
  		 	String query="Select * from orders";
  		 	Statement st = con.createStatement();
  	        ResultSet rs = st.executeQuery(query);
  	         
  	        while (rs.next()) {
  	        	int oid=rs.getInt("orderId");
  	        	int cid=rs.getInt("customerId");
  	        	int iid=rs.getInt("itemId");
  	    		Date date=rs.getDate("orderDate");
  	    		int q=rs.getInt("quantity");
  	    		String s=rs.getString("status");
  	    		 String d=date.toString();
  	    		
  	    		
  	           OrderBean bean = new OrderBean();
  	           bean.setOrderId(oid);
  	           bean.setCustomerId(cid);
  	           bean.setItemId(iid);
  	           bean.setOrderDate(d);
  	           bean.setQuantity(q);
  	           bean.setStatus(s);
  	            orderList.add(bean);
  	            
  	            System.out.println(oid+" "+cid+" "+iid+d+q+s);
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
   	return orderList;
   }
   
   public OrderBean getOrder(int orderId){
	   	OrderBean bean=new OrderBean();
	   	try {
	   		Class.forName("com.mysql.jdbc.Driver").newInstance();     
	  		 	con = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
	  		 	String query="Select * from orders where orderId=?";
	  		 	PreparedStatement pst = con.prepareStatement(query);
	  		 	pst.setInt(1, orderId);
	  	        ResultSet rs = pst.executeQuery();
	  	         
	  	        while (rs.next()) {
	  	        	int oid=rs.getInt("orderId");
	  	        	int cid=rs.getInt("customerId");
	  	        	int iid=rs.getInt("itemId");
	  	    		Date date=rs.getDate("orderDate");
	  	    		int q=rs.getInt("quantity");
	  	    		String s=rs.getString("status");
	  	    		 String d=date.toString();
	  	    		
	  	           bean.setOrderId(oid);
	  	           bean.setCustomerId(cid);
	  	           bean.setItemId(iid);
	  	           bean.setOrderDate(d);
	  	           bean.setQuantity(q);
	  	           bean.setStatus(s);
	  	            
	  	            System.out.println(oid+" "+cid+" "+iid+d+q+s);
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
   
   public ArrayList<OrderBean> getListByCustomer(int customerId){
	   ArrayList<OrderBean> orderList=new ArrayList<>();
	 
	   	try {
	   		Class.forName("com.mysql.jdbc.Driver").newInstance();     
	  		 	con = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
	  		 	String query="Select * from orders where customerId=?";
	  		 	PreparedStatement pst = con.prepareStatement(query);
	  		 	pst.setInt(1, customerId);
	  	        ResultSet rs = pst.executeQuery();
	  	         
	  	        while (rs.next()) {
	  	        	int oid=rs.getInt("orderId");
	  	        	int cid=rs.getInt("customerId");
	  	        	int iid=rs.getInt("itemId");
	  	    		Date date=rs.getDate("orderDate");
	  	    		int q=rs.getInt("quantity");
	  	    		String s=rs.getString("status");
	  	    		 String d=date.toString();
	  	    		
	  	    		OrderBean bean = new OrderBean();
	   	           bean.setOrderId(oid);
	   	           bean.setCustomerId(cid);
	   	           bean.setItemId(iid);
	   	           bean.setOrderDate(d);
	   	           bean.setQuantity(q);
	   	           bean.setStatus(s);
	   	            orderList.add(bean);
	  	            
	  	            System.out.println(oid+" "+cid+" "+iid+d+q+s);
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
	   	return orderList;
	   }
   
   public boolean editOrder(OrderBean orderBean) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
   	int numAffected = 0;
   	 boolean isSuccess=false;
		 try {
			 Class.forName("com.mysql.jdbc.Driver").newInstance();     
			con = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
			String updateQuery = "Update orders set customerId=?, itemId=?, orderDate=?, quantity=?, status=? where orderId=?"; 
		    PreparedStatement pst = con.prepareStatement(updateQuery);
		    
			pst.setInt(1, orderBean.getCustomerId());
			pst.setInt(2, orderBean.getItemId());
			pst.setString(3, orderBean.getOrderDate());
			pst.setInt(4, orderBean.getQuantity());
			pst.setString(5, orderBean.getStatus());
			pst.setInt(6, orderBean.getOrderId());
			
			numAffected=pst.executeUpdate();
		 isSuccess=numAffected>0;
		 
		if(pst!=null) {
				pst.close();}
				if(con!=null) {
					con.close();}
		 
		 } catch (Exception e) {
				e.printStackTrace();
			}
		 return isSuccess;
   }
   
   public boolean addOrder(OrderBean orderBean) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
	   	int numAffected = 0;
	   	 boolean isSuccess=false;
			 try {
				 Class.forName("com.mysql.jdbc.Driver").newInstance();     
				con = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
				String updateQuery = "Insert into orders (customerId, itemId, orderDate, quantity, status) values (?,?,?,?,?)"; 
			    PreparedStatement pst = con.prepareStatement(updateQuery);
			    
			   
				pst.setInt(1, orderBean.getCustomerId());
				pst.setInt(2, orderBean.getItemId());
				pst.setString(3, orderBean.getOrderDate());
				pst.setInt(4, orderBean.getQuantity());
				pst.setString(5, orderBean.getStatus());
				
				
				numAffected=pst.executeUpdate();
			 isSuccess=numAffected>0;
			 
			if(pst!=null) {
					pst.close();}
					if(con!=null) {
						con.close();}
			 
			 } catch (Exception e) {
					e.printStackTrace();
				}
			 return isSuccess;
	   }
   public ArrayList<OrderBean> getListByCustomer(String userName){
	   ArrayList<OrderBean> orderList=new ArrayList<>();
	 
	   	try {
	   		Class.forName("com.mysql.jdbc.Driver").newInstance();     
	  		 	con = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
	  		 	
	  	        
	  		 	String query="Select orders.orderId,orders.customerId,orders.itemId,orders.orderDate,orders.quantity,orders.status from orders inner join customers on (orders.customerId = customers.customerId) where userName=?";
	  		 	PreparedStatement pst2 = con.prepareStatement(query);
	  		 	pst2.setString(1, userName);
	  	        ResultSet rs2 = pst2.executeQuery();
	  	         
	  	        while (rs2.next()) {
	  	        	int oid=rs2.getInt("orderId");
	  	        	int cid=rs2.getInt("customerId");
	  	        	int iid=rs2.getInt("itemId");
	  	    		Date date=rs2.getDate("orderDate");
	  	    		int q=rs2.getInt("quantity");
	  	    		String s=rs2.getString("status");
	  	    		 String d=date.toString();
	  	    		
	  	    		OrderBean bean = new OrderBean();
	   	           bean.setOrderId(oid);
	   	           bean.setCustomerId(cid);
	   	           bean.setItemId(iid);
	   	           bean.setOrderDate(d);
	   	           bean.setQuantity(q);
	   	           bean.setStatus(s);
	   	            orderList.add(bean);
	  	            
	  	            System.out.println(oid+" "+cid+" "+iid+d+q+s);
	  	        }
	  	         
	  	     if(rs2!=null) {
					rs2.close();}
	  	     if(pst2!=null) {
					pst2.close();}
					if(con!=null) {
						con.close();}
	      	
	   	}catch (Exception e){
	   		e.getMessage();
	   	}
	   	return orderList;
	   }

   
   public boolean checkStatus(int Id) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
	   System.out.println("inside check status");
	   	String status=null;
			 try {
				 Class.forName("com.mysql.jdbc.Driver").newInstance();     
				con = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
				String query="Select status from orders where orderId=?";
	  		 	PreparedStatement pst2 = con.prepareStatement(query);
	  		 	pst2.setInt(1, Id);
	  	        ResultSet rs2 = pst2.executeQuery();
	  	        
	  	        while (rs2.next()) {
	  	    		status=rs2.getString("status");
	  	        }
	  	      
	  	        System.out.println(status);
	  	        
	  	     if(rs2!=null) {
					rs2.close();}
	  	     if(pst2!=null) {
					pst2.close();}
					if(con!=null) {
						con.close();}
			 
			 } catch (Exception e) {
					e.printStackTrace();
				}
			  
			 if(status.equals("order placed")) {
	  	        	return true;
	  	        }
	  	        else {
	  	        	return false;
	  	        }
	  	      
	   }

}