package com.example.Proyecto.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Proyecto.Model.Rol;
import com.example.Proyecto.Repository.RoleRepository;

@Service
public class RoleServiceImp implements RoleService{

	@Autowired
	private RoleRepository repository;
	
	@Override
	public void save(Rol rol) {
		repository.save(rol);
	}

}
