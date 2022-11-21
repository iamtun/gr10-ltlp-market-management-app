package dao;

import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import db.MyEMFactory;
import entity.Product;
import service.IProductService;

public class ProductDAO extends UnicastRemoteObject implements IProductService {
	private static final long serialVersionUID = 1L;
	private SessionFactory factory;

	public ProductDAO() throws Exception {
		super();
		this.factory = MyEMFactory.getInstance().getEntityManagerFactory();
	}

	@Override
	public Product findProductById(int id) throws Exception {
		Session session = factory.openSession();
		try {
			Product product = session
					.createNativeQuery("SELECT *  FROM products WHERE product_id = :product_id and selling != 0", Product.class)
					.setParameter("product_id", id).getSingleResultOrNull();
			System.out.println(product);
			return product;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	@Override
	public List<Product> getAllProduct() throws Exception {
		Session session = factory.openSession();
		try {
			List<Product> products = session
					.createNativeQuery("SELECT * FROM products where selling != 0", Product.class).list();
			return products;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> getAllProductByProductTypeId(int product_type_id) throws Exception {
		Session session = factory.openSession();
		try {
			List<Product> entities = session.createNativeQuery(
					"SELECT *  FROM products WHERE product_type_id = :product_type_id and selling != 0", Product.class)
					.setParameter("product_type_id", product_type_id).list();
			return entities;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addOrUpdateProduct(Product product) throws Exception {
		Session session = factory.getCurrentSession();
		Transaction transaction = session.getTransaction();
		try {
			transaction.begin();
			session.merge(product);
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
	public boolean deleteProduct(Product product) throws Exception {
		Session session = factory.getCurrentSession();
		Transaction transaction = session.getTransaction();
		try {
			transaction.begin();
			session.delete(product);
			transaction.commit();

			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}

		return false;

	}

	@Override
	public Product findProductByName(String name) throws Exception {
		Session session = factory.openSession();
		try {
			Product product = session
					.createNativeQuery("select * from products where selling != 0 and name like :name", Product.class)
					.setParameter("name", name).getSingleResultOrNull();
			System.out.println(product);
			return product;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	

}
