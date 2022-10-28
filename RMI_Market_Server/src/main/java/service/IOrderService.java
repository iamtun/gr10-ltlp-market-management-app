package service;

import java.rmi.Remote;
import java.util.List;

import entity.Order;

public interface IOrderService extends Remote {
	public List<Order> getAllOrder() throws Exception;

	public Order findOrderById(int id) throws Exception;

	public void addOrder(Order order) throws Exception;

	public void deleteOrder(Order order) throws Exception;

	public void updateOrder(Order order) throws Exception;
}
