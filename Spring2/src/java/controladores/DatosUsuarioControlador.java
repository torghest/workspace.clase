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
public class DatosUsuarioControlador implements Controller{

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = new ModelAndView("DatosUsuario");
        String mensaje = "Datos de Usuario de la VISTA:";
        Usuario usu = new Usuario();
        usu.setNombre("Benito");
        usu.setApellidos("Floro");
        usu.setEdad(24);
        mv.addObject("mensaje", mensaje);
        mv.addObject("usuario", usu);
        return mv;
    }
    
}
