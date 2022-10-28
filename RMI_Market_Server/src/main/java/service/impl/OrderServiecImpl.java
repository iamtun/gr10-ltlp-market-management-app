package service.impl;

import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.OrderDAO;
import entity.Order;
import service.IOrderService;

public class OrderServiecImpl extends UnicastRemoteObject implements IOrderService{
	private static final long serialVersionUID = 1L;
	private OrderDAO dao;
	
	
	public OrderServiecImpl() throws Exception {
		super();
		this.dao = new OrderDAO();
	}


	@Override
	public Order findOrderById(int id) throws Exception {
		// TODO Auto-generated method stub
		return dao.findOrderById(id);
	}


	@Override
	public void addOrder(Order order) throws Exception {
		// TODO Auto-generated method stub
		dao.addOrder(order);
	}


	@Override
	public void deleteOrder(Order order) throws Exception {
		// TODO Auto-generated method stub
		dao.deleteOrder(order);
	}


	@Override
	public void updateOrder(Order order) throws Exception {
		// TODO Auto-generated method stub
		dao.updateOrder(order);
	}


	@Override
	public List<Order> getAllOrder() throws Exception {
		// TODO Auto-generated method stub
		return dao.getAllOrder();
	}

}
