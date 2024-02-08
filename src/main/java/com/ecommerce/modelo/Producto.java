package com.ecommerce.modelo;

import java.util.Objects;

public class Producto {

	private int id;
	private String nombre;
    private double precio;

    public Producto(int id, String nombre, double precio) {
    	this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    // Getters y Setters

    public int getId() {
		return id;
	}

	protected void setId(int id) {
		this.id = id;
	}
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }

    // Método equals para comparar los productos (para su manejo en la clase Carrito)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Producto product = (Producto) obj;
        return  id == product.id &&
        		Double.compare(product.precio, precio) == 0 &&
                Objects.equals(nombre, product.nombre);
    }

    // Método hashCode para generar un código hash basado en id, nombre y precio
    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, precio);
    }

}
