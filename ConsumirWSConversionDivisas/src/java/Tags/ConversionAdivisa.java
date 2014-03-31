/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Tags;

import java.text.DecimalFormat;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author alumno
 */
public class ConversionAdivisa extends TagSupport{

    private int indice;
    private double valor;
    
    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    @Override
    public int doEndTag() throws JspException {
        JspWriter jw = pageContext.getOut();
        DecimalFormat df = new DecimalFormat("#.####");
        try{
            WebServiceClients.WSConversionDivisas_Service service = new WebServiceClients.WSConversionDivisas_Service();
            WebServiceClients.WSConversionDivisas port = service.getWSConversionDivisasPort();
            jw.write(df.format(port.convertirAdivisa(this.valor, this.indice)));
        } catch (Exception e) {
            throw new JspTagException("Excepcion: "+e.toString());
        }
        return super.doEndTag(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int doStartTag() throws JspException {
        return super.doStartTag(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
