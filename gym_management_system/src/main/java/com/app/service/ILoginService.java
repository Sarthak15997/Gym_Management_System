package com.app.service;

import com.app.pojos.Admin;
import com.app.pojos.Member;
import com.app.pojos.Trainer;

public interface ILoginService {

	Admin validateAdmin(String email, String password);

	Trainer validateTrainer(String email, String password);

	Member validateMember(String email, String password);

	int countOfTrainer();

	int CountOfMember();

	double countofPayment();

	int countOfPayments();
}
