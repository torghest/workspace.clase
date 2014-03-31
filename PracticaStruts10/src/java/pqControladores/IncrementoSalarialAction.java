/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pqControladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
public class IncrementoSalarialAction extends org.apache.struts.action.Action {

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
        int res = 0;
        DynaActionForm dynaForm = (DynaActionForm)form;
        Connection conexion = null;
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            conexion = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:XE","system","javaoracle"
            );
            PreparedStatement ps = conexion.prepareStatement(
                    "UPDATE emp SET salario = salario + ? WHERE apellido = ?"
            );
            ps.setInt(1, (Integer)dynaForm.get("incremento"));
            ps.setString(2, (String)dynaForm.getString("apellido"));
            res = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conexion != null){
                conexion.close();
            }
        }
        request.setAttribute("apellido", (String)dynaForm.get("apellido"));
        if (res == 1){
            request.setAttribute("resultado", "correcto");
            request.setAttribute("dato", (Integer)dynaForm.get("incremento"));
        } else {
            request.setAttribute("resultado", "incorrecto");
        }
        return mapping.findForward(SUCCESS);
    }
}
