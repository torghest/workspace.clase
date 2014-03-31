/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pqControladores;

import core.equipo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.config.ModuleConfig;

/**
 *
 * @author alumno
 */
public class Controlador extends DispatchAction implements PlugIn {

    /* forward name="success" path="" */
    private static final String PLANTILLA = "plantilla";
    private static final String JUGADOR = "jugador";
    
    private Connection conexion;

    public ActionForward plantilla(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        Connection con = this.getConexion();
        PreparedStatement ps = con.prepareStatement(
                "SELECT " +
                    "eq.nombre nombre_eq, " +
                    "eq.foto_equipo, " +
                    "eq.foto_escudo, " +
                    "es.nombre nombre_est, " +
                    "es.direccion, " +
                    "es.construccion, " +
                    "es.aforo, " +
                    "es.foto_estadio " +
                "FROM " +
                    "equipos eq " +
                    "join " +
                    "estadios es " +
                        "on eq.equipo_cod = es.equipo_cod " +
                "WHERE " +
                    "eq.equipo_cod = ? "
        );
        ps.setInt(1, Integer.valueOf(request.getParameter("equipo_cod")));
        ResultSet rs = ps.executeQuery();
        if (rs.next()){
            equipo e = new equipo(
                    rs.getString("nombre"),
                    rs.getString("foto_escdo"),
                    rs.getString("nombre_est"),
                    rs.getString("foto_estadio"),
                    rs.getString("direccion"),
                    rs.getString("construccion"),
                    rs.getString("aforo"),
                    rs.getString("foto_equipo")
            );
            request.setAttribute("datosEquipo", e);
        }
                            
        return mapping.findForward(PLANTILLA);
    }
    
    public ActionForward jugador(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        return mapping.findForward(JUGADOR);
    }

    @Override
    public void destroy() {
        
    }

    @Override
    public void init(ActionServlet servlet, ModuleConfig config) throws ServletException {
        Connection con = this.getConexion();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "SELECT " +
                        "equipo_cod, " +
                        "nombre, " +
                        "fundacion, " +
                        "presidente, " +
                        "foto_escudo " +
                    "FROM " +
                        "equipos " +
                    "ORDER BY " +
                        "nombre"
            );
            ArrayList al = new ArrayList();
            while (rs.next()){
                equipo eq = new equipo(
                    rs.getInt("equipo_cod"),
                    rs.getString("nombre"),
                    rs.getString("fundacion"),
                    rs.getString("presidente"),
                    rs.getString("foto_escudo")
                );
                System.out.println("Añadido: "+eq);
                al.add(eq);
            }
            servlet.getServletContext().setAttribute("equipos", al);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private Connection getConexion(){
        if (this.conexion == null){
            try {
                DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
                this.conexion = DriverManager.getConnection(
                        "jdbc:oracle:thin:@localhost:1521:xe","system","javaoracle"
                );
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return this.conexion;
    }
}
