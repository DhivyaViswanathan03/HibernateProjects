package com.divs.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicInsert;

@Entity
@DynamicInsert(value = true)
public class Student {
	
	@Id
	private Integer sid;
	private String sname;
	private Integer sage;
	private String sddress;
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Integer getSage() {
		return sage;
	}
	public void setSage(Integer sage) {
		this.sage = sage;
	}
	public String getSddress() {
		return sddress;
	}
	public void setSddress(String sddress) {
		this.sddress = sddress;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", sage=" + sage + ", sddress=" + sddress + "]";
	}
	

}
