package service;

import java.rmi.Remote;
import java.util.List;

import entity.ProductType;

public interface IProductTypeService extends Remote {
	public List<ProductType> getAllProductType() throws Exception;

	public ProductType findProductTypeById(int id) throws Exception;

	public void addProductType(ProductType productType) throws Exception;

	public void updateProductType(ProductType productType) throws Exception;

	public void deleteProductType(ProductType productType) throws Exception;
}
