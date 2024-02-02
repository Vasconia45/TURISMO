package com.example.Proyecto.Service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Proyecto.DTO.UserDTO;
import com.example.Proyecto.Model.Direccion;
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
		User user = new User(us.getNombre(), us.getNombre_usuario(), us.getPhone(), us.getEmail(), us.getPassword(), LocalDateTime.now(), us.getDireccion(), us.getRole());
		return Userrepository.save(user);
	}
	
	@Override
	public void deleteAll() {
		Userrepository.deleteAll();
	}
}
