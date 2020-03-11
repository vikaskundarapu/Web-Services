package com.vikas.restws.modal;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Check {

	private String checkNumber;
	private String accountNumber;
	private double amount;

	public String getCheckNumber() {
		return checkNumber;
	}

	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Check [checkNumber=" + checkNumber + ", accountNumber=" + accountNumber + ", amount=" + amount + "]";
	}
}
