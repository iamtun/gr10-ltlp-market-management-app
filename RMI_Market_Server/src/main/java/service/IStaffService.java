package service;

import java.rmi.Remote;
import java.util.List;

import entity.Staff;

public interface IStaffService extends Remote {
	public List<Staff> getAllStaff() throws Exception;

	public Staff findStaffById(String id) throws Exception;

	public boolean addOrUpdateStaff(Staff staff) throws Exception;

	public boolean deleteStaff(Staff staff) throws Exception;
}
