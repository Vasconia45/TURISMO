package com.example.Proyecto.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Proyecto.Model.Pintxo;
import com.example.Proyecto.Repository.PintxoRepository;

@Service
public class PintxoServiceImp implements PintxoService{
	
	@Autowired
	private PintxoRepository repository;

	@Override
	public void save(Pintxo pintxo) {
		Pintxo p = new Pintxo(pintxo.getNombre(), pintxo.getIngredientes());
		repository.save(p);
	}

	@Override
	public void deleteAll() {
		repository.deleteAll();
		
	}

	@Override
	public List<Pintxo> getAll() {
		List<Pintxo> pintxos = repository.findAll();
		return pintxos;
	}

}
