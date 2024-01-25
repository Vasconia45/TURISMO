package com.example.Proyecto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Proyecto.Model.EstablecimientoBebida;
import com.example.Proyecto.Model.EstablecimientoBebida.Id;

public interface EstablecimientoBebidaRepository extends JpaRepository<EstablecimientoBebida, Id>{

}
