package com.divs.model;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@DiscriminatorValue(value = "CARD")
@Entity
@Table(name = "CARDPAYMENT_TBSC")
@PrimaryKeyJoinColumn(name = "payment_id",referencedColumnName = "pid")
public class CardPayment extends Payment implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer cardNo;
	private String cardType;
	private String paymentGateWay;
	public Integer getCardNo() {
		return cardNo;
	}
	public void setCardNo(Integer cardNo) {
		this.cardNo = cardNo;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getPaymentGateWay() {
		return paymentGateWay;
	}
	public void setPaymentGateWay(String paymentGateWay) {
		this.paymentGateWay = paymentGateWay;
	}
	@Override
	public String toString() {
		return "CardPayment [cardNo=" + cardNo + ", cardType=" + cardType + ", paymentGateWay=" + paymentGateWay + "]";
	}
	
	

}
