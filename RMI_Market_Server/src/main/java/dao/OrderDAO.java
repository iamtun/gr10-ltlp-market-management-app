package dao;

import java.rmi.server.UnicastRemoteObject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import db.MyEMFactory;
import entity.Order;
import service.IOrderService;

public class OrderDAO extends UnicastRemoteObject implements IOrderService{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SessionFactory factory;

	public OrderDAO() throws Exception{
		this.factory = MyEMFactory.getInstance().getEntityManagerFactory();
	}

	@Override
	public Order findOrderById(int id) throws Exception {
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
