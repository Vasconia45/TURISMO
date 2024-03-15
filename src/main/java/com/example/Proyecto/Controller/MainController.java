package com.example.Proyecto.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Proyecto.DTO.UserDTO;
import com.example.Proyecto.Model.Ciudad;
import com.example.Proyecto.Model.ERole;
import com.example.Proyecto.Model.Establecimiento;
import com.example.Proyecto.Model.Opinion;
import com.example.Proyecto.Model.Pintxo;
import com.example.Proyecto.Model.Rol;
import com.example.Proyecto.Model.User;
import com.example.Proyecto.Repository.RoleRepository;
import com.example.Proyecto.Service.CiudadService;
import com.example.Proyecto.Service.EstablecimientoService;
import com.example.Proyecto.Service.OpinionService;
import com.example.Proyecto.Service.PintxoService;
import com.example.Proyecto.Service.RoleService;
import com.example.Proyecto.Service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class MainController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private CiudadService ciudadService;
	
	@Autowired
	private RoleRepository roleRep;
	
	@Autowired
	private EstablecimientoService estService;
	
	@Autowired
	private PintxoService pintxoService;
	
	@Autowired
	private OpinionService opinionService;
	
	private List<String> ingredientes = new ArrayList<>();

	
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
	
	/*@PostMapping("/register")
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
	}*/
	
	// VISTAS ADMIN
	
	@RequestMapping(value="/admin", method = RequestMethod.GET)
	public String adminView(Model m) {
		int totalUsers = userService.getAll().size();
		m.addAttribute("totalUsers", totalUsers);
		return "admin";
	}
	
	@RequestMapping(value="/admin/nuevoUser", method= RequestMethod.GET)
	public String insertarNuevoUser(Model m) {
		m.addAttribute("user", new UserDTO());
		ArrayList<Rol> roles = roleService.getAll();
		System.out.println(roles.get(0).getName());
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
		userService.deleteById(id);
		return "redirect:/admin/tableUser";
	}
	
	/// NEW ESTABLECIMIENTO
	
	@RequestMapping(value="/admin/nuevoEstablecimiento", method = RequestMethod.GET)
	public String insertarNuevoEstablecimiento(Model m) {
		m.addAttribute("est", new Establecimiento());
		ArrayList<Ciudad> ciudades = ciudadService.getAll();
		m.addAttribute("ciudades", ciudades);
		return "admin/newEstablecimiento";
	}
	
	@RequestMapping(value="/admin/nuevoEstablecimiento", method = RequestMethod.POST)
	public String insertaNuevoEstablecimiento(@ModelAttribute("est") Establecimiento est, Model m) {
		estService.save(est);
		return "redirect:/admin/tableEstablecimiento";
	}
	
	@RequestMapping(value="/admin/tableEstablecimiento", method= RequestMethod.GET)
	public String tableEstablecimiento(Model m) {
		List<Establecimiento> establecimientos = estService.getAll();
		m.addAttribute("establecimientos", establecimientos);
		return "admin/tableEstablecimiento";
	}
	
	@RequestMapping(value="/admin/tableEstablecimiento/deleteEst/{id}", method= RequestMethod.POST)
	public String deleteEstablecimiento(@PathVariable("id") Long id, Model m) {
		estService.deleteById(id);
		return "redirect:/admin/tableEstablecimiento";
	}
	
	
	@RequestMapping(value="/admin/nuevoPintxo", method = RequestMethod.GET)
	public String insertarNuevoPintxo(Model m) {
		m.addAttribute("pintxo", new Pintxo());
		return "admin/newPintxo";
	}
	
	@RequestMapping(value="/admin/nuevoPintxo", method = RequestMethod.POST)
	public String insertaNuevoPintxo(@ModelAttribute("pintxo") Pintxo pintxo) {
		System.out.println(pintxo.getNombre() +"---" + pintxo.getIngredientes());
		pintxoService.save(pintxo);
		return "redirect:/admin";
	}
	
	
	// CIUDADES
	
	@GetMapping("/bilbao")
	public String bilbao(Model m) {
		List<Establecimiento> establecimientos = estService.getAllBilbao();
		m.addAttribute("establecimientos", establecimientos);
		return "ciudades/bilbao";
	}
	
	@GetMapping("/donostia")
	public String donostia(Model m) {
		List<Establecimiento> establecimientos = estService.getAllDonostia();
		m.addAttribute("establecimientos", establecimientos);
		return "ciudades/donostia";
	}
	
	@GetMapping("/vitoria")
	public String vitoria(Model m) {
		List<Establecimiento> establecimientos = estService.getAllVitoria();
		m.addAttribute("establecimientos", establecimientos);
		return "ciudades/vitoria";
	}
	
	// COMENTARIO 
	
	// Guardar opinion
	@RequestMapping(value="/opinion", method= RequestMethod.POST)
	public String opinion() {
		return "redirect:/#ciudad";
	}
	
	//PINTXOS
	@RequestMapping(value="/pintxos", method = RequestMethod.GET)
	public String pintxos(Model m) {
		List<Pintxo> pintxos = pintxoService.getAll();
		m.addAttribute("pintxos", pintxos);
		m.addAttribute("opinion", new Opinion());
		return "pintxos/donostia";
	}
	
	@RequestMapping(value="/pintxos/guardar/{id}", method = RequestMethod.POST)
	public String guardarPintxos(@PathVariable("id") Long id, @ModelAttribute("opinion") Opinion op) {
		op.setId(id, userService.findByUsername("ADMIN"));
		opinionService.save(op);
		return "redirect:/pintxos";
	}
}
