package com.example.Proyecto.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Proyecto.Model.ERole;
import com.example.Proyecto.Model.Rol;

@Repository
public interface RoleRepository extends JpaRepository<Rol, Long>{
	Optional<Rol> findByName(ERole name);
}
