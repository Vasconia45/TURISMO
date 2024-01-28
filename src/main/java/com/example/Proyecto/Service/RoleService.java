package com.example.Proyecto.Service;

import com.example.Proyecto.Model.Rol;

public interface RoleService {

	public void save(Rol rol);
	
	public Rol getRol();
	
	public void deleteAll();
}
