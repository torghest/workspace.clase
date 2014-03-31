/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pqControladores;

import java.util.Hashtable;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.config.ModuleConfig;

/**
 *
 * @author alumno
 */
public class MundialAction
    extends org.apache.struts.action.Action
    implements org.apache.struts.action.PlugIn {

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
        ActionForward respuesta = null;
        try // ejecutamos la funcion de negocio
        {
            // Obtenemos acceso al formulario
            DynaActionForm formulario = (DynaActionForm) form;
            // aqui va la inserción de los datos
            int pais = Integer.parseInt(formulario.get("pais").toString());
            if (pais == 1)
            {
                // redirigimos a la presentación
                respuesta = mapping.findForward("correcto");
            }else{
                //mantenemos la vista actual
                respuesta = mapping.getInputForward();
            }
            System.out.println("El pais es: " + formulario.get("pais"));
            System.out.println("Observaciones: " + formulario.get("observaciones"));
        }
        catch(Exception ex) // en caso de problemas retornar a la página origen
        {
             // recuperamos acceso al JSP de origen
            System.out.println("Excepcion "+ex);
            respuesta = mapping.getInputForward();
        }
        return respuesta; // redirigimos a la presentacion
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(ActionServlet servlet, ModuleConfig config) throws ServletException {
        Hashtable vPaises = new Hashtable();
        
        // aqui hay que poner el código que nos proporcione los datos de la base de datos
        vPaises.put("1","España");
        vPaises.put("2","Francia");
        vPaises.put("3","Brasil");
        vPaises.put("4","Holanda");
        vPaises.put("5","Argentina");
        
        // ponemos la tabla en el ambito de la aplicación
        servlet.getServletContext().setAttribute("tablapaises",vPaises);
    }
}
