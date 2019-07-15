/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entidades.Vacuna;
import java.util.ArrayList;

/**
 *
 * @author BETHZY
 */
public interface IVacuna {
 
    public abstract boolean guardarCliente(Vacuna vacuna);

    public abstract ArrayList<Vacuna> listarCliente();

    public abstract boolean actualizarCliente(Vacuna vacuna);

    public abstract boolean eliminarCliente(Vacuna vacuna);   
}
