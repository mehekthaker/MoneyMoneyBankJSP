package com.moneymoney.framework.account.pojo;

/**
 * 
 * @author Satyen Singh
 *
 *Maintaining savings account details of money money bank
 */
public abstract class SavingsAccount extends BankAccount {
	private boolean salary;
	private double MINIMUM_BALANCE;

	public SavingsAccount(Customer accountHolder, double accountBalance, boolean salary) {
		super(accountHolder, accountBalance);
		this.salary = salary;
		this.MINIMUM_BALANCE = 10000;
	}


	public boolean isSalaryValue() {
		return salary;
	}
	public void setSalary(boolean salary) {
		this.salary = salary;
		if(salary)
			this.MINIMUM_BALANCE =0;
		else
			this.MINIMUM_BALANCE = 10000;
	}
	
	
	public double getMINIMUM_BALANCE() {
		return MINIMUM_BALANCE;
	}
	public void setMINIMUM_BALANCE(double mINIMUM_BALANCE) {
		MINIMUM_BALANCE = mINIMUM_BALANCE;
	}
	
	
	public abstract String withdraw(double amount);
	
	
	@Override
	public String toString() {
		return "SavingsAccount [salary=" + salary + ", toString()=" + super.toString() + "]";
	}
}
