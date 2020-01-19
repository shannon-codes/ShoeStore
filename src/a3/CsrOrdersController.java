package a3;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





/**
 * Servlet implementation class CsrOrdersController
 */
@WebServlet("/CsrOrdersController")
public class CsrOrdersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private CsrOrdersDAO orderDAO;

	
    public CsrOrdersController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String connectionUrl = "jdbc:mysql://localhost:3306/mvcdb";
		 String connectionUser = "root";
		 String connectionPassword = "MySQL";
		 
		 orderDAO =new CsrOrdersDAO(connectionUrl, connectionUser, connectionPassword);
    try {
  	  System.out.println("inside controller");
		 String choice = request.getParameter("submit");
		 String orderId = request.getParameter("orderId");
		 String customerId = request.getParameter("customerId");
		 
				 
		 if(choice!=null) {
		 
			if (choice.equals("Add")) {
				add(request,response);
			}
			else if (choice.equals("Edit")) {
				edit(request,response);	
				}
			
			else if (choice.equals("List")){
				list(request,response);	
			}
		 } else if (orderId!=null) {
			 populateEdit(request,response);
		 }
		else if (customerId!=null) {
		 listByCustomer(request,response);
		}
		else {
			list(request,response);	
		}
    }
    catch(Exception e) {
  	  e.getMessage();
    }
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public void add(HttpServletRequest request, HttpServletResponse response) {
//		try {
//		
//	       
//	   	int customerId = Integer.parseInt(request.getParameter("customerId"));
//		String userName = request.getParameter("userName");
//		String password = request.getParameter("password");
//		String firstname = request.getParameter("firstname");
//		String lastname = request.getParameter("lastname");
//		String address = request.getParameter("address");
//		String city = request.getParameter("city");
//		String postalCode = request.getParameter("postalCode");
//		
//		CustomerBean bean =new CustomerBean();
//		bean.setCustomerId(customerId);
//		bean.setUserName(userName);
//		bean.setPassword(password);
//		bean.setFirstname(firstname);
//		bean.setLastname(lastname);
//		bean.setAddress(address);
//		bean.setCity(city);
//		bean.setPostalCode(postalCode);
//		
//		boolean isSuccess=orderDAO.addCustomer(bean);
//		String message;
//		if (isSuccess) {
//			message="Successfully Saved!";
//		}else {
//			message="Failed to Update.";
//		}
//		request.setAttribute("message", message);
//		
//list(request,response);
//	
//	}
//	catch(Exception e){
//		e.getMessage();
//	}
	}
	
	public void edit(HttpServletRequest request, HttpServletResponse response) {
		try{
			
	   	int orderId = Integer.parseInt(request.getParameter("orderId"));
	   	int customerId = Integer.parseInt(request.getParameter("customerId"));
	   	int itemId = Integer.parseInt(request.getParameter("itemId"));
		String orderDate = request.getParameter("orderDate");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		String status = request.getParameter("status");
		
		OrderBean bean =new OrderBean();
		bean.setOrderId(orderId);
		bean.setCustomerId(customerId);
		bean.setItemId(itemId);
		bean.setOrderDate(orderDate);
		bean.setQuantity(quantity);
		bean.setStatus(status);
		
		boolean isSuccess=orderDAO.editOrder(bean);
		String message;
		if (isSuccess) {
			message="Successfully Saved";
		}else {
			message="Failed";
		}
		request.setAttribute("message", message);
			//RequestDispatcher dispatcher = request.getRequestDispatcher("/csrManageShoes.jsp");
	        //dispatcher.forward(request, response);
		list(request,response);
		}
		catch (Exception e) {
			e.getMessage();
		}
	}
	
	public void delete(HttpServletRequest request, HttpServletResponse response) {
//		try{
//			
//			int customerId = Integer.parseInt(request.getParameter("customerId"));
//		CustomerBean bean =new CustomerBean();
//		bean.setCustomerId(customerId);
//		
//		
//		boolean isSuccess=orderDAO.deleteCustomer(bean);
//		String message;
//		if (isSuccess) {
//			message="Successful Deleted";
//		}else {
//			message="Failed";
//		}
//		request.setAttribute("message", message);
//			//RequestDispatcher dispatcher = request.getRequestDispatcher("/csrManageShoes.jsp");
//	        //dispatcher.forward(request, response);
//		list(request,response);
//		}
//		catch (Exception e) {
//			e.getMessage();
//		}
	}
	
	public void populateEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int orderId = Integer.parseInt(request.getParameter("orderId"));
		OrderBean order=orderDAO.getOrder(orderId);
		request.setAttribute("order", order);
		System.out.println("inside populate method of controller");
		list(request,response);
		//RequestDispatcher rd = request.getRequestDispatcher("/csrManageOrders.jsp");
		//rd.forward(request, response);
	}
	
	public void listByCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int customerId = Integer.parseInt(request.getParameter("customerId"));
		ArrayList<OrderBean> ordersList=orderDAO.getListByCustomer(customerId);
		request.setAttribute("ordersList", ordersList);
		request.setAttribute("customerId", customerId);
		String message=null;
		if(!ordersList.isEmpty()) {
			message= "Orders for Customer Id: "+customerId;
		}else {
			message= "No orders exist for Customer Id: "+customerId;
		}
		request.setAttribute("message", message);
		System.out.println("inside list by customer method of controller");
		RequestDispatcher rd = request.getRequestDispatcher("/CsrManageOrders.jsp");
		rd.forward(request, response);
	}
	
	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<OrderBean> ordersList=orderDAO.listOrders();
		request.setAttribute("ordersList", ordersList);
		System.out.println("inside list method of controller");
		RequestDispatcher rd = request.getRequestDispatcher("/CsrManageOrders.jsp");
		rd.forward(request, response);
	}
	
	
}
