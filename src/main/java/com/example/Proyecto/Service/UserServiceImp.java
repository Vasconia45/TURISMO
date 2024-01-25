package com.example.Proyecto.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Proyecto.DTO.UserDTO;
import com.example.Proyecto.Model.Rol;
import com.example.Proyecto.Model.User;
import com.example.Proyecto.Repository.RoleRepository;
import com.example.Proyecto.Repository.UserRepository;

@Service
public class UserServiceImp implements UserService{

	@Autowired
	private UserRepository Userrepository;
	
	@Autowired
	private RoleRepository Rolerepository;

	@Override
	public User save(UserDTO us) {
		Rol rol = Rolerepository.findById(1l).get();
		User user = new User(us.getNombre(), us.getNombre_usuario(), us.getPhone(), us.getEmail(), us.getPassword(), us.getCreatedOn(), us.getDireccion() ,rol);
		//User user = User.build(0l, us.getNombre(), us.getNombre_usuario(), us.getPhone(), us.getEmail(), us.getPassword(), us.getCreatedOn(), us.getRole());
		return Userrepository.save(user);
	}
}
