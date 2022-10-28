package service;

import java.util.List;

import entity.Staff;

public interface IOStaffService {
	public List<Staff> getAllStaff();
	public Staff findStaffById(String id);
	public boolean addStaff(Staff staff);
	public boolean deleteStaff(Staff staff);
	public void updateStaff(Staff staff);
}
