package com.app.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "request_tbl")
public class TrainerRequest extends BaseEntity {

	@Column(name = "request_status",length = 30)
	private String status;
	@ManyToOne
	@JoinColumn(name = "trainer_id", nullable = false)
	private Trainer trainer;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "member_id", nullable = false)
	private Member member;
	public TrainerRequest() {
		super();
	}
	public TrainerRequest(String status) {
		super();
		this.status = status;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Trainer getTrainer() {
		return trainer;
	}
	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	@Override
	public String toString() {
		return "TrainerRequest [status=" + status + ", trainer=" + trainer + ", member=" + member + "]";
	}
	
}
