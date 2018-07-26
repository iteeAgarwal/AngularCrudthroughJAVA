package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import bean.Product;
public class ProductDaoImpl  implements ProductDao
{

	@Override
	public List<Product> getProductDetails(double minPrice, double maxPrice)
	{
		// TODO Auto-generated method stub 
		List<Product> list =new ArrayList<>();
		Connection con=null;  
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/abc","root","rootroot");  
			System.out.println(con);
			String str="select pId,pname,price from Product where price>=? and price<=?";
			PreparedStatement pst=con.prepareStatement(str);
			pst.setDouble(1, minPrice);
			pst.setDouble(2, maxPrice);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				Product product=new Product();
				product.setPid(rs.getInt(1));
				product.setPname(rs.getString(2));
				product.setPrice(rs.getDouble(3));
				list.add(product);
			}
			}
		 	catch(Exception e)
				{
		 		System.out.println(e);
		 		e.printStackTrace();
		 		}
		return list;
	}

}
