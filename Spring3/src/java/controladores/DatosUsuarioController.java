/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controladores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Usuario;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author alumno
 */
public class DatosUsuarioController implements Controller{

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        String nombreUsu = hsr.getParameter("txtNombre");
        String apellidosUsu = hsr.getParameter("txtApellidos");
        String edadUsu = hsr.getParameter("txtEdad");
        
        ModelAndView mv = new ModelAndView("DatosUsuario");
        String mensaje = "Datos de Usuario de la VISTA:";
        Usuario usu = new Usuario();
        if (nombreUsu != null)
        {
            mensaje = "Datos cambiados en VISTA a " + nombreUsu; 
            usu.setNombre(nombreUsu);
            usu.setApellidos(apellidosUsu);
            usu.setEdad(Integer.parseInt(edadUsu));
        }else{
            usu.setNombre("Lucia");
            usu.setApellidos("Ramos");        
            usu.setEdad(24);
        }
        
        mv.addObject("mensaje", mensaje);
        mv.addObject("usuario",usu);
        
        return mv;
    }
        
}
