package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import db.MyEMFactory;
import entity.Account;
import entity.Staff;
import service.IOAccountService;

public class AccountDAO implements IOAccountService {
	private SessionFactory factory;
	
	public AccountDAO() {
		this.factory = MyEMFactory.getInstance().getEntityManagerFactory();
	}
	
	@Override
	public Account findAccountByUserName(String id) {
		Session session = factory.openSession();
		try {
			Account account = session.find(Account.class, id);
			session.close();
			return account;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void changePassWord(Account account) {
		Session session = factory.openSession();
		try {
			session.getTransaction().begin();
			session.update(account);
			session.getTransaction().commit();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addAccount(Account account) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		try {
			session.getTransaction().begin();
			session.persist(account);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean deleteAccount(Account account) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		try {
			session.getTransaction().begin();
			session.delete(account);;
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
