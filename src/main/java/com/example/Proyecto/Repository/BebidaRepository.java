package com.example.Proyecto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Proyecto.Model.Bebida;

@Repository
public interface BebidaRepository extends JpaRepository<Bebida, Long>{

}
