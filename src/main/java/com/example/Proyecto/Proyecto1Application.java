package com.example.Proyecto;

import java.time.LocalDateTime;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.example.Proyecto.DTO.UserDTO;
import com.example.Proyecto.Model.Direccion;
import com.example.Proyecto.Model.Rol;
import com.example.Proyecto.Model.User;
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
	public ApplicationRunner configure(RoleService roleservice, UserService userservice) {
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
			
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Proyecto1Application.class, args);
	}
	

}
