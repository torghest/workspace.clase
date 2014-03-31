/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pqModelo;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author alumno
 */
public class BorrarDoctorActionForm extends org.apache.struts.action.ActionForm {
    
    private String doctor_no;

    public String getDoctor_no() {
        return doctor_no;
    }

    public void setDoctor_no(String doctor_no) {
        this.doctor_no = doctor_no;
    }
    
    /**
     *
     */
    public BorrarDoctorActionForm() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     */
    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        if (getDoctor_no()== null || getDoctor_no().length() < 1) {
            errors.add("doctor_no", new ActionMessage("error.campo.requerido"));
        } else if (!getDoctor_no().matches("\\d{3}")){
            errors.add("doctor_no", new ActionMessage("error.campo.incorrecto"));
        }
        return errors;
    }
}
