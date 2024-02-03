package com.example.Proyecto.Service;

import java.util.List;

import com.example.Proyecto.Model.Establecimiento;

public interface EstablecimientoService {

	public void save(Establecimiento est);
	
	public List<Establecimiento> getAll();
	
	public void deleteById(Long id);
	
	public void deleteAll();
}
