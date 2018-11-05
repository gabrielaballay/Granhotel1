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
    private int id_Reseva;
    private int cantidadPersonas;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private double importeTotal;
    private boolean estadoReserva;
    private LocalDate fechaReserva;
    private Habitacion habitacio;
    private Huesped huesped;

    public Reserva(int id_Reseva, int cantidadPersonas, LocalDate fechaEntrada, LocalDate fechaSalida, double importeTotal, boolean estadoReserva,LocalDate fr, Habitacion habitacio, Huesped huesped) {
        this.id_Reseva = id_Reseva;
        this.cantidadPersonas = cantidadPersonas;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.importeTotal = importeTotal;
        this.estadoReserva = estadoReserva;
        fechaReserva=fr;
        this.habitacio = habitacio;
        this.huesped = huesped;
    }

    public Reserva(int cantidadPersonas, LocalDate fechaEntrada, LocalDate fechaSalida, double importeTotal, boolean estadoReserva,LocalDate fr, Habitacion habitacio, Huesped huesped) {
        this.cantidadPersonas = cantidadPersonas;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.importeTotal = importeTotal;
        this.estadoReserva = estadoReserva;
        fechaReserva=fr;
        this.habitacio = habitacio;
        this.huesped = huesped;
    }

    public Reserva() {
    }

    public int getId_Reseva() {
        return id_Reseva;
    }

    public void setId_Reseva(int id_Reseva) {
        this.id_Reseva = id_Reseva;
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

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public Habitacion getHabitacio() {
        return habitacio;
    }

    public void setHabitacio(Habitacion habitacio) {
        this.habitacio = habitacio;
    }

    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }

        
 }
