package com.moneymoney.app.model.service;

import java.util.ArrayList;

import com.moneymoney.app.model.dao.DaoImpl;
import com.moneymoney.framework.account.pojo.BankAccount;
import com.moneymoney.framework.account.pojo.Customer;
import com.moneymoney.framework.account.pojo.PaymentGateway;
import com.moneymoney.framework.service.Service;

public class ServiceImpl implements Service{
	
	DaoImpl dao = new DaoImpl();

	@Override
	public void addBankAccount(BankAccount bankAccount) {
		dao.addBankAccount(bankAccount);		
	}

	@Override
	public void addCustomer(Customer customer) {
		dao.addCustomer(customer);		
	}

	@Override
	public ArrayList<BankAccount> viewAllAccounts() {
		return dao.viewAllAccounts();
	}

	@Override
	public ArrayList<Customer> viewAllCustomers() {
		return dao.viewAllCustomers();
	}

	@Override
	public BankAccount searchAccountById(int num) {
		return dao.searchAccountById(num);
	}

	@Override
	public boolean FundTransfer(BankAccount sender, BankAccount reciever, double amount) {
		return PaymentGateway.transfer(sender, reciever, amount);
	}
	
	public String withdraw(int accNo,double amount) {
		BankAccount account = searchAccountById(accNo);
		return account.withdraw(amount);		
	}
	
	
	public void deposit(int accNo,double amount) {
		BankAccount account = searchAccountById(accNo);
		account.deposit(amount);		
	}

}
