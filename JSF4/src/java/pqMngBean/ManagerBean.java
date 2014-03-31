/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pqMngBean;

import java.util.Map;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;

/**
 *
 * @author alumno
 */
public class ManagerBean {
    private HtmlInputText txtNumero = new HtmlInputText();
    private HtmlOutputLabel lblResultado = new HtmlOutputLabel();

    public HtmlInputText getTxtNumero() {
        return txtNumero;
    }

    public void setTxtNumero(HtmlInputText txtNumero) {
        this.txtNumero = txtNumero;
    }

    public HtmlOutputLabel getLblResultado() {
        return lblResultado;
    }

    public void setLblResultado(HtmlOutputLabel lblResultado) {
        this.lblResultado = lblResultado;
    }
    
    public String btnEnviar_Click(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Map parametros = facesContext.getExternalContext().getRequestParameterMap();
        String accion = (String)parametros.get("accion");
        int numero = Integer.parseInt(this.txtNumero.getValue().toString());
        String resultado = "<table border='1'>";
        resultado += "<tr><th>Resultado</th></tr>";
        if (accion.equalsIgnoreCase("tabla"))
        {
            resultado += "<tr><td>Tabla Multiplicar</td></tr>";
            for (int i = 1; i <= 10;i++)
            {
                resultado += "<tr>";
                resultado += "<td>" + i + "*" + numero + "=<b>" + (numero * i) + "</b></td>";
                resultado += "</tr>";
            }
        }else if (accion.equalsIgnoreCase("collatz"))
        {
            resultado += "<tr><td>Collatz</td></tr>";
            while (numero != 1)
            {
                resultado += "<tr>";
                if (numero%2==0)
                {
                    numero = numero / 2;
                }else
                {
                    numero = (numero * 3) + 1;
                }
                resultado += "<th>" + numero + "</th>";
                resultado += "</tr>";
            }
        }
        resultado += "</table>";
        this.lblResultado.setValue(resultado);
        //Esta acción hace que podamos generar
        //código HTML desde el servidor
        //en JSF
        this.lblResultado.setEscape(false);
        return null;
    }
}
