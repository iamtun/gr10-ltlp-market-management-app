package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import db.MyEMFactory;
import entity.OrderDetail;
import service.IOOrderDetailService;
import service.IOProductTypeService;

public class OrderDetailDAO implements IOOrderDetailService {

	private SessionFactory factory;

	public OrderDetailDAO() {
		this.factory = MyEMFactory.getInstance().getEntityManagerFactory();
	}

	@Override
	public OrderDetail findOrderDetailById(int order_id, int product_id) {
		Session session = factory.openSession();
		try {
			List<OrderDetail> entities = session.createNativeQuery(
					"SELECT * " +
					"FROM order_details " +
					"WHERE order_id = :order_id and product_id = :product_id", OrderDetail.class)
					.setParameter("order_id", order_id)
					.setParameter("product_id", product_id)
				.list();
			for (OrderDetail phone : entities) {
				System.out.println(phone.getQuantity());
				session.close();
				return phone;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addOrderDetail(OrderDetail orderDetail) {
		Session session = factory.getCurrentSession();
		Transaction transaction = session.getTransaction();
		try {
			transaction.begin();
			session.save(orderDetail);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}	
	}

	@Override
	public void deleteOrderDetail(OrderDetail orderDetail) {
		Session session = factory.getCurrentSession();
		Transaction transaction = session.getTransaction();
		try {
			transaction.begin();
			session.delete(orderDetail);;
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}	
		
	}

	@Override
	public void updateOrderDetail(OrderDetail orderDetail) {
		Session session = factory.getCurrentSession();
		Transaction transaction = session.getTransaction();
		try {
			transaction.begin();
			session.update(orderDetail);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}	
	}

	@Override
	public List<OrderDetail> getAllOrderDetail() {
		Session session = factory.openSession();
		try {
			List<OrderDetail> entities = session.createNativeQuery(
					"SELECT * " +
					"FROM order_details ", OrderDetail.class)
				.list();
			return entities;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<OrderDetail> getAllByOrderId(int order_id) {
		Session session = factory.openSession();
		try {
			System.out.println(order_id);
			List<OrderDetail> entities = session.createNativeQuery(
					"SELECT * " +
					"FROM order_details " +
					"WHERE order_id = :order_id", OrderDetail.class)
					.setParameter("order_id", order_id)
				.list();
			return entities;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
