/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Pelicula;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 *
 * @author alumno
 */
public class PeliculasController extends MultiActionController{
    
    private Connection conexion = null;
    
    private Object getBean(String nombrebean, ServletContext servlet)
    {
        ApplicationContext contexto = WebApplicationContextUtils.getRequiredWebApplicationContext(servlet);
        Object beanobject = contexto.getBean(nombrebean);
        return beanobject;
    }
    
    private Connection getConnection(ServletContext servlet){
        if (this.conexion == null){
            DriverManagerDataSource dataSource;
            dataSource = (DriverManagerDataSource)this.getBean("dataSource",servlet);
            try {
                this.conexion = dataSource.getConnection();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return this.conexion;
    }
    
    public ModelAndView inicio(HttpServletRequest request, HttpServletResponse response) throws Exception {
        this.getConnection(request.getServletContext());
        ArrayList al = new ArrayList();
        try {
            Statement stmt = this.conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT ids, nombre, observaciones, tipopeli, precio, foto FROM peliculas");
            while (rs.next()){
                Pelicula p = new Pelicula(
                        rs.getInt("ids"),
                        rs.getString("nombre"),
                        rs.getString("tipopeli"),
                        rs.getString("observaciones"),
                        rs.getInt("precio"),
                        rs.getString("foto").toUpperCase()
                );
                al.add(p);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("peliculas", al);
        mv.addObject("metodo","inicio");
        return mv;
    }
    
    public ModelAndView verMas(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int pid = Integer.valueOf(request.getParameter("pid"));
        this.getConnection(request.getServletContext());
        Pelicula p = null;
        try {
            PreparedStatement ps = this.conexion.prepareStatement(
                    "SELECT ids, nombre, observaciones, tipopeli, precio, foto FROM peliculas WHERE ids = ?"
            );
            ps.setInt(1, pid);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                p = new Pelicula(
                        rs.getInt("ids"),
                        rs.getString("nombre"),
                        rs.getString("tipopeli"),
                        rs.getString("observaciones"),
                        rs.getInt("precio"),
                        rs.getString("foto").toUpperCase()
                );
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        ModelAndView mv;
        if (p != null){
            mv = new ModelAndView("detalles");
            mv.addObject("pelicula", p);
        } else {
            mv = this.inicio(request, response);
        }
        mv.addObject("metodo","verMas");
        return mv;
    }
    
    public ModelAndView comprar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("metodo","comprar");
        return mv;
    }
    
    public ModelAndView guardarCompra(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("metodo","guardarCompra");
        return mv;
    }
    
}
