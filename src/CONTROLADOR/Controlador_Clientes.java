/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR;

import Datos.RepositorioDatos;
import MODELO.Cliente;
import java.util.ArrayList;

public class Controlador_Clientes {

    public boolean guardarCliente(String nombre, String telefono,
            String correo, String direccion) {

        if (nombre == null || nombre.trim().isEmpty()) {
            return false;
        }

        Cliente cliente = new Cliente(
                RepositorioDatos.siguienteIdCliente(),
                nombre.trim(),
                telefono.trim(),
                correo.trim(),
                direccion.trim()
        );

        RepositorioDatos.getClientes().add(cliente);
        return true;
    }

    public boolean actualizarCliente(int idCliente, String nombre,
            String telefono, String correo, String direccion) {

        Cliente cliente = buscarPorId(idCliente);

        if (cliente == null || nombre == null || nombre.trim().isEmpty()) {
            return false;
        }

        cliente.setNombre(nombre.trim());
        cliente.setTelefono(telefono.trim());
        cliente.setCorreo(correo.trim());
        cliente.setDireccion(direccion.trim());

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

        for (Cliente cliente : RepositorioDatos.getClientes()) {
            if (cliente.getNombre().toLowerCase()
                    .contains(texto.toLowerCase())) {
                encontrados.add(cliente);
            }
        }

        return encontrados;
    }
}