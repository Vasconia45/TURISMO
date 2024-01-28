package com.example.Proyecto.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Proyecto.Model.Opinion;
import com.example.Proyecto.Repository.OpinionRepository;

@Service
public class OpinionServiceImp implements OpinionService{
	
	@Autowired
	private OpinionRepository repository;

	@Override
	public void save(Opinion opinion) {
		repository.save(opinion);
		
	}

	@Override
	public void deleteAll() {
		repository.deleteAll();
		
	}

}
