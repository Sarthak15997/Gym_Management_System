package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IMemberDao;
import com.app.pojos.Excercise;
import com.app.pojos.Feedback;
import com.app.pojos.Member;
import com.app.pojos.Payment;
import com.app.pojos.Trainer;
import com.app.pojos.TrainerRequest;

@Service
@Transactional
public class MemberServiceImp implements IMemberService {

	@Autowired
	private IMemberDao memberDao;

	@Override
	public List<Member> fetchAllMember(Trainer trainer) {
		System.out.println("In member Service");
		return memberDao.fetchAllMember(trainer);
	}

	@Override
	public String saveRequest(TrainerRequest tr,Trainer trainerInfo, Member member) {
		
		return memberDao.saveRequest(tr,trainerInfo,member);
	}

	@Override
	public String changepassword(Integer id, String con, String old) {
		
		return memberDao.changePassword(id,con,old);
	}

	@Override
	public Trainer fetchMytrainer(String id) {
		// TODO Auto-generated method stub
		return memberDao.fetchMytrainer(id);
	}

	@Override
	public Member fetchMyDetails(int id) {
		// TODO Auto-generated method stub
		return memberDao.fetchMyDetails(id);
	}

	@Override
	public String updateMember(int id,String name, String email, String mobileNo, String city, String state, String district,
			String addLine1, String addLine2, String country, String pincode, String dateOfBirth, String gender,
			String height, String weight, String startTime, String endTime, byte[] imageFile) {
		
		return memberDao.updateMember(id,name, email, mobileNo, city, state, district, addLine1, addLine2,
				country, pincode, dateOfBirth, gender, height, weight, startTime, endTime, imageFile);
	}

	@Override
	public String deleteMember(int mid) {
		
		return memberDao.deleteMember(mid);
	}

	@Override
	public List<Excercise> showExcercise() {
		
		return memberDao.showExcercise();
	}

	@Override
	public String addPayment(Payment p, Member m) {
		
		return memberDao.addPayment(p,m);
	}

	@Override
	public List<Member> fetchAllMember() {
		
		return memberDao.fetchAllMember();
	}

	@Override
	public String deleteMemberFromAdmin(int mid) {
		
		return memberDao.deleteMemberFromAdmin(mid);
	}

	@Override
	public List<Payment> fetchPayments() {
		
		return memberDao.fetchPayments();
	}

	@Override
	public List<Payment> fetchTodayesPayments() {
		
		return memberDao.fetchTodayesPayments();
	}

	@Override
	public String saveFeedBack(Feedback f) {
		// TODO Auto-generated method stub
		return memberDao.saveFeedBack(f);
	}

	@Override
	public List<Feedback> fetchAllFeedBack() {
		// TODO Auto-generated method stub
		return memberDao.fetchAllFeedBack();
	}

	
}
