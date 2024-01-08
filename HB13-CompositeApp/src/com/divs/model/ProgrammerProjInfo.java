package com.divs.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ProgrammerProjInfo implements Serializable {

	private static final long serialVersionUID = -4501496148983696626L;
	@EmbeddedId
	private ProgrammerProjId id;
	private Integer depNo;
	private String pName;
	private String projName;
	public ProgrammerProjId getId() {
		return id;
	}
	public void setId(ProgrammerProjId id) {
		this.id = id;
	}
	public Integer getDepNo() {
		return depNo;
	}
	public void setDepNo(Integer depNo) {
		this.depNo = depNo;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getProjName() {
		return projName;
	}
	public void setProjName(String projName) {
		this.projName = projName;
	}
	@Override
	public String toString() {
		return "ProgrammerProjInfo [id=" + id + ", depNo=" + depNo + ", pName=" + pName + ", projName=" + projName
				+ "]";
	}
	

}
