package controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.ProductService;
import service.ProductServiceImpl;
public class ProductServlet extends HttpServlet
{
private ProductService productService;
public void init()
{
  productService=new ProductServiceImpl();
}
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//		super.doGet(req, resp);
		//Get Min and Max Price from Servlet Request
		double minPrice=Double.parseDouble(req.getParameter("minPrice"));
		double maxPrice=Double.parseDouble(req.getParameter("maxPrice"));
		//Call the ProductService class Method
	String jsonProductList=	productService.getProductDetails(minPrice, maxPrice);
		resp.setContentType("application/json");
		//Send the json Result back to angular controller
		resp.getWriter().write(jsonProductList);
	}
}
