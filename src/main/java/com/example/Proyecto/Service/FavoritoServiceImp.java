package com.example.Proyecto.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Proyecto.Model.Favorito;
import com.example.Proyecto.Repository.FavoritoRepository;

@Service
public class FavoritoServiceImp implements FavoritoService{
	
	@Autowired
	private FavoritoRepository repository;

	@Override
	public void save(Favorito favorito) {
		repository.save(favorito);
		
	}

	@Override
	public void deleteAll() {
		repository.deleteAll();
		
	}

}
