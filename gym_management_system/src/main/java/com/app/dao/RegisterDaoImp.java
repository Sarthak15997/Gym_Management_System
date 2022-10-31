package com.app.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Address;
import com.app.pojos.Member;
import com.app.pojos.Trainer;

@Repository
public class RegisterDaoImp implements IRegisterDao {

	@Autowired
	private EntityManager mgr;

	@Override
	public String trainerRegistration(Trainer trainer, Address address) {
		trainer.setAddress(address);
		mgr.persist(trainer);
		return "trainner registration is done ";
	}

	@Override
	public String changePassword(int id, String password) {
		Trainer t = mgr.find(Trainer.class, id);
		if (t != null) {
			t.setPassword(password);
			t.setStatus("OLD");
			return "password cahanged";
		}
		else
		return "password not changed";
	}

	@Override
	public String registerMember(Address address, Member member, String trainer) {
		Trainer t = mgr.find(Trainer.class, Integer.parseInt(trainer));
		if (t != null) {
			member.setAddress(address);
			member.setAllocatedTrainer(t);
			mgr.persist(member);
			return "new Member Registration success";
		}
		return "Member Registration failed";
	}

}
