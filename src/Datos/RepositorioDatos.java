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
import MODELO.Empleado;
import MODELO.Lavado;
import MODELO.Rol;
import MODELO.Servicio;
import MODELO.Ticket;
import java.util.ArrayList;

public class RepositorioDatos {

    private static final ArrayList<Cliente> clientes = new ArrayList<>();
    private static final ArrayList<Automovil> automoviles = new ArrayList<>();
    private static final ArrayList<Servicio> servicios = new ArrayList<>();
    private static final ArrayList<Rol> roles = new ArrayList<>();
    private static final ArrayList<Empleado> empleados = new ArrayList<>();
    private static final ArrayList<Lavado> lavados = new ArrayList<>();
    private static final ArrayList<Ticket> tickets = new ArrayList<>();

    private static int ultimoIdCliente = 0;
    private static int ultimoIdAutomovil = 0;
    private static int ultimoIdServicio = 0;
    private static int ultimoIdRol = 0;
    private static int ultimoIdEmpleado = 0;
    private static int ultimoIdLavado = 0;
    private static int ultimoIdTicket = 0;

    public static ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public static ArrayList<Automovil> getAutomoviles() {
        return automoviles;
    }

    public static ArrayList<Servicio> getServicios() {
        return servicios;
    }

    public static ArrayList<Rol> getRoles() {
        return roles;
    }

    public static ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public static ArrayList<Lavado> getLavados() {
        return lavados;
    }

    public static ArrayList<Ticket> getTickets() {
        return tickets;
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

    public static int siguienteIdRol() {
        ultimoIdRol++;
        return ultimoIdRol;
    }

    public static int siguienteIdEmpleado() {
        ultimoIdEmpleado++;
        return ultimoIdEmpleado;
    }

    public static int siguienteIdLavado() {
        ultimoIdLavado++;
        return ultimoIdLavado;
    }

    public static int siguienteIdTicket() {
        ultimoIdTicket++;
        return ultimoIdTicket;
    }
}