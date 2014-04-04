/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Util;

/**
 *
 * @author Administrador
 */
public class Navegacion {
    private String form;
    private String[] var;
    private String[] val;

    public Navegacion(String form, String[] var) {
        this.form = form;
        this.var = var;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String[] getVar() {
        return var;
    }

    public void setVar(String[] var) {
        this.var = var;
    }

    public String[] getVal() {
        return val;
    }

    public void setVal(String[] val) {
        this.val = val;
    }
    
    public String form(){
        String aux = "<form name=\"" + this.form + "\" action=\"\" method=\"get\">";
        for (int i = 0; i < var.length; i++){
            aux += "<input type=\"hidden\" name=\"" + this.var[i] + "\"" + (this.val!=null?" value=\"" + this.val[i] + "\"":"") + "/>";
        }
        aux += "</form>";
        return aux;
    }
    
    public String onClick(){
        String varVal = "";
        for(int i = 0; i < var.length; i++){
            varVal += this.form + "." + this.var[i] + ".value=" + this.val[i] + ";";
        }
        String aux = " onclick=\"javascript:" + varVal + this.form + ".submit();\"";
        return aux;
    }
    
}
