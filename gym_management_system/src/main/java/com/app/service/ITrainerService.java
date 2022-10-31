package com.app.service;

import java.util.List;

import com.app.pojos.Excercise;
import com.app.pojos.Trainer;

public interface ITrainerService {

	List<Trainer> fetchAllTrainer();

	Trainer findTrainerById(String tid);

	String addExcercise(Excercise e);

	List<Excercise> fetAllExcercise();

	String deleteExcercise(int eid);

	
	
}
