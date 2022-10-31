package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IRegisterDao;
import com.app.pojos.Address;
import com.app.pojos.Member;
import com.app.pojos.Trainer;

@Service
@Transactional
public class RegisterServiceImp implements IRegisterService {

	@Autowired
	private IRegisterDao registerDao;
	@Override
	public String trainerRegistration(Trainer trainer, Address address) {
		
		return registerDao.trainerRegistration(trainer,address);
	}
	@Override
	public String changePassword(int id,String password) {
		
		return registerDao.changePassword(id,password);
	}
	@Override
	public String registerMember(Address address, Member member, String trainer) {
		
		return registerDao.registerMember(address,member,trainer);
	}

}
