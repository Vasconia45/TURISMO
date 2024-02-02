package com.example.Proyecto.Controller;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Proyecto.DTO.DireccionDTO;
import com.example.Proyecto.DTO.UserDTO;
import com.example.Proyecto.Model.Direccion;
import com.example.Proyecto.Model.Establecimiento;
import com.example.Proyecto.Model.Rol;
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
	
	@RequestMapping(value="/admin", method = RequestMethod.GET)
	public String adminView() {
		return "admin";
	}
	
	@RequestMapping(value="/admin/nuevoUser", method= RequestMethod.GET)
	public String insertarNuevoUser(Model m) {
		m.addAttribute("user", new UserDTO());
		ArrayList<Rol> roles = roleService.getAll();
		m.addAttribute("roles", roles);
		return "admin/newUser";
	}
	
	@RequestMapping(value="/admin/nuevoUser", method= RequestMethod.POST)
	public String insertaNuevoUser(@ModelAttribute("user") UserDTO user,
			Model model) {
			userService.save(user);
			return "redirect:/admin/tableUser";
	}
	
	@RequestMapping(value="/admin/tableUser", method= RequestMethod.GET)
	public String tableUser(Model m) {
		ArrayList<User> usuarios = userService.getAll();
		m.addAttribute("usuarios", usuarios);
		return "admin/tableUser";
	}
	
	@RequestMapping(value="/admin/tableUser/deleteUser/{id}", method= RequestMethod.POST)
	public String deleteUser(@PathVariable("id") Long id, Model m) {
		System.out.println(id);
		userService.deleteById(id);
		return "redirect:/admin/tableUser";
	}
	
	/// NEW CIUDAD
	
	@RequestMapping(value="/admin/nuevoEstablecimiento", method = RequestMethod.GET)
	public String insertaNuevoEstablecimiento(Model m) {
		m.addAttribute("est", new Establecimiento());
		return "admin/newEstablecimiento";
	}
}
