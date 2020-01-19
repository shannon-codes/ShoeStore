package a3;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserEditController
 */
@WebServlet("/UserEditController")
public class UserEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CsrOrdersDAO orderDAO;
	private CsrCustomerDAO customerDAO;
	
    public UserEditController() {
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
		 
		 orderDAO =new CsrOrdersDAO(connectionUrl, connectionUser, connectionPassword);
		 customerDAO =new CsrCustomerDAO(connectionUrl, connectionUser, connectionPassword);
		 
		 String choice = request.getParameter("submit");
		 if(choice!=null)
		 {
			 if(choice.equals("Edit")) {
				 userEdit(request,response);
				 getCustomer(request,response);
					getOrdersByCustomer(request,response);
					
			 }
		 }else {
			 getCustomer(request,response);
				getOrdersByCustomer(request,response);
		 }
		 
		 RequestDispatcher rd = request.getRequestDispatcher("/UserEditOrderForm.jsp");
			rd.forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public void getCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session=request.getSession(false);
			String userName = (String)session.getAttribute("userName");
			
			CustomerBean customerBean=customerDAO.getCustomerBean(userName);
			System.out.print(userName);
			request.setAttribute("customerBean", customerBean);
			
			System.out.println("inside getCustomer method of controller");
	}
	
	
	public void getOrdersByCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session=request.getSession(false);
			String userName = (String)session.getAttribute("userName");
			
			ArrayList<OrderBean> ordersList=orderDAO.getListByCustomer(userName);
			System.out.print(userName);
			request.setAttribute("ordersList", ordersList);
			String message=null;
			if(!ordersList.isEmpty()) {
				message= "Orders for Customer Id: "+userName;
			}else {
				message= "No orders exist for Customer Id: "+userName;
			}
			request.setAttribute("message", message);
			System.out.println("inside list by customer method of controller");
			
	}
	
	public void userEdit(HttpServletRequest request, HttpServletResponse response) {
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
		
		boolean checkStatus= orderDAO.checkStatus(orderId);
		
		if (checkStatus) {
			
			boolean isSuccess=orderDAO.editOrder(bean);
			String message;
			if (isSuccess) {
				message="Successfully Saved";
			}else {
				message="Failed";
			}
			request.setAttribute("feedback", message);
				
		}else {
			request.setAttribute("feedback", "unable to edit due to status of order in-process or delivered");
		
		}
		
		}
		catch (Exception e) {
			e.getMessage();
		}
	}


}