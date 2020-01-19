package a3;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Data
 */
@WebServlet("/Data")
public class Data extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	PreparedStatement pr;
	ResultSet rs;
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Data() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();

		try
		{
			String url = "jdbc:mysql://localhost:3306/mvcdb";
			String user = "root";
			String pass = "MySQL";	
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		con=DriverManager.getConnection(url, user, pass);
		pr=con.prepareStatement("select * from  where manufacturer=?");		
		
		
		LoginNamePrint info = new LoginNamePrint();
		info.setId(id);
		info.setPasswd(passwd);
		request.setAttribute("information", info);

		RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp");
		rd.forward(request, response);
		
		
		
		}catch(Exception e)
		{
			System.out.print(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
