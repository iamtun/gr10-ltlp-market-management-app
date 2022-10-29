package service;

import java.rmi.Remote;
import java.util.List;

import entity.Order;

public interface IOrderService extends Remote {
	public List<Order> getAllOrder() throws Exception;

	public Order findOrderById(int id) throws Exception;

	public int addOrUpdateOrder(Order order) throws Exception;
}
