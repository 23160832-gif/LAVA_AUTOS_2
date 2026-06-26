/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

/**
 *
 * @author OSCAR
 */
import MODELO.Automovil;
import MODELO.Cliente;
import MODELO.Servicio;

import java.util.ArrayList;

public class RepositorioDatos {

    private static final ArrayList<Cliente> clientes = new ArrayList<>();
    private static final ArrayList<Automovil> automoviles = new ArrayList<>();
    private static final ArrayList<Servicio> servicios = new ArrayList<>();
 

    private static int ultimoIdCliente = 0;
    private static int ultimoIdAutomovil = 0;
    private static int ultimoIdServicio = 0;


    public static ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public static ArrayList<Automovil> getAutomoviles() {
        return automoviles;
    }

    public static ArrayList<Servicio> getServicios() {
        return servicios;
    }


    public static int siguienteIdCliente() {
        ultimoIdCliente++;
        return ultimoIdCliente;
    }

    public static int siguienteIdAutomovil() {
        ultimoIdAutomovil++;
        return ultimoIdAutomovil;
    }

    public static int siguienteIdServicio() {
        ultimoIdServicio++;
        return ultimoIdServicio;
    }

   
}