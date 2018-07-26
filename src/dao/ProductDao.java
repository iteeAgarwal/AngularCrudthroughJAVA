package dao;
import java.util.List;

import bean.Product;
public interface ProductDao
{
public List<Product> getProductDetails(double minPrice,double maxPrice);
}
