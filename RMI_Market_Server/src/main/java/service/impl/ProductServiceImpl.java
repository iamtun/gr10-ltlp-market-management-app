package service.impl;

import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.ProductDAO;
import entity.Product;
import service.IProductService;

public class ProductServiceImpl extends UnicastRemoteObject implements IProductService {
	private static final long serialVersionUID = 1L;
	private ProductDAO dao;
	
	public ProductServiceImpl() throws Exception {
		this.dao = new ProductDAO();
	}
	@Override
	public Product findProductById(int id) throws Exception {
		return dao.findProductById(id);
	}

	@Override
	public boolean addOrUpdateProduct(Product product) throws Exception {
		// TODO Auto-generated method stub
		return dao.addOrUpdateProduct(product);
		
	}

	@Override
	public boolean deleteProduct(Product product) throws Exception {
		// TODO Auto-generated method stub
		return dao.deleteProduct(product);
		
	}
	@Override
	public List<Product> getAllProduct() throws Exception {
		// TODO Auto-generated method stub
		return dao.getAllProduct();
	}
	@Override
	public List<Product> getAllProductByProductTypeId(int product_type_id) throws Exception {
		// TODO Auto-generated method stub
		return dao.getAllProductByProductTypeId(product_type_id);
	}

}
