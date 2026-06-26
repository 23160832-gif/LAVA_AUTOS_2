/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR;

import Datos.RepositorioDatos;
import MODELO.Automovil;
import MODELO.Cliente;
import java.util.ArrayList;

public class ControladorAutomovil {

    public boolean guardarAutomovil(Cliente cliente, String placa,
            String marca, String modelo, String color, String tipo) {

        if (cliente == null || placa == null || placa.trim().isEmpty()
                || marca == null || marca.trim().isEmpty()) {
            return false;
        }

        if (placaYaExiste(placa.trim(), 0)) {
            return false;
        }

        Automovil automovil = new Automovil(
                RepositorioDatos.siguienteIdAutomovil(),
                cliente,
                placa.trim().toUpperCase(),
                marca.trim(),
                modelo.trim(),
                color.trim(),
                tipo.trim()
        );

        RepositorioDatos.getAutomoviles().add(automovil);
        return true;
    }

    public boolean actualizarAutomovil(int idAutomovil, Cliente cliente,
            String placa, String marca, String modelo, String color, String tipo) {

        Automovil automovil = buscarPorId(idAutomovil);

        if (automovil == null || cliente == null
                || placa == null || placa.trim().isEmpty()) {
            return false;
        }

        if (placaYaExiste(placa.trim(), idAutomovil)) {
            return false;
        }

        automovil.setCliente(cliente);
        automovil.setPlaca(placa.trim().toUpperCase());
        automovil.setMarca(marca.trim());
        automovil.setModelo(modelo.trim());
        automovil.setColor(color.trim());
        automovil.setTipo(tipo.trim());

        return true;
    }

    public boolean eliminarAutomovil(int idAutomovil) {
        Automovil automovil = buscarPorId(idAutomovil);

        if (automovil == null) {
            return false;
        }

        RepositorioDatos.getAutomoviles().remove(automovil);
        return true;
    }

    public Automovil buscarPorId(int idAutomovil) {
        for (Automovil automovil : RepositorioDatos.getAutomoviles()) {
            if (automovil.getIdAutomovil() == idAutomovil) {
                return automovil;
            }
        }

        return null;
    }

    public ArrayList<Automovil> listarAutomoviles() {
        return new ArrayList<>(RepositorioDatos.getAutomoviles());
    }

    public ArrayList<Automovil> listarPorCliente(Cliente cliente) {
        ArrayList<Automovil> encontrados = new ArrayList<>();

        if (cliente == null) {
            return encontrados;
        }

        for (Automovil automovil : RepositorioDatos.getAutomoviles()) {
            if (automovil.getCliente().getIdCliente() == cliente.getIdCliente()) {
                encontrados.add(automovil);
            }
        }

        return encontrados;
    }

    private boolean placaYaExiste(String placa, int idExcluir) {
        for (Automovil automovil : RepositorioDatos.getAutomoviles()) {
            if (automovil.getPlaca().equalsIgnoreCase(placa)
                    && automovil.getIdAutomovil() != idExcluir) {
                return true;
            }
        }

        return false;
    }
}