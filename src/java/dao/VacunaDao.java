/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Vacuna;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilitarios.HibernateUtil;

/**
 *
 * @author BETHZY
 */
public class VacunaDao {

    public boolean guardarVacuna(Vacuna vacuna) {
               Session session = null;
        boolean respuesta = true;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaccion = session.beginTransaction(); //inicia
            session.save(vacuna);
            transaccion.commit();
        } catch (Exception e) {
            System.out.println("Error al guardar. " + e);
            respuesta = false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return respuesta;
    }

    public boolean actualizarVacuna(Vacuna vacuna) {
        
        boolean resp = true;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaccion = session.beginTransaction();
            session.update(vacuna);
            transaccion.commit();
        } catch (Exception e) {
            resp = false;
            System.out.println("ERROR EN ACTU::" + e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return resp;
    
    }

    public ArrayList<Vacuna> listarVacuna() {
               Session session = null;
        ArrayList<Vacuna> lista = new ArrayList<>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            String hql = "FROM Vacuna";
            Query query = session.createQuery(hql);
            lista = (ArrayList<Vacuna>) query.list();
        } catch (Exception e) {
            System.out.println("ERROR EN LISTAR::" + e);
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return lista;
    
    }

    public boolean eliminarVacuna(Vacuna vacuna) {
        Session sesion = null;
        boolean resp = true;
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.delete(vacuna);
            sesion.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("ERROR DAO::" + e);
            resp = false;
            sesion.getTransaction().rollback();
        } finally {
            if (sesion != null) {
                sesion.close();
            }
        }

        return resp;
        }
    
}
