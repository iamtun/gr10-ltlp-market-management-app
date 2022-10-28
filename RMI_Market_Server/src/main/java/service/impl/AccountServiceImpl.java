package service.impl;

import java.util.List;

import dao.AccountDAO;
import entity.Account;
import entity.Staff;
import service.IOAccountService;

public class AccountServiceImpl implements IOAccountService {

	private AccountDAO dao;
	
	public AccountServiceImpl() {
		super();
		this.dao = new AccountDAO();
	}
	
	@Override
	public Account findAccountByUserName(String id) {
		// TODO Auto-generated method stub
		return dao.findAccountByUserName(id);
	}

	@Override
	public void changePassWord(Account account) {
		// TODO Auto-generated method stub
		dao.changePassWord(account);
	}

	@Override
	public void addAccount(Account account) {
		// TODO Auto-generated method stub
		dao.addAccount(account);
	}

	@Override
	public boolean deleteAccount(Account account) {
		// TODO Auto-generated method stub
		return dao.deleteAccount(account);
	}

	@Override
	public List<Account> getAllAccount() {
		// TODO Auto-generated method stub
		return dao.getAllAccount();
	}

}
