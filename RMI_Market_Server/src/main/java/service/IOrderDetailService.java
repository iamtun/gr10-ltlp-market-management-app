package service;

import java.rmi.Remote;
import java.util.List;

import entity.OrderDetail;

public interface IOrderDetailService extends Remote {
	public List<OrderDetail> getAllOrderDetail() throws Exception;

	public List<OrderDetail> getAllByOrderId(int order_id) throws Exception;

	public OrderDetail findOrderDetailById(int idOrder, int idProduct) throws Exception;

	public boolean addOrUpdateOrderDetail(OrderDetail orderDetail) throws Exception;

	public boolean deleteOrderDetail(OrderDetail orderDetail) throws Exception;
}
