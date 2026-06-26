/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR;

import Datos.RepositorioDatos;
import MODELO.Lavado;
import MODELO.Ticket;
import java.util.ArrayList;

public class ControladorTicket {

    public Ticket generarTicket(int idLavado, String metodoPago) {
        ControladorLavado controladorLavado = new ControladorLavado();
        Lavado lavado = controladorLavado.buscarPorId(idLavado);

        if (lavado == null || metodoPago == null || metodoPago.trim().isEmpty()) {
            return null;
        }

        if (!lavado.getEstado().equalsIgnoreCase("Terminado")) {
            return null;
        }

        if (buscarPorLavado(idLavado) != null) {
            return null;
        }

        Ticket ticket = new Ticket(
                RepositorioDatos.siguienteIdTicket(),
                lavado,
                metodoPago.trim()
        );

        RepositorioDatos.getTickets().add(ticket);
        lavado.setEstado("Entregado");

        return ticket;
    }

    public Ticket buscarPorLavado(int idLavado) {
        for (Ticket ticket : RepositorioDatos.getTickets()) {
            if (ticket.getLavado().getIdLavado() == idLavado) {
                return ticket;
            }
        }

        return null;
    }

    public ArrayList<Ticket> listarTickets() {
        return new ArrayList<>(RepositorioDatos.getTickets());
    }
}