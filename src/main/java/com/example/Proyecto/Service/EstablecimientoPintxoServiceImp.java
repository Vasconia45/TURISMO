package com.example.Proyecto.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Proyecto.Model.EstablecimientoPintxo;
import com.example.Proyecto.Repository.EstablecimientoPintxoRepository;

@Service
public class EstablecimientoPintxoServiceImp implements EstablecimientoPintxoService{

	@Autowired
	private EstablecimientoPintxoRepository repository;
	
	@Override
	public void save(EstablecimientoPintxo est) {
		repository.save(est);
		
	}

	@Override
	public void deleteAll() {
		repository.deleteAll();
		
	}

}
