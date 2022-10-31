package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "addresses_tbl")
public class Address extends BaseEntity {

	@Column(name = "city", length = 30)
	private String city;
	@Column(name = "state", length = 20)
	private String state;
	@Column(name = "district", length = 20)
	private String district;
	@Column(name = "street_address_1", length = 100)
	private String addLine1;
	@Column(name = "street_address_2", length = 100)
	private String addLine2;
	@Column(name = "country", length = 20)
	private String country;
	@Column(name = "pincode", length = 6)
	private int pincode;

	public Address() {
		super();
	}

	public Address(String city, String state, String district, String addLine1, String addLine2, String country,
			int pincode) {
		super();
		this.city = city;
		this.state = state;
		this.district = district;
		this.addLine1 = addLine1;
		this.addLine2 = addLine2;
		this.country = country;
		this.pincode = pincode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getAddLine1() {
		return addLine1;
	}

	public void setAddLine1(String addLine1) {
		this.addLine1 = addLine1;
	}

	public String getAddLine2() {
		return addLine2;
	}

	public void setAddLine2(String addLine2) {
		this.addLine2 = addLine2;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return addLine1+" "+addLine2+" "+city+" "+district+" "+state+" "+country+" "+pincode;
	}

}
