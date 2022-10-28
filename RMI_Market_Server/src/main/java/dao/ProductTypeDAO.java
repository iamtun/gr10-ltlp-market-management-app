package dao;

import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import db.MyEMFactory;
import entity.ProductType;
import service.IProductTypeService;

public class ProductTypeDAO extends UnicastRemoteObject implements IProductTypeService {
	private static final long serialVersionUID = 1L;
	private SessionFactory factory;

	public ProductTypeDAO() throws Exception {
		super();
		this.factory = MyEMFactory.getInstance().getEntityManagerFactory();
	}

	@Override
	public ProductType findProductTypeById(int id) throws Exception {
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

	@SuppressWarnings("deprecation")
	@Override
	public void addProductType(ProductType productType) throws Exception {
		Session session = factory.getCurrentSession();
		Transaction transaction = session.getTransaction();
		try {
			transaction.begin();
			session.save(productType);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public void updateProductType(ProductType productType) throws Exception {
		Session session = factory.getCurrentSession();
		Transaction transaction = session.getTransaction();
		try {
			transaction.begin();
			session.update(productType);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}

	}

	@SuppressWarnings("deprecation")
	@Override
	public void deleteProductType(ProductType productType) throws Exception {
		Session session = factory.getCurrentSession();
		Transaction transaction = session.getTransaction();
		try {
			transaction.begin();
			session.delete(productType);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public List<ProductType> getAllProductType() throws Exception {
		Session session = factory.openSession();
		try {
			List<ProductType> productTypes = session.createNativeQuery("SELECT * FROM product_types", ProductType.class)
					.list();
			return productTypes;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
