/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelidealuno;

import java.time.LocalDate;

/**
 *
 * @author asus
 */
public class Reserva {
    private int id=-1;
    private int cantidadPersonas;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private double importeTotal;
    private boolean estadoReserva;
    private int id_habitacion;
    private int id_huesped;

    public Reserva(int id, int cantidadPersonas, LocalDate fechaEntrada, LocalDate fechaSalida, double importeTotal, boolean estadoReserva, int id_habitacion, int id_huesped) {
        this.id = id;
        this.cantidadPersonas = cantidadPersonas;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.importeTotal = importeTotal;
        this.estadoReserva = estadoReserva;
        this.id_habitacion = id_habitacion;
        this.id_huesped = id_huesped;
    }

    public Reserva(int cantidadPersonas, LocalDate fechaEntrada, LocalDate fechaSalida, double importeTotal, boolean estadoReserva, int id_habitacion, int id_huesped) {
        id = -1;
        this.cantidadPersonas = cantidadPersonas;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.importeTotal = importeTotal;
        this.estadoReserva = estadoReserva;
        this.id_habitacion = id_habitacion;
        this.id_huesped = id_huesped;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public double getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(double importeTotal) {
        this.importeTotal = importeTotal;
    }

    public boolean getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(boolean estadoReserva) {
        this.estadoReserva = estadoReserva;
    }

    public int getId_habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(int id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    public int getId_huesped() {
        return id_huesped;
    }

    public void setId_huesped(int id_huesped) {
        this.id_huesped = id_huesped;
    }

    public Reserva() {
        
    }

    public Object getNombre() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object getNumeroHabitacion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object getTipoHabitacion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object getEstado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    
 }
