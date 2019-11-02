package com.service;

import java.util.ArrayList;

import com.DAO.CustomerDAO;
import com.model.Customer;

public class CustomerService {
CustomerDAO dao=new CustomerDAO();
	public int registerCustomer(Customer customer)
	{	
		return dao.registerCustomer(customer);
	}
	public Customer getCustomerDetails(int ssnid,int custid)
	{
		return dao.getCustomerDetails(ssnid, custid);
	}
	public int updateCustomer(int custid,String name,String address,int age)
	{
		return dao.updateCustomer(custid, name, address, age);
	}
	public int deleteCustomer(int custid)
	{
		return dao.deleteCustomer(custid);
	}
	public int createCustomerStatus(int ssnid)
	{
		return dao.createCustomerStatus(ssnid);
	}
	public int updateCustomerStatus(int custid)
	{
		return dao.updateCustomerStatus(custid);
	}
	public int updateCustomerStatusInProgress(int custid)
	{
		return dao.updateCustomerStatusInProgress(custid);
	}
	public ArrayList<Customer> getCustomerStatus() {
		return dao.getCustomerStatus();
	}
	public ArrayList<Integer>  deleteCustomerAccount(int custid) {
		return dao.deleteCustomerAccount(custid);
	}
}
