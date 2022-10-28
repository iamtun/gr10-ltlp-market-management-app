package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import db.MyEMFactory;
import entity.ProductType;
import service.IOProductTypeService;

public class ProductTypeDAO implements IOProductTypeService {
	private SessionFactory factory;
	public ProductTypeDAO() {
		super();
		this.factory = MyEMFactory.getInstance().getEntityManagerFactory();
	}
	@Override
	public ProductType findProductTypeById(String id) {
		Session session = factory.openSession();
		try {
			ProductType productType = session.find(ProductType.class, id);
			session.close();
			return productType;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addProductType(ProductType productType) {
		Session session = factory.openSession();
		try {
			session.getTransaction().begin();
			session.persist(productType);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateProductType(ProductType productType) {
		Session session = factory.openSession();
		try {
			session.getTransaction().begin();
			session.update(productType);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteProductType(ProductType productType) {
		Session session = factory.openSession();
		try {
			session.getTransaction().begin();
			session.delete(productType);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
