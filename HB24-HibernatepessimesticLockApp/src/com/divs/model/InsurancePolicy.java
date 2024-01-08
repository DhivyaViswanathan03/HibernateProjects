package com.divs.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class InsurancePolicy implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pid;
	private String pname;
	private String ptype;
	private Integer ptenure;
	
	@Version
	private Integer count;

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

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "InsurancePolicy [pid=" + pid + ", pname=" + pname + ", ptype=" + ptype + ", ptenure=" + ptenure
				+ ", count=" + count + "]";
	}
	

}
