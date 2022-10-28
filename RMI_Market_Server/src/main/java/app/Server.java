package app;

import java.rmi.registry.LocateRegistry;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;

import service.IAccountService;
import service.IOrderDetailService;
import service.IOrderService;
import service.IProductService;
import service.IProductTypeService;
import service.IStaffService;
import service.impl.AccountServiceImpl;
import service.impl.OrderDetailServiceImpl;
import service.impl.OrderServiecImpl;
import service.impl.ProductServiceImpl;
import service.impl.ProductTypeServiceImpl;
import service.impl.StaffServiceImpl;


public class Server {
	public static void main(String[] args) {
		try {
			Hashtable<String, String> hashtable = new Hashtable<String, String>();
			hashtable.put("java.sercurity.policy", "policy.policy");
			Context context = new InitialContext(hashtable);
			LocateRegistry.createRegistry(8989);
			
			//init services
			IOrderService orderService = new OrderServiecImpl();
			IAccountService accountService = new AccountServiceImpl();
			IOrderDetailService orderDetailService = new OrderDetailServiceImpl();
			IProductService productService = new ProductServiceImpl();
			IProductTypeService productTypeService = new ProductTypeServiceImpl();
			IStaffService staffService = new StaffServiceImpl();
			
			//init path rmi
			
			context.bind("rmi://localhost:8989/IOrderService", orderService);
			context.bind("rmi://localhost:8989/IAccountService", accountService);
			context.bind("rmi://localhost:8989/IOrderDetailService", orderDetailService);
			context.bind("rmi://localhost:8989/IProductService", productService);
			context.bind("rmi://localhost:8989/IProductTypeService", productTypeService);
			context.bind("rmi://localhost:8989/IStaffService", staffService);
			System.out.println("Server Start PORT 8989 ...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
