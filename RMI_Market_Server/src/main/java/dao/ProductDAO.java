package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import db.MyEMFactory;
import entity.Product;
import service.IOProductService;

public class ProductDAO implements IOProductService {
	private SessionFactory factory;

	public ProductDAO() {
		super();
		this.factory = MyEMFactory.getInstance().getEntityManagerFactory();
	}

	@Override
	public Product findProductById(int id) {
		Session session = factory.openSession();
		try {
			Product product = session.find(Product.class, id);
			session.close();
			return product;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void addProduct(Product product) {
		Session session = factory.getCurrentSession();
		Transaction transaction = session.getTransaction();
		try {
			transaction.begin();
			session.save(product);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}				
	}

	@Override
	public void updateProduct(Product product) {
		Session session = factory.getCurrentSession();
		Transaction transaction = session.getTransaction();
		try {
			transaction.begin();
			session.update(product);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteProduct(Product product) {
		Session session = factory.getCurrentSession();
		Transaction transaction = session.getTransaction();
		try {
			transaction.begin();
			session.delete(product);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Product> getAllProduct() {
		Session session = factory.openSession();
		try {
			List<Product> products = session.createNativeQuery(
					"SELECT * FROM products",Product.class)
				.list();
			return products;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> getAllProductByProductTypeId(int product_type_id) {
		Session session = factory.openSession();
		try {
			List<Product> entities = session.createNativeQuery(
					"SELECT * " +
					"FROM products " +
					"WHERE product_type_id = :product_type_id", Product.class)
					.setParameter("product_type_id", product_type_id)
				.list();
			return entities;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
}
