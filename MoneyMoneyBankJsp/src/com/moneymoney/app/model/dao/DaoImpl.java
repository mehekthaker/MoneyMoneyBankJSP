package com.moneymoney.app.model.dao;

import java.util.ArrayList;

import com.moneymoney.framework.account.dao.DAO;
import com.moneymoney.framework.account.pojo.BankAccount;
import com.moneymoney.framework.account.pojo.Customer;

public class DaoImpl implements DAO{
	private static ArrayList<BankAccount> bankAccList  = new ArrayList<>();
	private static ArrayList<Customer> customerList = new ArrayList<>();

	@Override
	public void addBankAccount(BankAccount bankAccount) {
		bankAccList.add(bankAccount);
		
	}

	@Override
	public void addCustomer(Customer customer) {
		customerList.add(customer);
		
	}

	@Override
	public ArrayList<BankAccount> viewAllAccounts() {
		return bankAccList;
	}

	@Override
	public ArrayList<Customer> viewAllCustomers() {
		return customerList;
	}

	@Override
	public BankAccount searchAccountById(int num) {
		BankAccount account = null;
		for(BankAccount ba: bankAccList) {
			if(ba.getAccountNumber() == num) {
				account=ba;
			}
		}
		return account;
	}

}
