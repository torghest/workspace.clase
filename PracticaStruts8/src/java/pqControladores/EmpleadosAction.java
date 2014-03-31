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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

/**
 *
 * @author alumno
 */
public class EmpleadosAction extends org.apache.struts.action.Action {

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
        DynaActionForm formulario = (DynaActionForm)form;
        int emp = Integer.parseInt(formulario.get("empno").toString());
        
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","javaoracle");
        PreparedStatement pst = cn.prepareStatement("SELECT APELLIDO FROM EMP WHERE EMP_NO=?");
        pst.setInt(1, emp);
        ResultSet rs = pst.executeQuery();
        String dato;
        if (rs.next()== true)
        {
            dato ="El empleado encontrado es " + rs.getString("APELLIDO"); 
            rs.close();
        }else
        {
            dato = "Empleado no encontrado";
        }
        request.setAttribute("empleado", dato);    
        return mapping.findForward("DatosEmpleado"); 
    }
}
