package service.impl;

import java.util.List;

import dao.ProductTypeDAO;
import entity.ProductType;
import service.IOProductTypeService;

public class ProductTypeServiceImpl implements IOProductTypeService {

	private ProductTypeDAO dao;
	
	public ProductTypeServiceImpl() {
		this.dao = new ProductTypeDAO();
	}
	
	@Override
	public ProductType findProductTypeById(int id) {
		// TODO Auto-generated method stub
		return dao.findProductTypeById(id);
	}

	@Override
	public void addProductType(ProductType productType) {
		dao.addProductType(productType);
		
	}

	@Override
	public void updateProductType(ProductType productType) {
		dao.updateProductType(productType);
		
	}

	@Override
	public void deleteProductType(ProductType productType) {
		dao.deleteProductType(productType);	
	}

	@Override
	public List<ProductType> getAllProductType() {
		// TODO Auto-generated method stub
		return dao.getAllProductType();
	}

}
