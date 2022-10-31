package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "feedback_tbl")
public class Feedback extends BaseEntity{
	
	private String name;
	private String email;
	private String mobileNo;
	@Column(length = 1000)
	private String comment;
	public Feedback() {
		super();
	}
	public Feedback(String name, String email, String mobileNo, String comment) {
		super();
		this.name = name;
		this.email = email;
		this.mobileNo = mobileNo;
		this.comment = comment;
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
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		comment = comment;
	}
	@Override
	public String toString() {
		return "Feedback [name=" + name + ", email=" + email + ", mobileNo=" + mobileNo + ", Comment=" + comment + "]";
	}
	
	
}
