package app;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.AccountDAO;
import dao.OrderDAO;
import dao.ProductDAO;
import dao.StaffDAO;
import db.MyEMFactory;
import entity.Account;
import entity.Order;
import entity.OrderDetail;
import entity.Product;
import entity.ProductType;
import entity.Staff;
import service.IOAccountService;
import service.IOOrderDetailService;
import service.IOStaffService;
import service.IOrderService;
import service.impl.AccountServiceImpl;
import service.impl.OrderDetailServiceImpl;
import service.impl.OrderServiecImpl;
import service.impl.StaffServiceImpl;

public class InitDatabase {
	public static void main(String[] args) {
		try {
			Session session = MyEMFactory.getInstance().getEntityManagerFactory().getCurrentSession();
			Transaction transaction = session.getTransaction();
			Staff staff = new Staff("NV010", "Nguyen Duc Huy", "21211935", "0343240598", "Nghe An", false, false, false);
//			Account account = new Account(staff, "123456");
			
			// Test Account
			
//			IOAccountService accountService = new AccountServiceImpl();
//			IOStaffService staffService = new StaffServiceImpl();
			IOOrderDetailService orderDetail = new OrderDetailServiceImpl();
			OrderDetail detail = orderDetail.findOrderDetailById(1,1);
//			System.out.println(detail.toString());
//			for(int i = 0 ; i < detail.size() ; i++) {
//				System.out.println(detail[i]);
//			}
//			Account _account = accountService.findAccountByUserName("NV003");
//			_account.setPassword("22222");
//			accountService.changePassWord(_account);
//			Account _account1 = accountService.findAccountByUserName("NV003");
//			System.out.println("test2 " + _account1.getStaff().getName());
			
//			Staff staff2 = new Staff("NV003", "Nguyen Duc Hung", "212112", "0879276284", "Nghe An", false, false, false);
//			staffService.addStaff(staff);
//			Account account2 = new Account(staff2, "123456");
//			accountService.addAccount(account);
//			Account _account2 = accountService.findAccountByUserName("NV010");
//			Staff staff = staffService.findStaffById("NV010");
//			staff.setName("Sông Lam Nghệ An");
//			staffService.updateStaff(staff);
//			System.out.println("Staff "+ staff.toString());
//			System.out.println("Account " + _account2.toString());
//			System.out.println("Staff "+ staff.getName());
			
			//show sql
			//  <property name="hibernate.show_sql">true</property>
			
			
//			ProductType productType = new ProductType("Nuoc uong", "Chai");
//			Product product = new Product("Aqua", 100, 5000, productType);
//			Order order = new Order(new Date(), staff, null);
//			OrderDetail orderDetail = new OrderDetail(product, order, 3);
//
//			ProductDAO productDAO = new ProductDAO();
//			Product _product = productDAO.findProductById(1);
//
//			IOrderService orderDAO = new OrderServiecImpl();
//			Order _order = orderDAO.findOrderById(1);
			
//			System.out.println(_product + "\n" + _order.getTotal());
			
//			OrderDetail detail = new OrderDetail(_product, _order, 3);

			
			
//			try {
//				transaction.begin();
//				session.persist(productType);// use saveorupdate
//				session.persist(product);
//				session.persist(order);
//				session.persist(orderDetail);
//				transaction.commit();
//			} catch (Exception e) {
//				e.printStackTrace();
//				transaction.rollback();
//			}
			
//			try {
//				transaction.begin();
//				//session.persist(staff);// use saveorupdate
//				session.persist(account);
//				transaction.commit();
//			} catch (Exception e) {
//				e.printStackTrace();
//				transaction.rollback();
//			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}
