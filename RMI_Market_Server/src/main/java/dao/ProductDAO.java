package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
	public Product findProductById(String id) {
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
		Session session = factory.openSession();
		try {
			session.getTransaction().begin();
			session.persist(product);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}				
	}

	@Override
	public void updateProduct(Product product) {
		Session session = factory.openSession();
		try {
			session.getTransaction().begin();
			session.update(product);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteProduct(Product product) {
		Session session = factory.openSession();
		try {
			session.getTransaction().begin();
			session.delete(product);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}