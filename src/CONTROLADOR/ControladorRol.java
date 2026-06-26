/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR;

import Datos.RepositorioDatos;
import MODELO.Rol;
import java.util.ArrayList;

public class ControladorRol {

    public boolean guardarRol(String nombreRol) {

        if (nombreRol == null || nombreRol.trim().isEmpty()) {
            return false;
        }

        Rol rol = new Rol(
                RepositorioDatos.siguienteIdRol(),
                nombreRol.trim()
        );

        RepositorioDatos.getRoles().add(rol);
        return true;
    }

    public Rol buscarPorId(int idRol) {
        for (Rol rol : RepositorioDatos.getRoles()) {
            if (rol.getIdRol() == idRol) {
                return rol;
            }
        }

        return null;
    }

    public ArrayList<Rol> listarRoles() {
        return new ArrayList<>(RepositorioDatos.getRoles());
    }
}