/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelidealuno;

/**
 *
 * @author okped
 */
public class TipoHabitacion {
    private int id=-1;
    private int codigo;
    private String tipo;
    private Double precioPorNoche;
    private int cantPersonasMax;
    private int cantCamas;
    private String tipoCama;

    public TipoHabitacion(int codigo, String tipo, Double precioPorNoche, int cantPersonasMax, int cantCamas, String tipoCama) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.precioPorNoche = precioPorNoche;
        this.cantPersonasMax = cantPersonasMax;
        this.cantCamas = cantCamas;
        this.tipoCama = tipoCama;
    }

    public TipoHabitacion(int id, int codigo, String tipo, Double precioPorNoche, int cantPersonasMax, int cantCamas, String tipoCama) {
        this.id = id;
        this.codigo = codigo;
        this.tipo = tipo;
        this.precioPorNoche = precioPorNoche;
        this.cantPersonasMax = cantPersonasMax;
        this.cantCamas = cantCamas;
        this.tipoCama = tipoCama;
    }
    

    public TipoHabitacion() {}

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getPrecioPorNoche() {
        return precioPorNoche;
    }

    public void setPrecioPorNoche(Double precioPorNoche) {
        this.precioPorNoche = precioPorNoche;
    }

    public int getCantPersonasMax() {
        return cantPersonasMax;
    }

    public void setCantPersonasMax(int cantPersonasMax) {
        this.cantPersonasMax = cantPersonasMax;
    }

    public int getCantCamas() {
        return cantCamas;
    }

    public void setCantCamas(int cantCamas) {
        this.cantCamas = cantCamas;
    }

    public String getTipoCama() {
        return tipoCama;
    }

    public void setTipoCama(String tipoCama) {
        this.tipoCama = tipoCama;
    }
    
}
