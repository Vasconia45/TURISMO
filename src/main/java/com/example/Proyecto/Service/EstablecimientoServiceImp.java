package com.example.Proyecto.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Proyecto.Model.Ciudad;
import com.example.Proyecto.Model.Establecimiento;
import com.example.Proyecto.Repository.CiudadRepository;
import com.example.Proyecto.Repository.EstablecimientoRepository;

@Service
public class EstablecimientoServiceImp implements EstablecimientoService{

	@Autowired
	private EstablecimientoRepository estrepository;
	
	@Autowired
	private CiudadRepository ciudadRepository;
	
	@Override
	public void save(Establecimiento establecimiento) {
		estrepository.save(establecimiento);	
	}

	@Override
	public void deleteAll() {
		estrepository.deleteAll();
		
	}

	@Override
	public List<Establecimiento> getAll() {
		List<Establecimiento> establecimientos = estrepository.findAll();
		return establecimientos;
	}

	@Override
	public void deleteById(Long id) {
		estrepository.deleteById(id);
	}

	@Override
	public List<Establecimiento> getAllDonostia() {
		Long ciudad = ciudadRepository.findAllByNombre("Donostia").getId();
		List<Establecimiento> establecimientos = estrepository.findAllByCiudadId(ciudad);
		return establecimientos;
	}

	@Override
	public List<Establecimiento> getAllBilbao() {
		Long ciudad = ciudadRepository.findAllByNombre("Bilbao").getId();
		List<Establecimiento> establecimientos = estrepository.findAllByCiudadId(ciudad);
		return establecimientos;
	}

	@Override
	public List<Establecimiento> getAllVitoria() {
		Long ciudad = ciudadRepository.findAllByNombre("Vitoria").getId();
		List<Establecimiento> establecimientos = estrepository.findAllByCiudadId(ciudad);
		return establecimientos;
	}

}
