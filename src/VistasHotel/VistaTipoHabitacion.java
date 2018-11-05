package VistasHotel;

import hotelidealuno.Conexion;
import hotelidealuno.ModelaTabla;
import hotelidealuno.TipoHabitacion;
import hotelidealuno.TipoHabitacionData;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VistaTipoHabitacion extends javax.swing.JInternalFrame {

    private int id;
    private int codigo;
    private String tipo;
    private Double precioPorNoche;
    private int cantPersonasMax;
    private int cantCamas;
    private String tipoCama;
    private TipoHabitacionData tipoHabitacionData;
    private Conexion conexion;
    ArrayList<TipoHabitacion> listaTipoHabitaciones;
    DefaultTableModel modelo;
    /**
     * Creates new form VistaTipoHabitacion
     */
    public VistaTipoHabitacion() {
        initComponents();
        try {
            conexion = new Conexion("jdbc:mysql://localhost/hotelideal1", "root", "");
            tipoHabitacionData = new TipoHabitacionData(conexion);
            modelo=new DefaultTableModel();
            cabezeraTabla();
            cargarDatos();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VistaTipoHabitacion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

        //****** Metodo que arma la cabezera de la tabla*******
    public void cabezeraTabla(){
        ArrayList<Object> columnas=new ArrayList<>();
        
        columnas.add("Id");
        columnas.add("Codigo");
        columnas.add("Tipo Habitacion");
        columnas.add("Tipo Cama");
        columnas.add("Nro de Camas");
        columnas.add("Nro de Personas");
        columnas.add("Precio por Noche");
        
        for (Object it:columnas){
            modelo.addColumn(it);
        }
        tblTiposHabitaciones.setModel(modelo);
        ModelaTabla mt=new ModelaTabla();
        mt.modelaHabitacion(tblTiposHabitaciones);
    }
        
        //******Metodo que borra las filas de la tabla******
        public void borrarFilasTabla(){
            int a =modelo.getRowCount()-1;
            for(int i=a;i>=0;i--){
                modelo.removeRow(i);
            }
        }

        //********Metodo que carga los datos en la tabla********
        public void cargarDatos(){
            listaTipoHabitaciones=(ArrayList)tipoHabitacionData.obtenerTipoHabitaciones();

            borrarFilasTabla();
            for (TipoHabitacion m:listaTipoHabitaciones){
                modelo.addRow(new Object[]{m.getId_tipoHabitacion(),m.getCodigo(),m.getTipo(),m.getTipoCama(),m.getCantCamas(),m.getCantPersonasMax(),m.getPrecioPorNoche()});
            }
            
        }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbotipo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtprecio_por_noche = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbotipo_cama = new javax.swing.JComboBox<>();
        btnguardar = new javax.swing.JButton();
        btnactualizar = new javax.swing.JButton();
        txtcantidad_personas = new javax.swing.JTextField();
        txtcantidad_camas = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnbuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTiposHabitaciones = new javax.swing.JTable();
        txtcodigo = new javax.swing.JFormattedTextField();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registro Tipo Habitaciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel2.setText("Codigo");

        jLabel3.setText("Tipo Habitacion");

        cbotipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estándar simple", "Doble", "Triple", "Suite Lujo" }));
        cbotipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbotipoActionPerformed(evt);
            }
        });

        jLabel4.setText("Precio Por Noche");

        txtprecio_por_noche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtprecio_por_nocheActionPerformed(evt);
            }
        });

        jLabel5.setText("Cantidad Personas (Max)");

        jLabel6.setText("Cantidad Camas");

        jLabel8.setText("Tipo Cama");

        cbotipo_cama.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Simples", "Queen", "King Size" }));

        btnguardar.setBackground(new java.awt.Color(102, 102, 102));
        btnguardar.setForeground(new java.awt.Color(255, 255, 255));
        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btnactualizar.setBackground(new java.awt.Color(102, 102, 102));
        btnactualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnactualizar.setText("Actualizar Precio");
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });

        txtcantidad_personas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcantidad_personasActionPerformed(evt);
            }
        });

        txtcantidad_camas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcantidad_camasActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/habitacion.jpg"))); // NOI18N

        btnbuscar.setBackground(new java.awt.Color(102, 102, 102));
        btnbuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        tblTiposHabitaciones=new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndes){
                return false;
            }
        };
        tblTiposHabitaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblTiposHabitaciones.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblTiposHabitaciones);

        txtcodigo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtcodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodigoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbotipo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbotipo_cama, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcodigo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtprecio_por_noche, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtcantidad_camas, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtcantidad_personas, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)))
                        .addGap(37, 37, 37))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(btnactualizar)
                        .addGap(48, 48, 48))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcantidad_camas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cbotipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(txtcantidad_personas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtprecio_por_noche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(cbotipo_cama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnactualizar)
                            .addComponent(btnbuscar)
                            .addComponent(btnguardar)))
                    .addComponent(jLabel1))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbotipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbotipoActionPerformed
        // TODO add your handling code here:
        cbotipo.transferFocus();
    }//GEN-LAST:event_cbotipoActionPerformed

    private void txtprecio_por_nocheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtprecio_por_nocheActionPerformed
        // TODO add your handling code here:
        txtprecio_por_noche.transferFocus();
    }//GEN-LAST:event_txtprecio_por_nocheActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // TODO add your handling code here:
        codigo = Integer.parseInt(txtcodigo.getText());
        tipo = (String) cbotipo.getSelectedItem();
        precioPorNoche = Double.parseDouble(txtprecio_por_noche.getText());
        cantPersonasMax = Integer.parseInt(txtcantidad_personas.getText());
        cantCamas = Integer.parseInt(txtcantidad_camas.getText());
        tipoCama = (String) cbotipo_cama.getSelectedItem();

        TipoHabitacion tipoHabitacion = new TipoHabitacion(codigo, tipo, precioPorNoche, cantPersonasMax, cantCamas, tipoCama);
        tipoHabitacionData.guardarTipoHabitacion(tipoHabitacion);
        JOptionPane.showMessageDialog(null, " El tipo de habitación fue registrado satisfactoriamente ");

        // En blanco los campos de texto y actualiza tabla
        txtcodigo.setText("");
        txtprecio_por_noche.setText("");
        txtcantidad_camas.setText("");
        txtcantidad_personas.setText("");
        borrarFilasTabla();
        cargarDatos();

    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
        if (txtcodigo.getText().equals("")||txtcantidad_camas.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Debe Buscar un Tipo de Habitacion primero!!!");
        }else{
            tipo = (String) cbotipo.getSelectedItem();
            precioPorNoche = Double.parseDouble(JOptionPane.showInputDialog("Ingrese nuevo Precio"));
            txtprecio_por_noche.setText(precioPorNoche+"");
            cantPersonasMax = Integer.parseInt(txtcantidad_personas.getText());
            cantCamas = Integer.parseInt(txtcantidad_camas.getText());
            tipoCama = (String) cbotipo_cama.getSelectedItem();
            codigo=Integer.parseInt(txtcodigo.getText());
        }        
        if (codigo!=0) {
        // actualiza precio     
            TipoHabitacion tipoHabitacion = new TipoHabitacion(id,codigo, tipo, precioPorNoche, cantPersonasMax, cantCamas, tipoCama);
            tipoHabitacionData.actualizarTipoHabitacion(tipoHabitacion);
            JOptionPane.showMessageDialog(null, " Datos Actualizado ");
            

        // En blanco los campos de texto y actualiza tabla
            txtcodigo.setText("");
            txtprecio_por_noche.setText("");
            txtcantidad_camas.setText("");
            txtcantidad_personas.setText("");
            borrarFilasTabla();
            cargarDatos();
        }
    }//GEN-LAST:event_btnactualizarActionPerformed

    private void txtcantidad_camasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcantidad_camasActionPerformed
        // TODO add your handling code here:
        txtcantidad_camas.transferFocus();
    }//GEN-LAST:event_txtcantidad_camasActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        // TODO add your handling code here:
        String codigo = JOptionPane.showInputDialog("Ingrese Codigo de Habitacion");
        if(codigo!=null){
            int cod=Integer.parseInt(codigo);
            TipoHabitacion tipoHabitacion = tipoHabitacionData.buscarTipoHabitacion(cod);
            txtcodigo.setText(tipoHabitacion.getCodigo()+"");
            txtprecio_por_noche.setText(tipoHabitacion.getPrecioPorNoche()+"");
            txtcantidad_camas.setText(tipoHabitacion.getCantCamas()+"");
            txtcantidad_personas.setText(tipoHabitacion.getCantPersonasMax()+"");
            tipo=tipoHabitacion.getTipo();
            id=tipoHabitacion.getId_tipoHabitacion();
            tipoCama=tipoHabitacion.getTipoCama();
            cbotipo_cama.setSelectedItem(tipoCama);
            cbotipo.setSelectedItem(tipo);
        }
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void txtcantidad_personasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcantidad_personasActionPerformed
        // TODO add your handling code here:
        txtcantidad_personas.transferFocus();
    }//GEN-LAST:event_txtcantidad_personasActionPerformed

    private void txtcodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodigoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JComboBox<String> cbotipo;
    private javax.swing.JComboBox<String> cbotipo_cama;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTiposHabitaciones;
    private javax.swing.JTextField txtcantidad_camas;
    private javax.swing.JTextField txtcantidad_personas;
    private javax.swing.JFormattedTextField txtcodigo;
    private javax.swing.JTextField txtprecio_por_noche;
    // End of variables declaration//GEN-END:variables
}
