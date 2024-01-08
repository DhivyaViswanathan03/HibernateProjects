package com.divs.model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	private String cityName;
	private String countryName;
	private String stateName;
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	@Override
	public String toString() {
		return "Address [cityName=" + cityName + ", countryName=" + countryName + ", stateName=" + stateName + "]";
	}
	

}
