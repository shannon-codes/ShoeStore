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
 * Servlet implementation class CsrCustomerController
 */
@WebServlet("/CsrCustomerController")
public class CsrCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
	private CsrCustomerDAO customerDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CsrCustomerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String connectionUrl = "jdbc:mysql://localhost:3306/mvcdb";
		 String connectionUser = "root";
		 String connectionPassword = "MySQL";
		 
		 customerDAO =new CsrCustomerDAO(connectionUrl, connectionUser, connectionPassword);
     try {
   	  System.out.println("inside controller");
		 String choice = request.getParameter("submit");
		 String choiceDelete = request.getParameter("customerId");
		 String choicePopulateEdit = request.getParameter("userName");
				 
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
		 } else if (choiceDelete!=null) {
			 delete(request,response);
		 }
		 else if (choicePopulateEdit!=null) {
	 		 populateEdit(request,response);
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
		try {
		
	       
	   	int customerId = Integer.parseInt(request.getParameter("customerId"));
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String postalCode = request.getParameter("postalCode");
		
		CustomerBean bean =new CustomerBean();
		bean.setCustomerId(customerId);
		bean.setUserName(userName);
		bean.setPassword(password);
		bean.setFirstname(firstname);
		bean.setLastname(lastname);
		bean.setAddress(address);
		bean.setCity(city);
		bean.setPostalCode(postalCode);
		
		boolean isSuccess=customerDAO.addCustomer(bean);
		String message;
		if (isSuccess) {
			message="Successfully Saved!";
		}else {
			message="Failed to Update.";
		}
		request.setAttribute("message", message);
		
list(request,response);
	
	}
	catch(Exception e){
		e.getMessage();
	}
	}
	
	public void edit(HttpServletRequest request, HttpServletResponse response) {
		try{
			
	   	int customerId = Integer.parseInt(request.getParameter("customerId"));
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String postalCode = request.getParameter("postalCode");
		
		CustomerBean bean =new CustomerBean();
		bean.setCustomerId(customerId);
		bean.setUserName(userName);
		bean.setPassword(password);
		bean.setFirstname(firstname);
		bean.setLastname(lastname);
		bean.setAddress(address);
		bean.setCity(city);
		bean.setPostalCode(postalCode);
		
		
		boolean isSuccess=customerDAO.editCustomer(bean);
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
		try{
			
			int customerId = Integer.parseInt(request.getParameter("customerId"));
		CustomerBean bean =new CustomerBean();
		bean.setCustomerId(customerId);
		
		
		boolean isSuccess=customerDAO.deleteCustomer(bean);
		String message;
		if (isSuccess) {
			message="Successful Deleted";
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
	
	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<CustomerBean> customerList=customerDAO.listCustomers();
		request.setAttribute("customerList", customerList);
		System.out.println("inside list method of controller");
		RequestDispatcher rd = request.getRequestDispatcher("/CsrManageCustomers.jsp");
		rd.forward(request, response);
	}
	
	public void populateEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String userName = request.getParameter("userName");
		CustomerBean customer=customerDAO.getCustomerBean(userName);
		request.setAttribute("customer", customer);
		System.out.println("inside populate method of controller");
		list(request,response);
		//RequestDispatcher rd = request.getRequestDispatcher("/csrManageOrders.jsp");
		//rd.forward(request, response);
	}
}
