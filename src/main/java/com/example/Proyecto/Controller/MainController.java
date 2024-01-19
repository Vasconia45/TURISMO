package com.example.Proyecto.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Proyecto.DTO.UserDTO;
import com.example.Proyecto.Model.User;
import com.example.Proyecto.Service.UserService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class MainController {

	@Autowired
	private UserService service;
	
	@GetMapping
	public String home() {
		return "home";
	}

	@GetMapping("/register")
	public String register(Model m) {
		m.addAttribute("user", new User());
		return "register";
	}
	
	@PostMapping("/register")
	public String saveUser(@Valid @ModelAttribute("user") UserDTO userDTO 
			,BindingResult bindingResults){
		if(userDTO.getNombre() == null) {
			
		}
		if(bindingResults.hasErrors()) {
			return "register";
		}
		else {
			service.save(userDTO);		
			return "redirect:/register?exito";
		}
	}
	
	@PostMapping("/login/{id}")
	public String login(){
		return "cliente";
	}
	
	@GetMapping("/admin")
	public String adminView() {
		return "admin";
	}
}
