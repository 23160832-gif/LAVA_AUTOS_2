/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR;


import Datos.RepositorioDatos;
import MODELO.Servicio;
import java.util.ArrayList;

public class ControladorServicio {

    public boolean guardarServicio(String nombre, String descripcion, double precio) {

        if (nombre == null || nombre.trim().isEmpty() || precio <= 0) {
            return false;
        }

        Servicio servicio = new Servicio(
                RepositorioDatos.siguienteIdServicio(),
                nombre.trim(),
                descripcion.trim(),
                precio
        );

        RepositorioDatos.getServicios().add(servicio);
        return true;
    }

    public boolean actualizarServicio(int idServicio, String nombre,
            String descripcion, double precio) {

        Servicio servicio = buscarPorId(idServicio);

        if (servicio == null || nombre == null
                || nombre.trim().isEmpty() || precio <= 0) {
            return false;
        }

        servicio.setNombre(nombre.trim());
        servicio.setDescripcion(descripcion.trim());
        servicio.setPrecio(precio);

        return true;
    }

    public boolean eliminarServicio(int idServicio) {
        Servicio servicio = buscarPorId(idServicio);

        if (servicio == null) {
            return false;
        }

        RepositorioDatos.getServicios().remove(servicio);
        return true;
    }

    public Servicio buscarPorId(int idServicio) {
        for (Servicio servicio : RepositorioDatos.getServicios()) {
            if (servicio.getIdServicio() == idServicio) {
                return servicio;
            }
        }

        return null;
    }

    public ArrayList<Servicio> listarServicios() {
        return new ArrayList<>(RepositorioDatos.getServicios());
    }
}