package a3;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LogoutController")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public LogoutController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession(false);
		 if (session==null) {
			 System.out.println("No session available. User was not logged in.");
			 request.getRequestDispatcher("LoginFirst.jsp");   
			}
			else
			{
				 session.removeAttribute("userName");
				 session.invalidate();
				 System.out.println("Successfully logged out.");
					RequestDispatcher rd = request.getRequestDispatcher("/MainPage.jsp");
					rd.forward(request, response);
			  }
		    
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
