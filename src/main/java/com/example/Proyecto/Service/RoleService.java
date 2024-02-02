package com.example.Proyecto.Service;

import java.util.ArrayList;

import com.example.Proyecto.Model.Rol;

public interface RoleService {

	public void save(Rol rol);
	
	public Rol getRol();
	
	public void deleteAll();
	
	public ArrayList<Rol> getAll();
}
