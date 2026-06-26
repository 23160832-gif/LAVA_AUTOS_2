/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR;


import Datos.RepositorioDatos;
import MODELO.Automovil;
import MODELO.Cliente;
import MODELO.Empleado;
import MODELO.Lavado;
import MODELO.Servicio;
import java.util.ArrayList;

public class ControladorLavado {

    public Lavado guardarLavado(Cliente cliente, Automovil automovil,
            Empleado empleado, String fecha, String horaEntrada) {

        if (cliente == null || automovil == null || empleado == null
                || fecha == null || fecha.trim().isEmpty()
                || horaEntrada == null || horaEntrada.trim().isEmpty()) {
            return null;
        }

        if (automovil.getCliente().getIdCliente() != cliente.getIdCliente()) {
            return null;
        }

        Lavado lavado = new Lavado(
                RepositorioDatos.siguienteIdLavado(),
                cliente,
                automovil,
                empleado,
                fecha.trim(),
                horaEntrada.trim(),
                "En proceso"
        );

        RepositorioDatos.getLavados().add(lavado);
        return lavado;
    }

    public boolean agregarServicio(int idLavado, Servicio servicio, int cantidad) {
        Lavado lavado = buscarPorId(idLavado);

        if (lavado == null || servicio == null || cantidad <= 0) {
            return false;
        }

        if (lavado.getEstado().equalsIgnoreCase("Entregado")) {
            return false;
        }

        lavado.agregarServicio(servicio, cantidad);
        return true;
    }

    public boolean cambiarEstado(int idLavado, String estado) {
        Lavado lavado = buscarPorId(idLavado);

        if (lavado == null || !estadoValido(estado)) {
            return false;
        }

        lavado.setEstado(estado.trim());
        return true;
    }

    public Lavado buscarPorId(int idLavado) {
        for (Lavado lavado : RepositorioDatos.getLavados()) {
            if (lavado.getIdLavado() == idLavado) {
                return lavado;
            }
        }

        return null;
    }

    public ArrayList<Lavado> listarLavados() {
        return new ArrayList<>(RepositorioDatos.getLavados());
    }

    public ArrayList<Lavado> listarPorEstado(String estado) {
        ArrayList<Lavado> encontrados = new ArrayList<>();

        for (Lavado lavado : RepositorioDatos.getLavados()) {
            if (lavado.getEstado().equalsIgnoreCase(estado)) {
                encontrados.add(lavado);
            }
        }

        return encontrados;
    }

    private boolean estadoValido(String estado) {
        if (estado == null) {
            return false;
        }

        return estado.equalsIgnoreCase("En proceso")
                || estado.equalsIgnoreCase("Terminado")
                || estado.equalsIgnoreCase("Entregado")
                || estado.equalsIgnoreCase("Cancelado");
    }
}
