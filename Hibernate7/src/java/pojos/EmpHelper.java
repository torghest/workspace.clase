/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pojos;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author alumno
 */
public class EmpHelper {
    Session sesion;
    static final int numRegPag = 2;
    int paginas = 0;
    
    public EmpHelper()
    {
        this.sesion = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public int getPaginas(){
        return this.paginas;
    }
    
    public List getDatosEmpleados(int pagina)
    {
        List<Emp> listaempleados;
        this.sesion.beginTransaction();
        String consulta = "from Emp";
        Query query = this.sesion.createQuery(consulta);
        this.paginas = ((query.list().size()-1)/numRegPag)+1;
        query.setFirstResult((pagina-1)*numRegPag);
        query.setMaxResults(numRegPag);
        listaempleados = query.list();
        return listaempleados;
    }
}
