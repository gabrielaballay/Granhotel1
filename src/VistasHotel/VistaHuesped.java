/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VistasHotel;

import hotelidealuno.Conexion;
import hotelidealuno.Huesped;
import hotelidealuno.HuespedData;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aballay Gabriel
 */
public class VistaHuesped extends javax.swing.JInternalFrame {
    //Declaracion de Variables
    private String nombre, direccion,correo;
    private int dni;
    private long celular;
    private int id;
    HuespedData huespedData;
    Conexion conexion;
    ArrayList<Huesped> listaHuespedes;
    DefaultTableModel modelo;
    /**
     * Creates new form VistaHuesped
     */
    public VistaHuesped() {
        initComponents();
        try {
            conexion=new Conexion("jdbc:mysql://localhost/hotelideal1","root","");
            huespedData=new HuespedData(conexion);
            modelo=new DefaultTableModel();
            listaHuespedes=(ArrayList)huespedData.obtenerHuespedes();
            armaCabezeraTabla();
            cargaDatos();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VistaHuesped.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtNombre = new javax.swing.JTextField();
        jtDni = new javax.swing.JTextField();
        jtDireccion = new javax.swing.JTextField();
        jtCelular = new javax.swing.JTextField();
        jtCorreo = new javax.swing.JTextField();
        jbGuardar = new javax.swing.JButton();
        jbActualizar = new javax.swing.JButton();
        jbBuscar = new javax.swing.JButton();
        jbBorrar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        button1 = new java.awt.Button();
        jScrollPane2 = new javax.swing.JScrollPane();
        jHuespes = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();

        setTitle("Registrar Huespedes");

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setText("Nombre");

        jLabel2.setText("DNI");

        jLabel3.setText("Direccion");

        jLabel4.setText("Celular");

        jLabel5.setText("Correo");

        jtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtNombreActionPerformed(evt);
            }
        });

        jtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtDireccionActionPerformed(evt);
            }
        });

        jbGuardar.setText("Guardar");
        jbGuardar.setPreferredSize(new java.awt.Dimension(79, 24));
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jbActualizar.setText("Actualizar");
        jbActualizar.setEnabled(false);
        jbActualizar.setPreferredSize(new java.awt.Dimension(80, 24));
        jbActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActualizarActionPerformed(evt);
            }
        });

        jbBuscar.setText("Buscar");
        jbBuscar.setPreferredSize(new java.awt.Dimension(79, 24));
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jbBorrar.setText("Borrar");
        jbBorrar.setEnabled(false);
        jbBorrar.setPreferredSize(new java.awt.Dimension(79, 24));
        jbBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBorrarActionPerformed(evt);
            }
        });

        jLabel6.setText("Ej.: nombrecorreo@ulp.edu.ar");

        jLabel7.setText("ingrese sin 0 y 15 ej.: 2664456789");

        jLabel8.setText("ingrese sin puntos ej.: 32456789");

        button1.setLabel("Cerrar");
        button1.setPreferredSize(new java.awt.Dimension(79, 24));
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        jHuespes.setModel(new javax.swing.table.DefaultTableModel(
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
        jHuespes.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                jHuespesAncestorMoved(evt);
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jHuespes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jHuespesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jHuespes);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/Registrar Huesped.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jbGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(80, 80, 80)
                                .addComponent(jbActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addGap(37, 37, 37)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel8))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(9, 9, 9)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jbBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7)))))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(25, 25, 25)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jLabel6))))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addGap(31, 31, 31)
                                            .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel5))
                                    .addGap(122, 122, 122)))))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void armaCabezeraTabla(){
        ArrayList<Object> columnas=new ArrayList<>();
        
        columnas.add("Nombre");
        columnas.add("DNI");
        columnas.add("Domicilio");
        columnas.add("Correo");
        columnas.add("Celular");
        
        for (Object it:columnas){
            modelo.addColumn(it);
        }
        jHuespes.setModel(modelo);
        }
        
        public void borraFilasTabla(){
            int a =modelo.getRowCount()-1;
            for(int i=a;i>=0;i--){
                modelo.removeRow(i);
            }
        }

        public void cargaDatos(){
            borraFilasTabla();
            for (Huesped m:listaHuespedes){
                modelo.addRow(new Object[]{m.getNombre(),m.getDni(),m.getDomicilio(),m.getCorreo(),m.getCelular()});
            }
        }
    
    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed

        //**** TRASPASO DE VARIABLES BOTON GUARDAR
        nombre=jtNombre.getText();
        dni=Integer.parseInt(jtDni.getText());
        direccion=jtDireccion.getText();
        correo=jtCorreo.getText();
        celular= Long.parseLong(jtCelular.getText());

        //**** CREACCION DE UN NUEVO HUESPED Y LLAMADA AL METODO guardarHuesped()
        Huesped huesped=new Huesped(nombre,dni,direccion,correo,celular);
        huespedData.guardarHuesped(huesped);
        JOptionPane.showMessageDialog(null, "Se Guardo Correctamente!!!");

        //**** LIMPIAR CASILLAS DE TEXTO
        jtNombre.setText(""); jtDni.setText(""); jtDireccion.setText("");
        jtCorreo.setText(""); jtCelular.setText("");
        listaHuespedes=(ArrayList)huespedData.obtenerHuespedes();
        cargaDatos();
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarActionPerformed

        //**** TRASPASO DE VARIABLES BOTON ACTUALIZAR
        nombre=jtNombre.getText();
        dni=Integer.parseInt(jtDni.getText());
        direccion=jtDireccion.getText();
        correo=jtCorreo.getText();
        celular= Long.parseLong(jtCelular.getText());

        //**** CREACCION DE UN NUEVO HUESPED Y LLAMADA AL METODO actualizarHuesped()
        if (!nombre.equalsIgnoreCase("")){
            Huesped huesped=new Huesped(id,nombre,dni,direccion,correo,celular);
            huespedData.actualizarHusped(huesped);
            JOptionPane.showMessageDialog(null, "Se Actualizo Correctamente!!!");
        }
        //**** LIMPIAR CASILLAS DE TEXTO
        jtNombre.setText(""); jtDni.setText(""); jtDireccion.setText("");
        jtCorreo.setText(""); jtCelular.setText("");

        //**** Se bloquean los botones actualizar y borrar
        jbActualizar.setEnabled(false);
        jbBorrar.setEnabled(false);
        listaHuespedes=(ArrayList)huespedData.obtenerHuespedes();
        cargaDatos();
    }//GEN-LAST:event_jbActualizarActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed

        // se solicita un dni de un Huesped a buscar existente en la base de datos
        String dniBuscar=JOptionPane.showInputDialog("Ingrese DNI del Huesped");
        if(dniBuscar!=null){
            int dni=Integer.parseInt(dniBuscar);
            Huesped huesped=huespedData.buscarHuesped(dni);
            if(huesped!=null){
                //Se activa los botones actualizar y borrar
                jbActualizar.setEnabled(true);
                jbBorrar.setEnabled(true);

                //TRASPASO DE VARIABLES
                jtNombre.setText(huesped.getNombre());
                jtDni.setText(huesped.getDni()+"");
                jtDireccion.setText(huesped.getDomicilio());
                jtCorreo.setText(huesped.getCorreo());
                jtCelular.setText(huesped.getCelular()+"");
                id=huesped.getId_huesped();
            }
        }
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBorrarActionPerformed
        int confirma=JOptionPane.showConfirmDialog(rootPane, "Seguro que desea borrar");
        if (confirma==0){
            int dni=Integer.parseInt(jtDni.getText());
            huespedData.borrarHuesped(dni);

            //LIMPIAR CASILLAS DE TEXTO
            jtNombre.setText(""); jtDni.setText(""); jtDireccion.setText("");
            jtCorreo.setText(""); jtCelular.setText("");

            // Se bloquean los botones actualizar y borrar
            jbActualizar.setEnabled(false);
            jbBorrar.setEnabled(false);
            listaHuespedes=(ArrayList)huespedData.obtenerHuespedes();
            cargaDatos();
        }
    }//GEN-LAST:event_jbBorrarActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        try {
            this.setClosed(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(VistaHuesped.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_button1ActionPerformed

    private void jHuespesAncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jHuespesAncestorMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jHuespesAncestorMoved

    private void jHuespesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jHuespesMouseClicked
        /*int cel=jHuespes.getSelectedRow();
        jtNombre.setText(String.valueOf(jHuespes.getValueAt(cel, 0)));
        jtDni.setText(String.valueOf(jHuespes.getValueAt(cel, 1)));
        jtDireccion.setText(String.valueOf(jHuespes.getValueAt(cel, 2)));
        jtCorreo.setText(String.valueOf(jHuespes.getValueAt(cel, 3)));
        jtCelular.setText(String.valueOf(jHuespes.getValueAt(cel, 4)));
        */
    }//GEN-LAST:event_jHuespesMouseClicked

    private void jtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtNombreActionPerformed

    private void jtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtDireccionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private javax.swing.JTable jHuespes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbActualizar;
    private javax.swing.JButton jbBorrar;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JTextField jtCelular;
    private javax.swing.JTextField jtCorreo;
    private javax.swing.JTextField jtDireccion;
    private javax.swing.JTextField jtDni;
    private javax.swing.JTextField jtNombre;
    // End of variables declaration//GEN-END:variables
}
