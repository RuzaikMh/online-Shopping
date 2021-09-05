

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet implements DBConnector {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Items itemsUpdate = new Items();
		
		itemsUpdate.SetItemNo(request.getParameter("ItemNo"));
		itemsUpdate.SetCategory(request.getParameter("Category"));
		itemsUpdate.SetProductName(request.getParameter("ProductName"));
		itemsUpdate.SetPrice(Integer.parseInt(request.getParameter("Price")));
		itemsUpdate.SetDescription(request.getParameter("Description"));
		itemsUpdate.SetQty(Integer.parseInt(request.getParameter("Qty")));
		itemsUpdate.SetPimage(request.getParameter("Pimage"));
		itemsUpdate.SetNo(Integer.parseInt(request.getParameter("No")));
		System.out.println(itemsUpdate.toString());
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		 
			try {
					Connection DB;
					DB = DBConnector.newConnection();
		
					if(DB == null) {
						System.out.println("Connection not establish");
					}
					else {
					String query1 = "update items set Name=?,Id=?,Price=?,Qty=?,Category=?,Description=?,Pimage=? where No='"+itemsUpdate.GetNo()+"'";

					PreparedStatement pstatement = DB.prepareStatement(query1);
		
					pstatement.setString(1, itemsUpdate.GetProductName());
					pstatement.setString(2, itemsUpdate.GetItemNo());
					pstatement.setInt(3, itemsUpdate.GetPrice());
					pstatement.setInt(4, itemsUpdate.GetQty());
					pstatement.setString(5, itemsUpdate.GetCategory());
					pstatement.setString(6, itemsUpdate.GetDescription());
					pstatement.setString(7, itemsUpdate.GetPimage());
					pstatement.executeUpdate();
					
					int Results;
					
					Results  = pstatement.executeUpdate();
					
					
					Object result =  itemsUpdate.GetProductName() +" " +"Updated";
					
					
					request.getRequestDispatcher("/EditItems.jsp").forward(request,response);
						
					}
					
			}
			
			catch (SQLException e) {
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
