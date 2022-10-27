package dao;

import org.hibernate.Session;

import db.MyEMFactory;
import entity.Product;

public class ProductDAO {
	private Session session;

	public ProductDAO() {
		super();
		this.session = MyEMFactory.getInstance().getEntityManagerFactory().openSession();
	}
	
	public Product findProductById(int id) {
		
		return session.find(Product.class, id);
	}
	
	
}
