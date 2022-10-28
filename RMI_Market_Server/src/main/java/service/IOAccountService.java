package service;

import entity.Account;

public interface IOAccountService {
	public Account findAccountByUserName(String id);
	public void changePassWord(Account account);
	public void addAccount(Account account);
	public boolean deleteAccount(Account account);
}
