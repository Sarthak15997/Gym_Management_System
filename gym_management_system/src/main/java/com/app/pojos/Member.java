package com.app.pojos;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.tomcat.util.codec.binary.Base64;

@Entity
@Table(name = "member_tbl")
public class Member extends BaseEntity{
	@Column(name = "full_name",length = 50)
	private String name;
	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth;
	@Column(name = "gender",length = 10)
	private String gender;
	@Column(name = "member_height")
	private Double height;
	@Column(name = "member_weight")
	private Double weight;
	@Column(name = "mobile_no",length = 20)
	private String mobileNo;
	@Column(name = "email",length = 30)
	private String email;
	@Column(name = "password",length = 30)
	private String password;
	@Column(name = "profile_image",length = 50000000)
	private byte[] image;
	@Column(name = "start_time")
	private String startTime;
	@Column(name = "end_time")
	private String endTime;
	@Column(name = "joining_date")
	private LocalDate joinDate;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "member_address_id")
	private Address address;
	
	@ManyToOne
	@JoinColumn(name = "trainer_id", nullable = false)
	private Trainer allocatedTrainer;
	
	@Transient
	private String imgUtility;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Payment_id")
	private Payment payment;

	public Member() {
		super();
	}

	

	public Member(String name, LocalDate dateOfBirth, String gender, Double height, Double weight, String mobileNo,
			String email, String password, byte[] image, String startTime, String endTime, LocalDate joinDate) {
		super();
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.height = height;
		this.weight = weight;
		this.mobileNo = mobileNo;
		this.email = email;
		this.password = password;
		this.image = image;
		this.startTime = startTime;
		this.endTime = endTime;
		this.joinDate = joinDate;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
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

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
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

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public LocalDate getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Trainer getAllocatedTrainer() {
		return allocatedTrainer;
	}

	public void setAllocatedTrainer(Trainer allocatedTrainer) {
		this.allocatedTrainer = allocatedTrainer;
	}
	
	public String getImgUtility() throws UnsupportedEncodingException {

	       byte[] encodeBase64 = Base64.encodeBase64(getImage());
	       if(encodeBase64 == null)
		    	return "";
	       String base64Encoded = new String(encodeBase64, "UTF-8");              
	       return base64Encoded;
		   }
	
	@Override
	public String toString() {
		return "Member [name=" + name + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", height=" + height
				+ ", weight=" + weight + ", email=" + email + ", password=" + password + ", image="
				+ Arrays.toString(image) + ", startTime=" + startTime + ", endTime=" + endTime + ", joinDate="
				+ joinDate + "]";
	}
	
	
}
