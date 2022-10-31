package com.app.service;

import java.time.LocalDate;
import java.util.List;

import com.app.pojos.Diet;
import com.app.pojos.Member;

public interface IDietService {

	String saveDiet(Diet diet, String memberId);

	Diet yesterdayDiet(Member member, LocalDate todayesDate);

	Diet findTodayesDiet(int id, LocalDate today);

	List<Diet> searchDiet(int mid);
}
