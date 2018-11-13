package hotelidealuno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Aballay Gabriel
 */
public class HabitacionData {
    //***Declaracion de variable tipo Connection
    private Connection connection = null;
    private Conexion conexion;
    public HabitacionData(Conexion conexion) {
        try {
            this.conexion=conexion;
            connection = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error al abrir al obtener la conexion");
        }
    }

    //****GUARDA UNA HABITACION NUEVA EN LA BASE DE DATOS****
    //*******************************************************
    public void guardarHabitacion(Habitacion habitacion){
        try {
            String sql = "INSERT INTO habitacion ( nroHabitacion , piso, estado , id_tipohabitacion )"
                    + " VALUES ( ? , ? , ? , ? );";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, habitacion.getNroHabitacion());
            statement.setInt(2, habitacion.getPiso());
            statement.setBoolean(3, habitacion.isEstado());
            statement.setInt(4, habitacion.getId_tipoHabitacion().getId_tipoHabitacion());
                       
            statement.executeUpdate();
            
            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                habitacion.setIdHabitacion(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id luego de insertar un habitacion");
            }
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar una habitacion : " + ex.getMessage());
        }
    }
    
    //*****LISTA TODOS LAS HABITACIONES EXISTENTES EN LA BASE DE DATOS****
    //********************************************************************
    public List<Habitacion> obtenerHabitaciones(){
        List<Habitacion> habitaciones = new ArrayList<Habitacion>();
        
        try {
            String sql = "SELECT * FROM habitacion;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Habitacion habitacion;
            while(resultSet.next()){
                habitacion = new Habitacion();
                habitacion.setIdHabitacion(resultSet.getInt("id_habitacion")); 
                habitacion.setNroHabitacion(resultSet.getInt("nroHabitacion"));
                habitacion.setPiso(resultSet.getInt("piso"));
                habitacion.setEstado(resultSet.getBoolean("estado"));
                TipoHabitacion th=buscarTipoHabitacion(resultSet.getInt("id_tipohabitacion"));
                habitacion.setId_tipoHabitacion(th);
                habitaciones.add(habitacion);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener las habitaciones: " + ex.getMessage());
        }    
        return habitaciones;
    }
    
    //****ACTUALIZAR UNA HABITACION EXISTENTE EN LA BASE DE DATOS****
    //***************************************************************
    public void actualizarHabitacion(Habitacion habitacion){
    
        try {
            
            String sql = "UPDATE habitacion SET nroHabitacion = ? , piso = ? , estado = ? , id_tipohabitacion = ? "
                    + "WHERE id_habitacion = ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, habitacion.getNroHabitacion());
            statement.setInt(2, habitacion.getPiso());
            statement.setBoolean(3, habitacion.isEstado());
            statement.setInt(4, habitacion.getId_tipoHabitacion().getId_tipoHabitacion());
            statement.setInt(5, habitacion.getIdHabitacion());
            statement.executeUpdate();
    
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al actualizar una habitacion : " + ex.getMessage());
        }
    }
    
    //****BUSCA UNA HABITACION EXISTENTE EN LA BASE DE DATOS****
    //********************************************************** 
    public Habitacion buscarHabitacion(int nroHabitacion){
    Habitacion habitacion=null;
    try {
            
            String sql = "SELECT * FROM habitacion WHERE nroHabitacion = ? ;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, nroHabitacion);
                      
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                habitacion = new Habitacion();
                habitacion.setIdHabitacion(resultSet.getInt("id_habitacion"));
                habitacion.setNroHabitacion(resultSet.getInt("nroHabitacion"));
                habitacion.setPiso(resultSet.getInt("piso"));
                habitacion.setEstado(resultSet.getBoolean("estado"));
                TipoHabitacion th=buscarTipoHabitacion(resultSet.getInt("id_tipohabitacion"));
                habitacion.setId_tipoHabitacion(th);
            }      
            statement.close();
               
        } catch (SQLException ex) {
            System.out.println("Error al buscar una habitacion : " + ex.getMessage());
        }  
        return habitacion;
    }
    
    
    public Habitacion buscarIdHabitacion(int id){
    Habitacion habitacion=null;
    try {
            
            String sql = "SELECT * FROM habitacion WHERE id_habitacion = ? ;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
                      
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                habitacion = new Habitacion();
                habitacion.setIdHabitacion(resultSet.getInt("id_habitacion"));
                habitacion.setNroHabitacion(resultSet.getInt("nroHabitacion"));
                habitacion.setPiso(resultSet.getInt("piso"));
                habitacion.setEstado(resultSet.getBoolean("estado"));
                TipoHabitacion th=buscarTipoHabitacion(resultSet.getInt("id_tipohabitacion"));
                habitacion.setId_tipoHabitacion(th);
            }      
            statement.close();
               
        } catch (SQLException ex) {
            System.out.println("Error al buscar una habitacion : " + ex.getMessage());
        }  
        return habitacion;
    }
    
    
    
    
    
    //****BORRA UNA HABITACION DE LA BASE DE DATOS*******
    //***************************************************
    public void borrarHabitacion(int numero){
        try {
            
            String sql = "DELETE FROM habitacion WHERE nroHabitacion = ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, numero);
            
            statement.executeUpdate();
            
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al borrar una habitacion " + ex.getMessage());
        }
    }
    
    
    public TipoHabitacion buscarTipoHabitacion(int id){
            
        TipoHabitacionData thd=new TipoHabitacionData(conexion);
        
        return thd.buscarTipoHabita(id);
        
    }
}