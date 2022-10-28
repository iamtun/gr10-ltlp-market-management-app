package service;

import entity.Order;

public interface IOrderService {
	public Order findOrderById(int id);
	public void addOrder(Order order);
	public void deleteOrder(Order order);
	public void updateOrder(Order order);
}
