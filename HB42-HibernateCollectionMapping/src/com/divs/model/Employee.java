package com.divs.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.ListIndexBase;

@Entity
@Table(name = "EMPLOYEE_COLLECTION")
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer eid;
	private String ename;
	private String eaddress;
	
	@ElementCollection
	@Column(name = "friend_name")
	@OrderColumn(name = "friend_no")
	@ListIndexBase(value = 1)
	@CollectionTable(name = "EMP_FRNDS",joinColumns = @JoinColumn(name = "emp_id", referencedColumnName = "eid"))
	private List<String> friends;
	
	@ElementCollection
	@Column(name = "phone_no")
	@CollectionTable(name = "EMP_MOBILE",joinColumns = @JoinColumn(name = "emp_id",referencedColumnName ="eid" ))
	private Set<Long> mobiles;
	
	@ElementCollection
	@Column(name = "account_no")
	@MapKeyColumn(name = "bank_name")
	@CollectionTable(name="EMP_ACCounts",joinColumns = @JoinColumn(name="emp_id",referencedColumnName = "eid"))
	private Map<String,Long> accounts;

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEaddress() {
		return eaddress;
	}

	public void setEaddress(String eaddress) {
		this.eaddress = eaddress;
	}

	public List<String> getFriends() {
		return friends;
	}

	public void setFriends(List<String> friends) {
		this.friends = friends;
	}

	public Set<Long> getMobiles() {
		return mobiles;
	}

	public void setMobiles(Set<Long> mobiles) {
		this.mobiles = mobiles;
	}

	public Map<String, Long> getAccounts() {
		return accounts;
	}

	public void setAccounts(Map<String, Long> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", eaddress=" + eaddress + ", friends=" + friends
				+ ", mobiles=" + mobiles + ", accounts=" + accounts + "]";
	}
	
	
	

}
