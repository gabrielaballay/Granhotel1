
package VistasHotel;

import hotelidealuno.Conexion;
import hotelidealuno.HabitacionData;
import hotelidealuno.Habitacion;
import hotelidealuno.Huesped;
import hotelidealuno.HuespedData;
import hotelidealuno.ModelaTabla;
import hotelidealuno.Reserva;
import hotelidealuno.ReservaData;
import java.beans.PropertyVetoException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author Aballay Gabriel
 */
public class VistaReserva extends javax.swing.JInternalFrame {
    private int idHabitacion;
    private int idHuesped;
    private int cantPersona;
    private int valor;//verifica si hay habitaciones de un tipo
    private int nroHabitacion;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private double impTotal;
    private boolean estadoReserva;
    private HabitacionData habitacionData;
    private DefaultTableModel modelo;
    private ArrayList<Habitacion> listaHabitaciones;
    private HuespedData huespedData;
    private ReservaData reservaData;
    private Conexion conexion;

    /**
     * Creates new form VistaReserva
     */
    public VistaReserva() {
        initComponents();
        try {
            conexion=new Conexion("jdbc:mysql://localhost/hotelideal1","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VistaReserva.class.getName()).log(Level.SEVERE, null, ex);
        }
        huespedData=new HuespedData(conexion);
        modelo=new DefaultTableModel();
        habitacionData=new HabitacionData(conexion);
        reservaData=new ReservaData(conexion);
        cabezeraTabla();
        fechaReserva.setText(fechaActual());
     }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chcActiva = new javax.swing.JCheckBox();
        chcInactiva = new javax.swing.JCheckBox();
        sprCantidad = new javax.swing.JSpinner();
        btnGuardarReserva = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtImporteTotal = new java.awt.TextField();
        jLabel19 = new javax.swing.JLabel();
        btnBuscarHuesped = new javax.swing.JButton();
        cbxTipoHabitacion = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTiposHabitaciones = new javax.swing.JTable();
        btnSalirReserva = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtFechaEntrada = new javax.swing.JFormattedTextField();
        txtFechaSalida = new javax.swing.JFormattedTextField();
        sumaImporte = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        fechaReserva = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtDomicilio = new javax.swing.JTextField();
        txtDni = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtCelular = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("CREAR RESERVA");

        chcActiva.setText("Activa");
        chcActiva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chcActivaActionPerformed(evt);
            }
        });

        chcInactiva.setText("Inactiva");
        chcInactiva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chcInactivaActionPerformed(evt);
            }
        });

        sprCantidad.setModel(new javax.swing.SpinnerNumberModel(0, 0, 20, 1));
        sprCantidad.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sprCantidadStateChanged(evt);
            }
        });

        btnGuardarReserva.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnGuardarReserva.setText("Guardar Reserva");
        btnGuardarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarReservaActionPerformed(evt);
            }
        });

        jLabel14.setText("Estado de Reserva");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Cantidad de Personas");

        jLabel16.setText("Fecha de Entrada");

        jLabel17.setText("Fecha de Salida");

        txtImporteTotal.setColumns(2);
        txtImporteTotal.setEditable(false);
        txtImporteTotal.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtImporteTotal.setForeground(new java.awt.Color(0, 0, 102));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("Tipo de Habitacion");

        btnBuscarHuesped.setText("BUSCAR HUESPED");
        btnBuscarHuesped.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarHuespedActionPerformed(evt);
            }
        });

        cbxTipoHabitacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elejir tipo...", "Estándar Simple", "Doble", "Triple", "Suite Lujo", " " }));
        cbxTipoHabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipoHabitacionActionPerformed(evt);
            }
        });

        tblTiposHabitaciones =new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndes){
                return false;
            }
        };
        tblTiposHabitaciones.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblTiposHabitaciones);

        btnSalirReserva.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSalirReserva.setText("Salir");
        btnSalirReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirReservaActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/hotelucho.jpg"))); // NOI18N

        try {
            txtFechaEntrada.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtFechaSalida.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        sumaImporte.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        sumaImporte.setForeground(new java.awt.Color(255, 0, 0));
        sumaImporte.setText("Presione para Calcular Importe");
        sumaImporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sumaImporteActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Seleccione una Habitacion.....");

        fechaReserva.setEditable(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(49, 145, 49));
        jLabel4.setText("Fecha Creacion de Reserva");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Huesped"));

        jLabel11.setText("Nombre");

        jLabel12.setText("DNI");

        jLabel13.setText("Domicilio");

        jLabel20.setText("Correo");

        jLabel21.setText("Celular");

        txtNombre.setEditable(false);

        txtDomicilio.setEditable(false);

        txtDni.setEditable(false);

        txtCorreo.setEditable(false);

        txtCelular.setEditable(false);

        txtId.setEditable(false);

        jLabel2.setText("ID");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtCorreo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel12))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(311, 311, 311)
                .addComponent(btnBuscarHuesped, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(182, 182, 182)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fechaReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(142, 142, 142)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel15)
                .addGap(110, 110, 110)
                .addComponent(jLabel19)
                .addGap(71, 71, 71)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addComponent(chcActiva)
                .addGap(80, 80, 80)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(txtFechaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(sprCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(154, 154, 154)
                .addComponent(cbxTipoHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(180, 180, 180)
                .addComponent(chcInactiva)
                .addGap(70, 70, 70)
                .addComponent(jLabel17)
                .addGap(27, 27, 27)
                .addComponent(txtFechaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(jLabel3))
            .addGroup(layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sumaImporte)
                        .addGap(18, 18, 18)
                        .addComponent(txtImporteTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(239, 239, 239)
                        .addComponent(btnGuardarReserva)
                        .addGap(85, 85, 85)
                        .addComponent(btnSalirReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(btnBuscarHuesped))
                            .addComponent(fechaReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel4)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel19)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(chcActiva)
                        .addComponent(jLabel14))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel16))
                    .addComponent(txtFechaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sprCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxTipoHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(chcInactiva))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txtFechaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addComponent(jLabel3)
                .addGap(11, 11, 11)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sumaImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtImporteTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarReserva)
                    .addComponent(btnSalirReserva))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //****** Metodo que arma la cabezera de la tabla*******
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
        tblTiposHabitaciones.setModel(modelo);
        ModelaTabla mt=new ModelaTabla();
        mt.modela(tblTiposHabitaciones);
    }
        
    //******Metodo que borra las filas de la tabla******
    public void borrarFilasTabla(){
        int a =modelo.getRowCount()-1;
        for(int i=a;i>=0;i--){
            modelo.removeRow(i);
        }
    }

    //********Metodo que carga los datos en la tabla********
    public void cargaDatos(String tipo){
        listaHabitaciones=(ArrayList)habitacionData.obtenerHabitaciones();
        borrarFilasTabla();
        int valorSpinner=(int) sprCantidad.getValue();
        for (Habitacion h:listaHabitaciones){
            if (h.isEstado()){                
                if (h.getId_tipoHabitacion().getTipo().equalsIgnoreCase(tipo)&& h.getId_tipoHabitacion().getCantPersonasMax()==valorSpinner) {
                    modelo.addRow(new Object[]{h.getNroHabitacion(),"Libre",h.getPiso(),h.getId_tipoHabitacion().getTipo(),
                        h.getId_tipoHabitacion().getCodigo(),h.getId_tipoHabitacion().getTipoCama(),h.getId_tipoHabitacion().getCantCamas(),
                        h.getId_tipoHabitacion().getCantPersonasMax(),h.getId_tipoHabitacion().getPrecioPorNoche()});
                    idHabitacion=h.getIdHabitacion();
                }
            }
        }
    }
    
    
    private void btnSalirReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirReservaActionPerformed
        try {
            this.setClosed(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(VistaReserva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSalirReservaActionPerformed

    private void btnBuscarHuespedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarHuespedActionPerformed
        VentanaDatosHuesped vdh=new VentanaDatosHuesped();
        Principal.centrarVentana(vdh);
        VentanaDatosHuesped.btnBuscarHuespedYFechas.setVisible(false);
        VentanaDatosHuesped.btnBuscarFecha.setVisible(false);
        VentanaDatosHuesped.txtBuscarFecha.setVisible(false);
        VentanaDatosHuesped.tituloBuscar.setVisible(false);
        VentanaDatosHuesped.btnSeleccionarPorFecha.setVisible(false);
        VentanaDatosHuesped.buscarInforme.setVisible(false);
    }//GEN-LAST:event_btnBuscarHuespedActionPerformed

    /*
    * Metodo que comprueba si existe un tipo de habitacion 
    * por la cantidad de personas ingresadas
    */
    private void cbxTipoHabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipoHabitacionActionPerformed
        valor=0;
        String tipo;
        tipo=(String)cbxTipoHabitacion.getSelectedItem();
        listaHabitaciones=(ArrayList)habitacionData.obtenerHabitaciones();
        int valorspiner=(int)sprCantidad.getValue();
        for(Habitacion h:listaHabitaciones){
            if(tipo.equalsIgnoreCase(h.getId_tipoHabitacion().getTipo())&& valorspiner==h.getId_tipoHabitacion().getCantPersonasMax()
                    && h.isEstado()){
                valor=1;
            }
        }
        
        if(cbxTipoHabitacion.getSelectedIndex()>0){
            if(valor==1){
                borrarFilasTabla();
                cargaDatos(tipo);
            }else{
                JOptionPane.showMessageDialog(null, "No hay habitaciones "+tipo+" Disponibles\n para esa cantidad de personas","ATENCION!!!",JOptionPane.WARNING_MESSAGE);
                cbxTipoHabitacion.setSelectedIndex(0);
                borrarFilasTabla();
            }
        }
    }//GEN-LAST:event_cbxTipoHabitacionActionPerformed

    private void chcActivaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chcActivaActionPerformed
        chcInactiva.setSelected(false);        // TODO add your handling code here:
    }//GEN-LAST:event_chcActivaActionPerformed

    private void chcInactivaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chcInactivaActionPerformed
        chcActiva.setSelected(false);        // TODO add your handling code here:
    }//GEN-LAST:event_chcInactivaActionPerformed

    //********Metodo Boton Guardar Reserva **********
    //***********************************************
    private void btnGuardarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarReservaActionPerformed
        Habitacion h;
        Huesped hues;
        int cel=tblTiposHabitaciones.getSelectedRow();
        //if (chcActiva.isSelected()){estadoReserva=true;}else{estadoReserva=false;}
        if (cel>-1){
            if(idHuesped>0 && idHabitacion>0 && !txtFechaEntrada.getText().equals(null)&& !txtFechaSalida.getText().equals(null)){
                Habitacion ha=habitacionData.buscarHabitacion(nroHabitacion);
                idHabitacion=ha.getIdHabitacion();
                h=new Habitacion(idHabitacion);
                hues=new Huesped(idHuesped);
                LocalDate fechaRe=LocalDate.parse((CharSequence) fechaReserva.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                Reserva reserva=new Reserva(cantPersona,fechaEntrada,fechaSalida,impTotal,chcActiva.isSelected(),fechaRe,h,hues);
                reservaData.guardarReserva(reserva);
                int num=Integer.parseInt(String.valueOf(tblTiposHabitaciones.getValueAt(cel, 0)));
                reservaData.actualizarEstado(false, num);
                JOptionPane.showMessageDialog(null, "Se creo la reserva en forma correcta!");
                limpiar();
            }else{JOptionPane.showMessageDialog(null, "Debe llenar todos los campos!!!","ATENCION!!!",JOptionPane.WARNING_MESSAGE);}
        }else{JOptionPane.showMessageDialog(null, "Debe Seleccionar una \nHabitacion de la Lista","Atencion",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarReservaActionPerformed

    private void sumaImporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sumaImporteActionPerformed
        int suma=0;
        int cel=tblTiposHabitaciones.getSelectedRow();
        cantPersona=(int)sprCantidad.getValue();
        if(cel>-1 && cantPersona>0){
            fechaEntrada=LocalDate.parse((CharSequence) txtFechaEntrada.getValue(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            fechaSalida=LocalDate.parse((CharSequence) txtFechaSalida.getValue(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            idHuesped=Integer.parseInt(txtId.getText());
            suma=fechaSalida.getDayOfYear()-fechaEntrada.getDayOfYear();
            impTotal=  (double) tblTiposHabitaciones.getValueAt(cel, 8)*suma;
            nroHabitacion=(int) tblTiposHabitaciones.getValueAt(cel, 0);
            txtImporteTotal.setText(impTotal+"");
        }else{JOptionPane.showMessageDialog(null, "Debe Seleccionar una \nHabitacion de la Lista","Atencion",JOptionPane.WARNING_MESSAGE);}
    }//GEN-LAST:event_sumaImporteActionPerformed

    private void sprCantidadStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sprCantidadStateChanged
        cbxTipoHabitacion.setSelectedIndex(0);
        borrarFilasTabla();
    }//GEN-LAST:event_sprCantidadStateChanged
   void limpiar(){
        txtNombre.setText("");
        txtDni.setText("");
        txtDomicilio.setText("");
        txtCorreo.setText("");
        txtCelular.setText("");
        txtId.setText("");
        txtFechaEntrada.setText("");
        txtFechaSalida.setText("");
        chcActiva.setSelected(false);
        chcInactiva.setSelected(false);
        cbxTipoHabitacion.setSelectedIndex(0);
        txtImporteTotal.setText("");
        borrarFilasTabla();
   }
   public static String fechaActual(){
       Date fecha=new Date();
       SimpleDateFormat formatoFecha=new SimpleDateFormat("dd/MM/yyyy");
       return formatoFecha.format(fecha);
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarHuesped;
    private javax.swing.JButton btnGuardarReserva;
    private javax.swing.JButton btnSalirReserva;
    private javax.swing.JComboBox<String> cbxTipoHabitacion;
    private javax.swing.JCheckBox chcActiva;
    private javax.swing.JCheckBox chcInactiva;
    private javax.swing.JTextField fechaReserva;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner sprCantidad;
    private javax.swing.JButton sumaImporte;
    private javax.swing.JTable tblTiposHabitaciones;
    public static javax.swing.JTextField txtCelular;
    public static javax.swing.JTextField txtCorreo;
    public static javax.swing.JTextField txtDni;
    public static javax.swing.JTextField txtDomicilio;
    private javax.swing.JFormattedTextField txtFechaEntrada;
    private javax.swing.JFormattedTextField txtFechaSalida;
    public static javax.swing.JTextField txtId;
    private java.awt.TextField txtImporteTotal;
    public static javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
