package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import db.MyEMFactory;
import entity.Account;
import entity.Order;
import entity.Staff;
import service.IOAccountService;
import service.IOStaffService;
import service.impl.AccountServiceImpl;

public class StaffDAO implements IOStaffService {

	private SessionFactory factory;
	
	public StaffDAO() {
		this.factory = MyEMFactory.getInstance().getEntityManagerFactory();
	}
	
	@Override
	public Staff findStaffById(String id) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		try {
			Staff staff = session.find(Staff.class, id);
			session.close();
			return staff;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addStaff(Staff staff) {
		Session session = factory.getCurrentSession();
		Transaction transaction = session.getTransaction();
		try {
			transaction.begin();
			session.save(staff);
			transaction.commit();;
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void updateStaff(Staff staff) {
		Session session = factory.getCurrentSession();
		Transaction transaction = session.getTransaction();
		try {
			transaction.begin();
			session.update(staff);
			transaction.commit();
		}catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public List<Staff> getAllStaff() {
		Session session = factory.openSession();
		try {
			List<Staff> entities = session.createNativeQuery(
					"SELECT * " +
					"FROM staffs ", Staff.class)
				.list();
			return entities;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean deleteStaff(Staff staff) {
		Session session = factory.getCurrentSession();
		Transaction transaction = session.getTransaction();
		try {
			transaction.begin();
			session.delete(staff);
			transaction.commit();;
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return false;
	}

}
