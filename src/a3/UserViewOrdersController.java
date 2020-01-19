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
 * Servlet implementation class UserViewOrdersController
 */
@WebServlet("/UserViewOrdersController")
public class UserViewOrdersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CsrOrdersDAO orderDAO;
	private CsrCustomerDAO customerDAO;
	
    public UserViewOrdersController() {
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
		
		 
				getCustomer(request,response);
				getOrdersByCustomer(request,response);
				RequestDispatcher rd = request.getRequestDispatcher("/UserViewOrder.jsp");
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
				message= "Orders for "+userName;
			}else {
				message= "No orders exist for Customer: "+userName;
			}
			request.setAttribute("message", message);
			System.out.println("inside list by customer method of controller");
			
	}
	
	


}
