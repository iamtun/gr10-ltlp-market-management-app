package service;

import java.rmi.Remote;
import java.util.List;

import entity.ProductType;

public interface IProductTypeService extends Remote {
	public List<ProductType> getAllProductType() throws Exception;

	public ProductType findProductTypeById(int id) throws Exception;

	public boolean addOrUpdateProductType(ProductType productType) throws Exception;

	public boolean deleteProductType(ProductType productType) throws Exception;
}
