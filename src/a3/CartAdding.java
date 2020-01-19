package a3;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CartAdding
 */
@WebServlet("/CartAdding")
public class CartAdding extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	PreparedStatement pr;
	PreparedStatement ch;
	ResultSet rs;
	Statement st;
	private ShoesDAO shoesDAO;
	private CsrCustomerDAO customerDAO;
	       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartAdding() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//PrintWriter out = response.getWriter();

		 String connectionUrl = "jdbc:mysql://localhost:3306/mvcdb";
		 String connectionUser = "root";
		 String connectionPassword = "MySQL";
		 
		 shoesDAO =new ShoesDAO(connectionUrl, connectionUser, connectionPassword);
		 customerDAO=new CsrCustomerDAO(connectionUrl, connectionUser, connectionPassword);
		 try {
			
		
		   	int itemId = Integer.parseInt(request.getParameter("itemId"));
			Double shoeSize = Double.parseDouble(request.getParameter("size1"));
			Double price = Double.parseDouble(request.getParameter("price"));
			
			HttpSession session=request.getSession(false);
			String userName=(String)session.getAttribute("userName");
			System.out.println(userName);
			int customerId=customerDAO.getCustomerId(userName);
			System.out.println(customerId);
			ShoesBean bean =new ShoesBean();
			bean.setItemId(itemId);
			bean.setShoeSize(shoeSize);
			bean.setPrice(price);
			
			request.setAttribute("myBean", bean);
			request.setAttribute("customerId", customerId);
			

				RequestDispatcher dispatcher = request.getRequestDispatcher("CartList.jsp");
		        dispatcher.forward(request, response);
	
			
		}catch(Exception e)
		{
			e.printStackTrace();			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
//	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		ArrayList<ShoesBean> shoesList=shoesDAO.listShoes();
//		request.setAttribute("shoesList", shoesList);
//		System.out.println("inside list method of controller");
//		RequestDispatcher rd = request.getRequestDispatcher("CartList.jsp");
//		rd.forward(request, response);
//	}
}
