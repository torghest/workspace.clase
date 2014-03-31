/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pqControladores;

import auxClasses.Pelicula;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.actions.DispatchAction;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.config.ModuleConfig;

/**
 *
 * @author alumno
 */
public class PeliculasAction
        extends DispatchAction
        implements org.apache.struts.action.PlugIn
{

    /* forward name="success" path="" */
    private final static String VerMas = "verMas";
    private final static String Comprar = "comprar";
    private Connection conexion;

    /**
     * This is the Struts action method called on
     * http://.../actionPath?method=verMas, where "method" is the value
     * specified in <action> element : ( <action parameter="method" .../> )
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return 
     * @throws java.lang.Exception 
     */
    public ActionForward verMas(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        return mapping.findForward(VerMas);
    }

    /**
     * This is the Struts action method called on
     * http://.../actionPath?method=myAction2, where "method" is the value
     * specified in <action> element : ( <action parameter="method" .../> )
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return 
     * @throws java.lang.Exception 
     */
    public ActionForward comprar(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        return mapping.findForward(Comprar);
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(ActionServlet servlet, ModuleConfig config) throws ServletException {
        Connection con = this.getConnection();
        try {
            ArrayList al = new ArrayList();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT ids, nombre, observaciones, tipopeli, precio, foto FROM peliculas");
            while (rs.next()){
                Pelicula p = new Pelicula(
                        rs.getInt("ids"),
                        rs.getString("nombre"),
                        rs.getString("tipopeli"),
                        rs.getString("observaciones"),
                        rs.getInt("precio"),
                        rs.getString("foto").toUpperCase()
                );
                al.add(p);
            }
            servlet.getServletContext().setAttribute("peliculas", al);
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(PeliculasAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private Connection getConnection(){
        if (this.conexion == null){
            try {
                DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
                this.conexion = DriverManager.getConnection(
                        "jdbc:oracle:thin:@localhost:1521:XE", "system", "javaoracle"
                );
            } catch (SQLException ex) {
                Logger.getLogger(PeliculasAction.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return this.conexion;
    }
    
}
