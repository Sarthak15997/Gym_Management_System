package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Admin;
import com.app.pojos.Member;
import com.app.pojos.Payment;
import com.app.pojos.Trainer;

@Repository
public class LoginDaoImp implements ILoginDao {

	@Autowired
	private EntityManager mgr;

	@Override
	public Admin validateAdmin(String email, String password) {
		String jpql = "select a from Admin a where a.email=:email and a.password=:password";
		return mgr.createQuery(jpql, Admin.class).setParameter("email", email).setParameter("password", password)
				.getSingleResult();
	}

	@Override
	public Trainer validateTrainer(String email, String password) {
		String jpql = "select t from Trainer t where t.email=:email and t.password=:password";
		return mgr.createQuery(jpql, Trainer.class).setParameter("email", email).setParameter("password", password)
				.getSingleResult();
	}

	@Override
	public Member validateMember(String email, String password) {
		String jpql = "select m from Member m where m.email=:email and m.password=:password";
		return mgr.createQuery(jpql, Member.class).setParameter("email", email).setParameter("password", password)
				.getSingleResult();
	}

	@Override
	public int countOfTrainer() {
		int count = 0;
		List<Trainer> trainers = mgr.createQuery("select t from Trainer t", Trainer.class).getResultList();
		for (Trainer t : trainers) {
			count++;
		}
		return count;
	}

	@Override
	public int CountOfMember() {
		int count = 0;
		List<Member> member = mgr.createQuery("select m from Member m", Member.class).getResultList();
		for (Member t : member) {
			count++;
		}
		return count;
	}

	@Override
	public double countofPayment() {
		double total = 0;

		List<Payment> payments = mgr.createQuery("select p from Payment p", Payment.class).getResultList();
		for (Payment p : payments) {
			total += p.getAmount();
		}
		return total;
	}

	@Override
	public int countOfPayments() {
		int count = 0;

		List<Payment> payments = mgr.createQuery("select p from Payment p", Payment.class).getResultList();
		for (Payment p : payments) {
			count++;
		}
		return count;
	}

}
