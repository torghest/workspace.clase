/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pqControlador;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import pqModelo.BorrarDoctorActionForm;

/**
 *
 * @author alumno
 */
public class BorrarDoctorAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";
    private static final String NO_EXISTE = "noExist";
    
    private Connection conexion;
    private PreparedStatement ps;
    
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
        String resultado = "";
        int res = -1;
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            conexion = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:XE","system","javaoracle"
            );
            ps = conexion.prepareStatement("DELETE FROM doctor WHERE doctor_no = ?");
            ps.setInt(1, Integer.valueOf(((BorrarDoctorActionForm)form).getDoctor_no()));
            res = ps.executeUpdate();
        
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            conexion.close();
        }
        switch (res){
            case 0:
                request.setAttribute("noExisteDoctorNo", NO_EXISTE);
                return mapping.findForward("inicio");
            case 1:
                request.setAttribute("resultado", SUCCESS);
                break;
            default:
                request.setAttribute("resultado", FAIL);
                break;
        }
        return mapping.findForward("resultado");
    }
}
