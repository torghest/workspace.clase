/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pqMngBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author alumno
 */
public class MngBean {

    private int idPlantilla;
    private String apellido;
    private String turno;
    private int salario;
    private String mensaje;
    
    Connection cn = null;

    public int getIdPlantilla() {
        return idPlantilla;
    }

    public void setIdPlantilla(int idPlantilla) {
        this.idPlantilla = idPlantilla;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public void conectarSQL() throws SQLException
    {
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        this.cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","system", "javaoracle");
    }
    
    public String modificarSalario()
    {
        try
        {
            this.conectarSQL();
            String consulta = "UPDATE PLANTILLA SET APELLIDO=? " +
                    ",T=?,SALARIO=SALARIO+? WHERE EMPLEADO_NO=?";
            PreparedStatement pst = this.cn.prepareStatement(consulta);
            pst.setString(1, apellido);
            pst.setString(2, turno);
            pst.setInt(3, salario);
            pst.setInt(4, idPlantilla);
            
            int resultado = pst.executeUpdate();
            this.mensaje = "Registros modificados: " + resultado;
        }catch (Exception ex)
        {
            this.mensaje = "Excepción modificando salario: " + ex;
        }
        return null;
    }
    
    public void validarTurno(FacesContext contexto, UIComponent componente, Object obj) throws ValidatorException
    {
        String t = obj.toString();
        if (t.equalsIgnoreCase("T") == false
                && t.equalsIgnoreCase("N") == false
                && t.equalsIgnoreCase("M") == false)
        {
            throw new ValidatorException(new FacesMessage("El turno sólo puede ser M, N, o T"));
        }
    }

}
