package service;

import java.rmi.Remote;

import entity.Order;

public interface IOrderService extends Remote{
	public Order findOrderById(int id) throws Exception;
}
