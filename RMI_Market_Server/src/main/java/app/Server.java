package app;

import java.rmi.registry.LocateRegistry;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;

import service.IOrderService;
import service.impl.OrderServiceImpl;

public class Server {
	public static void main(String[] args) {
		try {
			IOrderService orderService = new OrderServiceImpl();
			Hashtable<String, String> hashtable = new Hashtable<String, String>();
			hashtable.put("java.sercurity.policy", "policy.policy");
			Context context = new InitialContext(hashtable);
			LocateRegistry.createRegistry(8989);
			context.bind("rmi://DESKTOP-7A8D61I:8989/IOrderService", orderService);
			System.out.println("Server Start ...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
