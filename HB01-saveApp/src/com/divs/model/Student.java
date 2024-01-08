package com.divs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STDTAB")
public class Student {
	
	@Id
	@Column(name = "stdId")
	private Integer sid;
	@Column(name = "stdName",length = 20)
	private String sname;
	@Column(name = "stdAge")
	private Integer sage;
	@Column(name = "stdAddr",length = 20)
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
