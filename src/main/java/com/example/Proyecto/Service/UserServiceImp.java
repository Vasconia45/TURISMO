package com.example.Proyecto.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Proyecto.DTO.UserDTO;
import com.example.Proyecto.Model.Direccion;
import com.example.Proyecto.Model.Rol;
import com.example.Proyecto.Model.User;
import com.example.Proyecto.Repository.UserRepository;

@Service
public class UserServiceImp implements UserService{
	
	@Autowired
	private RoleService roleService;

	@Autowired
	private UserRepository Userrepository;

	@Override
	public User save(UserDTO us) {
		User user = new User(us.getNombre(), us.getUsername(), us.getPhone(), us.getEmail(), us.getPassword(), LocalDateTime.now(), us.getDireccion());
		return Userrepository.save(user);
	}
	
	@Override
	public void deleteAll() {
		Userrepository.deleteAll();
	}

	@Override
	public ArrayList<User> getAll() {
		ArrayList<User> usuarios = (ArrayList<User>) Userrepository.findAll();
		return usuarios;
	}

	@Override
	public void deleteById(Long id) {
		Userrepository.deleteById(id);
	}

	@Override
	public Long findByUsername(String username) {
		Long us = Userrepository.getByUsername(username).getId();
		return us;
	}
}
