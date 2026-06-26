package CONTROLADOR;

import Datos.RepositorioDatos;
import MODELO.Automovil;
import MODELO.Cliente;
import MODELO.Servicio;
import java.util.ArrayList;
import java.util.Date;

public class ControladorServicio {

    public boolean guardarServicio(Cliente cliente, Automovil automovil,
            String tipoLavado, double precio, Date fechaServicio,
            String hora, String observaciones) {

        if (cliente == null || automovil == null
                || tipoLavado == null || tipoLavado.trim().isEmpty()
                || precio <= 0
                || fechaServicio == null
                || hora == null || hora.trim().isEmpty()) {
            return false;
        }

        // Verifica que el automóvil pertenezca al cliente elegido.
        if (automovil.getCliente().getIdCliente() != cliente.getIdCliente()) {
            return false;
        }

        Servicio servicio = new Servicio(
                RepositorioDatos.siguienteIdServicio(),
                cliente,
                automovil,
                tipoLavado.trim(),
                precio,
                fechaServicio,
                hora.trim(),
                observaciones.trim()
        );

        RepositorioDatos.getServicios().add(servicio);
        return true;
    }

    public boolean actualizarServicio(int idServicio, Cliente cliente,
            Automovil automovil, String tipoLavado, double precio,
            Date fechaServicio, String hora, String observaciones) {

        Servicio servicio = buscarPorId(idServicio);

        if (servicio == null || cliente == null || automovil == null
                || tipoLavado == null || tipoLavado.trim().isEmpty()
                || precio <= 0
                || fechaServicio == null
                || hora == null || hora.trim().isEmpty()) {
            return false;
        }

        if (automovil.getCliente().getIdCliente() != cliente.getIdCliente()) {
            return false;
        }

        servicio.setCliente(cliente);
        servicio.setAutomovil(automovil);
        servicio.setTipoLavado(tipoLavado.trim());
        servicio.setPrecio(precio);
        servicio.setFechaServicio(fechaServicio);
        servicio.setHora(hora.trim());
        servicio.setObservaciones(observaciones.trim());

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

    public ArrayList<Servicio> buscarServicios(String texto) {
        ArrayList<Servicio> encontrados = new ArrayList<>();

        if (texto == null || texto.trim().isEmpty()) {
            return listarServicios();
        }

        String busqueda = texto.trim().toLowerCase();

        for (Servicio servicio : RepositorioDatos.getServicios()) {
            String cliente = servicio.getCliente()
                    .getNombreCompleto().toLowerCase();

            String automovil = servicio.getAutomovil()
                    .toString().toLowerCase();

            String tipoLavado = servicio.getTipoLavado().toLowerCase();

            if (cliente.contains(busqueda)
                    || automovil.contains(busqueda)
                    || tipoLavado.contains(busqueda)) {

                encontrados.add(servicio);
            }
        }

        return encontrados;
    }
}