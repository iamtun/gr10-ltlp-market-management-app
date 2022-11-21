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
	public int addOrUpdateOrder(Order order) throws Exception {
		// TODO Auto-generated method stub
		return dao.addOrUpdateOrder(order);
	}

	@Override
	public List<Order> getAllOrder() throws Exception {
		// TODO Auto-generated method stub
		return dao.getAllOrder();
	}


	@Override
	public List<Order> filter(String dateStart, String dateEnd) throws Exception{
		// TODO Auto-generated method stub
		return dao.filter(dateStart, dateEnd);
	}


	@Override
	public List<Order> getAllOrderDateNow(String dateNow) throws Exception {
		// TODO Auto-generated method stub
		return dao.getAllOrderDateNow(dateNow);
	}

}
