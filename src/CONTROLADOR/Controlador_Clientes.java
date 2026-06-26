package CONTROLADOR;

import Datos.RepositorioDatos;
import MODELO.Cliente;
import java.util.ArrayList;
import java.util.Date;

public class Controlador_Clientes {

    public boolean guardarCliente(String nombre, String apellidoPaterno,
            String apellidoMaterno, String genero, String telefono,
            String correo, String ciudad, Date fechaRegistro) {

        if (nombre == null || nombre.trim().isEmpty()
                || apellidoPaterno == null || apellidoPaterno.trim().isEmpty()
                || telefono == null || telefono.trim().isEmpty()
                || fechaRegistro == null) {
            return false;
        }

        Cliente cliente = new Cliente(
                RepositorioDatos.siguienteIdCliente(),
                nombre.trim(),
                apellidoPaterno.trim(),
                apellidoMaterno.trim(),
                genero.trim(),
                telefono.trim(),
                correo.trim(),
                ciudad.trim(),
                fechaRegistro
        );

        RepositorioDatos.getClientes().add(cliente);
        return true;
    }

    public boolean actualizarCliente(int idCliente, String nombre,
            String apellidoPaterno, String apellidoMaterno, String genero,
            String telefono, String correo, String ciudad, Date fechaRegistro) {

        Cliente cliente = buscarPorId(idCliente);

        if (cliente == null || nombre == null || nombre.trim().isEmpty()
                || apellidoPaterno == null || apellidoPaterno.trim().isEmpty()
                || telefono == null || telefono.trim().isEmpty()
                || fechaRegistro == null) {
            return false;
        }

        cliente.setNombre(nombre.trim());
        cliente.setApellidoPaterno(apellidoPaterno.trim());
        cliente.setApellidoMaterno(apellidoMaterno.trim());
        cliente.setGenero(genero.trim());
        cliente.setTelefono(telefono.trim());
        cliente.setCorreo(correo.trim());
        cliente.setCiudad(ciudad.trim());
        cliente.setFechaRegistro(fechaRegistro);

        return true;
    }

    public boolean eliminarCliente(int idCliente) {
        Cliente cliente = buscarPorId(idCliente);

        if (cliente == null) {
            return false;
        }

        RepositorioDatos.getClientes().remove(cliente);
        return true;
    }

    public Cliente buscarPorId(int idCliente) {
        for (Cliente cliente : RepositorioDatos.getClientes()) {
            if (cliente.getIdCliente() == idCliente) {
                return cliente;
            }
        }

        return null;
    }

    public ArrayList<Cliente> listarClientes() {
        return new ArrayList<>(RepositorioDatos.getClientes());
    }

    public ArrayList<Cliente> buscarPorNombre(String texto) {
        ArrayList<Cliente> encontrados = new ArrayList<>();

        if (texto == null) {
            return encontrados;
        }

        String busqueda = texto.trim().toLowerCase();

        for (Cliente cliente : RepositorioDatos.getClientes()) {
            if (cliente.getNombreCompleto().toLowerCase().contains(busqueda)) {
                encontrados.add(cliente);
            }
        }

        return encontrados;
    }
}