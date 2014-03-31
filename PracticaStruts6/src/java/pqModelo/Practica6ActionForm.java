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
public class Practica6ActionForm extends org.apache.struts.action.ActionForm {
    
    private String nombre;
    private String apellido;
    private String email;
    private String codigoPostal;
    private String login;
    private String password1;
    private String password2;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }
    
    /**
     *
     */
    public Practica6ActionForm() {
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
        if (getNombre()== null || getNombre().length() < 1) {
            errors.add("nombre", new ActionMessage("error.nombre.requerido"));
            // TODO: add 'error.name.required' key to your resources
        }
        if (getApellido()== null || getApellido().length() < 1) {
            errors.add("apellido", new ActionMessage("error.apellido.requerido"));
            // TODO: add 'error.name.required' key to your resources
        }
        if (getEmail() == null || getEmail().length() < 1) {
            errors.add("email", new ActionMessage("error.email.requerido"));
        } else if (!email.matches(".+@.+\\.[a-z]+")) {
            errors.add("email", new ActionMessage("error.email.incorrecto"));
        }
        
        if (getCodigoPostal() == null || getCodigoPostal().length() < 1) {
            errors.add("codigoPostal", new ActionMessage("error.codigoPostal.requerido"));
        } else if (!codigoPostal.matches("\\d{5}")) {
            errors.add("codigoPostal", new ActionMessage("error.codigoPostal.incorrecto"));
        }

        if (getLogin() == null || getLogin().length() < 1) {
            errors.add("login", new ActionMessage("error.login.requerido"));
        }

        if (getPassword1() == null || getPassword1().length() < 1) {
            errors.add("password1", new ActionMessage("error.password.requerido"));
        } else if (getPassword1().trim().length() < 8) {
            errors.add("password1", new ActionMessage("error.password.incorrecto"));
        }

        if (getPassword2() == null || getPassword2().length() < 1) {
            errors.add("password2", new ActionMessage("error.confirmarPassword.requerido"));
        } else if (!getPassword1().equals(getPassword2())) {
            errors.add("password2", new ActionMessage("error.confirmarPassword.incorrecto"));
        } 

        return errors;
    }
}
