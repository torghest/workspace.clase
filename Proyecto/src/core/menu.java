/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core;

import Util.Navegacion;
import Util.properties;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import jdbc.AccesoJDBC;

/**
 *
 * @author alumno
 */
public class menu {
    private String[] optMenu;
    private String colorBase;
    private String colorSel;
    private String[] varForm;
    private Navegacion nav;
    private String selected;

    public menu() {
        AccesoJDBC jdbc = new AccesoJDBC();
        this.optMenu = this.getMenu(jdbc.getConnection());
        this.colorBase = properties.FONDO_MENU2;
        this.colorSel = properties.FONDO_MENU1;
        this.varForm = new String[1];
        this.varForm[0] = "opt";
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
        String aux = (this.selected!=null)?this.selected:"1";
        return aux;
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
