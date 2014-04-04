/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jdbc;

import com.mysql.jdbc.CharsetMapping;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrador
 */
public class AccesoJDBC {
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String cadena = "jdbc:mysql://127.0.0.1:3306/proyecto";
    private static final String user = "root";
    private static final String pass = "";
    public static final String separador1 = "%";
    public static final String separador2 = "#";
    private Connection con = null;

    public AccesoJDBC() {
        this.con = this.conectar();
    }
    
    private static Connection conectar(){
        Connection c = null;
        try {
            Class.forName(driver);
            c = DriverManager.getConnection(cadena,user,pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }
    
    public Connection getConnection(){
        if (this.con == null){
            this.con = this.conectar();
        }
        return this.con;
    }
    
    public String[] getMenu(){
        this.con = getConnection();
        String[] res = null;
        try {
            Statement stmt = this.con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT nombre,id FROM menu ORDER BY id");
            String aux = "";
            while (rs.next()){
                aux += this.separador1 + rs.getString("nombre") + this.separador2 + rs.getString("id");
            }
            aux = aux.substring(this.separador1.length());
            res = aux.split(this.separador1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return res;
    }
    
}
