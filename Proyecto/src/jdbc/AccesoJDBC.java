/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
    private Connection con;

    private static AccesoJDBC instancia;
    
    public static AccesoJDBC getInstancia (){
        if(AccesoJDBC.instancia==null){
            AccesoJDBC.instancia = new AccesoJDBC();
        }
        return instancia;
    }
    
    public void conectar(){
        if(this.con == null){
            try {
                Class.forName(this.driver);
                this.con = DriverManager.getConnection(this.cadena, this.user, this.pass);
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void desconectar()throws Exception{
        if(!this.getConexion().isClosed()){
            this.con.close();
            this.con = null;
        }
    }

    public AccesoJDBC(){
//        this.conectar();
    }
    
    public Connection getConexion() {
        try {
            if (con == null || con.isClosed()){
                con = null;
                this.conectar();
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return con;
    }
    
    @Override
    protected void finalize() throws Throwable{
        this.desconectar();
        super.finalize();
    } 
}
