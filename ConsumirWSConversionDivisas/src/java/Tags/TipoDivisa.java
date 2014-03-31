/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author alumno
 */
public class TipoDivisa extends TagSupport{

    private int indice;

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }
    
    @Override
    public int doEndTag() throws JspException {
        JspWriter jw = pageContext.getOut();
        try{
            switch (this.indice){
                case 0:
                    jw.write("Dolares");
                    break;
                case 1:
                    jw.write("Pesos");
                    break;
                case 2:
                    jw.write("Rupias");
                    break;
                case 3:
                    jw.write("Yenes");
                    break;
                case 4:
                    jw.write("Pesetas");
                    break;
            }
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
