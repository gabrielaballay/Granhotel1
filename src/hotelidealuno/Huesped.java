/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelidealuno;

/**
 *
 * @author Aballay Gabriel
 */
public class Huesped {
    private int id_huesped=-1;
    private String nombre;
    private int dni;
    private String domicilio;
    private String correo;
    private long Celular;

    public Huesped(int id, String nombre, int dni, String domicilio, String correo, long Celular) {
        this.id_huesped = id;
        this.nombre = nombre;
        this.dni = dni;
        this.domicilio = domicilio;
        this.correo = correo;
        this.Celular = Celular;
    }

    public Huesped(String nombre, int dni, String domicilio, String correo, long Celular) {
        id_huesped=-1;
        this.nombre = nombre;
        this.dni = dni;
        this.domicilio = domicilio;
        this.correo = correo;
        this.Celular = Celular;
    }


    public Huesped() {
        id_huesped=-1;
    }

    public int getId_huesped() {
        return id_huesped;
    }

    public void setId_huesped(int id) {
        this.id_huesped = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public long getCelular() {
        return Celular;
    }

    public void setCelular(long Celular) {
        this.Celular = Celular;
    }
}
