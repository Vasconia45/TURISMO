package com.example.Proyecto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Proyecto.Model.Ciudad;

@Repository
public interface CiudadRepository extends JpaRepository<Ciudad, Long>{

}
