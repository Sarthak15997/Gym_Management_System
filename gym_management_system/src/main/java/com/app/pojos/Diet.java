package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "diet_tbl")
public class Diet extends BaseEntity {

	@Column(name = "breakfast",length = 500)
	private String breakFast;
	@Column(name = "lunch",length = 500)
	private String lunch;
	@Column(name = "evening_snacks",length = 500)
	private String eveningSnacks;
	@Column(name = "dinner",length = 500)
	private String dinner;
	@Column(name = "added_date")
	private LocalDate addedDate;
	@Column(name = "for_date")
	private LocalDate forDate;
	@OneToOne(cascade = CascadeType.ALL,orphanRemoval =true)
    @JoinColumn(name = "member_id")
	private Member member;
	
	public Diet() {
		super();
	}
	

	public Diet(String breakFast, String lunch, String eveningSnacks, String dinner, LocalDate addedDate,
			LocalDate forDate) {
		super();
		this.breakFast = breakFast;
		this.lunch = lunch;
		this.eveningSnacks = eveningSnacks;
		this.dinner = dinner;
		this.addedDate = addedDate;
		this.forDate = forDate;
	}


	public String getBreakFast() {
		return breakFast;
	}

	public void setBreakFast(String breakFast) {
		this.breakFast = breakFast;
	}

	public String getLunch() {
		return lunch;
	}

	public void setLunch(String lunch) {
		this.lunch = lunch;
	}

	public String getEveningSnacks() {
		return eveningSnacks;
	}

	public void setEveningSnacks(String eveningSnacks) {
		this.eveningSnacks = eveningSnacks;
	}

	public String getDinner() {
		return dinner;
	}

	public void setDinner(String dinner) {
		this.dinner = dinner;
	}

	public LocalDate getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(LocalDate addedDate) {
		this.addedDate = addedDate;
	}

	public LocalDate getForDate() {
		return forDate;
	}

	public void setForDate(LocalDate forDate) {
		this.forDate = forDate;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}


	@Override
	public String toString() {
		return "Diet [breakFast=" + breakFast + ", lunch=" + lunch + ", eveningSnacks=" + eveningSnacks + ", dinner="
				+ dinner + ", addedDate=" + addedDate + ", forDate=" + forDate + ", member=" + member + "]";
	}
	
	
	
}
