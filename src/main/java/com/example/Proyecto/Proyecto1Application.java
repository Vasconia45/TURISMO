package com.example.Proyecto;

import java.time.Year;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Proyecto.DTO.CiudadDTO;
import com.example.Proyecto.DTO.EstablecimientoDTO;
import com.example.Proyecto.DTO.PintxoDTO;
import com.example.Proyecto.DTO.UserDTO;
import com.example.Proyecto.Model.Ciudad;
import com.example.Proyecto.Model.Direccion;
import com.example.Proyecto.Model.Establecimiento;
import com.example.Proyecto.Model.EstablecimientoPintxo;
import com.example.Proyecto.Model.Pintxo;
import com.example.Proyecto.Model.Rol;
import com.example.Proyecto.Model.User;
import com.example.Proyecto.Repository.EstablecimientoPintxoRepository;
import com.example.Proyecto.Service.CiudadService;
import com.example.Proyecto.Service.EstablecimientoService;
import com.example.Proyecto.Service.PintxoService;
import com.example.Proyecto.Service.RoleService;
import com.example.Proyecto.Service.UserService;

@SpringBootApplication
public class Proyecto1Application {
	
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
	public ApplicationRunner configure(RoleService roleservice, UserService userservice, CiudadService ciudadservice, EstablecimientoPintxoRepository estPinrepository, EstablecimientoService estservice, PintxoService pintxoservice) {
		return env -> {

			// Relacion entre User, Rol, Direccion
			/*Rol rol1 = new Rol(1l, "ADMIN");
			Rol rol2 = new Rol(2l, "USER");
			UserDTO pablo = new UserDTO("Pablo", "ablo_44", 6598256, "pil.donosti@gmail.com", "sadas", LocalDateTime.now(), "Borroto 34", 20009, "3B", rol1);
			UserDTO pepe = new UserDTO("Pepe", "PEPE_56", 6598256, "pil.donosti@gmail.com", "sadas", LocalDateTime.now(), "Pascual 31 2D", 10014, "3B", rol2);
			UserDTO pruebaNull = new UserDTO("Prueba", null, 0, "pil.donosti@gmail.com", "sadas", null,null, 0, null, rol2);
			
			roleservice.save(rol1);
			roleservice.save(rol2);
			userservice.save(pablo);
			userservice.save(pepe);
			userservice.save(pruebaNull);
			*/
			
			// Relacion entre Ciudad, Establecimiento, Direccion
			/*Direccion d1 = new Direccion("Plaza Guipuzcoa", 20005, "16");

			Ciudad ciudad1 = new Ciudad(1l, "Donostia", "Guipuzcoa", "Esto es Donosti");
			Ciudad ciudad2 = new Ciudad(2l, "Bilbao", "Bizkaia", "Esto es Bilbao");
			Ciudad ciudad3 = new Ciudad(3l, "Vitoria", "Araba", "Esto es Vitoria");
			EstablecimientoDTO est1 = new EstablecimientoDTO(22l, "Bideluze", "6522145", Year.now(), d1, ciudad1);
			
			ciudadservice.save(ciudad1);
			ciudadservice.save(ciudad2);
			ciudadservice.save(ciudad3);
			estservice.save(est1, ciudad1.getId());*/
			
			
			//Relacion Many to Many
			Direccion d1 = new Direccion("Plaza Guipuzcoa", 20005, "16");
			Ciudad ciudad2 = new Ciudad(2l, "Bilbao", "Bizkaia", "Esto es Bilbao");
			Pintxo pintxo1 = new Pintxo("Pintxo gilda", "scmsdcsd", "extra1");
			Establecimiento est1 = new Establecimiento("Quijote", "233242", Year.now(), d1 ,ciudad2);
			ciudadservice.save(ciudad2);
			pintxoservice.save(pintxo1);
			estservice.save(est1);
			
			EstablecimientoPintxo establecimientoPintxo1 = new EstablecimientoPintxo(3.0, pintxo1, est1);
			
			
			estPinrepository.save(establecimientoPintxo1);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Proyecto1Application.class, args);
	}
	

}
