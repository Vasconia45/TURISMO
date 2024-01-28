package com.example.Proyecto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Proyecto.Model.Favorito;
import com.example.Proyecto.Model.Favorito.Id;

@Repository
public interface FavoritoRepository extends JpaRepository<Favorito, Id>{

}
