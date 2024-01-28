package com.example.Proyecto.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Proyecto.Model.Establecimiento;
import com.example.Proyecto.Repository.EstablecimientoRepository;

@Service
public class EstablecimientoServiceImp implements EstablecimientoService{

	@Autowired
	private EstablecimientoRepository estrepository;
	
	@Override
	public void save(Establecimiento establecimiento) {
		estrepository.save(establecimiento);	
	}

	@Override
	public void deleteAll() {
		estrepository.deleteAll();
		
	}

}
