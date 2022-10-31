package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ITrainerDao;
import com.app.pojos.Excercise;
import com.app.pojos.Trainer;

@Service
@Transactional
public class TrainerServiceImp implements ITrainerService {

	@Autowired
	private ITrainerDao trainerDao;
	
	@Override
	public List<Trainer> fetchAllTrainer() {
		System.out.println("in trainer Service");
		return trainerDao.fetchAllTrainer();
	}

	@Override
	public Trainer findTrainerById(String tid) {
		
		return trainerDao.findTrainerById(tid);
	}

	@Override
	public String addExcercise(Excercise e) {
		
		return trainerDao.addExcercise(e);
	}

	@Override
	public List<Excercise> fetAllExcercise() {
		
		return trainerDao.fetchAllExcercise();
	}

	@Override
	public String deleteExcercise(int eid) {
		
		return trainerDao.deleteExcercise(eid);
	}

	

	

}
