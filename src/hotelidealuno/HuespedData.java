/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelidealuno;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aballay Gabriel
 */
public class HuespedData {
    private Connection connection = null;

    public HuespedData(Conexion conexion) {
        try {
            connection = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error al abrir al obtener la conexion");
        }
    }

    // GUARDA UN HUESPED NUEVO EN LA BASE DE DATOS...
    public void guardarHuesped(Huesped huesped){
        try {
            
            String sql = "INSERT INTO huesped ( nombre , dni , domicilio , correo , celular )"
                    + " VALUES ( ? , ? , ? , ? , ? );";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, huesped.getNombre());
            statement.setInt(2, huesped.getDni());
            statement.setString(3, huesped.getDomicilio());
            statement.setString(4,huesped.getCorreo());
            statement.setLong(5, huesped.getCelular());
            
            statement.executeUpdate();
            
            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                huesped.setId_huesped(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id luego de insertar un husped");
            }
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un huesped : " + ex.getMessage());
        }
    }
    
    // LISTA TODOS LOS HUESPEDES EXISTENTES EN LA BASE DE DATOS (metodo no utilizado)
    public List<Huesped> obtenerHuespedes(){
        List<Huesped> huespedes = new ArrayList<Huesped>();
            

        try {
            String sql = "SELECT * FROM huesped;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Huesped huesped;
            while(resultSet.next()){
                huesped = new Huesped();
                huesped.setId_huesped(resultSet.getInt("id_huesped")); 
                huesped.setNombre(resultSet.getString("nombre"));
                huesped.setDni(resultSet.getInt("dni"));
                huesped.setDomicilio(resultSet.getString("domicilio"));
                huesped.setCorreo(resultSet.getString("correo"));
                huesped.setCelular(resultSet.getLong("celular"));
    
                huespedes.add(huesped);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los huesped: " + ex.getMessage());
        }
        
        return huespedes;
    }
    
    // BORRA UN HUESPED POR EL DNI ...
    public void borrarHuesped(int dni){
        try {
            
            String sql = "DELETE FROM huesped WHERE dni = ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, dni);
            
            statement.executeUpdate();
            
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un huesped: " + ex.getMessage());
        }
    
    }
    
    // ACTUALIZAR UN HUESPED EXISTENTE EN LA BASE DE DATOS...
    public void actualizarHusped(Huesped huesped){
    
        try {
            
            String sql = "UPDATE huesped SET nombre = ?, dni = ? , domicilio = ? , correo = ? , celular = ? WHERE id_huesped = ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, huesped.getNombre());
            statement.setInt(2, huesped.getDni());
            statement.setString(3, huesped.getDomicilio());
            statement.setString(4, huesped.getCorreo());
            statement.setLong(5, huesped.getCelular());
            statement.setInt(6, huesped.getId_huesped());
            statement.executeUpdate();
    
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un huesped : " + ex.getMessage());
        }
    
    }
    
    // BUSCA UN HUESPED EXISTENTE EN LA BASE DE DATOS...
    public Huesped buscarHuesped(int dni){
    Huesped huesped=null;
    try {
            
            String sql = "SELECT * FROM huesped WHERE dni = ? ;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, dni);
           
            
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                huesped = new Huesped();
                huesped.setId_huesped(resultSet.getInt("id_huesped"));
                huesped.setNombre(resultSet.getString("nombre"));
                huesped.setDni(resultSet.getInt("dni"));
                huesped.setDomicilio(resultSet.getString("domicilio"));
                huesped.setCorreo(resultSet.getString("correo"));
                huesped.setCelular(resultSet.getLong("celular"));
                
            }      
            statement.close();
            
            
        } catch (SQLException ex) {
            System.out.println("Error al insertar un huesped : " + ex.getMessage());
        }
        
        return huesped;
    }
   
}
