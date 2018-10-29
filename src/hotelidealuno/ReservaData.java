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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asus
 */
public class ReservaData {
   private Connection connection = null;

    public ReservaData(Conexion conexion) {
        try {
            connection = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error al abrir al obtener la conexion");
        }
    }


    public void guardarReserva(Reserva reserva){
        try {
            
            String sql = "INSERT INTO reserva ( cantidadPersonas , fechaEntrada , fechaSalida , importeTotal , estadoReserva ,"
                    + " id_habitacion , id_huesped ) VALUES ( ? , ? , ? , ? , ? , ? , ? );";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, reserva.getCantidadPersonas());
            statement.setDate(2, Date.valueOf(reserva.getFechaEntrada()));
            statement.setDate(3, Date.valueOf(reserva.getFechaSalida()));
            statement.setDouble(4, reserva.getImporteTotal());
            statement.setBoolean(5, reserva.getEstadoReserva()); 
            statement.setInt (6, reserva.getId_habitacion());
            statement.setInt (7, reserva.getId_huesped());
            
            statement.executeUpdate();
            
            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                reserva.setId(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id luego de insertar un reserva");
            }
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un reserva : " + ex.getMessage());
        }
    }
       public void actualizarEstado(int id, boolean estado){
    
        try {
            
            String sql = "UPDATE habitacion SET estado = ? WHERE id_habitacion = ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setBoolean(1, estado);
            statement.setInt(2, id);
            statement.executeUpdate();
    
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al ACTUALIZAR EL ESTADO DE HABITACION: " + ex.getMessage());
        }
    
    }

    public List<Reserva> obtenerResevas(){
        List<Reserva> reservas = new ArrayList<>();
            

        try {
            String sql = "SELECT * FROM reserva;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Reserva reserva;
            while(resultSet.next()){
                reserva = new Reserva();
                reserva.setId(resultSet.getInt("id_reserva")); 
                reserva.setCantidadPersonas(resultSet.getInt("cantidadPersonas"));
                reserva.setFechaEntrada(resultSet.getDate("fechaEntrada").toLocalDate());
                reserva.setFechaSalida(resultSet.getDate("fechaSalida").toLocalDate());
                reserva.setImporteTotal(resultSet.getDouble("importeTotal"));
                reserva.setEstadoReserva(resultSet.getBoolean("estadoReserva"));
                reserva.setId_habitacion(resultSet.getInt("id_habitacion"));
                reserva.setId_huesped(resultSet.getInt("id_huesped"));
    
                reservas.add(reserva);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los huesped: " + ex.getMessage());
        }
        
        return reservas;
    }    
   
}
