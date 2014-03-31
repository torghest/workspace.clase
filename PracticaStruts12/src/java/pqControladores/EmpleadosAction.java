/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pqControladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.config.ModuleConfig;

/**
 *
 * @author alumno
 */
public class EmpleadosAction
    extends org.apache.struts.action.Action
    implements org.apache.struts.action.PlugIn {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private Connection conexion = null;

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DynaActionForm daf = (DynaActionForm) form;
        String oficio = daf.getString("oficio");
        Connection con = this.getConexion();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM emp WHERE oficio = ?");
            ps.setString(1, oficio);
            ResultSet rs = ps.executeQuery();
            String tabla = "<table border=\"1\" bgcolor=\"#FFFFFF\"><tr>";
            ResultSetMetaData rsmd = rs.getMetaData();
            for (int i = 1; i <= rsmd.getColumnCount(); i++){
                tabla = tabla + "<td bgcolor=\"#333399\" style=\"color: #DDDDFF\">" + rsmd.getColumnName(i) + "</td>";
            }
            tabla = tabla + "</tr>";
            while (rs.next()){
                tabla = tabla + "<tr>";
                for (int i = 1; i <= rsmd.getColumnCount(); i++){
                    tabla = tabla + "<td bgcolor=\"#DDEEFF\">" + ((rs.getString(i) == null)?"0":rs.getString(i)) + "</td>";
                }
                tabla = tabla + "</tr>";
            }
            tabla = tabla + "</table>";
            request.setAttribute("datos", tabla);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return mapping.findForward(SUCCESS);
    }

    @Override
    public void destroy() {
        if (this.conexion != null){
            try {
                this.conexion.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void init(ActionServlet servlet, ModuleConfig config) throws ServletException {
        Connection con = this.getConexion();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT DISTINCT oficio FROM emp ORDER BY oficio");
            HashMap lista = new HashMap();
            while (rs.next()){
                lista.put(rs.getString("oficio"),rs.getString("oficio"));
            }
            servlet.getServletContext().setAttribute("oficios", lista);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private Connection getConexion(){
        if (this.conexion == null){
            try {
                DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
                this.conexion = DriverManager.getConnection(
                        "jdbc:oracle:thin:@localhost:1521:XE","system","javaoracle"
                );
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return this.conexion;
    }
}
