package service;

import java.util.List;

import entity.Order;

public interface IOrderService {
	public List<Order> getAllOrder();
	public Order findOrderById(int id);
	public void addOrder(Order order);
	public void deleteOrder(Order order);
	public void updateOrder(Order order);
}
