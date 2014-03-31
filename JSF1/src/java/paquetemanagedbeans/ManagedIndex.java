/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package paquetemanagedbeans;

/**
 *
 * @author alumno
 */
public class ManagedIndex {
    
    private String Saludo;
    
    public String getSaludo() {
        return Saludo;
    }

    public void setSaludo(String Saludo) {
        this.Saludo = Saludo;
    }

    public String mostrarSaludo()
    {
        System.out.println("Acción capturada");
        this.setSaludo("Primer Ejemplo de JavaServerFace (JSF)");
        return  null;
    }
    
}
