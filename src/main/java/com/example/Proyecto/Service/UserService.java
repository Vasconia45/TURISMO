package com.example.Proyecto.Service;

import java.util.ArrayList;

import com.example.Proyecto.DTO.UserDTO;
import com.example.Proyecto.Model.User;

public interface UserService {

	public User save(UserDTO us);
	
	public ArrayList<User> getAll();
	
	public void deleteAll();
	
	public void deleteById(Long id);
}
