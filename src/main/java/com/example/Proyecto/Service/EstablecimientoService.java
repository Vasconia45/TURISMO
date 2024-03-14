package com.example.Proyecto.Service;

import java.util.List;

import com.example.Proyecto.Model.Establecimiento;

public interface EstablecimientoService {

	public void save(Establecimiento est);
	
	public List<Establecimiento> getAllDonostia();
	
	public List<Establecimiento> getAllBilbao();
	
	public List<Establecimiento> getAllVitoria();
	
	public List<Establecimiento> getAll();
	
	public void deleteById(Long id);
	
	public void deleteAll();
}
