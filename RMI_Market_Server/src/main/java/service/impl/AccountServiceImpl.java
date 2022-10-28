package service.impl;

import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.AccountDAO;
import entity.Account;
import service.IAccountService;

public class AccountServiceImpl extends UnicastRemoteObject implements IAccountService {
	private static final long serialVersionUID = 1L;
	
	private AccountDAO dao;
	
	public AccountServiceImpl() throws Exception {
		super();
		this.dao = new AccountDAO();
	}
	
	@Override
	public Account findAccountByUserName(String id) throws Exception {
		// TODO Auto-generated method stub
		return dao.findAccountByUserName(id);
	}

	@Override
	public void changePassWord(Account account) throws Exception {
		// TODO Auto-generated method stub
		dao.changePassWord(account);
	}

	@Override
	public void addAccount(Account account) throws Exception {
		// TODO Auto-generated method stub
		dao.addAccount(account);
	}

	@Override
	public boolean deleteAccount(Account account) throws Exception {
		// TODO Auto-generated method stub
		return dao.deleteAccount(account);
	}

	@Override
	public List<Account> getAllAccount() throws Exception {
		// TODO Auto-generated method stub
		return dao.getAllAccount();
	}

}
