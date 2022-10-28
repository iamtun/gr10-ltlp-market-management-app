package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import db.MyEMFactory;
import entity.Order;
import entity.OrderDetail;
import service.IOrderService;

public class OrderDAO implements IOrderService{
	private SessionFactory factory;

	public OrderDAO() {
		this.factory = MyEMFactory.getInstance().getEntityManagerFactory();
	}

	@Override
	public void addOrder(Order order) {
		Session session = factory.getCurrentSession();
		Transaction transaction = session.getTransaction();
		try {
			transaction.begin();
			session.save(order);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}	
		
	}

	@Override
	public void deleteOrder(Order order) {
		Session session = factory.getCurrentSession();
		Transaction transaction = session.getTransaction();
		try {
			transaction.begin();
			session.delete(order);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}	
		
	}

	@Override
	public void updateOrder(Order order) {
		Session session = factory.getCurrentSession();
		Transaction transaction = session.getTransaction();
		try {
			transaction.begin();
			session.update(order);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
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

	@Override
	public List<Order> getAllOrder() {
		Session session = factory.openSession();
		try {
			List<Order> entities = session.createNativeQuery(
					"SELECT * " +
					"FROM orders ", Order.class)
				.list();
			return entities;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
