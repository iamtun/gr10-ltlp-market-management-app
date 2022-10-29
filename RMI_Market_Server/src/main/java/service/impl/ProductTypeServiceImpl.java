package service.impl;

import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.ProductTypeDAO;
import entity.ProductType;
import service.IProductTypeService;

public class ProductTypeServiceImpl extends UnicastRemoteObject implements IProductTypeService {
	private static final long serialVersionUID = 1L;
	private ProductTypeDAO dao;
	
	public ProductTypeServiceImpl() throws Exception {
		this.dao = new ProductTypeDAO();
	}
	
	@Override
	public ProductType findProductTypeById(int id) throws Exception {
		// TODO Auto-generated method stub
		return dao.findProductTypeById(id);
	}

	@Override
	public boolean addOrUpdateProductType(ProductType productType) throws Exception {
		return dao.addOrUpdateProductType(productType);
		
	}

	@Override
	public boolean deleteProductType(ProductType productType) throws Exception {
		return dao.deleteProductType(productType);	
	}

	@Override
	public List<ProductType> getAllProductType() throws Exception {
		// TODO Auto-generated method stub
		return dao.getAllProductType();
	}

}
