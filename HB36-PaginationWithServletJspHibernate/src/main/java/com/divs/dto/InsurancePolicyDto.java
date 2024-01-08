package com.divs.dto;

import java.io.Serializable;


public class InsurancePolicyDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private Integer pid;
	private String pname;
	private String ptype;
	private Integer ptenure;
	
	

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPtype() {
		return ptype;
	}

	public void setPtype(String ptype) {
		this.ptype = ptype;
	}

	public Integer getPtenure() {
		return ptenure;
	}

	public void setPtenure(Integer ptenure) {
		this.ptenure = ptenure;
	}

	@Override
	public String toString() {
		return "InsurancePolicy [pid=" + pid + ", pname=" + pname + ", ptype=" + ptype + ", ptenure=" + ptenure + "]";
	}

	
	
	

}
