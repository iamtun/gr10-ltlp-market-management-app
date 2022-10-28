package service.impl;

import java.util.List;

import dao.OrderDAO;
import entity.Order;
import service.IOrderService;

public class OrderServiecImpl implements IOrderService{
	private OrderDAO dao;
	
	
	public OrderServiecImpl() {
		super();
		this.dao = new OrderDAO();
	}


	@Override
	public Order findOrderById(int id) {
		// TODO Auto-generated method stub
		return dao.findOrderById(id);
	}


	@Override
	public void addOrder(Order order) {
		// TODO Auto-generated method stub
		dao.addOrder(order);
	}


	@Override
	public void deleteOrder(Order order) {
		// TODO Auto-generated method stub
		dao.deleteOrder(order);
	}


	@Override
	public void updateOrder(Order order) {
		// TODO Auto-generated method stub
		dao.updateOrder(order);
	}


	@Override
	public List<Order> getAllOrder() {
		// TODO Auto-generated method stub
		return dao.getAllOrder();
	}

}
