package service.impl;

import java.util.List;

import dao.ProductDAO;
import entity.Product;
import service.IOProductService;

public class ProductServiceImpl implements IOProductService {

	private ProductDAO dao;
	
	public ProductServiceImpl() {
		this.dao = new ProductDAO();
	}
	@Override
	public Product findProductById(int id) {
		return dao.findProductById(id);
	}

	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		dao.addProduct(product);
		
	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		dao.updateProduct(product);
		
	}

	@Override
	public void deleteProduct(Product product) {
		// TODO Auto-generated method stub
		dao.deleteProduct(product);
		
	}
	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return dao.getAllProduct();
	}
	@Override
	public List<Product> getAllProductByProductTypeId(int product_type_id) {
		// TODO Auto-generated method stub
		return dao.getAllProductByProductTypeId(product_type_id);
	}

}
