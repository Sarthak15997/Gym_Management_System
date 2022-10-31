package com.app.dao;

import java.util.List;

import com.app.pojos.Excercise;
import com.app.pojos.Trainer;

public interface ITrainerDao {

	List<Trainer> fetchAllTrainer();

	Trainer findTrainerById(String tid);

	String addExcercise(Excercise e);

	List<Excercise> fetchAllExcercise();

	String deleteExcercise(int eid);

	

}
