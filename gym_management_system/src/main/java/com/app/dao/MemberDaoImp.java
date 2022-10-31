package com.app.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Address;
import com.app.pojos.Diet;
import com.app.pojos.Excercise;
import com.app.pojos.Feedback;
import com.app.pojos.Member;
import com.app.pojos.Payment;
import com.app.pojos.Trainer;
import com.app.pojos.TrainerRequest;

@Repository
public class MemberDaoImp implements IMemberDao {

	@Autowired
	private EntityManager mgr;

	@Override
	public List<Member> fetchAllMember(Trainer trainer) {
		String jpql = "select m from Member m where m.allocatedTrainer=:trainer";
		return mgr.createQuery(jpql, Member.class).setParameter("trainer", trainer).getResultList();
	}

	@Override
	public String saveRequest(TrainerRequest tr, Trainer trainerInfo, Member member) {
		tr.setTrainer(trainerInfo);
		tr.setMember(member);
		mgr.persist(tr);

		return "Request is Submited wait for the response";
	}

	@Override
	public String changePassword(Integer id, String con, String old) {
		Member m = mgr.find(Member.class, id);
		if (m != null) {
			if (m.getPassword().equals(old)) {
				m.setPassword(con);
				return "password is changed sucessfully";
			} else
				return "old password is wrong";
		} else
			return "password not changed ";
	}

	@Override
	public Trainer fetchMytrainer(String id) {
		return mgr.find(Trainer.class, Integer.parseInt(id));
	}

	@Override
	public Member fetchMyDetails(int id) {

		return mgr.find(Member.class, id);
	}

	@Override
	public String updateMember(int id, String name, String email, String mobileNo, String city, String state,
			String district, String addLine1, String addLine2, String country, String pincode, String dateOfBirth,
			String gender, String height, String weight, String startTime, String endTime, byte[] imageFile) {
		Member m = mgr.find(Member.class, id);
		if (m != null) {
			m.setName(name);
			m.setEmail(email);
			m.setMobileNo(mobileNo);
			m.setDateOfBirth(LocalDate.parse(dateOfBirth));
			m.setGender(gender);
			m.setHeight(Double.parseDouble(height));
			m.setWeight(Double.parseDouble(weight));
			m.setStartTime(startTime);
			m.setEndTime(endTime);
			m.setImage(imageFile);
			Address add = mgr.find(Address.class, m.getAddress().getId());
			add.setCity(city);
			add.setState(state);
			add.setDistrict(district);
			add.setPincode(Integer.valueOf(pincode));
			add.setCountry(country);
			add.setAddLine1(addLine1);
			add.setAddLine2(addLine2);
			return "Profile is Updated";
		} else
			return "profile is not updated";
	}

	@Override
	public String deleteMember(int mid) {
		Member m=mgr.find(Member.class, mid);
		mgr.remove(m);
		return "Member Is Removed";
	}

	@Override
	public List<Excercise> showExcercise() {
		String jpql="select e from Excercise e";
		return mgr.createQuery(jpql, Excercise.class).getResultList();
	}

	@Override
	public String addPayment(Payment p, Member m) {
		Member member=mgr.find(Member.class, m.getId());
		member.setPayment(p);
		return "payment is saved";
	}

	@Override
	public List<Member> fetchAllMember() {
		String jpql="select m from Member m";
		return mgr.createQuery(jpql, Member.class).getResultList();
	}

	@Override
	public String deleteMemberFromAdmin(int mid) throws RuntimeException{
		try {
		Member m=mgr.find(Member.class, mid);
		Address a=mgr.find(Address.class, m.getAddress().getId());
	
		m.setAllocatedTrainer(null);
		m.setAddress(null);
		m.setPayment(null);
		mgr.remove(m);
		mgr.remove(a);
		}catch (RuntimeException e) {
			return "error "+e;
		}
		return "Deleted SUccessfully";
	}

	@Override
	public List<Payment> fetchPayments() {
		String jpql="select p from Payment p";
		return mgr.createQuery(jpql, Payment.class).getResultList();
	}

	@Override
	public List<Payment> fetchTodayesPayments() {
		LocalDate today=LocalDate.now();
		String jpql="select p from Payment p where p.paymentDate=:now order by p.id desc";
		return mgr.createQuery(jpql, Payment.class).setParameter("now", today).getResultList();
	}

	@Override
	public String saveFeedBack(Feedback f) {
	mgr.persist(f);
		return "Feedback is Submitted";
	}

	@Override
	public List<Feedback> fetchAllFeedBack() {
	String jpql="select f from Feedback f";
		return mgr.createQuery(jpql, Feedback.class).getResultList();
	}

}
