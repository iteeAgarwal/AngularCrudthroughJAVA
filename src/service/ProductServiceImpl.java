package service;
import java.util.List;
import dao.ProductDao;
import dao.ProductDaoImpl;
import util.JsonUtill;
public class ProductServiceImpl  implements ProductService 
{
	@Override
	public String getProductDetails(double minPrice, double maxPrice) {
		// It call Dao class Method 
		ProductDao productDao=new ProductDaoImpl();
		List list=productDao.getProductDetails(minPrice, maxPrice);
		// The list value convert into JSOn by using JACKSON API
		String jsonProductsList=JsonUtill.convertJavaToJson(list);
		//return JsonList
		return jsonProductsList;
	}
}
