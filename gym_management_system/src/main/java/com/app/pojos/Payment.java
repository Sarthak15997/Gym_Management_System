package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name = "payment_tbl")
public class Payment extends BaseEntity{

	@Column(name = "membership_pack")
	private String pack;
	@Column(name = "payment_mode")
	private String paymentMode;
	@Column(name = "card_holder_name")
	private String username;
	@Column(name = "card_no")
	private String cardNumber;
	@Column(name = "card_exp_month")
	private int month;
	@Column(name = "card_exp_year")
	private int year;
	@Column(name = "cvv")
	private int cvv;
	@Column(name = "payment_amount")
	private double amount;
	@Column(name = "upi_id")
	private String upi;
	@Column(name = "payment_date")
	private LocalDate paymentDate;
	
	
	public Payment() {
		super();
	}
	public Payment(String pack, String paymentMode, String username, String cardNumber, int month, int year, int cvv,
			double amount, String upi, LocalDate paymentDate) {
		super();
		this.pack = pack;
		this.paymentMode = paymentMode;
		this.username = username;
		this.cardNumber = cardNumber;
		this.month = month;
		this.year = year;
		this.cvv = cvv;
		this.amount = amount;
		this.upi = upi;
		this.paymentDate = paymentDate;
	}
	public String getPack() {
		return pack;
	}
	public void setPack(String pack) {
		this.pack = pack;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getUpi() {
		return upi;
	}
	public void setUpi(String upi) {
		this.upi = upi;
	}
	public LocalDate getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}
	@Override
	public String toString() {
		return "Payment [pack=" + pack + ", paymentMode=" + paymentMode + ", username=" + username + ", cardNumber="
				+ cardNumber + ", month=" + month + ", year=" + year + ", cvv=" + cvv + ", amount=" + amount + ", upi="
				+ upi + ", paymentDate=" + paymentDate + "]";
	}
	
	
	
}
