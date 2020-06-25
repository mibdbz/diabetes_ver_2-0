package pl.mibdbz.diabetes.service;

import java.util.List;

import pl.mibdbz.diabetes.entity.Product;


public interface ProductService {

	public List<Product> getProducts();

	public void saveProduct(Product theProduct);

	public Product getProduct(int theId);

	public void deleteProduct(int theId);

	public List<Product> searchForProducts(String theSearchName);
}
