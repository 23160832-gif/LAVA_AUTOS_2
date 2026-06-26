/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR;

import MODELO.Cliente;
import java.util.ArrayList;

/**
 *
 * @author OSCAR
 */
public class Controlador_Clientes {
       public static ArrayList<Cliente> listaClientes = new ArrayList<>();

    public static int generarIdCliente() {
        return listaClientes.size() + 1;
    }
}



