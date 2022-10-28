package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import db.MyEMFactory;
import entity.Order;
import service.IOrderService;

public class OrderDAO implements IOrderService{
	private SessionFactory factory;

	public OrderDAO() {
		this.factory = MyEMFactory.getInstance().getEntityManagerFactory();
	}

	@Override
	public void addOrder(Order order) {
		Session session = factory.openSession();
		try {
			session.getTransaction().begin();
			session.persist(order);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
	}

	@Override
	public void deleteOrder(Order order) {
		Session session = factory.openSession();
		try {
			session.getTransaction().begin();
			session.delete(order);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
	}

	@Override
	public void updateOrder(Order order) {
		Session session = factory.openSession();
		try {
			session.getTransaction().begin();
			session.update(order);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
	}

	@Override
	public Order findOrderById(int id) {
		Session session = factory.openSession();
		try {
			Order order = session.find(Order.class, id);
			return order;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}