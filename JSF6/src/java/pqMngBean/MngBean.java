/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pqMngBean;

import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author alumno
 */
public class MngBean {
    private String txtEmail;
    private String txtPass;
    private String txtconfpass;
    private String txtNombre;
    private String txtApellidos;
    private String txtDireccion;
    private String txtCiudad;
    private int txtCp;
    private int txtTlf;

    public String getTxtEmail() {
        return txtEmail;
    }

    public void setTxtEmail(String txtEmail) {
        this.txtEmail = txtEmail;
    }

    public String getTxtPass() {
        return txtPass;
    }

    public void setTxtPass(String txtPass) {
        this.txtPass = txtPass;
    }

    public String getTxtconfpass() {
        return txtconfpass;
    }

    public void setTxtconfpass(String txtconfpass) {
        this.txtconfpass = txtconfpass;
    }

    public String getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(String txtNombre) {
        this.txtNombre = txtNombre;
    }

    public String getTxtApellidos() {
        return txtApellidos;
    }

    public void setTxtApellidos(String txtApellidos) {
        this.txtApellidos = txtApellidos;
    }

    public String getTxtDireccion() {
        return txtDireccion;
    }

    public void setTxtDireccion(String txtDireccion) {
        this.txtDireccion = txtDireccion;
    }

    public String getTxtCiudad() {
        return txtCiudad;
    }

    public void setTxtCiudad(String txtCiudad) {
        this.txtCiudad = txtCiudad;
    }

    public int getTxtCp() {
        return txtCp;
    }

    public void setTxtCp(int txtCp) {
        this.txtCp = txtCp;
    }

    public int getTxtTlf() {
        return txtTlf;
    }

    public void setTxtTlf(int txtTlf) {
        this.txtTlf = txtTlf;
    }
    
    public void validarPass(FacesContext contexto, UIComponent componente, Object obj) throws ValidatorException {
        String confPass = obj.toString();
        System.out.println(this.txtPass);
        System.out.println(this.txtconfpass);
            if (!confPass.equals(this.txtPass)){
                throw new ValidatorException(new FacesMessage("No coinciden las contraseñas"));
            }
    }
}
