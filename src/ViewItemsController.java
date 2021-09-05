import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


/**
 * Servlet implementation class ViewItemsController
 */
@WebServlet("/ViewItemsController")
public class ViewItemsController extends HttpServlet  implements DBConnector{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewItemsController() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Items items = new Items();
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		
		Connection DB;
		
		String query = "select * from items";
		out.print("<h1>Products List</h1>");
		out.print("<table border = 1 cellpadding = 5 ><tr bgcolor = #4CAF50 >"
				+ "<td>Name</td>"
				+ "<td>Id</td>"
				+ "<td>Price</td>"
				+ "<td>Qty</td>"
				+ "<td>Category</td>"
				+ "<td>Description</td>"
				+ "<td>Image</td>"
				+ "</tr>");
		
		try {
			DB = DBConnector.newConnection();
			
			ResultSet rs  = DBConnector.DBquery(query);
			while(rs.next()) {
				out.print("<tr><td>");
				out.print(rs.getString(1));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getString(2));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getInt(3));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getInt(4));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getString(5));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getString(6));
				out.print("</td>");
				out.print("<td>");
				out.print("<img src='" + rs.getString(7) + "' + height='50' width='50' >");
				out.print("</td>");
				out.print("</tr>");
			}
			
		
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		out.print("</table>");
	}


	@Override
	public void syncDB() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void updateDB() {
		// TODO Auto-generated method stub
		
	}

}
