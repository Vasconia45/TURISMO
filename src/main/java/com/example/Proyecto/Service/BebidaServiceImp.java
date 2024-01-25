package com.example.Proyecto.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Proyecto.Model.Bebida;
import com.example.Proyecto.Repository.BebidaRepository;

@Service
public class BebidaServiceImp implements BebidaService{
	
	@Autowired
	private BebidaRepository repository;

	@Override
	public void save(Bebida bebida) {
		repository.save(bebida);	
	}

}
