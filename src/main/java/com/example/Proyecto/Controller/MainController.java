package com.example.Proyecto.Controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Proyecto.DTO.UserDTO;
import com.example.Proyecto.Model.Direccion;
import com.example.Proyecto.Model.User;
import com.example.Proyecto.Service.RoleService;
import com.example.Proyecto.Service.UserService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class MainController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	// INICIO
	
	@GetMapping
	public String home() {
		return "home";
	}
	
	// VISTAS LOGIN Y REGISTER

	@GetMapping("/register")
	public String register(Model m) {
		m.addAttribute("user", new User());
		return "register";
	}
	
	@PostMapping("/register")
	public String saveUser(@Valid @ModelAttribute("user") User user
			,BindingResult bindingResults){
		if(user.getNombre() == null) {
			
		}
		if(bindingResults.hasErrors()) {
			return "register";
		}
		else {
			//userService.save(user);		
			return "redirect:/register?exito";
		}
	}

	@PostMapping("/login/{id}")
	public String login(){
		return "cliente";
	}
	
	// VISTAS ADMIN
	
	@GetMapping("/admin")
	public String adminView() {
		return "admin";
	}
	
	@GetMapping("/admin/nuevoUser")
	public String insertarNuevoUser(Model m) {
		m.addAttribute("user", new UserDTO());
		return "admin/nuevoUser";
	}
	
	@PostMapping("/admin/nuevoUser")
	public String insertaNuevoUser(@Valid @ModelAttribute("user") UserDTO user, BindingResult bindingResults) {
		if(bindingResults.hasErrors()) {
			return "admin/nuevoUser";
		}
		else {
			userService.save(user);
			return "redirect:/admin";
		}
	}
}
