package com.example.Proyecto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Proyecto.Model.Pintxo;

@Repository
public interface PintxoRepository extends JpaRepository<Pintxo, Long>{

}
