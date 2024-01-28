package com.example.Proyecto.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Proyecto.Model.Ciudad;
import com.example.Proyecto.Repository.CiudadRepository;

@Service
public class CiudadServiceImp implements CiudadService{
	
	@Autowired
	private CiudadRepository repository;

	@Override
	public void save(Ciudad ciudad) {
		repository.save(ciudad);
	}

	@Override
	public void deleteAll() {
		repository.deleteAll();
		
	}

}
