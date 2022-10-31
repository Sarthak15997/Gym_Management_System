package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "trainer_tbl")
public class Trainer extends BaseEntity{

	@Column(name = "trainer_name",length = 30)
	private String name;
	@Column(name = "email",length = 30)
	private String email;
	@Column(name = "mobile_no",length = 13)
	private String mobileNo;
	private String experience;
	private String status;
	@Column(name = "password",length = 30)
	private String password;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "trainer_address_id")
	private Address address;
	
	@OneToMany(mappedBy = "allocatedTrainer", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Member> member=new ArrayList<>();

	public Trainer() {
		super();
	}

	

	public Trainer(String name, String email, String mobileNo, String experience, String status, String password) {
		super();
		this.name = name;
		this.email = email;
		this.mobileNo = mobileNo;
		this.experience = experience;
		this.status = status;
		this.password = password;
	}



	public String getExperience() {
		return experience;
	}



	public void setExperience(String experience) {
		this.experience = experience;
	}



	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMobileNo() {
		return mobileNo;
	}



	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Member> getMember() {
		return member;
	}

	public void setMember(List<Member> member) {
		this.member = member;
	}

	@Override
	public String toString() {
		return "Trainer [name=" + name + ", email=" + email + ", password=" + password + "]";
	}
	
	
}
