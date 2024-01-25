package com.example.Proyecto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Proyecto.Model.EstablecimientoPintxo;
import com.example.Proyecto.Model.EstablecimientoPintxo.Id;

@Repository
public interface EstablecimientoPintxoRepository extends JpaRepository<EstablecimientoPintxo, Id>{

}
