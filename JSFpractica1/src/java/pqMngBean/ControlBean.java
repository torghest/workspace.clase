/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pqMngBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.faces.component.html.HtmlInputText;

/**
 *
 * @author alumno
 */
public class ControlBean {
    private HtmlInputText emp_no;

    public HtmlInputText getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(HtmlInputText emp_no) {
        this.emp_no = emp_no;
    }
    
    public String validarEmp(){
        String res = "noExiste";
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:XE","system","javaoracle"
            );
            PreparedStatement ps = con.prepareStatement("select * from emp where emp_no = ?");
            ps.setInt(1, Integer.valueOf((this.emp_no).getValue().toString()));
            ResultSet rs = ps.executeQuery();
            if (rs.next())
                res = "correcto";
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return res;
    }
}
