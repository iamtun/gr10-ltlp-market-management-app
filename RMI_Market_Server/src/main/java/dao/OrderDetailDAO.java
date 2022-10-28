package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
			session.getTransaction().begin();
			List<OrderDetail> persons = session.createNativeQuery(
					"SELECT * FROM order_details where order_id= :order_id")
					.addEntity(OrderDetail.class)
					.list();
			for (OrderDetail phone : persons) {
				return phone;
			}
			session.getTransaction().commit();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
//		return null;
		return null;
	}

	@Override
	public void addOrderDetail(OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		try {
			session.getTransaction().begin();
			session.persist(orderDetail);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void deleteOrderDetail(OrderDetail orderDetail) {
		Session session = factory.openSession();
		try {
			session.getTransaction().begin();
			session.delete(orderDetail);
			session.getTransaction().commit();
			session.close();
			System.out.println("Oke");
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
	}

	@Override
	public void updateOrderDetail(OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		try {
			session.getTransaction().begin();
			session.update(orderDetail);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

}
