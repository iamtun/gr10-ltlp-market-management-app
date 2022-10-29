package app;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.AccountDAO;
import dao.OrderDAO;
import dao.OrderDetailDAO;
import dao.ProductDAO;
import dao.StaffDAO;
import db.MyEMFactory;
import entity.Account;
import entity.Order;
import entity.OrderDetail;
import entity.Product;
import entity.ProductType;
import entity.Staff;
import service.IAccountService;
import service.IOrderDetailService;
import service.IProductService;
import service.IProductTypeService;
import service.IStaffService;
import service.IOrderService;
import service.impl.AccountServiceImpl;
import service.impl.OrderDetailServiceImpl;
import service.impl.OrderServiecImpl;
import service.impl.ProductServiceImpl;
import service.impl.ProductTypeServiceImpl;
import service.impl.StaffServiceImpl;

public class InitDatabase {
	public static void main(String[] args) {
		try {
//			Session session = MyEMFactory.getInstance().getEntityManagerFactory().getCurrentSession();
//			Transaction transaction = session.getTransaction();
//			Account account = new Account(staff, "123456");
//			ProductType productType = new ProductType("Nuoc uong", "Chai");
//			Product product = new Product("AquaPhina", 100, 5000, productType);
//			Order order = new Order(new Date(), staff, null);
//			OrderDetail orderDetail = new OrderDetail(product, order, 3);
//			
			
			// Test 
			
			IAccountService ioAccountService = new AccountServiceImpl();
			IStaffService ioStaffService = new StaffServiceImpl();
			IOrderService ioOrderService = new OrderServiecImpl();
			IOrderDetailService ioOrderDetailIO = new OrderDetailServiceImpl();
			IProductService ioProductService = new ProductServiceImpl();
			IProductTypeService ioProductTypeService = new ProductTypeServiceImpl();
			
//			
//			Staff staff = ioStaffService.findStaffById("US0001");
//			System.out.println(staff);
//			Order order = new Order(new Date(), staff);
//			ioOrderService.addOrUpdateOrder(order);
//			System.out.println(ioProductService.getAllProduct());
			
//			
//			List<OrderDetail> list = new ArrayList<>();
//			list = ioOrderDetailIO.getAllOrderDetail();
//			for(OrderDetail detail : list) {
//				System.out.println("all" + detail.getQuantity());
//			}
			
//			List<OrderDetail> list2 = new ArrayList<>();
//			list2 = ioOrderDetailIO.getAllByOrderId(2);
//			for(OrderDetail detail : list2) {
//				System.out.println("id = 2" + detail.getQuantity());
//			}
//			List<Product> accounts = new ArrayList<>();
//			accounts = ioAccountService.get();
//			accounts = ioProductService.getAllProductByProductTypeId(1);
//			System.out.println(accounts);
//			for(Product account : accounts) {
//				System.out.println(account.getName());
//			}
			
//			List<ProductType> list = new ArrayList<>();
//			list = ioProductTypeService.getAllProductType();
//			System.out.println(list);
//			for(ProductType account : list) {
//				System.out.println(account.getName());
//			}
			
//			Account _account = ioAccountService.findAccountByUserName("NV001");
//			_account.setPassword("111111");
//			System.out.println(_account.getPassword());
//			ioAccountService.changePassWord(_account);
			
//			Staff _staff = ioStaffService.findStaffById("NV001");
//			_staff.setName("Name 1");
//			ioStaffService.updateStaff(_staff);
//			System.out.println(_staff.toString());
//			Staff _staff = new Staff("NV002", "Nguyen Duc Huy", "11113", "11113", "Nghe An", false, false, false);
//			Account _newAccount = new Account(_staff, "123456");
//			ioStaffService.addStaff(_staff);
//			ioAccountService.addAccount(_newAccount);
//			
//			ProductType _productType = ioProductTypeService.findProductTypeById(4);
//			System.out.println(_productType.toString());
//			ProductType _newProductType = new ProductType("Vit", "Troi");
//			ioProductTypeService.addProductType(_newProductType);
			
			//Product
			
//			Product _product1 = ioProductService.findProductById(1);
//			Product _product2= ioProductService.findProductById(2);
//			System.out.println(_product.toString());
//			Product _newProduct = new Product("Product vit troi", 20, 100000, _productType);
//			ioProductService.addProduct(_newProduct);
			
//			Order _order = ioOrderService.findOrderById(1);
//			System.out.println(_order.toString());

//			Order _newOrder = new Order(new Date(), _staff, null);
//			Order _order = ioOrderService.findOrderById(2);
//			OrderDetail detail1 = new OrderDetail(_product1, _order, 3);
//			OrderDetail detail2 = new OrderDetail(_product2, _order, 3);
//			List<OrderDetail> list = new ArrayList<>();
//			list.add(detail1);
//			list.add(detail2);
//			_order.setDetails(list);
//			ioOrderService.updateOrder(_order);

//			ioOrderService.addOrder(_newOrder);
//			OrderDetail _orderDetail = ioOrderDetailIO.findOrderDetailById(1,1);
//			System.out.println(_orderDetail.getQuantity());
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}
