package service.impl;

import java.util.List;

import dao.OrderDetailDAO;
import entity.OrderDetail;
import service.IOOrderDetailService;

public class OrderDetailServiceImpl implements IOOrderDetailService {
	private OrderDetailDAO dao;
	
	
	public OrderDetailServiceImpl() {
		super();
		this.dao = new OrderDetailDAO();
	}
	@Override
	public OrderDetail findOrderDetailById(int idOrder, int idProduct) {
		// TODO Auto-generated method stub
		return dao.findOrderDetailById(idOrder, idProduct);
	}

	@Override
	public void addOrderDetail(OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOrderDetail(OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrderDetail(OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		
	}

}
