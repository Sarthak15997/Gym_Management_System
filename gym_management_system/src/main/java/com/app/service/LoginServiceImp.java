package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ILoginDao;
import com.app.pojos.Admin;
import com.app.pojos.Member;
import com.app.pojos.Trainer;

@Service
@Transactional
public class LoginServiceImp implements ILoginService {

	@Autowired
	private ILoginDao loginDao;
	@Override
	public Admin validateAdmin(String email, String password) {
	System.out.println("validate Admin service ");
		return loginDao.validateAdmin(email, password);
	}
	@Override
	public Trainer validateTrainer(String email, String password) {
		System.out.println("validate Trainer Service");
		return loginDao.validateTrainer(email, password);
	}
	@Override
	public Member validateMember(String email, String password) {
		System.out.println("validate Member Service");
		return loginDao.validateMember(email,password);
	}
	@Override
	public int countOfTrainer() {
		// TODO Auto-generated method stub
		return loginDao.countOfTrainer();
	}
	@Override
	public int CountOfMember() {
		// TODO Auto-generated method stub
		return loginDao.CountOfMember();
	}
	@Override
	public double countofPayment() {
		// TODO Auto-generated method stub
		return loginDao.countofPayment();
	}
	@Override
	public int countOfPayments() {
		// TODO Auto-generated method stub
		return loginDao.countOfPayments();
	}

}
