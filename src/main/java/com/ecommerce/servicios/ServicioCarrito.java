package com.ecommerce.servicios;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.modelo.Carrito;
import com.ecommerce.modelo.Producto;
import com.ecommerce.repositorio.RepositorioCarrito;

@Service
public class ServicioCarrito {

    @Autowired
    private RepositorioCarrito repCarrito;

    public void inicializarProductos() {
    	repCarrito.inicializarProductos();
    }
    
    public Carrito crearCarrito(String id) {
    	return repCarrito.crearCarrito(id);
    }
    
    public List<Carrito> getCarritos(){
    	return repCarrito.getCarritos();
    }
    
    public Carrito getCarritoPorId(String id) {
    	return repCarrito.encontrarPorId(id);
    }
    
    public String borrarCarrito(String id) {
    	repCarrito.borrarCarrito(id);
    	return "Carrito " + id + " borrado";
    }
    
    public Carrito addProductosCarrito(String id, List<Producto> productos, int cantidad) {
    	return repCarrito.agregarProductosAlCarrito(id, productos, cantidad);
    }
    
}
