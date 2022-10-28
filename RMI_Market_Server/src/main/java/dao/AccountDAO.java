package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import db.MyEMFactory;
import entity.Account;
import entity.OrderDetail;
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
		Session session = factory.getCurrentSession();
		Transaction transaction = session.getTransaction();
		try {
			transaction.begin();
			session.update(account);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public void addAccount(Account account) {
		Session session = factory.getCurrentSession();
		Transaction transaction = session.getTransaction();
		try {
			transaction.begin();
			session.save(account);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public boolean deleteAccount(Account account) {
		Session session = factory.getCurrentSession();
		Transaction transaction = session.getTransaction();
		try {
			transaction.begin();
			session.delete(account);
			;
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Account> getAllAccount() {
		Session session = factory.openSession();
		try {
			List<Account> accounts = session.createNativeQuery(
					"SELECT * FROM accounts",Account.class)
				.list();
			return accounts;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
