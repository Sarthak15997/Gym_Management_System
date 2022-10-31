package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Excercise;
import com.app.pojos.Trainer;
import com.app.pojos.TrainerRequest;

@Repository
public class TrainerDaoImp implements ITrainerDao {

	@Autowired
	private EntityManager mgr;

	@Override
	public List<Trainer> fetchAllTrainer() {
		String jpql="select t from Trainer t";
		return mgr.createQuery(jpql,Trainer.class).getResultList();
	}

	@Override
	public Trainer findTrainerById(String tid) {
		int id=Integer.parseInt(tid);
		return mgr.find(Trainer.class, id);
	}

	@Override
	public String addExcercise(Excercise e) {
		mgr.persist(e);
		return "new Excercise Added Successfully";
	}

	@Override
	public List<Excercise> fetchAllExcercise() {
		String jpql="select e from Excercise e";
		return mgr.createQuery(jpql, Excercise.class).getResultList();
	}

	@Override
	public String deleteExcercise(int eid) {
		mgr.remove(mgr.find(Excercise.class, eid));
		return "Exceercise Is Deleted";
	}

	

	
}
