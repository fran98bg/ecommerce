package com.ecommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ecommerce.repositorio.RepositorioCarrito;

@SpringBootApplication
public class ECommerceApp implements CommandLineRunner{
	
	@Autowired
    private RepositorioCarrito repositorioCarrito;
	
	public static void main(String[] args) {
		SpringApplication.run(ECommerceApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repositorioCarrito.inicializarProductos();		
	}
}
