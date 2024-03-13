package com.example.Proyecto;

import java.time.LocalDateTime;
import java.time.Year;

import org.hibernate.boot.model.source.spi.AttributeRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.Proyecto.DTO.UserDTO;
import com.example.Proyecto.Model.Ciudad;
import com.example.Proyecto.Model.Direccion;
import com.example.Proyecto.Model.ERole;
import com.example.Proyecto.Model.Establecimiento;
import com.example.Proyecto.Model.EstablecimientoPintxo;
import com.example.Proyecto.Model.Favorito;
import com.example.Proyecto.Model.Opinion;
import com.example.Proyecto.Model.Pintxo;
import com.example.Proyecto.Model.Rol;
import com.example.Proyecto.Model.User;
import com.example.Proyecto.Repository.EstablecimientoBebidaRepository;
import com.example.Proyecto.Repository.UserRepository;
import com.example.Proyecto.Service.BebidaService;
import com.example.Proyecto.Service.CiudadService;
import com.example.Proyecto.Service.EstablecimientoPintxoService;
import com.example.Proyecto.Service.EstablecimientoService;
import com.example.Proyecto.Service.FavoritoService;
import com.example.Proyecto.Service.OpinionService;
import com.example.Proyecto.Service.PintxoService;
import com.example.Proyecto.Service.RoleService;
import com.example.Proyecto.Service.UserService;

@SpringBootApplication
public class Proyecto1Application {
	
	 @Autowired
	  PasswordEncoder encoder;
	
	/*@Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public LocalValidatorFactoryBean validator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }*/
	
	@Bean
	public ApplicationRunner configure(UserRepository userRepository, RoleService roleService, UserService userService, CiudadService ciudadservice, 
			EstablecimientoPintxoService estPinservice, EstablecimientoService estservice, PintxoService pintxoservice,
			BebidaService bebidaservice, EstablecimientoBebidaRepository estBebrepository, FavoritoService favoritoservice,
			OpinionService opinionservice) {
		return env -> {
			ciudadservice.deleteAll();
			userService.deleteAll();
			roleService.deleteAll();
			
			Ciudad donostia = new Ciudad("Donostia", "Guipuzcoa", 150000, "Tiene X habitantes");
			Ciudad vitoria = new Ciudad("Vitoria", "Alava", 80000, "Tiene X");
			Ciudad bilbao = new Ciudad("Bilbao", "Bizkaia", 200000, "Tiene Y");

			ciudadservice.save(bilbao);
			ciudadservice.save(donostia);
			ciudadservice.save(vitoria);
			
			Rol rol1 = new Rol();
			rol1.setName(ERole.ROLE_USER);
			
			Rol rol2 = new Rol();
			rol2.setName(ERole.ROLE_ADMIN);
			
			Rol rol3 = new Rol();
			rol3.setName(ERole.ROLE_MODERATOR);

			
			roleService.save(rol1);
			roleService.save(rol2);
			roleService.save(rol3);
			
			User admin = new User();
			admin.setUsername("ADMIN");
			admin.setPassword(encoder.encode("Donosti34"));
			
			
			userRepository.save(admin);
			
			/*favoritoservice.deleteAll();
			opinionservice.deleteAll();
			userservice.deleteAll();
			ciudadservice.deleteAll();
			estPinservice.deleteAll();
			estservice.deleteAll();
			pintxoservice.deleteAll();
			
			
			//Relacion Usuario-Opinion
			
			User user1 = new User("Pablo", "Pablo_45", 6058998, "Donostiii", "Donostiii");
			user1.setCreatedOn(LocalDateTime.now());
			user1.setDireccion(new Direccion("Borroto 35", 20009, "3B"));
			Rol rol1 = new Rol(1l, "ADMIN");
			Rol rol2 = new Rol(2l, "USER");
			user1.setRole(rol1);
			
			Ciudad donostia = new Ciudad("Donostia", "Guipuzcoa", 150000, "Tiene X habitantes");
			Ciudad vitoria = new Ciudad("Vitoria", "Alava", 80000, "Tiene X");
			Ciudad bilbao = new Ciudad("Bilbao", "Bizkaia", 200000, "Tiene Y");

			ciudadservice.save(bilbao);
			ciudadservice.save(donostia);
			ciudadservice.save(vitoria);
			
			Establecimiento est1 = new Establecimiento("Bideluze", "60588952", Year.now());
			Establecimiento est2 = new Establecimiento("Quijote", "60588882", Year.now());
			est1.setDireccion(new Direccion("Plaza Guipuzcoa", 20004, "7"));
			est2.setDireccion(new Direccion("Avenida Libertad", 20004, "22"));
			est1.setCiudad(donostia);
			est2.setCiudad(bilbao);
			
			estservice.save(est1);
			estservice.save(est2);
			
			Pintxo bonito = new Pintxo("Bonito", "etcccc", "extra1");
			Pintxo bacalao = new Pintxo("Bacalao", "etcccc", "extra2");
			pintxoservice.save(bonito);
			pintxoservice.save(bacalao);

			EstablecimientoPintxo estPin = new EstablecimientoPintxo(3.00, bonito, est1);
			estPinservice.save(estPin);
			
			roleservice.save(rol1);
			roleservice.save(rol2);
			userservice.save(user1);
			
			Favorito fav = new Favorito(bonito, user1);
			Favorito fav2 = new Favorito(bacalao, user1);
			favoritoservice.save(fav);
			favoritoservice.save(fav2);
			
			Opinion opinion1 = new Opinion(bonito, user1, "Muy muy bueno", 8);
			opinionservice.save(opinion1);*/
			
			
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Proyecto1Application.class, args);
	}
	

}
