package com.divs.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

@Entity
@Table(name = "bankaccount")
@FilterDef(name = "FILTER_BANK_ACCOUNT_BY_STATUS", 
parameters = { 
		   		@ParamDef(type = "string", name = "accType1"),
		   		@ParamDef(type = "string", name = "accType2") 
		   		}
)
@Filter(name = "FILTER_BANK_ACCOUNT_BY_STATUS", condition = "status not in (:accType1,:accType2)")
public class BankAccount {
	
	@Id
	private Integer accNo;
	private String holderName;
	private Float balance;
	private String status;
	public Integer getAccNo() {
		return accNo;
	}
	public void setAccNo(Integer accNo) {
		this.accNo = accNo;
	}
	public String getHolderName() {
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	public Float getBalance() {
		return balance;
	}
	public void setBalance(Float balance) {
		this.balance = balance;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "BankAccount [accNo=" + accNo + ", holderName=" + holderName + ", balance=" + balance + ", status="
				+ status + "]";
	}
	

}
