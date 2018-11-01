package hotelidealuno;

/**
 *
 * @author Aballay Gabriel
 */
public class Habitacion {
    //*****Declaracion de los atributos de la clase
    private int idHabitacion=-1;
    private int nroHabitacion;
    private int piso;
    private boolean estado;
    private int id_tipoHabitacion;
    //*****Constructor
    public Habitacion(int nroHabitacion,int piso, boolean estado, int id_tipoHabitacion) {
        idHabitacion=-1;
        this.nroHabitacion=nroHabitacion;
        this.piso = piso;
        this.estado = estado;
        this.id_tipoHabitacion = id_tipoHabitacion;
    }
    //******SEgundo constructor
    public Habitacion(int idHabitacion,int nroHabitacion, int piso, boolean estado, int id_tipoHabitacion) {
        this.idHabitacion = idHabitacion;
        this.nroHabitacion=nroHabitacion;
        this.piso = piso;
        this.estado = estado;
        this.id_tipoHabitacion = id_tipoHabitacion;
    }
    //********Constructor por Defecto
    public Habitacion() {
        idHabitacion=-1;
    }
    /* A partir de este punto se declaran todos los metodos
    ** Setters y Getters de la clase.-
    */
    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public int getNroHabitacion() {
        return nroHabitacion;
    }

    public void setNroHabitacion(int nroHabitacion) {
        this.nroHabitacion = nroHabitacion;
    }

    
    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getId_tipoHabitacion() {
        return id_tipoHabitacion;
    }

    public void setId_tipoHabitacion(int id_tipoHabitacion) {
        this.id_tipoHabitacion = id_tipoHabitacion;
    }

    
}
