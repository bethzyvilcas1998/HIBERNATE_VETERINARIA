/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import dao.ClienteDao;
import dao.MascotaDao;
import dao.MascotaporClienteDao;
import entidades.Mascotaporcliente;
import entidades.MascotaporclienteId;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author BETHZY
 */
@ManagedBean
//@RequestScoped
@ViewScoped
public class MascotaporClienteBean implements Serializable {

    private ArrayList listaClientes;
    private ArrayList listaMascotas;
    private int idCliente;
    private int idMascota;
    private Mascotaporcliente mascotaporcliente;

    private MascotaporClienteDao mascotaporClienteDao;
    MascotaporclienteId mascotaporclienteid;

    public MascotaporClienteBean() {
        listaClientes = new ArrayList();
        mascotaporcliente = new Mascotaporcliente();
        mascotaporclienteid = new MascotaporclienteId();
        combos();
    }

    public void combos() {
        ClienteDao clienteDao = new ClienteDao();
        MascotaDao mascotaDao = new MascotaDao();
        listaClientes = clienteDao.listarCliente();
        listaMascotas = mascotaDao.listarMascotas();
    }

    public String guardar() {
        MascotaporClienteDao dao = new MascotaporClienteDao();
        mascotaporclienteid.setCodigoCliente(idCliente);
        mascotaporclienteid.setIdMascota(idMascota);
        mascotaporcliente.setId(mascotaporclienteid);
        dao.guardarMascotaporcliente(mascotaporcliente);
        return "/GuardarMascotaporCliente";

    }

    public MascotaporClienteDao getMascotaporClienteDao() {
        return mascotaporClienteDao;
    }

    public void setMascotaporClienteDao(MascotaporClienteDao mascotaporClienteDao) {
        this.mascotaporClienteDao = mascotaporClienteDao;
    }

    public ArrayList getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList listaClientes) {
        this.listaClientes = listaClientes;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public ArrayList getListaMascotas() {
        return listaMascotas;
    }

    public void setListaMascotas(ArrayList listaMascotas) {
        this.listaMascotas = listaMascotas;
    }

    public Mascotaporcliente getMascotaporcliente() {
        return mascotaporcliente;
    }

    public void setMascotaporcliente(Mascotaporcliente mascotaporcliente) {
        this.mascotaporcliente = mascotaporcliente;
    }

}
