package service.impl;

import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.StaffDAO;
import entity.Staff;
import service.IStaffService;

public class StaffServiceImpl extends UnicastRemoteObject implements IStaffService {
	private static final long serialVersionUID = 1L;
	private StaffDAO dao;
	
	public StaffServiceImpl() throws Exception {
		super();
		this.dao = new StaffDAO();
	}
	
	@Override
	public Staff findStaffById(String id) throws Exception {
		// TODO Auto-generated method stub
		return dao.findStaffById(id);
	}

	@Override
	public boolean addStaff(Staff staff) throws Exception {
		// TODO Auto-generated method stub
		return dao.addStaff(staff);
	}

	@Override
	public void updateStaff(Staff staff) throws Exception {
		// TODO Auto-generated method stub
		dao.updateStaff(staff);
	}

	@Override
	public List<Staff> getAllStaff() throws Exception {
		// TODO Auto-generated method stub
		return dao.getAllStaff();
	}

	@Override
	public boolean deleteStaff(Staff staff) throws Exception {
		// TODO Auto-generated method stub
		return dao.deleteStaff(staff);
	}

}
