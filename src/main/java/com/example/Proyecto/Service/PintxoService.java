package com.example.Proyecto.Service;

import java.util.List;

import com.example.Proyecto.Model.Pintxo;

public interface PintxoService {

	public void save(Pintxo pintxo);
	
	public List<Pintxo> getAll();
	
	public void deleteAll();
}
