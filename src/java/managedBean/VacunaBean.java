/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;
import dao.VacunaDao;
import entidades.Vacuna;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.hibernate.HibernateException;

/**
 *
 * @author BETHZY
 */
@ManagedBean
//@RequestScoped
@ViewScoped
public class VacunaBean implements Serializable{
    private Vacuna vacuna;
      private boolean banderaSelect=false;

        public VacunaBean() {
        this.vacuna = new Vacuna();
    }
    public Vacuna getVacuna() {
        return vacuna;
    }

    public void setVacuna(Vacuna vacuna) {
        this.vacuna = vacuna;
    }
        public String guardarVacuna() {
        try {

            VacunaDao vacunaDao = new VacunaDao();
            boolean respuesta = vacunaDao.guardarVacuna(vacuna);
            if (respuesta) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se registro correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo registrar"));
            }
        } catch (HibernateException e) {
            ///transation.rollback();  -- regresa a la anterior
            System.out.println("Error::: " + e);
        }
        return "/RVacuna";
    }
    public String actualizarVacuna() {
        try {
           VacunaDao vacunaDao = new VacunaDao();
            boolean respuesta = vacunaDao.actualizarVacuna(vacuna);
            if (respuesta) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se actualizo correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo actualizar"));
            }
        } catch (HibernateException e) {
            ///transation.rollback();  -- regresa a la anterior
            System.out.println("Error::: " + e);
        }
        return "/RVacuna";

    }

    public ArrayList<Vacuna> listarVacuna() {
        ArrayList<Vacuna> lista = new ArrayList<>();
        VacunaDao vacunaDao = new VacunaDao();
        lista = vacunaDao.listarVacuna();
        return lista;
    }

    public String eliminar() {
        VacunaDao vacunaDao = new VacunaDao();
        boolean respuesta = vacunaDao.eliminarVacuna(vacuna);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se elimino correctamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo eliminar"));
        }
        return "/RVacuna";
    }
 public String limpiar() {
        return "/RVacuna";
    }
    public void selectBandera(){
        banderaSelect=true;
    }

    public boolean isBanderaSelect() {
        return banderaSelect;
    }

    public void setBanderaSelect(boolean banderaSelect) {
        this.banderaSelect = banderaSelect;
    }
    
}


 