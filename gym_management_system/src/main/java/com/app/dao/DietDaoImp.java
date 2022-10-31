package com.app.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Diet;
import com.app.pojos.Member;

@Repository
public class DietDaoImp implements IDietDao {

	@Autowired
	private EntityManager mgr;

	@Override
	public String saveDiet(Diet diet, String memberId) {
		Member member = mgr.find(Member.class, Integer.valueOf(memberId));
		if (member != null) {
			diet.setMember(member);
			mgr.persist(diet);
			return "Diet saved for user " + member.getName();
		}
		return "error in diet addition";
	}

	@Override
	public Diet yesterdayDiet(Member member, LocalDate todayesDate) {
		String jpql = "select d from Diet d where d.member=:member and d.forDate <:todayesDate order by d.forDate";
		System.out.println("member " + member + " todayes date " + todayesDate);
		return mgr.createQuery(jpql, Diet.class).setParameter("member", member).setParameter("todayesDate", todayesDate)
				.getSingleResult();
	}

	@Override
	public Diet findTodayesDiet(int id, LocalDate today)throws RuntimeException {
		try {
			Member m = mgr.find(Member.class, id);
			String jpql = "select d from Diet d where d.member=:m and d.forDate=:now";
			Diet d = mgr.createQuery(jpql, Diet.class).setParameter("m", m).setParameter("now", today)
					.getSingleResult();
			if (d == null)
				return null;
			else
				return d;
			
		}catch (RuntimeException e) {
			System.out.println("exception "+e);
			return null;
		}	
	}

	@Override
	public List<Diet> searchDiet(int mid) {
		Member m=mgr.find(Member.class, mid);
		String jpql="select d from Diet d where d.member=:m order by d.forDate DESC";
		return mgr.createQuery(jpql, Diet.class).setParameter("m", m).getResultList();
	}
}
