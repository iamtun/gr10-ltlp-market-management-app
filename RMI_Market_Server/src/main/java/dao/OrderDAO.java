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
