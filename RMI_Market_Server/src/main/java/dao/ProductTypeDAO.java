package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import db.MyEMFactory;
import entity.Product;
import entity.ProductType;
import service.IOProductTypeService;

public class ProductTypeDAO implements IOProductTypeService {
	private SessionFactory factory;
	public ProductTypeDAO() {
		super();
		this.factory = MyEMFactory.getInstance().getEntityManagerFactory();
	}
	@Override
	public ProductType findProductTypeById(int id) {
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

	@Override
	public void updateProductType(ProductType productType) {
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

	@Override
	public void deleteProductType(ProductType productType) {
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
	public List<ProductType> getAllProductType() {
		Session session = factory.openSession();
		try {
			List<ProductType> productTypes = session.createNativeQuery(
					"SELECT * FROM product_types",ProductType.class)
				.list();
			return productTypes;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
