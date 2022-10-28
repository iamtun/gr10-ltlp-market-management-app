package service;

import java.util.List;

import entity.ProductType;

public interface IOProductTypeService {
	public List<ProductType> getAllProductType();
	public ProductType findProductTypeById(int id);
	public void addProductType(ProductType productType);
	public void updateProductType(ProductType productType);
	public void deleteProductType(ProductType productType);
}
