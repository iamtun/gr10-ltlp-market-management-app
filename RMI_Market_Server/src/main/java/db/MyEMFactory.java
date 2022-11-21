package db;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entity.Account;
import entity.Order;
import entity.OrderDetail;
import entity.OrderProductId;
import entity.Product;
import entity.ProductType;
import entity.Staff;

public class MyEMFactory {
	private static MyEMFactory instance;
	private SessionFactory sessionFactory;

	StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure().build();

	Metadata metadata = new MetadataSources(standardRegistry).addAnnotatedClass(Staff.class)
			.addAnnotatedClass(Account.class)
			.addAnnotatedClass(ProductType.class)
			.addAnnotatedClass(Product.class)
			.addAnnotatedClass(Staff.class)
			.addAnnotatedClass(Order.class)
			.addAnnotatedClass(OrderProductId.class)
			.addAnnotatedClass(OrderDetail.class)
			.getMetadataBuilder().build();

	private MyEMFactory() {
		sessionFactory = metadata.getSessionFactoryBuilder().build();
	}

	public synchronized static MyEMFactory getInstance() {
		if (instance == null) {
			instance = new MyEMFactory();
		}

		return instance;
	}

	public SessionFactory getEntityManagerFactory() {
		return sessionFactory;
	}
}
