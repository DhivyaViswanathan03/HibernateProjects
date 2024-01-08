package com.divs.test;

import java.io.IOException;

import com.divs.dao.InsurancePolicyDaoImpl;

public class InsertApp {

	public static void main(String args[]) throws IOException {
		InsurancePolicyDaoImpl policy=new InsurancePolicyDaoImpl();
		String message=policy.transerPolicy(24);
		System.out.println(message);
		
	}

}
