/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelidealuno;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author okped
 */
public class TipoHabitacionData {
    private Connection connection = null;

    public TipoHabitacionData(Conexion conexion) {
        try {
            connection = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error al abrir al obtener la conexion");
        }
    }
    public void guardarTipoHabitacion(TipoHabitacion tipoHabitacion){
        try {
            
            String sql = "INSERT INTO tipoHabitacion ( codigo, tipo, precioPorNoche, cantPersonasMax, cantCamas, tipoCama ) VALUES ( ? , ? , ? , ? , ? , ? );";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, tipoHabitacion.getCodigo());
            statement.setString(2, tipoHabitacion.getTipo());
            statement.setDouble(3, tipoHabitacion.getPrecioPorNoche());
            statement.setInt(4, tipoHabitacion.getCantPersonasMax());
            statement.setInt(5, tipoHabitacion.getCantCamas());
            statement.setString(6, tipoHabitacion.getTipoCama());
            
            statement.executeUpdate();
            
            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                tipoHabitacion.setId(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id luego de insertar un tipoHabitacion");
            }
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un tipoHabitacion : " + ex.getMessage());
        }
    }
    
    public List<TipoHabitacion> obtenerTipoHabitaciones(){
        List<TipoHabitacion> tipoHabitaciones = new ArrayList<TipoHabitacion>();
            

        try {
            String sql = "SELECT * FROM tipoHabitacion;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            TipoHabitacion tipoHabitacion;
            while(resultSet.next()){
                tipoHabitacion = new TipoHabitacion();
                tipoHabitacion.setId(resultSet.getInt("id_tipohabitacion")); 
                tipoHabitacion.setCodigo(resultSet.getInt("codigo"));
                tipoHabitacion.setTipo(resultSet.getString("tipo"));
                tipoHabitacion.setPrecioPorNoche(resultSet.getDouble("precioPorNoche"));
                tipoHabitacion.setCantPersonasMax(resultSet.getInt("cantPersonasMax"));
                tipoHabitacion.setCantCamas(resultSet.getInt("cantCamas"));
                tipoHabitacion.setTipoCama(resultSet.getString("tipoCama"));
    
                tipoHabitaciones.add(tipoHabitacion);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los tipoHabitacion: " + ex.getMessage());
        }
        
        
        return tipoHabitaciones;
    }
    
    public void borrarTipoHabitacion(int codigo){
    try {
            
            String sql = "DELETE FROM tipoHabitacion WHERE codigo =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, codigo);
           
            
            statement.executeUpdate();
            
            
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al borrar un tipoHabitacion: " + ex.getMessage());
        }
        
    
    }
    
    public void actualizarTipoHabitacion(TipoHabitacion tipoHabitacion){
    
        try {
            
            String sql = "UPDATE tipoHabitacion SET codigo = ?, tipo = ?, precioPorNoche = ? , cantPersonasMax = ? , cantCamas = ? , tipoCama = ? WHERE id_tipoHabitacion = ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, tipoHabitacion.getCodigo());
            statement.setString(2, tipoHabitacion.getTipo());
            statement.setDouble(3, tipoHabitacion.getPrecioPorNoche());
            statement.setInt(4, tipoHabitacion.getCantPersonasMax());
            statement.setInt(5, tipoHabitacion.getCantCamas());
            statement.setString(6, tipoHabitacion.getTipoCama());
            statement.setInt(7, tipoHabitacion.getId());
            statement.executeUpdate();
    
          
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al actualizar un tipoHabitacion : " + ex.getMessage());
        }
    
    }
    
    public TipoHabitacion buscarTipoHabitacion(int codigo){
    TipoHabitacion tipoHabitacion=null;
    try {
            
            String sql = "SELECT * FROM tipoHabitacion WHERE codigo =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, codigo);
           
            
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                tipoHabitacion = new TipoHabitacion();
                tipoHabitacion.setId(resultSet.getInt("id_tipohabitacion"));
                tipoHabitacion.setCodigo(resultSet.getInt("codigo"));
                tipoHabitacion.setTipo(resultSet.getString("tipo"));
                tipoHabitacion.setPrecioPorNoche(resultSet.getDouble("precioPorNoche"));
                tipoHabitacion.setCantPersonasMax(resultSet.getInt("cantPersonasMax"));
                tipoHabitacion.setCantCamas(resultSet.getInt("cantCamas"));
                tipoHabitacion.setTipoCama(resultSet.getString("tipoCama"));
                
            }      
            statement.close();
            
            
            
            
    
        } catch (SQLException ex) {
            System.out.println("Error al buscar un tipoHabitacion : " + ex.getMessage());
        }
        
        return tipoHabitacion;
    }
   
}
