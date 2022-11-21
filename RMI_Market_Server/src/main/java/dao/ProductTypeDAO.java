package dao;

import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import db.MyEMFactory;
import entity.Product;
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
			ProductType productType = session
					.createNativeQuery("SELECT * FROM product_types where selling != 0 and product_type_id = :id",
							ProductType.class)
					.setParameter("id", id).getSingleResult();
			return productType;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ProductType> findListProductTypeByName(String name) throws Exception {
		Session session = factory.openSession();
		try {
			List<ProductType> listProductType = session
					.createNativeQuery("SELECT * FROM product_types where selling != 0 and type_name like :name",
							ProductType.class)
					.setParameter("name", name)
					.list();
			return listProductType;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addOrUpdateProductType(ProductType productType) throws Exception {
		Session session = factory.getCurrentSession();
		Transaction transaction = session.getTransaction();
		try {
			transaction.begin();
			session.merge(productType);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}

		return false;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean deleteProductType(ProductType productType) throws Exception {
		Session session = factory.getCurrentSession();
		Transaction transaction = session.getTransaction();
		try {
			transaction.begin();
			session.delete(productType);
			transaction.commit();

			return false;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}

		return true;
	}

	@Override
	public List<ProductType> getAllProductType() throws Exception {
		Session session = factory.openSession();
		try {
			List<ProductType> productTypes = session
					.createNativeQuery("SELECT * FROM product_types where selling != 0", ProductType.class).list();
			return productTypes;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
