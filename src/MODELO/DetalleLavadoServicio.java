/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

/**
 *
 * @author OSCAR
 */

public class DetalleLavadoServicio {

    private Servicio servicio;
    private int cantidad;
    private double subtotal;

    public DetalleLavadoServicio() {
    }

    public DetalleLavadoServicio(Servicio servicio, int cantidad) {
        this.servicio = servicio;
        this.cantidad = cantidad;
        calcularSubtotal();
    }

    public void calcularSubtotal() {
        subtotal = servicio.getPrecio() * cantidad;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
        calcularSubtotal();
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
        calcularSubtotal();
    }

    public double getSubtotal() {
        return subtotal;
    }
}