package service.impl;

import dao.StaffDAO;
import entity.Staff;
import service.IOStaffService;

public class StaffServiceImpl implements IOStaffService {

	private StaffDAO dao;
	
	public StaffServiceImpl() {
		super();
		this.dao = new StaffDAO();
	}
	
	@Override
	public Staff findStaffById(String id) {
		// TODO Auto-generated method stub
		return dao.findStaffById(id);
	}

	@Override
	public boolean addStaff(Staff staff) {
		// TODO Auto-generated method stub
		return dao.addStaff(staff);
	}

	@Override
	public void updateStaff(Staff staff) {
		// TODO Auto-generated method stub
		dao.updateStaff(staff);
	}

}
