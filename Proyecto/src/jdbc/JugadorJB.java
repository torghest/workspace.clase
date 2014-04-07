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
public class JugadorJB {
    private int id;
    private String nombre;
    private String apellido;
    private String apodo;
    private int idEquipo;
    private int telefono;
    private String email;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public JugadorJB() {
    }

    public JugadorJB(String id) {
        cargarDatos(id);
    }

    public JugadorJB(int id, String nombre, String apellido, String apodo,int idEquipo, int telefono, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.apodo = apodo;
        this.idEquipo = idEquipo;
        this.telefono = telefono;
        this.email = email;
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
            PreparedStatement ps = con.prepareStatement("Select * from jugador where id = ?");
            ps.setInt(1,Integer.valueOf(id));
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                this.id = rs.getInt("id");
                this.nombre = rs.getString("nombre");
                this.apellido = rs.getString("apellido");
                this.apodo = rs.getString("apodo");
                this.idEquipo = rs.getInt("id_equipo");
                this.telefono = rs.getInt("telefono");
                this.email = rs.getString("email");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();;
        }
    }
    
    public int insertar() {
        int res = 0;
        if (nombre != null && apellido != null){
            if (apodo == null){
                apodo = nombre + " " + apellido;
            }
            Connection con = AccesoJDBC.getInstancia().getConexion();
            try {
                PreparedStatement ps = con.prepareStatement("INSERT INTO JUGADOR(nombre,apellido,apodo,id_equipo,telefono,email) values (?,?,?,?,?,?)");
                ps.setString(1, nombre);
                ps.setString(2, apellido);
                ps.setString(3, apodo);
                ps.setInt(4, idEquipo);
                ps.setInt(5, telefono);
                ps.setString(6, email);
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
            PreparedStatement ps = con.prepareStatement("DELETE FROM jugador WHERE id=?");
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
            PreparedStatement ps = con.prepareStatement("UPDATE JUGADOR SET nombre=?, apellido=?, apodo=?, id_equipo=?, telefono=?, email=? WHERE id=?");
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, apodo);
            ps.setInt(4, idEquipo);
            ps.setInt(5, telefono);
            ps.setString(6, email);
            ps.setInt(7, id);
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
            res = "<div class=\"error\">No se ha podido dar de alta al Jugador</div>";
        } else {
            res = "<div class=\"correcto\">Se ha dado de alta al Jugador<br/><b>" + nombre + " " + apellido + " (" + apodo + ")</b></div>";
        }
        return res;
    }
    
    public String getBorrar(){
        cargarDatos(String.valueOf(id));
        int aux = eliminar();
        String res = "";
        if (aux == 0){
            res = "<div class=\"error flotante\">No se ha podido dar de baja al Jugador <b>" + nombre + " " + apellido + " (" + apodo + ")</b></div>";
        } else {
            res = "<div class=\"correcto flotante\">Se ha dado de baja al Jugador <b>" + nombre + " " + apellido + " (" + apodo + ")</b></div>";
        }
        return res;
    }
    
    public String getActualizar(){
        int aux = actualizar();
        String res = "";
        if (aux == 0){
            res = "<div class=\"error flotante\">No se ha podido actualizar los datos del Jugador</div>";
        } else {
            res = "<div class=\"correcto flotante\">Se han actualizado los datos del Jugador <b>" + nombre + " " + apellido + " (" + apodo + ")</b></div>";
        }
        return res;
    }
    
    public String getFormAlta() {
        String res = crearTablaInput(null, "1", "Alta de Jugador", "Dar de Atla");
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
        String[] auxLabels = {"Nombre:","Apellido:","Apodo:","Equipo:","Telefono:","E-Mail:"};
        String[] auxCampos = {"nombre","apellido","apodo","idEquipo","telefono","email"};
        String[] auxValores = {nombre,apellido,apodo,String.valueOf(idEquipo),String.valueOf(telefono),email};
        for (int i = 0; i < auxCampos.length; i++) {
            res += "<tr><td class=\"clave\">" + auxLabels[i] + "</td><td class=\"valor\">";
            if (auxCampos[i].equals("idEquipo")){
                String[] aux = getDatos("id", "nombre", "equipo");
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
    
    private String listar(String accion) {
        Connection con = AccesoJDBC.getInstancia().getConexion();
        String res = "";
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT jugador.*, ifnull(equipo.nombre,'---') as equipo FROM jugador left join equipo on jugador.id_equipo = equipo.id");
            while (rs.next()){
                res += "<div class=\"cajaDatos\">";
                res += "<table><tr><td>";
                res += "<span class=\"titulo\">" + rs.getString("apodo") + "</span>";
                res += "</td></tr><tr><td>";
                res += "<span class=\"subtitulo\">" + rs.getString("nombre") + " " + rs.getString("apellido") + "</span>";
                res += "</td></tr><tr><td>";
                res += "<b>Equipo: </b>" + rs.getString("equipo");
                res += "</td></tr><tr><td>";
                res += "<b>Telefono: </b>" + rs.getInt("telefono");
                res += "</td></tr><tr><td>";
                res += "<b>e-mail: </b>" + rs.getString("email");
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
