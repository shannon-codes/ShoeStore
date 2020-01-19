package a3;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ShoesController")
public class ShoesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	private ShoesDAO shoesDAO;
	
	
    public ShoesController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		 String connectionUrl = "jdbc:mysql://localhost:3306/mvcdb";
		 String connectionUser = "root";
		 String connectionPassword = "MySQL";
		 
		 shoesDAO =new ShoesDAO(connectionUrl, connectionUser, connectionPassword);
     try {
   	 
   	  System.out.print("controller top");
   	  
		 String choice = request.getParameter("submit");
		 
		 if(choice!=null) {

			 if (choice.equals("Add")) {
					add(request,response);
				}
				else if (choice.equals("Edit")) {
					edit(request,response);	
					System.out.print("inside edit");
					}
				
				else if (choice.equals("RefreshList")){
					list(request,response);	
				}
				 
		 }else {
			 System.out.print("else list");
			 list(request,response);	
		 }
		 
     }
     catch(Exception e) {
   	  e.getMessage();
   	  e.printStackTrace();
     }
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public void add(HttpServletRequest request, HttpServletResponse response) {
		try {
		
	       
	   	int itemId = Integer.parseInt(request.getParameter("itemId"));
		String itemName = request.getParameter("itemName");
		String category = request.getParameter("category");
		Double shoeSize = Double.parseDouble(request.getParameter("shoeSize"));
		Double price = Double.parseDouble(request.getParameter("price"));
		
		ShoesBean bean =new ShoesBean();
		bean.setItemId(itemId);
		bean.setItemName(itemName);
		bean.setCategory(category);
		bean.setShoeSize(shoeSize);
		bean.setPrice(price);
		
		boolean isSuccess = shoesDAO.addShoes(bean);
		String message;
		if (isSuccess) {
			message="Successfully Saved!";
		}else {
			message="Failed to Update.";
		}
		request.setAttribute("message", message);
		
		//request.setAttribute("myBean", bean);
			//RequestDispatcher dispatcher = request.getRequestDispatcher("/csrManageShoes.jsp");
	        //dispatcher.forward(request, response);
		list(request,response);
	
	}
	catch(Exception e){
		e.getMessage();
	}
	}
	
	public void edit(HttpServletRequest request, HttpServletResponse response) {
		try{
			
	   	int itemId = Integer.parseInt(request.getParameter("itemId"));
		String itemName = request.getParameter("itemName");
		String category = request.getParameter("category");
		Double shoeSize = Double.parseDouble(request.getParameter("shoeSize"));
		Double price = Double.parseDouble(request.getParameter("price"));
		
		ShoesBean bean =new ShoesBean();
		bean.setItemId(itemId);
		bean.setItemName(itemName);
		bean.setCategory(category);
		bean.setShoeSize(shoeSize);
		bean.setPrice(price);
		
		boolean isSuccess=shoesDAO.editShoes(bean);
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
	
	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ShoesBean> shoesList=shoesDAO.listShoes();
		request.setAttribute("shoesList", shoesList);
		System.out.println("inside list method of controller");
		RequestDispatcher rd = request.getRequestDispatcher("/CsrManageShoes.jsp");
		rd.forward(request, response);
	}
}