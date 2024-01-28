package com.example.Proyecto.Service;

import com.example.Proyecto.DTO.UserDTO;
import com.example.Proyecto.Model.User;

public interface UserService {

	public User save(UserDTO us);
	
	public void deleteAll();
}
