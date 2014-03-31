/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controladores;

/**
 *
 * @author alumno
 */
import java.sql.*;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Departamento;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class DepartamentosController implements Controller
{

    Connection cn;
    
    private Object getBean(String nombrebean, ServletContext servlet)
    {
        ApplicationContext contexto = WebApplicationContextUtils.getRequiredWebApplicationContext(servlet);
        Object beanobject = contexto.getBean(nombrebean);
        return beanobject;
    }
    
    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception 
    {
        ModelAndView mv = new ModelAndView("departamentos");
        DriverManagerDataSource dataSource;
        dataSource = (DriverManagerDataSource)this.getBean("dataSource",hsr.getServletContext());
        this.cn = dataSource.getConnection();
        
        mv.addObject("listadepartamentos", this.getDepartamentos());
        
        return mv;
    }
    
    private ArrayList<Departamento> getDepartamentos()
    {
        try {
            ArrayList<Departamento> listadept = new ArrayList<Departamento>();
            Statement st = this.cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM DEPT");
            while (rs.next())
            {
                Departamento dept = new Departamento();
                dept.setNumero(rs.getInt("DEPT_NO"));
                dept.setNombre(rs.getString("DNOMBRE"));
                dept.setLocalidad(rs.getString("LOC"));
                listadept.add(dept);
            }
            return listadept;
        } catch (SQLException ex) {
            System.out.println("Error leyendo departamentos: " + ex);
        }
        return null;
    }
}
