package com.example.Proyecto.Service;

import java.util.ArrayList;

import com.example.Proyecto.Model.Ciudad;

public interface CiudadService {

	public void save(Ciudad ciudad);
	
	public ArrayList<Ciudad> getAll();
	
	public void deleteAll();
}
