/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core;

/**
 *
 * @author alumno
 */
public class equipo {
    private int equipo_cod;
    private String nombre;
    private String fundacion;
    private String presidente;
    private String foto_escudo;
    private String nombre_est;
    private String foto_estadio;
    private String direccion;
    private String construccion;
    private String aforo;
    private String foto_equipo;

    public int getEquipo_cod() {
        return equipo_cod;
    }

    public void setEquipo_cod(int equipo_cod) {
        this.equipo_cod = equipo_cod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFundacion() {
        return fundacion;
    }

    public void setFundacion(String fundacion) {
        this.fundacion = fundacion;
    }

    public String getPresidente() {
        return presidente;
    }

    public void setPresidente(String presidente) {
        this.presidente = presidente;
    }

    public String getFoto_escudo() {
        return foto_escudo;
    }

    public void setFoto_escudo(String foto_escudo) {
        this.foto_escudo = foto_escudo;
    }

    public equipo(int equipo_cod, String nombre, String fundacion, String presidente, String foto_escudo) {
        this.equipo_cod = equipo_cod;
        this.nombre = nombre;
        this.fundacion = fundacion;
        this.presidente = presidente;
        this.foto_escudo = foto_escudo;
    }

    public equipo(String nombre, String foto_escudo, String nombre_est, String foto_estadio, String direccion, String construccion, String aforo, String foto_equipo) {
        this.nombre = nombre;
        this.foto_escudo = foto_escudo;
        this.nombre_est = nombre_est;
        this.foto_estadio = foto_estadio;
        this.direccion = direccion;
        this.construccion = construccion;
        this.aforo = aforo;
        this.foto_equipo = foto_equipo;
    }

    @Override
    public String toString() {
        return "equipo{" + "equipo_cod=" + equipo_cod + ", nombre=" + nombre + ", fundacion=" + fundacion + ", presidente=" + presidente + ", foto_escudo=" + foto_escudo + '}';
    }
    
}
