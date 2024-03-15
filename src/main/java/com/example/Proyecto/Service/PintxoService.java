package com.example.Proyecto.Service;

import java.util.List;
import java.util.Optional;

import com.example.Proyecto.Model.Pintxo;

public interface PintxoService {

	public void save(Pintxo pintxo);
	
	public Pintxo findById(Long id);
	
	public List<Pintxo> getAll();
	
	public void deleteAll();
}
