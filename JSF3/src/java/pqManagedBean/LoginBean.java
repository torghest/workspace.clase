/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pqManagedBean;

import javax.faces.component.html.HtmlInputSecret;
import javax.faces.component.html.HtmlInputText;

/**
 *
 * @author alumno
 */
public class LoginBean {
    private HtmlInputText txtUsuario;
    private HtmlInputSecret txtPassword;

    public HtmlInputText getTxtUsuario() {
        return txtUsuario;
    }

    public void setTxtUsuario(HtmlInputText txtUsuario) {
        this.txtUsuario = txtUsuario;
    }

    public HtmlInputSecret getTxtPassword() {
        return txtPassword;
    }

    public void setTxtPassword(HtmlInputSecret txtPassword) {
        this.txtPassword = txtPassword;
    }

    public String btnValidarUsuario_Click(){
        String usuario = this.txtUsuario.getValue().toString();
        String password = this.txtPassword.getValue().toString();
        
        if (usuario.equalsIgnoreCase("programador") 
                && password.equalsIgnoreCase("java"))
        {
            return "correcto";
        }else
        {
            return "incorrecto";
        }

    }
}
