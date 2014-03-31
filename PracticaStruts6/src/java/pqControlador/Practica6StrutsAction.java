/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pqControlador;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import pqModelo.Practica6ActionForm;

/**
 *
 * @author alumno
 */
public class Practica6StrutsAction extends org.apache.struts.action.Action {
    private static Connection conexion;
    private static CallableStatement procedimiento;

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";

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
        
        try{
            DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());
            conexion = DriverManager.getConnection
                ("jdbc:oracle:thin:@localhost:1521:xe","system", "javaoracle");
            
            procedimiento = conexion.prepareCall("{call AltaUsuario(?,?,?,?,?,?)}");

            procedimiento.setString(1, ((Practica6ActionForm)form).getNombre());
            procedimiento.setString(2, ((Practica6ActionForm)form).getApellido());
            procedimiento.setString(3, ((Practica6ActionForm)form).getEmail());
            procedimiento.setString(4, ((Practica6ActionForm)form).getCodigoPostal());
            procedimiento.setString(5, ((Practica6ActionForm)form).getLogin());
            procedimiento.setString(6, ((Practica6ActionForm)form).getPassword1());
            
            procedimiento.executeUpdate();
        } catch (SQLException sqle){
            sqle.printStackTrace();
        } finally {
            conexion.close();
        }
        return mapping.findForward("correcto");
    }
}
