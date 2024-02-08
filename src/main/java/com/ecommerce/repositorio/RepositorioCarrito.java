package com.ecommerce.repositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ecommerce.modelo.Carrito;
import com.ecommerce.modelo.Producto;

@Repository
public class RepositorioCarrito {
	

	private List<Carrito> carritos = new ArrayList<Carrito>();
	private List<Producto> productosDisponibles = new ArrayList<Producto>();
	
	
	public void inicializarProductos() {
		productosDisponibles = List.of(
                new Producto(1, "Producto 1", 10),
                new Producto(2, "Producto 2", 20),
                new Producto(3, "Producto 3", 30)
        );
	}
	
	public Carrito crearCarrito(String id) {
		Carrito carrito = new Carrito(id);
		carritos.add(carrito);
		return carrito;
	}

	public List<Carrito> getCarritos(){
		return carritos;
	}
	
	public Carrito encontrarPorId(String id) {
		return carritos.stream()
                .filter(carrito -> carrito.getId().equals(id))
                .findFirst()
                .orElse(null);
	}
	
	public void borrarCarrito(String id) {
		Carrito carrito = encontrarPorId(id);
		if(carritos.remove(carrito)) {
			System.out.println("Carrito con id " + id + " ha sido eliminado");
		}
	}
	
    public Carrito agregarProductosAlCarrito(String idCarrito, List<Producto> productos, int cantidad) {
        Carrito carrito = encontrarPorId(idCarrito);
        if (carrito != null) {
        	for(Producto producto : productos) {
        		carrito = addProducto(carrito, producto, cantidad);
        	}
        } else {
        	System.out.println("\"No se encontró el carrito con id "+ idCarrito + ". No se pudo agregar el producto.");
        }
        return carrito;
    }
    
    public boolean isExpired(Carrito carrito) {
        return System.currentTimeMillis() > carrito.getTtl();
    }

    // Método para agregar un producto al carrito
    private Carrito addProducto(Carrito carrito, Producto producto, int cantidad) {
        if (!isExpired(carrito)) {
            Map<Producto,Integer> productos = carrito.getProductos();
            //Comprobamos que no se ha producido un error al introducir el producto
            for(Producto p : productosDisponibles) {
            	if(p.equals(producto)) {
                    // Actualizar la cantidad si el producto ya está en el carrito
                    productos.merge(producto, cantidad, Integer::sum);
                    
                    carrito.setProductos(productos);
            	}
            }

            System.out.println(cantidad + " unidades de "+ producto.getNombre() + " agregadas al carrito "+ carrito.getId()+ ". Total en el carrito de este producto: "+carrito.getProductos().get(producto));
        } else {
        	borrarCarrito(carrito.getId());
        	System.out.println("El carrito ha expirado. No se pueden agregar productos.");
        }
        return carrito;
    }
	

}
