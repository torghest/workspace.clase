/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clases;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author alumno
 */
public class EmpleadosHelper {

    Session session = null;
    Transaction tx = null;

    public EmpleadosHelper(){
       this.iniciarConexion();
    }
    
    private void iniciarConexion()
    {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        this.tx = session.beginTransaction();
    } 

    public void incrementarSalarioEmpleado(int empleado, int incremento)
    {
        this.tx = this.session.beginTransaction();
        Query query = session.createSQLQuery("CALL AUMENTARSALARIOEMP(?,?)");
        query.setParameter(0, empleado);
        query.setParameter(1, incremento);
        query.executeUpdate();
        tx.commit();
    }
    
    public List getEmpleados() 
    {
        List<Emp> listaemp = null;
        try 
        {
            if (!this.session.isOpen())
            {
                this.iniciarConexion();
            }
            Query q = session.createQuery("from Emp as emp");
            listaemp = (List<Emp>) q.list();
        } catch (Exception ex) 
        {
            System.out.println("Excepcion " + ex);
        }
        return listaemp;
    }    

}
