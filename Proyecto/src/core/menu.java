/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core;

import Util.Navegacion;
import Util.properties;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import jdbc.AccesoJDBC;

/**
 *
 * @author alumno
 */
public class menu {
    public static final String separador1 = AccesoJDBC.separador1;
    public static final String separador2 = AccesoJDBC.separador2;
    
    private String[] optMenu;
    private String colorBase;
    private String colorSel;
    private String[] varForm;
    private Navegacion nav;
    private String selected;

    public menu() {
        this.optMenu = this.getMenu(AccesoJDBC.getInstancia().getConexion());
        this.colorBase = properties.FONDO_MENU2;
        this.colorSel = properties.FONDO_MENU1;
        this.varForm = new String[]{"menu","submenu"};
        this.nav = new Navegacion("menu",varForm);
    }

    public String[] getOptMenu() {
        return optMenu;
    }

    public void setOptMenu(String[] optMenu) {
        this.optMenu = optMenu;
    }

    public String getColorBase() {
        return colorBase;
    }

    public String getColorSel() {
        return colorSel;
    }

    public Navegacion getNav() {
        return nav;
    }

    public void setNav(Navegacion nav) {
        this.nav = nav;
    }
    
    public String getSelected() {
        selected = (selected==null)?"1":selected;
        return selected;
    }

    public void setSelected(String selected) {
        this.selected = selected;
        String[] aux = {this.selected};
        this.nav.setVal(aux);
    }
    
    private String[] getMenu(Connection con){
        String[] res = null;
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT nombre,id FROM menu ORDER BY id");
            String aux = "";
            while (rs.next()){
                aux += AccesoJDBC.separador1 + rs.getString("nombre") + AccesoJDBC.separador2 + rs.getString("id");
            }
            aux = aux.substring(AccesoJDBC.separador1.length());
            res = aux.split(AccesoJDBC.separador1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return res;
    }
    
}
