package com.app.service;

import java.util.List;

import com.app.pojos.Excercise;
import com.app.pojos.Feedback;
import com.app.pojos.Member;
import com.app.pojos.Payment;
import com.app.pojos.Trainer;
import com.app.pojos.TrainerRequest;

public interface IMemberService {
	
	

	List<Member> fetchAllMember(Trainer trainer);

	String saveRequest(TrainerRequest tr, Trainer trainerInfo, Member member);

	String changepassword(Integer id, String con, String old);

	Trainer fetchMytrainer(String id);

	Member fetchMyDetails(int id);

	String updateMember(int id,String name, String email, String mobileNo, String city, String state, String district,
			String addLine1, String addLine2, String country, String pincode, String dateOfBirth, String gender,
			String height, String weight, String startTime, String endTime, byte[] imageFile);

	String deleteMember(int mid);

	List<Excercise> showExcercise();

	String addPayment(Payment p, Member m);

	List<Member> fetchAllMember();

	String deleteMemberFromAdmin(int mid);

	List<Payment> fetchPayments();

	List<Payment> fetchTodayesPayments();

	String saveFeedBack(Feedback f);

	List<Feedback> fetchAllFeedBack();
}
