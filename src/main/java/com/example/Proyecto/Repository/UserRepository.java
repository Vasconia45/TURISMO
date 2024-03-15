package com.example.Proyecto.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Proyecto.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findByUsername(String username);
	User getByUsername(String username);

  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);

	

}
