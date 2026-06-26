package MODELO;

import java.util.Date;

public class Servicio {

    private int idServicio;
    private Cliente cliente;
    private Automovil automovil;
    private String tipoLavado;
    private double precio;
    private Date fechaServicio;
    private String hora;
    private String observaciones;

    public Servicio() {
    }

    public Servicio(int idServicio, Cliente cliente, Automovil automovil,
            String tipoLavado, double precio, Date fechaServicio,
            String hora, String observaciones) {

        this.idServicio = idServicio;
        this.cliente = cliente;
        this.automovil = automovil;
        this.tipoLavado = tipoLavado;
        this.precio = precio;
        this.fechaServicio = fechaServicio;
        this.hora = hora;
        this.observaciones = observaciones;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
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

    public String getTipoLavado() {
        return tipoLavado;
    }

    public void setTipoLavado(String tipoLavado) {
        this.tipoLavado = tipoLavado;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Date getFechaServicio() {
        return fechaServicio;
    }

    public void setFechaServicio(Date fechaServicio) {
        this.fechaServicio = fechaServicio;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public String toString() {
        return idServicio + " - " + tipoLavado;
    }
}