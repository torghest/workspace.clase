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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Empleado;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author alumno
 */
public class controladorEmpleados implements Controller{
    
    private Connection conexion;
    
    private Connection getConexion(){
        if (this.conexion == null){
            try {
                DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
                this.conexion = DriverManager.getConnection(
                        "jdbc:oracle:thin:@localhost:1521:XE","system","javaoracle"
                );
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return this.conexion;
    }
    
    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        String apellido = hsr.getParameter("txtApellido");
        ModelAndView mv = new ModelAndView("index");
        Connection con = getConexion();
        ResultSet rs = null;
        if (apellido == null){
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery("Select apellido, oficio, salario, nvl(comision,0) comision from emp");
        } else {
            PreparedStatement ps = con.prepareStatement("Select apellido, oficio, salario, nvl(comision,0) comision from emp where apellido = ?");
            ps.setString(1, apellido);
            rs = ps.executeQuery();
        }
        ArrayList al = new ArrayList();
        while (rs.next()){
            Empleado emp = new Empleado();
            emp.setApellido(rs.getString("apellido"));
            emp.setOficio(rs.getString("oficio"));
            emp.setSalario(rs.getInt("salario"));
            emp.setComision(rs.getInt("comision"));
            al.add(emp);
        }
        mv.addObject("lista", al);
        return mv;
    }
    
}
