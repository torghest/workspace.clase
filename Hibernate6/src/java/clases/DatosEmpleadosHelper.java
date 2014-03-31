/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clases;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author alumno
 */
public class DatosEmpleadosHelper {
    Session sesion;
    
    public DatosEmpleadosHelper()
    {
        this.sesion = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public List getDatosEmpleados()
    {
        List<Datosempleados> listaempleados;
        this.sesion.beginTransaction();
        String consulta = "from Datosempleados as d";
        Query query = this.sesion.createQuery(consulta);
        listaempleados = query.list();
        return listaempleados;
    }

}
