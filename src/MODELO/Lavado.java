/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;


import java.util.ArrayList;

public class Lavado {

    private int idLavado;
    private Cliente cliente;
    private Automovil automovil;
    private Empleado empleado;
    private String fecha;
    private String horaEntrada;
    private String estado;
    private ArrayList<DetalleLavadoServicio> detalles;
    private double total;

    public Lavado() {
        detalles = new ArrayList<>();
    }

    public Lavado(int idLavado, Cliente cliente, Automovil automovil,
                  Empleado empleado, String fecha, String horaEntrada,
                  String estado) {

        this.idLavado = idLavado;
        this.cliente = cliente;
        this.automovil = automovil;
        this.empleado = empleado;
        this.fecha = fecha;
        this.horaEntrada = horaEntrada;
        this.estado = estado;
        this.detalles = new ArrayList<>();
        this.total = 0;
    }

    public void agregarServicio(Servicio servicio, int cantidad) {
        DetalleLavadoServicio detalle = new DetalleLavadoServicio(
                servicio, cantidad
        );

        detalles.add(detalle);
        calcularTotal();
    }

    public void calcularTotal() {
        total = 0;

        for (DetalleLavadoServicio detalle : detalles) {
            total += detalle.getSubtotal();
        }
    }

    public int getIdLavado() {
        return idLavado;
    }

    public void setIdLavado(int idLavado) {
        this.idLavado = idLavado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Automovil getAutomovil() {
        return automovil;
    }

    public void setAutomovil(Automovil automovil) {
        this.automovil = automovil;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ArrayList<DetalleLavadoServicio> getDetalles() {
        return detalles;
    }

    public void setDetalles(ArrayList<DetalleLavadoServicio> detalles) {
        this.detalles = detalles;
        calcularTotal();
    }

    public double getTotal() {
        return total;
    }
}