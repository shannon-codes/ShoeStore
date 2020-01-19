package a3;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserSubmitOrder
 */
@WebServlet("/UserSubmitOrder")
public class UserSubmitOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
  private CsrOrdersDAO orderDAO;
  
    public UserSubmitOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String connectionUrl = "jdbc:mysql://localhost:3306/mvcdb";
		 String connectionUser = "root";
		 String connectionPassword = "MySQL";
		 
		 orderDAO =new CsrOrdersDAO(connectionUrl, connectionUser, connectionPassword);
		

	   	int customerId = Integer.parseInt(request.getParameter("customerId"));
	   	int itemId = Integer.parseInt(request.getParameter("itemId"));
		String orderDate = request.getParameter("orderDate");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		String status = request.getParameter("status");
		
		OrderBean bean =new OrderBean();
		
		bean.setCustomerId(customerId);
		bean.setItemId(itemId);
		bean.setOrderDate(orderDate);
		bean.setQuantity(quantity);
		bean.setStatus(status);
		
		try {
			boolean isSuccess = orderDAO.addOrder(bean);
			String message;
			if (isSuccess) {
				message="Successfully Saved";
			}else {
				message="Failed";
			}
			request.setAttribute("message", message);
				RequestDispatcher dispatcher = request.getRequestDispatcher("UserViewOrdersController");
		        dispatcher.forward(request, response);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
