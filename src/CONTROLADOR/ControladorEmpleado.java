/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR;


import Datos.RepositorioDatos;
import MODELO.Empleado;
import MODELO.Rol;
import java.util.ArrayList;

public class ControladorEmpleado {

    public boolean guardarEmpleado(String nombre, String telefono, Rol rol) {

        if (nombre == null || nombre.trim().isEmpty() || rol == null) {
            return false;
        }

        Empleado empleado = new Empleado(
                RepositorioDatos.siguienteIdEmpleado(),
                nombre.trim(),
                telefono.trim(),
                rol
        );

        RepositorioDatos.getEmpleados().add(empleado);
        return true;
    }

    public Empleado buscarPorId(int idEmpleado) {
        for (Empleado empleado : RepositorioDatos.getEmpleados()) {
            if (empleado.getIdEmpleado() == idEmpleado) {
                return empleado;
            }
        }

        return null;
    }

    public ArrayList<Empleado> listarEmpleados() {
        return new ArrayList<>(RepositorioDatos.getEmpleados());
    }
}
