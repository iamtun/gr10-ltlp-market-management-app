package service;

import java.util.List;

import entity.OrderDetail;

public interface IOOrderDetailService {
	public List<OrderDetail> getAllOrderDetail();
	public List<OrderDetail> getAllByOrderId(int order_id);
	public OrderDetail findOrderDetailById(int idOrder, int idProduct);
	public void addOrderDetail(OrderDetail orderDetail);
	public void deleteOrderDetail(OrderDetail orderDetail);
	public void updateOrderDetail(OrderDetail orderDetail);
}
