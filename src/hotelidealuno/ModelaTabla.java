package hotelidealuno;

import javax.swing.JTable;

/**
 * @author Aballay Gabriel
 */
public class ModelaTabla {
    public void modela(JTable tabla){
        tabla.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setMaxWidth(60);
            tabla.getColumnModel().getColumn(1).setMaxWidth(60);
            tabla.getColumnModel().getColumn(2).setMaxWidth(40);
            tabla.getColumnModel().getColumn(3).setMaxWidth(120);
            tabla.getColumnModel().getColumn(4).setMaxWidth(50);
            tabla.getColumnModel().getColumn(5).setMaxWidth(120);
            tabla.getColumnModel().getColumn(6).setMaxWidth(100);
            tabla.getColumnModel().getColumn(7).setMaxWidth(110);
            tabla.getColumnModel().getColumn(8).setMaxWidth(110);
        }
    }
    public void modelaHabitacion(JTable tabla){
        tabla.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setMaxWidth(40);
            tabla.getColumnModel().getColumn(1).setMaxWidth(50);
            tabla.getColumnModel().getColumn(2).setMaxWidth(120);
            tabla.getColumnModel().getColumn(3).setMaxWidth(120);
            tabla.getColumnModel().getColumn(4).setMaxWidth(100);
            tabla.getColumnModel().getColumn(5).setMaxWidth(110);
            tabla.getColumnModel().getColumn(6).setMaxWidth(110);
        }
    }
    
    public void modelaInforme(JTable tabla){
        tabla.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setMaxWidth(60);
            tabla.getColumnModel().getColumn(1).setMaxWidth(60);
            tabla.getColumnModel().getColumn(2).setMaxWidth(40);
            tabla.getColumnModel().getColumn(3).setMaxWidth(120);
            tabla.getColumnModel().getColumn(4).setMaxWidth(50);
            tabla.getColumnModel().getColumn(5).setMaxWidth(100);
            tabla.getColumnModel().getColumn(6).setMaxWidth(100);
            tabla.getColumnModel().getColumn(7).setMaxWidth(120);
            tabla.getColumnModel().getColumn(8).setMaxWidth(90);
            tabla.getColumnModel().getColumn(9).setMaxWidth(90);
            tabla.getColumnModel().getColumn(10).setMaxWidth(100);
        }
    }
}
