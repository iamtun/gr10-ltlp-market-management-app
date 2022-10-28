package dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import db.MyEMFactory;
import entity.Staff;
import service.IOStaffService;

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
			session.getTransaction().begin();
			Staff staff = session.find(Staff.class, id);
			session.getTransaction().commit();
			session.close();
			return staff;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addStaff(Staff staff) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		try {
			session.getTransaction().begin();
			session.persist(staff);
			session.getTransaction().commit();;
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void updateStaff(Staff staff) {
		Session session = factory.openSession();
		try {
			session.getTransaction().begin();
			session.update(staff);
			session.getTransaction().commit();
			session.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
