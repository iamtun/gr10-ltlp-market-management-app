package service;

import java.util.List;

import entity.Account;

public interface IOAccountService {
	public List<Account> getAllAccount();
	public Account findAccountByUserName(String id);
	public void changePassWord(Account account);
	public void addAccount(Account account);
	public boolean deleteAccount(Account account);
}
