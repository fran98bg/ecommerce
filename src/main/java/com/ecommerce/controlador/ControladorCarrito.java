package com.ecommerce.controlador;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ecommerce.modelo.Carrito;
import com.ecommerce.modelo.Producto;
import com.ecommerce.servicios.ServicioCarrito;


@RestController
@RequestMapping("/carritos")
public class ControladorCarrito {
	
	@Autowired
	private ServicioCarrito servicioCarrito;
	
	
	@PostMapping (consumes = {"application/xml","application/json"})
    public Carrito crearCarrito(@RequestBody String carrito) {
        return servicioCarrito.crearCarrito(carrito);
    }

    @GetMapping
    public List<Carrito> findAllProducts() {
        return servicioCarrito.getCarritos();
    }

    @GetMapping("{id}")
    public Carrito getCarritoPorId(@PathVariable String id) {
        return servicioCarrito.getCarritoPorId(id);
    }

    @PutMapping (consumes = {"application/xml","application/json"})
    public Carrito addProductoCarrito(@RequestBody String idCarrito, List<Producto> productos, int cantidad) {
        return servicioCarrito.addProductosCarrito(idCarrito, productos, cantidad);
    }

    @DeleteMapping("{id}") 
    public String borrarCarrito(@PathVariable String id) {
        return servicioCarrito.borrarCarrito(id);
    }
    


}
