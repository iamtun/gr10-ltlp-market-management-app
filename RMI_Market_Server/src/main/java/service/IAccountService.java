package service;

import java.rmi.Remote;
import java.util.List;

import entity.Account;

public interface IAccountService extends Remote {
	public List<Account> getAllAccount() throws Exception;

	public Account findAccountByUserName(String username) throws Exception;

	public boolean changePassWord(Account account) throws Exception;

	public boolean addAccount(Account account) throws Exception;
}
