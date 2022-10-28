package service;

import java.rmi.Remote;
import java.util.List;

import entity.OrderDetail;

public interface IOrderDetailService extends Remote {
	public List<OrderDetail> getAllOrderDetail() throws Exception;

	public List<OrderDetail> getAllByOrderId(int order_id) throws Exception;

	public OrderDetail findOrderDetailById(int idOrder, int idProduct) throws Exception;

	public void addOrderDetail(OrderDetail orderDetail) throws Exception;

	public void deleteOrderDetail(OrderDetail orderDetail) throws Exception;

	public void updateOrderDetail(OrderDetail orderDetail) throws Exception;
}
