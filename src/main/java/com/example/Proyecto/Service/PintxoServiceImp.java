package com.example.Proyecto.Service;


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
		//Pintxo pintxo1 = new Pintxo(pintxo.getNombre(), pintxo.getIngredientes(), pintxo.getExtra());
		repository.save(pintxo);
	}

	@Override
	public void deleteAll() {
		repository.deleteAll();
		
	}

}
