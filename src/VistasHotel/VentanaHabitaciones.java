package VistasHotel;

import hotelidealuno.Conexion;
import hotelidealuno.Habitacion;
import hotelidealuno.HabitacionData;
import hotelidealuno.ModelaTabla;
import hotelidealuno.TipoHabitacion;
import hotelidealuno.TipoHabitacionData;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aballay Gabriel
 */
public class VentanaHabitaciones extends javax.swing.JInternalFrame {
    private DefaultTableModel modelo;
    private ArrayList<Habitacion> listaHabitaciones;
    private ArrayList<TipoHabitacion> listaTipoHabitaciones;
    private TipoHabitacionData tipoHabitacionData;
    private HabitacionData habitacionData;
    private Conexion conexion;
    public static String tipo;
    /**
     * Creates new form VentanaHabitaciones
     */
    public VentanaHabitaciones() {
        try {
            initComponents();
            conexion=new Conexion("jdbc:mysql://localhost/hotelideal1","root","");
            tipoHabitacionData=new TipoHabitacionData(conexion);
            habitacionData=new HabitacionData(conexion);
            modelo=new DefaultTableModel();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VentanaHabitaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
         tablaHabitaciones.setModel(modelo);
        cabezeraTabla();
        borrarFilasTabla();
        cargaDatos();
    }

    public void cabezeraTabla(){
        ArrayList<Object> columnas=new ArrayList<>();
        columnas.add("Numero");
        columnas.add("Estado");
        columnas.add("Piso");
        columnas.add("Tipo Habitacion");
        columnas.add("Codigo");
        columnas.add("Tipo Cama");
        columnas.add("Nro de Camas");
        columnas.add("Nro de Personas");
        columnas.add("Precio por Noche");
        
        for (Object it:columnas){
            modelo.addColumn(it);
        }
        tablaHabitaciones.setModel(modelo);
        ModelaTabla tbl=new ModelaTabla();
        tbl.modela(tablaHabitaciones);
    }
    
        //******Metodo que borra las filas de la tabla******
        public void borrarFilasTabla(){
            int a =modelo.getRowCount()-1;
            for(int i=a;i>=0;i--){
                modelo.removeRow(i);
            }
        }

        //********Metodo que carga los datos en la tabla********
        public void cargaDatos(){
            listaTipoHabitaciones=(ArrayList)tipoHabitacionData.obtenerTipoHabitaciones();
            listaHabitaciones=(ArrayList)habitacionData.obtenerHabitaciones();
            borrarFilasTabla();
            for (Habitacion r:listaHabitaciones){
                for (TipoHabitacion m:listaTipoHabitaciones){
                    String estado;
                        if(r.getId_tipoHabitacion()==m.getId()){
                            if(r.isEstado()){estado="Libre";}else{estado="Ocupada";}
                            modelo.addRow(new Object[]{r.getNroHabitacion(),estado,r.getPiso()
                            ,m.getTipo(),m.getCodigo(),m.getTipoCama(),m.getCantCamas(),m.getCantPersonasMax(),m.getPrecioPorNoche()});
                        }
                 }
            }
        }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        etiqueta = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaHabitaciones = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(etiqueta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 81, 23));

        tablaHabitaciones =new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndes){
                return false;
            }
        };
        tablaHabitaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero", "Estado", "Piso", "Tipo de Habitacion", "Codigo", "Tipo de Cama", "Nro de Camas", "Nro de Personas", "Precio por Noche"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaHabitaciones.setRowHeight(18);
        tablaHabitaciones.getTableHeader().setReorderingAllowed(false);
        tablaHabitaciones.setUpdateSelectionOnSort(false);
        jScrollPane1.setViewportView(tablaHabitaciones);
        tablaHabitaciones.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        if (tablaHabitaciones.getColumnModel().getColumnCount() > 0) {
            tablaHabitaciones.getColumnModel().getColumn(0).setMaxWidth(50);
            tablaHabitaciones.getColumnModel().getColumn(1).setMaxWidth(60);
            tablaHabitaciones.getColumnModel().getColumn(2).setMaxWidth(40);
            tablaHabitaciones.getColumnModel().getColumn(3).setMaxWidth(120);
            tablaHabitaciones.getColumnModel().getColumn(4).setMaxWidth(50);
            tablaHabitaciones.getColumnModel().getColumn(5).setMaxWidth(120);
            tablaHabitaciones.getColumnModel().getColumn(6).setMaxWidth(90);
            tablaHabitaciones.getColumnModel().getColumn(7).setMaxWidth(100);
            tablaHabitaciones.getColumnModel().getColumn(8).setMaxWidth(110);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 49, 780, 300));

        jButton1.setText("Cerrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 113, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 808, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            this.setClosed(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(VentanaHabitaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel etiqueta;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tablaHabitaciones;
    // End of variables declaration//GEN-END:variables
}
