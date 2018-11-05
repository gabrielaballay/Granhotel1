package hotelidealuno;

/**
 *
 * @author Aballay Gabriel
 */
public class Huesped {
    //*****Declaracion de todos los atributos de la clase
    private int id_huesped;
    private String nombre;
    private int dni;
    private String domicilio;
    private String correo;
    private long Celular;
    
    //****Prmer constructor de la clase
    public Huesped(int id, String nombre, int dni, String domicilio, String correo, long Celular) {
        this.id_huesped = id;
        this.nombre = nombre;
        this.dni = dni;
        this.domicilio = domicilio;
        this.correo = correo;
        this.Celular = Celular;
    }
    //*****Segundo constructor de la clase
    public Huesped(String nombre, int dni, String domicilio, String correo, long Celular) {
        id_huesped=-1;
        this.nombre = nombre;
        this.dni = dni;
        this.domicilio = domicilio;
        this.correo = correo;
        this.Celular = Celular;
    }

    public Huesped(int id_huesped) {
        this.id_huesped = id_huesped;
    }
    
    //*****Constructor por defecto
    public Huesped() {
        id_huesped=-1;
    }
    /* A partir de este punto se declaran todos los metodos
    ** Setters y Getters de la clase.-
    */
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