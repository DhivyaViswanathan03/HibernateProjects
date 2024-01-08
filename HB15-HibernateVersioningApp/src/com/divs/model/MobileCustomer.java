package com.divs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class MobileCustomer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String cusName;
	private Long cMobileNo;
	private String ringTone;
	
	@Version
	private Integer versionCount;
	
	

	public Integer getId() {
		return id;
	}

    public void setId(Integer id) {
		this.id = id;
	}

    public String getCusName() {
		return cusName;
	}

    public void setCusName(String cusName) {
		this.cusName = cusName;
	}

    public Long getcMobileNo() {
		return cMobileNo;
	}

    public void setcMobileNo(Long cMobileNo) {
		this.cMobileNo = cMobileNo;
	}

    public String getRingTone() {
		return ringTone;
	}

    public void setRingTone(String ringTone) {
		this.ringTone = ringTone;
	}

    public Integer getVersionCount() {
		return versionCount;
	}

    public void setVersionCount(Integer versionCount) {
		this.versionCount = versionCount;
	}


    @Override
	public String toString() {
		return "MobileCustomer [id=" + id + ", cusName=" + cusName + ", cMobileNo=" + cMobileNo + ", ringTone="
				+ ringTone + ", versionCount=" + versionCount + "]";
	}
	

}
