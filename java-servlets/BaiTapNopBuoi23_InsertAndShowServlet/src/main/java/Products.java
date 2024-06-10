import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "products", urlPatterns = {"/products"})
public class Products extends HttpServlet {
	private List<Product> products;
	private String errorMessage = null;
	
	public Products() {
		products = new ArrayList<Product>();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		res.setCharacterEncoding("UTF-8");
		req.setAttribute("errorMessage", errorMessage);
		
		req.setAttribute("products", products);
		req.getRequestDispatcher("Products.jsp").forward(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		errorMessage = null;
		try {
			String name = req.getParameter("name");
			int quantity = Integer.parseInt(req.getParameter("quantity"));
			double price = Double.parseDouble(req.getParameter("price"));
			
			products.add(new Product(name, quantity, price));
		}
		catch (IllegalArgumentException ex) {
			errorMessage = ex.getMessage();
		}
		
		res.sendRedirect("products");
	}
}
