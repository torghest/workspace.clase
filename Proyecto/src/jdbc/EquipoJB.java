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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrador
 */
public class EquipoJB {
    private int id;
    private String nombre;
    private int idLocal;
    private int idCategoria;
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(int idLocal) {
        this.idLocal = idLocal;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public EquipoJB() {
    }

    public EquipoJB(String id) {
        cargarDatos(id);
    }

    public EquipoJB(int id, String nombre, int idLocal, int idCategoria) {
        this.id = id;
        this.nombre = nombre;
        this.idLocal = idLocal;
        this.idCategoria = idCategoria;
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
            PreparedStatement ps = con.prepareStatement("Select * from equipo where id = ?");
            ps.setInt(1,Integer.valueOf(id));
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                this.id = rs.getInt("id");
                this.nombre = rs.getString("nombre");
                this.idLocal = rs.getInt("id_local");
                this.idCategoria = rs.getInt("id_categoria");
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
                PreparedStatement ps = con.prepareStatement("INSERT INTO EQUIPO(nombre,id_local,id_categoria) values (?,?,?)");
                ps.setString(1, nombre);
                ps.setInt(2, idLocal);
                ps.setInt(3, idCategoria);
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
            PreparedStatement ps = con.prepareStatement("DELETE FROM equipo WHERE id=?");
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
            PreparedStatement ps = con.prepareStatement("UPDATE Equipo SET nombre=?, id_local=?, id_categoria=? WHERE id=?");
            ps.setString(1, nombre);
            ps.setInt(2, idLocal);
            ps.setInt(3, idCategoria);
            ps.setInt(4, id);
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
            res = "<div class=\"error\">No se ha podido dar de alta al Equipo</div>";
        } else {
            res = "<div class=\"correcto\">Se ha dado de alta al Equipo<br/><b>" + nombre + "</b></div>";
        }
        return res;
    }
    
    public String getBorrar(){
        cargarDatos(String.valueOf(id));
        int aux = eliminar();
        String res = "";
        if (aux == 0){
            res = "<div class=\"error flotante\">No se ha podido dar de baja al Equipo <b>" + nombre + "</b></div>";
        } else {
            res = "<div class=\"correcto flotante\">Se ha dado de baja al Equipo <b>" + nombre + "</b></div>";
        }
        return res;
    }
    
    public String getActualizar(){
        int aux = actualizar();
        String res = "";
        if (aux == 0){
            res = "<div class=\"error flotante\">No se ha podido actualizar los datos del Equipo</div>";
        } else {
            res = "<div class=\"correcto flotante\">Se han actualizado los datos del Equipo <b>" + nombre + "</b></div>";
        }
        return res;
    }
    
    public String getFormAlta() {
        String res = "";
        res += crearTablaInput(null, "1", "Alta de Equipo", "Dar de Alta");
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
        String res = "";
        res += crearTablaInput(String.valueOf(id), "2", "Actualizar Datos", "Actualizar Datos");
        return res;
    }
    
    public String getMostrar() {
        String res = listar(null);
        return res;
    }
    
    private String crearTablaInput(String valorId, String valorProcesar, String titulo, String boton){
        String res = "<table class=\"tabla\"><tr><td class=\"cabecera\" colspan=2>" + titulo + "</td></tr>";
        String[] auxLabels = {"Nombre:", "Local:", "Categoria:"};
        String[] auxCampos = {"nombre","idLocal","idCategoria"};
        String[] auxValores = {nombre,String.valueOf(idLocal),String.valueOf(idCategoria)};
        for (int i = 0; i < auxCampos.length; i++) {
            res += "<tr><td class=\"clave\">" + auxLabels[i] + "</td><td class=\"valor\">";
            if (auxCampos[i].equals("idLocal")){
                String[] aux = getDatos("id", "nombre", "local");
                res += crearCombo(auxCampos[i], aux, (valorId!=null)?auxValores[i]:"");
            } else if (auxCampos[i].equals("idCategoria")){
                String[] aux = getDatos("id", "nombre", "categoria");
                res += crearCombo(auxCampos[i], aux, (valorId!=null)?auxValores[i]:"");
            } else {
                res += "<input type=\"text\" name=\"" + auxCampos[i] + "\"";
                if (valorId != null){
                    res += " value=\"" + auxValores[i] + "\"";
                }
                res += "/>";
            }
            res += "</td></tr>";
        }
        res += "<tr><td class=\"submit\" colspan=\"2\"><input type=\"submit\" value=\"" + boton + "\" onclick=\"form.procesar.value=" + valorProcesar + ";";
        if (valorId != null){
            res += "form.id.value=" + valorId + ";";
        }
        res += "\"/></td></tr></table>";
        return res;
    }
    
    private String crearCombo(String name, String[] opciones, String sel) {
        String res = "";
        res += "<select name=\"" + name + "\">";
        for (String opcione : opciones) {
            String[] aux = opcione.split(AccesoJDBC.separador2);
            res += "<option value=\"" + aux[0] + "\"" + ((aux[0].equals(sel))?" selected":"") + ">" + aux[1] + "</option>";
        }
        res += "</select>";
        return res;
    }
    
    private String[] getDatos(String clave, String valor, String tabla) {
        Connection con = AccesoJDBC.getInstancia().getConexion();
        String[] res = null;
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT " + clave + ", " + valor + " FROM " + tabla);
            String aux = "";
            while (rs.next()){
                aux += AccesoJDBC.separador1 + rs.getString(clave) + AccesoJDBC.separador2 + rs.getString(valor);
            }
            aux = aux.substring(AccesoJDBC.separador1.length());
            res = aux.split(AccesoJDBC.separador1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return res;
    }
    
    private String listar(String accion){
        Connection con = AccesoJDBC.getInstancia().getConexion();
        String res = "";
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT equipo.id as id, equipo.nombre as nombre, local.nombre as id_local, categoria.nombre as id_categoria FROM equipo join local on equipo.id_local = local.id join categoria on equipo.id_categoria = categoria.id");
            while (rs.next()){
                res += "<div class=\"cajaDatos\">";
                res += "<table><tr><td>";
                res += "<span class=\"titulo\">" + rs.getString("nombre") + "</span>";
                res += "</td></tr><tr><td>";
                res += "<b>Local: </b>" + rs.getString("id_local");
                res += "</td></tr><tr><td>";
                res += "<b>Categoria: </b>" + rs.getString("id_categoria");
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
