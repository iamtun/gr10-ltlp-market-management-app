package dao;

import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import db.MyEMFactory;
import entity.Order;
import service.IOrderService;

public class OrderDAO extends UnicastRemoteObject implements IOrderService{
	private static final long serialVersionUID = 1L;
	private SessionFactory factory;

	public OrderDAO() throws Exception{
		this.factory = MyEMFactory.getInstance().getEntityManagerFactory();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void addOrder(Order order) throws Exception{
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

	@SuppressWarnings("deprecation")
	@Override
	public void deleteOrder(Order order) throws Exception{
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

	@SuppressWarnings("deprecation")
	@Override
	public void updateOrder(Order order) throws Exception{
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
	public Order findOrderById(int id) throws Exception{
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
	public List<Order> getAllOrder() throws Exception{
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
