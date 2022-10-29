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
	public int addOrUpdateOrder(Order order) throws Exception{
		Session session = factory.getCurrentSession();
		Transaction transaction = session.getTransaction();
		try {
			transaction.begin();
			session.merge(order);
			transaction.commit();
			
			return order.getId();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}	
		
		return -1;
		
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
