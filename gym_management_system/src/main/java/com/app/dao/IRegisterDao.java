package com.app.dao;

import com.app.pojos.Address;
import com.app.pojos.Member;
import com.app.pojos.Trainer;

public interface IRegisterDao {

	String trainerRegistration(Trainer trainer, Address address);

	String changePassword(int id, String password);

	String registerMember(Address address, Member member, String trainer);

}
