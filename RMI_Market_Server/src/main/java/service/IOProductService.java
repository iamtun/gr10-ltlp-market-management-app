package service;

import java.util.List;

import entity.Product;

public interface IOProductService {
	public List<Product> getAllProduct();
	public List<Product> getAllProductByProductTypeId(int product_type_id);
	public Product findProductById(int id);
	public void addProduct(Product product);
	public void updateProduct(Product product);
	public void deleteProduct(Product product);
}
