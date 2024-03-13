package com.example.Proyecto.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Proyecto.Model.ERole;
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

	@Override
	public void deleteAll() {
		repository.deleteAll();
	}

	@Override
	public Rol getRol() {
		return  repository.getReferenceById(2l);
	}

	@Override
	public ArrayList<Rol> getAll() {
		ArrayList<Rol> roles = (ArrayList<Rol>) repository.findAll();
		return roles;
	}
}
