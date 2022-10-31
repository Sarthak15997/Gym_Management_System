package com.app.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IDietDao;
import com.app.pojos.Diet;
import com.app.pojos.Member;

@Service
@Transactional
public class DietServiceImp implements IDietService {

	@Autowired
	private IDietDao dietDao;

	@Override
	public String saveDiet(Diet diet, String memberId) {
		System.out.println("in diet Service");
		return dietDao.saveDiet(diet,memberId);
	}

	@Override
	public Diet yesterdayDiet(Member member, LocalDate todayesDate) {
		System.out.println("In Yesterday diet Service");
		return dietDao.yesterdayDiet(member, todayesDate);
	}

	@Override
	public Diet findTodayesDiet(int id, LocalDate today) {

		return dietDao.findTodayesDiet(id,today);
	}

	@Override
	public List<Diet> searchDiet(int mid) {
		// TODO Auto-generated method stub
		return dietDao.searchDiet(mid);
	}
}
