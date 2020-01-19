package a3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import a3.ShoesBean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ShoesDAO {

	 String connectionUrl;
	 String connectionUser;
	 String connectionPassword;
   Connection con;
    
   public ShoesDAO(String connectionUrl, String connectionUser, String connectionPassword) {
   	this.connectionUrl=connectionUrl;
   	this.connectionUser=connectionUser;
  	 	this.connectionPassword=connectionPassword;
   }
   
   public ArrayList<ShoesBean> listShoes(){
   	ArrayList<ShoesBean> shoesList=new ArrayList<>();
   	try {
   		Class.forName("com.mysql.jdbc.Driver").newInstance();     
  		 	con = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
  		 	String query="Select * from shoes";
  		 	Statement st = con.createStatement();
  	        ResultSet rs = st.executeQuery(query);
  	         
  	        while (rs.next()) {
  	        	int id=rs.getInt("itemId");
  	    		String in=rs.getString("itemName");
  	    		String cat=rs.getString("category");
  	    		Double size=rs.getDouble("shoesSize");
  	    		Double pr=rs.getDouble("price");
  	    		
  	           ShoesBean bean = new ShoesBean();
  	           bean.setItemId(id);
  	           bean.setItemName(in);
  	           bean.setCategory(cat);
  	           bean.setShoeSize(size);
  	           bean.setPrice(pr);
  	           
  	            shoesList.add(bean);
  	            
  	            System.out.println(id+in+cat+size+pr);
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
   	return shoesList;
   }
   
   public boolean addShoes(ShoesBean shoesBean) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
   	int numAffected = 0;
   	 boolean isSuccess=false;
		 try {
			 Class.forName("com.mysql.jdbc.Driver").newInstance();     
			con = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
			String insertQuery = "Insert into shoes values (?,?,?,?,?)"; 
		    PreparedStatement pst = con.prepareStatement(insertQuery);
			pst.setInt(1, shoesBean.getItemId());
			pst.setString(2, shoesBean.getItemName());
			pst.setString(3, shoesBean.getCategory());
			pst.setDouble(4, shoesBean.getShoeSize());
			pst.setDouble(5, shoesBean.getPrice());
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
   
   public boolean editShoes(ShoesBean shoesBean) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
   	int numAffected = 0;
   	 boolean isSuccess=false;
		 try {
			 Class.forName("com.mysql.jdbc.Driver").newInstance();     
			con = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
			String updateQuery = "Update shoes set itemName=?, category=?,shoesSize=?,price=? where itemId=?"; 
		    PreparedStatement pst = con.prepareStatement(updateQuery);
			
			pst.setString(1, shoesBean.getItemName());
			pst.setString(2, shoesBean.getCategory());
			pst.setDouble(3, shoesBean.getShoeSize());
			pst.setDouble(4, shoesBean.getPrice());
			pst.setInt(5, shoesBean.getItemId());
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
   

}
