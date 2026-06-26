/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

/**
 *
 * @author OSCAR
 */

public class Ticket {

    private int idTicket;
    private Lavado lavado;
    private String metodoPago;
    private double totalPagado;

    public Ticket() {
    }

    public Ticket(int idTicket, Lavado lavado, String metodoPago) {
        this.idTicket = idTicket;
        this.lavado = lavado;
        this.metodoPago = metodoPago;
        this.totalPagado = lavado.getTotal();
    }

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public Lavado getLavado() {
        return lavado;
    }

    public void setLavado(Lavado lavado) {
        this.lavado = lavado;

        if (lavado != null) {
            this.totalPagado = lavado.getTotal();
        }
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public double getTotalPagado() {
        return totalPagado;
    }

    public void setTotalPagado(double totalPagado) {
        this.totalPagado = totalPagado;
    }
}