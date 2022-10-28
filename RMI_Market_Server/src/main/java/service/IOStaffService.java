package service;

import entity.Staff;

public interface IOStaffService {
	public Staff findStaffById(String id);
	public boolean addStaff(Staff staff);
	public void updateStaff(Staff staff);
}
