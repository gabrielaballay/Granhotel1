package VistasHotel;

import hotelidealuno.Conexion;
import hotelidealuno.Habitacion;
import hotelidealuno.HabitacionData;
import hotelidealuno.Reserva;
import hotelidealuno.TipoHabitacion;
import hotelidealuno.TipoHabitacionData;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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
        cabezeraTabla();
        borrarFilasTabla();
        cargaDatos();
    }

    public void cabezeraTabla(){
        /*ArrayList<Object> columnas=new ArrayList<>();
        columnas.add("Codigo");
        columnas.add("Numero");
        columnas.add("Estado");
        columnas.add("Piso");
        columnas.add("Tipo Habitacion");
        columnas.add("Tipo Cama");
        columnas.add("Nro de Camas");
        columnas.add("Nro de Personas");
        columnas.add("Precio por Noche");
        
        for (Object it:columnas){
            modelo.addColumn(it);
        }
            tablaHabitaciones.setModel(modelo);*/
        
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
                        if(m.getTipo().equals(tipo)&&r.isEstado()&&r.getId_tipoHabitacion()==m.getId()){
                            estado="Libre";
                            modelo.addRow(new Object[]{m.getCodigo(),r.getNroHabitacion(),estado,r.getPiso()
                            ,m.getTipo(),m.getTipoCama(),m.getCantCamas(),m.getCantPersonasMax(),m.getPrecioPorNoche()});
                        }
                 }
            }
        }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaHabitaciones = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        etiqueta = new javax.swing.JLabel();

        setClosable(true);

        tablaHabitaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Numero", "Estado", "Piso", "Tipo de Habitacion", "Tipo de Cama", "Nro de Camas", "Nro de Personas", "Precio por Noche"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaHabitaciones.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(tablaHabitaciones);
        tablaHabitaciones.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        if (tablaHabitaciones.getColumnModel().getColumnCount() > 0) {
            tablaHabitaciones.getColumnModel().getColumn(0).setMaxWidth(50);
            tablaHabitaciones.getColumnModel().getColumn(1).setMaxWidth(50);
            tablaHabitaciones.getColumnModel().getColumn(2).setMaxWidth(60);
            tablaHabitaciones.getColumnModel().getColumn(3).setMaxWidth(40);
            tablaHabitaciones.getColumnModel().getColumn(4).setMaxWidth(120);
            tablaHabitaciones.getColumnModel().getColumn(5).setMaxWidth(120);
            tablaHabitaciones.getColumnModel().getColumn(6).setMaxWidth(90);
            tablaHabitaciones.getColumnModel().getColumn(7).setMaxWidth(100);
            tablaHabitaciones.getColumnModel().getColumn(8).setMaxWidth(110);
        }

        jButton1.setText("Aceptar");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 51));
        jLabel1.setText("Tipos de Habitaciones  :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 747, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(148, 148, 148)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(etiqueta, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(etiqueta, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel etiqueta;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tablaHabitaciones;
    // End of variables declaration//GEN-END:variables
}
