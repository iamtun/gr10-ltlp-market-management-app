package service;

import java.rmi.Remote;
import java.util.List;

import entity.Product;

public interface IProductService extends Remote {
	public List<Product> getAllProduct() throws Exception;

	public List<Product> getAllProductByProductTypeId(int product_type_id) throws Exception;

	public Product findProductById(int id) throws Exception;

	public void addProduct(Product product) throws Exception;

	public void updateProduct(Product product) throws Exception;

	public void deleteProduct(Product product) throws Exception;
}
