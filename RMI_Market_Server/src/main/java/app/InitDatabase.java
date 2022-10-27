package app;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.OrderDAO;
import dao.ProductDAO;
import db.MyEMFactory;
import entity.Account;
import entity.Order;
import entity.OrderDetail;
import entity.Product;
import entity.ProductType;
import entity.Staff;
import service.IOrderService;
import service.impl.OrderServiceImpl;

public class InitDatabase {
	public static void main(String[] args) {
		try {
			Session session = MyEMFactory.getInstance().getEntityManagerFactory().getCurrentSession();
			Transaction transaction = session.getTransaction();
			Staff staff = new Staff("NV001", "Le Tuan", "212112", "0343220597", "275 QT", false, false, false);
			Account account = new Account(staff, "123456");
			ProductType productType = new ProductType("Nuoc uong", "Chai");
			Product product = new Product("Aqua", 100, 5000, productType);
			Order order = new Order(new Date(), staff, null);

//			ProductDAO productDAO = new ProductDAO();
//			Product _product = productDAO.findProductById(1);
////
//			IOrderService orderDAO = new OrderServiceImpl();
//			Order _order = orderDAO.findOrderById(1);
//
//			System.out.println(_product + "\n" + _order.getTotal());
			
			//OrderDetail detail = new OrderDetail(_product, _order, 3);
			try {
				transaction.begin();
				session.persist(order);// use saveorupdate
				transaction.commit();
			} catch (Exception e) {
				e.printStackTrace();
				transaction.rollback();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}
