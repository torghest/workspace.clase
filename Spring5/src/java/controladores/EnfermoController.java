/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controladores;

import java.sql.Connection;
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
import modelos.Enfermo;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author alumno
 */
public class EnfermoController implements Controller{
    
    Connection cn = null;
    
    private Connection getConnection(ServletContext servlet){
        if (this.cn == null){
            DriverManagerDataSource dataSource;
            dataSource = (DriverManagerDataSource)this.getBean("xeBBDD",servlet);
            try {
                this.cn = dataSource.getConnection();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return this.cn;
    }
    
    private Object getBean(String nombrebean, ServletContext servlet)
    {
        ApplicationContext contexto = WebApplicationContextUtils.getRequiredWebApplicationContext(servlet);
        Object beanobject = contexto.getBean(nombrebean);
        return beanobject;
    }
    
    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        String inscripcion = hsr.getParameter("insEnf");
        ModelAndView mv = new ModelAndView("index");
        this.getConnection(hsr.getServletContext());
        mv.addObject("enfermos", this.getEnfermos());
        if (inscripcion != null){
            int res = this.borrarInscripcion(Integer.valueOf(inscripcion));
            if (res != 0){
                mv.addObject("inscripcion", inscripcion);
            }
        }
        return mv;
    }
    
    private int borrarInscripcion(int ins){
        int res = 1;
//        try {
////            PreparedStatement ps = this.cn.prepareStatement("DELETE FROM enfermo WHERE inscripcion = ?");
////            ps.setInt(1, ins);
////            res = ps.executeUpdate();
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
        return res;
    }
    
    private ArrayList<Enfermo> getEnfermos()
    {
        try {
            ArrayList<Enfermo> listaEnf = new ArrayList<Enfermo>();
            Statement st = this.cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT inscripcion, apellido, direccion, fecha_nac FROM enfermo");
            while (rs.next())
            {
                Enfermo enf = new Enfermo();
                enf.setInscripcion(rs.getInt("INSCRIPCION"));
                enf.setApellido(rs.getString("APELLIDO"));
                enf.setDireccion(rs.getString("DIRECCION"));
                enf.setFechaNac(rs.getString("FECHA_NAC"));
                listaEnf.add(enf);
            }
            return listaEnf;
        } catch (SQLException ex) {
            System.out.println("Error leyendo enfermos: " + ex);
        }
        return null;
    }
    
}
