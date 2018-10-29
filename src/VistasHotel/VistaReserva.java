/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VistasHotel;

import hotelidealuno.Conexion;
import hotelidealuno.HabitacionData;
import hotelidealuno.Habitacion;
import hotelidealuno.Huesped;
import hotelidealuno.HuespedData;
import hotelidealuno.Reserva;
import hotelidealuno.ReservaData;
import hotelidealuno.TipoHabitacion;
import hotelidealuno.TipoHabitacionData;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author asus
 */
public class VistaReserva extends javax.swing.JInternalFrame {
    private int idHabitacion;
    private int idHuesped;
    private int cantPersona;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private double impTotal;
    private boolean estadoReserva;
    private TipoHabitacionData tipoHabitacionData;
    private HabitacionData habitacionData;
    private ArrayList<TipoHabitacion> listaTipoHabitaciones;
    private DefaultTableModel modelo;
    private ArrayList<Habitacion> listaHabitaciones;
    private HuespedData huespedData;
    private ReservaData reservaData;
    private Conexion conexion;
    private int nroHabitacion;

    /**1
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
        tipoHabitacionData=new TipoHabitacionData(conexion);
        habitacionData=new HabitacionData(conexion);
        reservaData=new ReservaData(conexion);
        cabezeraTabla();
        cargaDatos("Estándar simple");

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
        cbxTipoHabitacion = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTiposHabitaciones = new javax.swing.JTable();
        btnSalirReserva = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtFechaEntrada = new javax.swing.JFormattedTextField();
        txtFechaSalida = new javax.swing.JFormattedTextField();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

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

        sprCantidad.setModel(new javax.swing.SpinnerNumberModel(1, 1, 20, 1));

        btnGuardarReserva.setText("Guardar Reserva");
        btnGuardarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarReservaActionPerformed(evt);
            }
        });

        jLabel14.setText("Estado de Reserva");

        jLabel15.setText("Cantidad de Personas");

        jLabel16.setText("Fecha de Entrada");

        jLabel17.setText("Fecha de Salida");

        jLabel19.setText("Tipo de Habitacion");

        btnBuscarHuesped.setText("BUSCAR HUESPED");
        btnBuscarHuesped.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarHuespedActionPerformed(evt);
            }
        });

        jLabel11.setText("Nombre");

        jLabel12.setText("DNI");

        jLabel13.setText("Domicilio");

        jLabel20.setText("Correo");

        jLabel21.setText("Celular");

        txtNombre.setEditable(false);

        txtDomicilio.setEditable(false);

        txtDni.setEditable(false);
        txtDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDniActionPerformed(evt);
            }
        });

        txtCorreo.setEditable(false);

        txtCelular.setEditable(false);

        cbxTipoHabitacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estándar Simple", "Doble", "Triple", "Suite Lujo", " " }));
        cbxTipoHabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipoHabitacionActionPerformed(evt);
            }
        });

        tblTiposHabitaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTiposHabitacionesMouseClicked(evt);
            }
        });
        tblTiposHabitaciones.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblTiposHabitacionesKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblTiposHabitacionesKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tblTiposHabitacionesKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(tblTiposHabitaciones);

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
        txtFechaEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaEntradaActionPerformed(evt);
            }
        });

        try {
            txtFechaSalida.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        txtId.setEditable(false);

        jLabel2.setText("ID");

        jButton1.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 0, 0));
        jButton1.setText("Calcular Importe Total");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardarReserva)
                        .addGap(365, 365, 365)
                        .addComponent(btnSalirReserva))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21))
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                            .addComponent(txtDomicilio)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(44, 44, 44))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addComponent(btnBuscarHuesped, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(128, 128, 128))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(cbxTipoHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sprCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chcInactiva)
                            .addComponent(chcActiva))
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFechaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFechaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(277, 277, 277)
                .addComponent(jButton1)
                .addGap(20, 20, 20)
                .addComponent(txtImporteTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBuscarHuesped)
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(jLabel15)
                            .addComponent(sprCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chcActiva)
                            .addComponent(jLabel14)
                            .addComponent(cbxTipoHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addComponent(chcInactiva))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtFechaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFechaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(txtImporteTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarReserva)
                    .addComponent(btnSalirReserva))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //****** Metodo que arma la cabezera de la tabla*******
    public void cabezeraTabla(){
        ArrayList<Object> columnas=new ArrayList<>();
        
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
        tblTiposHabitaciones.setModel(modelo);
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
            listaTipoHabitaciones=(ArrayList)tipoHabitacionData.obtenerTipoHabitaciones();
            listaHabitaciones=(ArrayList)habitacionData.obtenerHabitaciones();
            borrarFilasTabla();
            int valorSpinner=(int) sprCantidad.getValue();
            for (TipoHabitacion m:listaTipoHabitaciones){
                for (Habitacion hab:listaHabitaciones){
                    if (hab.isEstado()){                
                        if (m.getId()==hab.getId_tipoHabitacion()&& m.getTipo().equalsIgnoreCase(tipo)&& m.getCantPersonasMax()==valorSpinner) {
                                    modelo.addRow(new Object[]{m.getCodigo(),hab.getNroHabitacion(),"Libre",hab.getPiso(),m.getTipo(),m.getTipoCama(),m.getCantCamas(),m.getCantPersonasMax(),m.getPrecioPorNoche()});
                                    idHabitacion=hab.getIdHabitacion();
                        }
                    }
                }
            }
            
        }
    
    
    private void txtDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDniActionPerformed

    private void btnSalirReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirReservaActionPerformed
        try {
            this.setClosed(true);        // TODO add your handling code here:
        } catch (PropertyVetoException ex) {
            Logger.getLogger(VistaReserva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSalirReservaActionPerformed

    private void btnBuscarHuespedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarHuespedActionPerformed
        VentanaDatosHuesped vdh=new VentanaDatosHuesped();
        Principal.escritorio.add(vdh);
        vdh.setLocation(450, 200);
        vdh.toFront();
        vdh.setVisible(true);
        VentanaDatosHuesped.boton2.setVisible(true);
        VentanaDatosHuesped.boton1.setVisible(false);
    }//GEN-LAST:event_btnBuscarHuespedActionPerformed

    private void cbxTipoHabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipoHabitacionActionPerformed
        String tipo;
        tipo=(String)cbxTipoHabitacion.getSelectedItem();
        borrarFilasTabla();
        cargaDatos(tipo);
    }//GEN-LAST:event_cbxTipoHabitacionActionPerformed

    private void chcActivaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chcActivaActionPerformed
        chcInactiva.setSelected(false);        // TODO add your handling code here:
    }//GEN-LAST:event_chcActivaActionPerformed

    private void chcInactivaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chcInactivaActionPerformed
        chcActiva.setSelected(false);        // TODO add your handling code here:
    }//GEN-LAST:event_chcInactivaActionPerformed

    private void btnGuardarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarReservaActionPerformed
        if (chcActiva.isSelected()){estadoReserva=true;}else{estadoReserva=false;}
        
        if(idHuesped>0 && idHabitacion>0 && !txtFechaEntrada.getText().equals(null)&& !txtFechaSalida.getText().equals(null)){
            Habitacion ha=habitacionData.buscarHabitacion(nroHabitacion);
            idHabitacion=ha.getIdHabitacion();
            Reserva reserva=new Reserva(cantPersona,fechaEntrada,fechaSalida,impTotal,estadoReserva,idHabitacion,idHuesped);
            reservaData.guardarReserva(reserva);
            reservaData.actualizarEstado(idHabitacion, false);
            JOptionPane.showMessageDialog(null, "Se creo la reserva en forma correcta!");
            limpiar();
        }else{JOptionPane.showMessageDialog(null, "Debe llenar todos los campos!!!");}
    }//GEN-LAST:event_btnGuardarReservaActionPerformed

    private void txtFechaEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaEntradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaEntradaActionPerformed

    private void tblTiposHabitacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTiposHabitacionesMouseClicked
    }//GEN-LAST:event_tblTiposHabitacionesMouseClicked

    private void tblTiposHabitacionesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblTiposHabitacionesKeyTyped
    }//GEN-LAST:event_tblTiposHabitacionesKeyTyped

    private void tblTiposHabitacionesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblTiposHabitacionesKeyPressed
    }//GEN-LAST:event_tblTiposHabitacionesKeyPressed

    private void tblTiposHabitacionesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblTiposHabitacionesKeyReleased
    }//GEN-LAST:event_tblTiposHabitacionesKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int suma=0;
        int cel=tblTiposHabitaciones.getSelectedRow();
        cantPersona=(int)sprCantidad.getValue();
        fechaEntrada=LocalDate.parse((CharSequence) txtFechaEntrada.getValue(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        fechaSalida=LocalDate.parse((CharSequence) txtFechaSalida.getValue(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        idHuesped=Integer.parseInt(txtId.getText());
        suma=fechaSalida.getDayOfYear()-fechaEntrada.getDayOfYear();
        impTotal=  (double) tblTiposHabitaciones.getValueAt(cel, 8)*suma;
        nroHabitacion=(int) tblTiposHabitaciones.getValueAt(cel, 1);
        txtImporteTotal.setText(impTotal+"");
    }//GEN-LAST:event_jButton1ActionPerformed
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
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarHuesped;
    private javax.swing.JButton btnGuardarReserva;
    private javax.swing.JButton btnSalirReserva;
    private javax.swing.JComboBox<String> cbxTipoHabitacion;
    private javax.swing.JCheckBox chcActiva;
    private javax.swing.JCheckBox chcInactiva;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner sprCantidad;
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
