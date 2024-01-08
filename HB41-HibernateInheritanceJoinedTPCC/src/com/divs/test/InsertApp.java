package com.divs.test;

import java.io.IOException;
import java.time.LocalDate;

import com.divs.model.CardPayment;
import com.divs.model.ChequePayment;
import com.divs.model.Payment;
import com.divs.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class InsertApp {
	@SuppressWarnings("static-access")
	public static void main(String args[]) throws IOException {
		Session session=null;
		Transaction transaction=null;
		boolean flag=false;
		String id;
		try {
		    session=new HibernateUtil().getSession();
		    if(session!=null) {
			transaction=session.beginTransaction();
			
			if(transaction!=null) {
				CardPayment cardPayment = new CardPayment();
				cardPayment.setPid(123);
				cardPayment.setAmount(5000.5f);
				cardPayment.setCardNo(234);
				cardPayment.setCardType("debit");
				cardPayment.setPaymentGateWay("visa");
				
				session.save(cardPayment);
				
				
				ChequePayment chequepayment = new ChequePayment();
				chequepayment.setPid(345);
				chequepayment.setAmount(6000.6f);
				chequepayment.setCheckNo(567);
				chequepayment.setChecktype("self");
				chequepayment.setExpiryDate(LocalDate.of(2023, 4,23));
				
				session.save(chequepayment);
				flag=true;
			}
				}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(flag==true) {
				transaction.commit();
				System.out.println("Objects saved into DB..");
			}else {
				transaction.rollback();
				System.out.println("Objects not saved in DB");
			}
			session.close();
			
		}

	}
}
