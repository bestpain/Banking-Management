package com.service;

import java.util.ArrayList;

import com.DAO.AccountDAO;
import com.model.Account;

public class AccountService {

	AccountDAO dao=new AccountDAO();
	public int createAccount(int custid,String acctype,double balance) {
		return dao.createAccount(custid, acctype, balance);
	}
	public int deleteAccount(int accid)
	{
		return dao.deleteAccount(accid);
	}
	public ArrayList<Account> getAccountDetails(int ssnid, int custid) {
		return dao.getAccountDetails(ssnid, custid);
	}
	public int createAccountStatus(int custid,String accType)
	{
		return dao.createAccountStatus(custid, accType);
	}
	public ArrayList<Account> getAccountStatus() {
		return dao.getAccountStatus();
	}
	public ArrayList<Account> getAccountBalance(int custid)
	{
		return dao.getAccountBalance(custid);
	}
}
