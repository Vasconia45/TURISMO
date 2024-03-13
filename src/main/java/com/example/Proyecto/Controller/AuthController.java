package com.example.Proyecto.Controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.example.Proyecto.Model.ERole;
import com.example.Proyecto.Model.Rol;
import com.example.Proyecto.Model.User;
import com.example.Proyecto.Repository.RoleRepository;
import com.example.Proyecto.Repository.UserRepository;
import com.example.Proyecto.payload.request.LoginRequest;
import com.example.Proyecto.payload.request.SignupRequest;
import com.example.Proyecto.payload.response.MessageResponse;
import com.example.Proyecto.payload.response.UserInfoResponse;
import com.example.Proyecto.security.jwt.JwtUtils;
import com.example.Proyecto.security.services.UserDetailsImpl;

import jakarta.validation.Valid;

//for Angular Client (withCredentials)
//@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600, allowCredentials="true")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/")
public class AuthController {

	@Autowired
	  AuthenticationManager authenticationManager;

	  @Autowired
	  UserRepository userRepository;

	  @Autowired
	  RoleRepository roleRepository;

	  @Autowired
	  PasswordEncoder encoder;

	  @Autowired
	  JwtUtils jwtUtils;

	  @PostMapping("/login")
	  public ModelAndView authenticateUser(@Valid LoginRequest loginRequest) {
		  
	    Authentication authentication = authenticationManager
	        .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

	    SecurityContextHolder.getContext().setAuthentication(authentication);

	    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

	    ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);

	    List<String> roles = userDetails.getAuthorities().stream()
	        .map(item -> item.getAuthority())
	        .collect(Collectors.toList());
	    
	    if(loginRequest.getUsername().equals("ADMIN")) {
	    	return new ModelAndView("redirect:/admin");
	    }
	    return new ModelAndView("redirect:/");
	  }

	  @PostMapping("/register")
	  public ModelAndView registerUser(@Valid  SignupRequest signUpRequest) {
	    if (userRepository.existsByUsername(signUpRequest.getUsername())) {
	    	return new ModelAndView();
	     // return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
	    }

	    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
	     // return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
	    }

	    // Create new user's account
	    User user = new User(signUpRequest.getUsername(),
	                         signUpRequest.getEmail(),
	                         encoder.encode(signUpRequest.getPassword()));

	    Set<String> strRoles = signUpRequest.getRole();
	    Set<Rol> roles = new HashSet<>();

	    if (strRoles == null) {
	    	System.out.println("EROLE: " + roleRepository.findByName(ERole.ROLE_USER));
	      Rol userRole = roleRepository.findByName(ERole.ROLE_USER)
	          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
	      roles.add(userRole);
	    } else {
	      strRoles.forEach(role -> {
	        switch (role) {
	        case "admin":
	          Rol adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
	              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
	          roles.add(adminRole);

	          break;
	        case "mod":
	          Rol modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
	              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
	          roles.add(modRole);

	          break;
	        default:
	          Rol userRole = roleRepository.findByName(ERole.ROLE_USER)
	              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
	          roles.add(userRole);
	        }
	      });
	    }

	    user.setRoles(roles);
	    userRepository.save(user);

	    return new ModelAndView("redirect:/register").addObject("success", "The user has been created successfully!");
	  }

	  @PostMapping("/signout")
	  public ResponseEntity<?> logoutUser() {
	    ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
	    return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
	        .body(new MessageResponse("You've been signed out!"));
	  }
}
