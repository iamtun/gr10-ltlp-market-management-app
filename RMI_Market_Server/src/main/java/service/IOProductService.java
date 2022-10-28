package service;

import entity.Product;

public interface IOProductService {
	public Product findProductById(String id);
	public void addProduct(Product product);
	public void updateProduct(Product product);
	public void deleteProduct(Product product);
}
