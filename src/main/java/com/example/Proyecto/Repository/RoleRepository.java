package com.example.Proyecto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Proyecto.Model.Rol;

@Repository
public interface RoleRepository extends JpaRepository<Rol, Long>{

}
