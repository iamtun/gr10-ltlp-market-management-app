package service;

import entity.ProductType;

public interface IOProductTypeService {
	public ProductType findProductTypeById(String id);
	public void addProductType(ProductType productType);
	public void updateProductType(ProductType productType);
	public void deleteProductType(ProductType productType);
}
