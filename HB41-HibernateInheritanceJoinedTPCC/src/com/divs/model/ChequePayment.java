package com.divs.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name = "CHEQUEPAYMENT_TBCC")
public class ChequePayment extends Payment implements Serializable {
	

	private static final long serialVersionUID = 1L;
	private Integer checkNo;
	private String checktype;
	private LocalDate expiryDate;
	public Integer getCheckNo() {
		return checkNo;
	}
	public void setCheckNo(Integer checkNo) {
		this.checkNo = checkNo;
	}
	public String getChecktype() {
		return checktype;
	}
	public void setChecktype(String checktype) {
		this.checktype = checktype;
	}
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	@Override
	public String toString() {
		return "ChequePayment [checkNo=" + checkNo + ", checktype=" + checktype + ", expiryDate=" + expiryDate + "]";
	}

	
}
