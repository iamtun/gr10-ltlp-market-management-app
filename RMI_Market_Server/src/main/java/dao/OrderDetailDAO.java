package dao;

import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import db.MyEMFactory;
import entity.OrderDetail;
import service.IOrderDetailService;

public class OrderDetailDAO extends UnicastRemoteObject implements IOrderDetailService {
	private static final long serialVersionUID = 1L;
	private SessionFactory factory;

	public OrderDetailDAO() throws Exception {
		this.factory = MyEMFactory.getInstance().getEntityManagerFactory();
	}

	@Override
	public OrderDetail findOrderDetailById(int order_id, int product_id) throws Exception {
		Session session = factory.openSession();
		try {
			List<OrderDetail> entities = session
					.createNativeQuery("SELECT * " + "FROM order_details "
							+ "WHERE order_id = :order_id and product_id = :product_id", OrderDetail.class)
					.setParameter("order_id", order_id)
					.setParameter("product_id", product_id)
					.list();
			if(entities.size() > 0)
				return entities.get(0);
			else
				return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean addOrUpdateOrderDetail(OrderDetail orderDetail) throws Exception {
		Session session = factory.getCurrentSession();
		Transaction transaction = session.getTransaction();
		try {
			transaction.begin();
			session.merge(orderDetail);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}

		return false;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean deleteOrderDetail(OrderDetail orderDetail) throws Exception {
		Session session = factory.getCurrentSession();
		Transaction transaction = session.getTransaction();
		try {
			transaction.begin();
			session.delete(orderDetail);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public List<OrderDetail> getAllOrderDetail() throws Exception {
		Session session = factory.openSession();
		try {
			List<OrderDetail> entities = session
					.createNativeQuery("SELECT * " + "FROM order_details ", OrderDetail.class).list();
			return entities;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<OrderDetail> getAllByOrderId(int order_id) throws Exception {
		Session session = factory.openSession();
		try {
			System.out.println(order_id);
			List<OrderDetail> entities = session
					.createNativeQuery("SELECT * " + "FROM order_details " + "WHERE order_id = :order_id",
							OrderDetail.class)
					.setParameter("order_id", order_id).list();
			return entities;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
