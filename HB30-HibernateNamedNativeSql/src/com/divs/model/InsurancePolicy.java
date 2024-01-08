package com.divs.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;

@Entity
@NamedNativeQuery(name = "SELECT_QUERY",query ="select * from insurancepolicy where ptype=?")
public class InsurancePolicy implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
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
