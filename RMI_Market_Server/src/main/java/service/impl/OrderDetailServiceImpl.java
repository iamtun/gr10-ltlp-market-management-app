package service.impl;

import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.OrderDetailDAO;
import entity.OrderDetail;
import service.IOrderDetailService;

public class OrderDetailServiceImpl extends UnicastRemoteObject implements IOrderDetailService {
	private static final long serialVersionUID = 1L;
	private OrderDetailDAO dao;
	
	
	public OrderDetailServiceImpl() throws Exception {
		super();
		this.dao = new OrderDetailDAO();
	}
	@Override
	public OrderDetail findOrderDetailById(int idOrder, int idProduct) throws Exception {
		// TODO Auto-generated method stub
		return dao.findOrderDetailById(idOrder, idProduct);
	}

	@Override
	public void addOrderDetail(OrderDetail orderDetail) throws Exception {
		// TODO Auto-generated method stub
		dao.addOrderDetail(orderDetail);
	}

	@Override
	public void deleteOrderDetail(OrderDetail orderDetail) throws Exception {
		// TODO Auto-generated method stub
		dao.deleteOrderDetail(orderDetail);
	}

	@Override
	public void updateOrderDetail(OrderDetail orderDetail) throws Exception {
		// TODO Auto-generated method stub
		dao.updateOrderDetail(orderDetail);
	}
	@Override
	public List<OrderDetail> getAllOrderDetail() throws Exception {
		// TODO Auto-generated method stub
		return dao.getAllOrderDetail();
	}
	@Override
	public List<OrderDetail> getAllByOrderId(int order_id) throws Exception {
		// TODO Auto-generated method stub
		return dao.getAllByOrderId(order_id);
	}

}
