package service.impl;

import java.rmi.server.UnicastRemoteObject;

import dao.OrderDAO;
import entity.Order;
import service.IOrderService;

public class OrderServiceImpl extends UnicastRemoteObject implements IOrderService{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OrderDAO dao;
	
	
	public OrderServiceImpl() throws Exception{
		this.dao = new OrderDAO();
	}


	@Override
	public Order findOrderById(int id) throws Exception {
		// TODO Auto-generated method stub
		return dao.findOrderById(id);
	}

}
