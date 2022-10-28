package dao;

import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import db.MyEMFactory;
import entity.Account;
import service.IAccountService;

public class AccountDAO extends UnicastRemoteObject  implements IAccountService {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SessionFactory factory;

	public AccountDAO() throws Exception{
		this.factory = MyEMFactory.getInstance().getEntityManagerFactory();
	}

	@Override
	public Account findAccountByUserName(String username) throws Exception{
		Session session = factory.openSession();
		try {
			Account account = session.find(Account.class, username);
			session.close();
			return account;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void changePassWord(Account account) throws Exception{
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
	public void addAccount(Account account) throws Exception{
		Session session = factory.getCurrentSession();
		Transaction transaction = session.getTransaction();
		try {
			transaction.begin();
			session.persist(account);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean deleteAccount(Account account) throws Exception{
		Session session = factory.getCurrentSession();
		Transaction transaction = session.getTransaction();
		try {
			transaction.begin();
			session.delete(account);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Account> getAllAccount() throws Exception{
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
