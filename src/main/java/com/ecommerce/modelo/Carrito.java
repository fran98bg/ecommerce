package com.ecommerce.modelo;

import java.util.HashMap;
import java.util.Map;



public class Carrito {
	

	
	//Almacenamos los productos en un Map para poder gestionar la cantidad
	private String id;
	private Map<Producto, Integer> productos;
	private long ttl; //tiempo de vida (en milisegundos)
	
	//Constructores
	public Carrito(String id) {
		this.id = id;
		this.setProductos(new HashMap<>());
		this.ttl = System.currentTimeMillis() + 600_000; //10 minutos de tiempo de vida
		System.out.println("Carrito creado con id: "+id);
		}

	//Getters y Setters de las variables
	public String getId() {
		return id;
	}

	protected void setId(String id) {
		this.id = id;
	}

	public Map<Producto,Integer> getProductos() {
		return productos;
	}

	public void setProductos(Map<Producto,Integer> productos) {
		this.productos = productos;
	}

    public long getTtl() {
		return ttl;
	}


	// Método para obtener el total de la compra en el carrito
    public double calcularTotal() {
        double total = 0.0;
        for (Map.Entry<Producto, Integer> entry : productos.entrySet()) {
            Producto producto = entry.getKey();
            int cantidad = entry.getValue();
            total += producto.getPrecio() * cantidad;
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder carritoInfo = new StringBuilder();
        carritoInfo.append("ID del Carrito: ").append(getId()).append("\n");
        carritoInfo.append("Productos en el Carrito:\n");
        for (Map.Entry<Producto, Integer> entry : productos.entrySet()) {
            Producto product = entry.getKey();
            int quantity = entry.getValue();
            carritoInfo.append("- ").append(product.getNombre()).append(", Cantidad: ").append(quantity).append("\n");
        }
        carritoInfo.append("Tiempo de Vida Restante: ").append((ttl - System.currentTimeMillis()) / 1000).append(" segundos\n");
        carritoInfo.append("Total de la Compra: ").append(calcularTotal()).append(" €").append("\n");
        return carritoInfo.toString();
    }
    
    public void printCarritoInfo() {
        System.out.println(this.toString());
    }

}
