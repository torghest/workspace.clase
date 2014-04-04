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
public class subMenu {
    private AccesoJDBC jdbc;
    private String[] optMenu;
    private String colorBase;
    private String colorSel;
    private String[] varForm;
    private Navegacion nav;
    private String selected;
    private String selPadre;

    public subMenu() {
        this.jdbc = new AccesoJDBC();
        this.optMenu = this.getSubMenu(jdbc.getConnection());
        this.colorBase = properties.FONDO_MENU2;
        this.colorSel = properties.FONDO_MENU1;
        this.varForm = new String[2];
        this.varForm[0] = "menu";
        this.varForm[1] = "submenu";
        this.nav = new Navegacion("submenu",varForm);
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
        return selected;
    }

    public void setSelected(String selected) {
        this.selected = selected;
        String[] aux = {this.selPadre,this.selected};
        this.nav.setVal(aux);
    }
    
    public String getSelPadre() {
        return selPadre;
    }

    public void setSelPadre(String selPadre) {
        this.selPadre = selPadre;
        optMenu = getSubMenu(jdbc.getConnection());
    }
    
    private String[] getSubMenu(Connection con){
        String[] res = null;
        if (this.selPadre != null){
            try {
                PreparedStatement ps = con.prepareStatement("SELECT nombre,id FROM submenu WHERE id_padre = ? ORDER BY id");
                ps.setInt(1, Integer.valueOf(this.selPadre));
                ResultSet rs = ps.executeQuery();
                String aux = "";
                while (rs.next()){
                    aux += AccesoJDBC.separador1 + rs.getString("nombre") + AccesoJDBC.separador2 + rs.getString("id");
                }
                if (!aux.equals("")){
                    aux = aux.substring(AccesoJDBC.separador1.length());
                    res = aux.split(AccesoJDBC.separador1);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return res;
    }
}
