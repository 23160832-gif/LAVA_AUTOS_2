package CONTROLADOR;

import Datos.RepositorioDatos;
import MODELO.Automovil;
import MODELO.Cliente;
import java.util.ArrayList;

public class ControladorAutomovil {

    public boolean guardarAutomovil(Cliente cliente, String tipo,
            String marca, String modelo, String color, String placas,
            int anio, String estado) {

        if (cliente == null
                || tipo == null || tipo.trim().isEmpty()
                || marca == null || marca.trim().isEmpty()
                || modelo == null || modelo.trim().isEmpty()
                || placas == null || placas.trim().isEmpty()
                || estado == null || estado.trim().isEmpty()
                || anio < 1900 || anio > 2100) {
            return false;
        }

        if (placasYaExisten(placas.trim(), 0)) {
            return false;
        }

        Automovil automovil = new Automovil(
                RepositorioDatos.siguienteIdAutomovil(),
                cliente,
                tipo.trim(),
                marca.trim(),
                modelo.trim(),
                color.trim(),
                placas.trim().toUpperCase(),
                anio,
                estado.trim()
        );

        RepositorioDatos.getAutomoviles().add(automovil);
        return true;
    }

    public boolean actualizarAutomovil(int idAutomovil, Cliente cliente,
            String tipo, String marca, String modelo, String color,
            String placas, int anio, String estado) {

        Automovil automovil = buscarPorId(idAutomovil);

        if (automovil == null
                || cliente == null
                || tipo == null || tipo.trim().isEmpty()
                || marca == null || marca.trim().isEmpty()
                || modelo == null || modelo.trim().isEmpty()
                || placas == null || placas.trim().isEmpty()
                || estado == null || estado.trim().isEmpty()
                || anio < 1900 || anio > 2100) {
            return false;
        }

        if (placasYaExisten(placas.trim(), idAutomovil)) {
            return false;
        }

        automovil.setCliente(cliente);
        automovil.setTipo(tipo.trim());
        automovil.setMarca(marca.trim());
        automovil.setModelo(modelo.trim());
        automovil.setColor(color.trim());
        automovil.setPlacas(placas.trim().toUpperCase());
        automovil.setAnio(anio);
        automovil.setEstado(estado.trim());

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
            if (automovil.getCliente().getIdCliente()
                    == cliente.getIdCliente()) {
                encontrados.add(automovil);
            }
        }

        return encontrados;
    }

    private boolean placasYaExisten(String placas, int idExcluir) {
        for (Automovil automovil : RepositorioDatos.getAutomoviles()) {
            if (automovil.getPlacas().equalsIgnoreCase(placas)
                    && automovil.getIdAutomovil() != idExcluir) {
                return true;
            }
        }

        return false;
    }
}