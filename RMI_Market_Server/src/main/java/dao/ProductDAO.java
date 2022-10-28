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

	public ProductDAO() throws Exception{
		super();
		this.factory = MyEMFactory.getInstance().getEntityManagerFactory();
	}

	@Override
	public Product findProductById(int id) throws Exception{
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

	@SuppressWarnings("deprecation")
	@Override
	public void addProduct(Product product) throws Exception{
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

	@SuppressWarnings("deprecation")
	@Override
	public void updateProduct(Product product) throws Exception{
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

	@SuppressWarnings("deprecation")
	@Override
	public void deleteProduct(Product product) throws Exception{
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
	public List<Product> getAllProduct() throws Exception{
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
	public List<Product> getAllProductByProductTypeId(int product_type_id) throws Exception{
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
