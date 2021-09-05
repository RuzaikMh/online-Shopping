import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Servlet implementation class AddItems
 */
@WebServlet("/AddItems")
public class AddItems extends HttpServlet implements DBConnector{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddItems() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Items items1 = new Items();
		
		items1.SetItemNo(request.getParameter("ItemNo"));
		items1.SetCategory(request.getParameter("Category"));
		items1.SetProductName(request.getParameter("ProductName"));
		items1.SetPrice(Integer.parseInt(request.getParameter("Price")));
		items1.SetDescription(request.getParameter("Description"));
		items1.SetQty(Integer.parseInt(request.getParameter("Qty")));
		items1.SetPimage(request.getParameter("Pimage"));
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		try {
			String query = "insert into items (Name,Id,Price,Qty,Category,Description,Pimage)" + "values (?,?,?,?,?,?,?)";
			
			Connection DB;
			
			DB = DBConnector.newConnection();
		
			
			PreparedStatement pstatement = DB.prepareStatement(query);
			
			pstatement.setString(1, items1.GetProductName());
			pstatement.setString(2, items1.GetItemNo());
			pstatement.setInt(3, items1.GetPrice());
			pstatement.setInt(4, items1.GetQty());
			pstatement.setString(5, items1.GetCategory());
			pstatement.setString(6, items1.GetDescription());
			pstatement.setString(7, items1.GetPimage());
			
			int Results;
			
			Results  = pstatement.executeUpdate();
			
			Object result =  items1.GetProductName() +" " +"Added to the DataBase";
			request.setAttribute("display", result);
			request.getRequestDispatcher("/AddItems.jsp").forward(request,response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
				
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

