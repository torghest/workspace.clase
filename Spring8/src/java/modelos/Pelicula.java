/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelos;

/**
 *
 * @author alumno
 */
public class Pelicula {
    private int id;
    private String nombre;
    private String tipoPeli;
    private String observaciones;
    private int precio;
    private String foto;

    public Pelicula(int id, String nombre, String tipoPeli, String observaciones, int precio, String foto) {
        this.id = id;
        this.nombre = nombre;
        this.tipoPeli = tipoPeli;
        this.observaciones = observaciones;
        this.precio = precio;
        this.foto = foto.replaceAll("\\\\", "/");;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoPeli() {
        return tipoPeli;
    }

    public void setTipoPeli(String tipoPeli) {
        this.tipoPeli = tipoPeli;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto.replaceAll("\\\\", "/");
    }

    @Override
    public String toString() {
        return "Pelicula{" + "id=" + id + ", nombre=" + nombre + ", tipoPeli=" + tipoPeli + ", observaciones=" + observaciones + ", precio=" + precio + ", foto=" + foto + '}';
    }
    
}
