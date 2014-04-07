/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Administrador
 */
public class LocalJB {
    private int id;
    private String nombre;
    private String direccion;
    private String localidad;
    private int telefono;
    private int numDianas;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getNumDianas() {
        return numDianas;
    }

    public void setNumDianas(int numDianas) {
        this.numDianas = numDianas;
    }

    public LocalJB() {
    }

    public LocalJB(String id) {
        cargarDatos(id);
    }

    public LocalJB(int id, String nombre, String direccion, String localidad, int telefono, int numDianas) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.localidad = localidad;
        this.telefono = telefono;
        this.numDianas = numDianas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void cargarDatos(String id) {
        Connection con = AccesoJDBC.getInstancia().getConexion();
        try {
            PreparedStatement ps = con.prepareStatement("Select * from local where id = ?");
            ps.setInt(1,Integer.valueOf(id));
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                this.id = rs.getInt("id");
                this.nombre = rs.getString("nombre");
                this.direccion = rs.getString("direccion");
                this.localidad = rs.getString("localidad");
                this.telefono = rs.getInt("telefono");
                this.numDianas = rs.getInt("num_dianas");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();;
        }
    }
    
    public int insertar() {
        int res = 0;
        if (nombre != null){
            Connection con = AccesoJDBC.getInstancia().getConexion();
            try {
                PreparedStatement ps = con.prepareStatement("INSERT INTO LOCAL(nombre,direccion,localidad,telefono,num_dianas) values (?,?,?,?,?)");
                ps.setString(1, nombre);
                ps.setString(2, direccion);
                ps.setString(3, localidad);
                ps.setInt(4, telefono);
                ps.setInt(5, numDianas);
                res = ps.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return res;
    }
    
    public int eliminar() {
        Connection con = AccesoJDBC.getInstancia().getConexion();
        int res = 0;
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM local WHERE id=?");
            ps.setInt(1, id);
            res = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return res;
    }
    
    public int actualizar(){
        Connection con = AccesoJDBC.getInstancia().getConexion();
        int res = 0;
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE LOCAL SET nombre=?, direccion=?, localidad=?, telefono=?, num_dianas=? WHERE id=?");
            ps.setString(1, nombre);
            ps.setString(2, direccion);
            ps.setString(3, localidad);
            ps.setInt(4, telefono);
            ps.setInt(5, numDianas);
            ps.setInt(6, id);
            res = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return res;
    }
    
    public String getInsertar(){
        int aux = insertar();
        String res = "";
        if (aux == 0){
            res = "<div class=\"error\">No se ha podido dar de alta el Local</div>";
        } else {
            res = "<div class=\"correcto\">Se ha dado de alta el Local<br/><b>" + nombre + " (" + localidad + ")</b></div>";
        }
        return res;
    }
    
    public String getBorrar(){
        cargarDatos(String.valueOf(id));
        int aux = eliminar();
        String res = "";
        if (aux == 0){
            res = "<div class=\"error flotante\">No se ha podido dar de baja el Local <b>" + nombre + " (" + localidad + ")</b></div>";
        } else {
            res = "<div class=\"correcto flotante\">Se ha dado de baja el Local <b>" + nombre + " (" + localidad + ")</b></div>";
        }
        return res;
    }
    
    public String getActualizar(){
        int aux = actualizar();
        String res = "";
        if (aux == 0){
            res = "<div class=\"error flotante\">No se ha podido actualizar los datos del Local</div>";
        } else {
            res = "<div class=\"correcto flotante\">Se han actualizado los datos del Local <b>" + nombre + " (" + localidad + ")</b></div>";
        }
        return res;
    }
    
    public String getFormAlta() {
        String res = crearTablaInput(null, "1", "Alta de Local", "Dar de Atla");
        res += "<input type=\"hidden\" name=\"procesar\" value=\"0\"/>";
        return res;
    }
    
    public String getFormBaja() {
        String res = listar("borrar");
        res += "<input type=\"hidden\" name=\"id\"/>";
        res += "<input type=\"hidden\" name=\"procesar\" value=\"0\"/>";
        return res;
    }
    
    public String getTodosModificar() {
        String res = listar("editar");
        res += "<input type=\"hidden\" name=\"id\"/>";
        res += "<input type=\"hidden\" name=\"procesar\" value=\"0\"/>";
        return res;
    }
    
    public String getFormModificar() {
        cargarDatos(String.valueOf(id));
        String res = crearTablaInput(String.valueOf(id), "2", "Actualizar Datos", "Actualizar Datos");
        return res;
    }
    
    public String getMostrar() {
        String res = listar(null);
        return res;
    }
    
    private String crearTablaInput(String valorId, String valorProcesar, String titulo, String boton){
        String res = "<table class=\"tabla\"><tr><td class=\"cabecera\" colspan=2>" + titulo + "</td></tr>";
        String[] auxLabels = {"Nombre:","Direccion:","Localidad:","Telefono:","Numero de Dianas:"};
        String[] auxCampos = {"nombre","direccion","localidad","telefono","numDianas"};
        String[] auxValores = {nombre,direccion,localidad,String.valueOf(telefono),String.valueOf(numDianas)};
        for (int i = 0; i < auxCampos.length; i++) {
            res += "<tr><td class=\"clave\">" + auxLabels[i] + "</td><td class=\"valor\">";
            res += "<input type=\"text\" name=\"" + auxCampos[i] + "\"";
            if (valorId != null){
                res += " value=\"" + auxValores[i] + "\"";
            }
            res += "/>";
            res += "</td></tr>";
        }
        res += "<tr><td class=\"submit\" colspan=\"2\"><input type=\"submit\" value=\"" + boton + "\" onclick=\"form.procesar.value=" + valorProcesar + ";";
        if (valorId != null){
            res += "form.id.value=" + valorId + ";";
        }
        res += "\"/></td></tr></table>";
        return res;
    }
    
    private String listar(String accion) {
        Connection con = AccesoJDBC.getInstancia().getConexion();
        String res = "";
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM local");
            while (rs.next()){
                res += "<div class=\"cajaDatos\">";
                res += "<table><tr><td>";
                res += "<span class=\"tituloPequeno\">" + rs.getString("nombre") + "</span>";
                res += "</td></tr><tr><td>";
                res += "<span class=\"subtitulo\">" + rs.getString("direccion") + " (" + rs.getString("localidad") + ")</span>";
                res += "</td></tr><tr><td>";
                res += "<b>Telefono: </b>" + rs.getInt("telefono");
                res += "</td></tr><tr><td>";
                res += "<b>Número de Dianas: </b>" + rs.getString("num_dianas");
                res += "</td></tr></table>";
                if (accion != null){
                    res += "<div class=\"" + accion + "\">";
                    res += "<img src=\"imagenes/" + accion + ".png\" onclick=\"form.id.value=" + rs.getString("id") + ";form.procesar.value=1;form.submit();\"/>";
                    res += "</div>";
                }
                res += "</div>";
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return res;
    }
}
