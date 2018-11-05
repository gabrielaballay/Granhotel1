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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author Aballay Gabriel
 */
public class VistaHabitaciones extends javax.swing.JInternalFrame {
    //****Declaracion de los atributos de la clase****
    private int idHabitacion;
    private int nroHabitacion;
    private int piso;
    private int id_tipoHabitacion;
    private boolean estado;
    private TipoHabitacionData tipoHabitacionData;
    private HabitacionData habitacionData;
    private Conexion conexion;
    ArrayList<TipoHabitacion> listaTipoHabitaciones;
    DefaultTableModel modelo;

    /**
     * Creates new form Habitaciones
     */
    public VistaHabitaciones() {
        initComponents();
        modelo=new DefaultTableModel();
        try {
            conexion=new Conexion("jdbc:mysql://localhost/hotelideal1","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VistaHabitaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        tipoHabitacionData=new TipoHabitacionData(conexion);
        habitacionData=new HabitacionData(conexion);
        cabezeraTabla();
        cargaDatos("Estándar simple");
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
        public void cargaDatos(String tipo){
            listaTipoHabitaciones=(ArrayList)tipoHabitacionData.obtenerTipoHabitaciones();
            borrarFilasTabla();
            for (TipoHabitacion m:listaTipoHabitaciones){
                if (m.getTipo().equalsIgnoreCase(tipo)){
                    modelo.addRow(new Object[]{m.getId_tipoHabitacion(),m.getCodigo(),m.getTipo(),m.getTipoCama(),m.getCantCamas(),m.getCantPersonasMax(),m.getPrecioPorNoche()});
                }
            }
        }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPiso = new javax.swing.JTextField();
        txtNroHabitacion = new javax.swing.JTextField();
        cbxTipoHabitacion = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTiposHabitaciones = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        chcLibre = new javax.swing.JCheckBox();
        chcOcupada = new javax.swing.JCheckBox();
        btnBorra = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setClosable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Habitaciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel1.setText("Numero Habitacion");

        jLabel2.setText("Piso");

        jLabel3.setText("Estado");

        jLabel4.setText("Tipo Habitacion");

        cbxTipoHabitacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estándar simple", "Doble", "Triple", "Suite Lujo" }));
        cbxTipoHabitacion.setToolTipText("");
        cbxTipoHabitacion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cbxTipoHabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipoHabitacionActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.setPreferredSize(new java.awt.Dimension(80, 25));
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
        });
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.setPreferredSize(new java.awt.Dimension(80, 25));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.setPreferredSize(new java.awt.Dimension(80, 25));
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        tblTiposHabitaciones =new javax.swing.JTable(){
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
        tblTiposHabitaciones.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblTiposHabitaciones.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblTiposHabitaciones);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/habitacion.jpg"))); // NOI18N

        chcLibre.setText("Libre");
        chcLibre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chcLibreActionPerformed(evt);
            }
        });

        chcOcupada.setText("Ocupada");
        chcOcupada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chcOcupadaActionPerformed(evt);
            }
        });

        btnBorra.setText("Borrar");
        btnBorra.setPreferredSize(new java.awt.Dimension(80, 25));
        btnBorra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorraActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel6.setText("Seleccione una Habitacion....");

        jButton1.setText("Salir");
        jButton1.setPreferredSize(new java.awt.Dimension(80, 25));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(btnBorra, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(59, 59, 59)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2))
                                .addGap(37, 37, 37)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPiso, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxTipoHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(chcLibre)
                                        .addGap(32, 32, 32)
                                        .addComponent(chcOcupada))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(20, 20, 20)
                                .addComponent(txtNroHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtNroHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(chcLibre)
                                    .addComponent(chcOcupada))))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtPiso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cbxTipoHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBorra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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
    
    //****** Metodo del combo box*******
    private void cbxTipoHabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipoHabitacionActionPerformed
        String tipo;
        tipo=(String)cbxTipoHabitacion.getSelectedItem();
        borrarFilasTabla();
        cargaDatos(tipo);
    }//GEN-LAST:event_cbxTipoHabitacionActionPerformed
    
    //************Metodo del Boton Guardar*************
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        TipoHabitacion th;
        int cel=tblTiposHabitaciones.getSelectedRow();
        //********Consulta que los campos contegan algun valor
        if (txtNroHabitacion.getText().equals("")||txtPiso.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
        }else{
            if (cel!=-1){ //*****Consulta almenos una fila de la tabla este seleccionada*********
                if (chcLibre.isSelected()){
                    estado=true;
                }else{estado=false;}
                id_tipoHabitacion=(int) tblTiposHabitaciones.getValueAt(cel, 0);
                th=new TipoHabitacion(id_tipoHabitacion);
                nroHabitacion=Integer.parseInt(txtNroHabitacion.getText());
                piso=Integer.parseInt(txtPiso.getText());
                Habitacion habitacion=new Habitacion(nroHabitacion,piso,estado,th);
                habitacionData.guardarHabitacion(habitacion);
                
                JOptionPane.showMessageDialog(rootPane, "La Habitacion Nro "+nroHabitacion+" se Guardo Correctamente");
                //*****Limpia el formulario
                    txtNroHabitacion.setText("");
                    txtPiso.setText("");
                    chcLibre.setSelected(false);
                    chcOcupada.setSelected(false);
                    cargaDatos("Estándar simple");
                    cbxTipoHabitacion.setSelectedIndex(0);
            }else{JOptionPane.showMessageDialog(null, "Debe Selecccionar una habitacion de la lista");}
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void chcLibreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chcLibreActionPerformed
        chcOcupada.setSelected(false);        // TODO add your handling code here:
    }//GEN-LAST:event_chcLibreActionPerformed

    private void chcOcupadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chcOcupadaActionPerformed
        chcLibre.setSelected(false);// TODO add your handling code here:
    }//GEN-LAST:event_chcOcupadaActionPerformed

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked

    }//GEN-LAST:event_btnGuardarMouseClicked

    //********** Metodo del Boton Buscar **********
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // se solicita un Nro de habitacion existente en la base de datos
        String buscarHab=JOptionPane.showInputDialog("Ingrese Nro valido de Habitacion a buscar");
        if (buscarHab!=null){
            int busca=Integer.parseInt(buscarHab);
            Habitacion ha=habitacionData.buscarHabitacion(busca);
            //*******Consulta que habitacion sea diferente de null para asegurar que devuelva la habiacion deseada
            if(ha!=null){
                txtNroHabitacion.setText(ha.getNroHabitacion()+"");
                if(ha.isEstado()){
                    chcLibre.setSelected(true);
                    chcOcupada.setSelected(false);
                }else{
                    chcOcupada.setSelected(true);
                    chcLibre.setSelected(false);
                }
                txtPiso.setText(ha.getPiso()+"");
                idHabitacion=ha.getIdHabitacion();
                String tipo=ha.getId_tipoHabitacion().getTipo();
                cbxTipoHabitacion.setSelectedItem(tipo);
                borrarFilasTabla();
                modelo.addRow(new Object[]{ha.getId_tipoHabitacion().getId_tipoHabitacion(),ha.getId_tipoHabitacion().getCodigo(),
                    ha.getId_tipoHabitacion().getTipo(),ha.getId_tipoHabitacion().getTipoCama(),ha.getId_tipoHabitacion().getCantCamas(),
                    ha.getId_tipoHabitacion().getCantPersonasMax(),ha.getId_tipoHabitacion().getPrecioPorNoche()});
            
            }else{JOptionPane.showMessageDialog(null, "hbitacion no existe");}
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    //********Metodo Boton Modificar********* 
    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        TipoHabitacion th;
        int cel=tblTiposHabitaciones.getSelectedRow();
        //********Consulta que los campos contegan algun valor
        if (txtNroHabitacion.getText().equals("")||txtPiso.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Debe Buscar una Habitacion para Modificar");
            btnGuardar.setSelected(false);
        }else{
            //*****Consulta almenos una fila de la tabla este seleccionada*********
            if (cel!=-1){
                if (chcLibre.isSelected()){
                    estado=true;
                }else{estado=false;}
                nroHabitacion=Integer.parseInt(txtNroHabitacion.getText());
                piso=Integer.parseInt(txtPiso.getText());
                id_tipoHabitacion=(int) tblTiposHabitaciones.getValueAt(cel, 0);
                th=new TipoHabitacion(id_tipoHabitacion);
                Habitacion habitacion=new Habitacion(idHabitacion,nroHabitacion,piso,estado,th);
                habitacionData.actualizarHabitacion(habitacion);
                JOptionPane.showMessageDialog(rootPane, "La Habitacion Nro "+nroHabitacion+" se Modifico Correctamente");
                //*****Limpia el formulario
                    txtNroHabitacion.setText("");
                    txtPiso.setText("");
                    chcLibre.setSelected(false);
                    chcOcupada.setSelected(false);
                    cargaDatos("Estándar simple");
                    cbxTipoHabitacion.setSelectedIndex(0);
            }else{JOptionPane.showMessageDialog(null, "Debe Selecccionar Un tipo de habitacion de la lista");}
        }
    }//GEN-LAST:event_btnModificarActionPerformed
    
    //******Metodo del boton Borrar******
    private void btnBorraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorraActionPerformed
        
        if (txtNroHabitacion.getText().equals("")||txtPiso.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Debe Buscar una Habitacion para Borrar");
        }else{
            int confirma=JOptionPane.showConfirmDialog(rootPane, "Seguro que desea borrar esta habitacion");
            if (confirma==0){
                int numero=Integer.parseInt(txtNroHabitacion.getText());
                habitacionData.borrarHabitacion(numero);

                //LIMPIAR FORMULARIO
                    JOptionPane.showMessageDialog(rootPane, "La Habitacion Nro "+numero+" se Borro Correctamente");
                    txtNroHabitacion.setText("");
                    txtPiso.setText("");
                    chcLibre.setSelected(false);
                    chcOcupada.setSelected(false);
                    cargaDatos("Estándar simple");
                    cbxTipoHabitacion.setSelectedIndex(0);
            }   
        }
    }//GEN-LAST:event_btnBorraActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            this.setClosed(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(VistaHabitaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorra;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> cbxTipoHabitacion;
    private javax.swing.JCheckBox chcLibre;
    private javax.swing.JCheckBox chcOcupada;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTiposHabitaciones;
    private javax.swing.JTextField txtNroHabitacion;
    private javax.swing.JTextField txtPiso;
    // End of variables declaration//GEN-END:variables
}
