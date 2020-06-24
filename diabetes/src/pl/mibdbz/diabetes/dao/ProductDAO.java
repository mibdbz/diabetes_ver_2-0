package pl.mibdbz.diabetes.dao;

import java.util.List;

import pl.mibdbz.diabetes.entity.Product;

public interface ProductDAO {

	public List<Product> getProducts();

	public void saveProduct(Product theProduct);

	public Product getProduct(int theId);

	public void deleteProduct(int theId);
} 
