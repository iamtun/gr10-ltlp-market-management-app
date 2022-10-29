package dao;

import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import db.MyEMFactory;
import entity.Staff;
import service.IStaffService;

public class StaffDAO extends UnicastRemoteObject implements IStaffService {

	private static final long serialVersionUID = 1L;
	private SessionFactory factory;

	public StaffDAO() throws Exception {
		this.factory = MyEMFactory.getInstance().getEntityManagerFactory();
	}

	@Override
	public Staff findStaffById(String id) throws Exception {
		Session session = factory.openSession();
		try {
			Staff staff = session.find(Staff.class, id);
			session.close();
			return staff;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean addOrUpdateStaff(Staff staff) throws Exception {
		Session session = factory.getCurrentSession();
		Transaction transaction = session.getTransaction();
		try {
			transaction.begin();
			session.merge(staff);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Staff> getAllStaff() throws Exception {
		Session session = factory.openSession();
		try {
			List<Staff> entities = session.createNativeQuery("SELECT * " + "FROM staffs ", Staff.class).list();
			return entities;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean deleteStaff(Staff staff) throws Exception {
		Session session = factory.getCurrentSession();
		Transaction transaction = session.getTransaction();
		try {
			transaction.begin();
			session.delete(staff);
			transaction.commit();
			;
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return false;
	}

}
