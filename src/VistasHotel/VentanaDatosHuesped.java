/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VistasHotel;

import hotelidealuno.Conexion;
import hotelidealuno.Huesped;
import hotelidealuno.HuespedData;
import hotelidealuno.Reserva;
import hotelidealuno.ReservaData;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class VentanaDatosHuesped extends javax.swing.JInternalFrame {
    private HuespedData huespedData;
    private Conexion conexion;
    private ArrayList<Huesped> listaHuespedes;
    private DefaultTableModel modelo;
    /**
     * Creates new form VentanaDatosHuesped
     */
    public VentanaDatosHuesped() {
        try {
            initComponents();
            conexion=new Conexion("jdbc:mysql://localhost/hotelideal1","root","");
            huespedData=new HuespedData(conexion);
            modelo=new DefaultTableModel();
            listaHuespedes=(ArrayList)huespedData.obtenerHuespedes();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VentanaDatosHuesped.class.getName()).log(Level.SEVERE, null, ex);
        }
        armaCabezeraTabla();
        borraFilasTabla();
        cargaDatos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    public void armaCabezeraTabla(){
        ArrayList<Object> columnas=new ArrayList<>();
        
        columnas.add("Nombre");
        columnas.add("DNI");
        columnas.add("Domicilio");
        columnas.add("Correo");
        columnas.add("Celular");
        columnas.add("ID");
        for (Object it:columnas){
            modelo.addColumn(it);
        }
            datos.setModel(modelo);
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
                modelo.addRow(new Object[]{m.getNombre(),m.getDni(),m.getDomicilio(),m.getCorreo(),m.getCelular(),m.getId_huesped()});
            }
        }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        datos = new javax.swing.JTable();
        boton2 = new javax.swing.JButton();
        boton1 = new javax.swing.JButton();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 153, 153));
        setClosable(true);

        datos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(datos);

        boton2.setText("Seleccionar");
        boton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton2ActionPerformed(evt);
            }
        });

        boton1.setText("Seleccionar");
        boton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton1ActionPerformed(evt);
            }
        });

        try {
            jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel1.setText("Ingrese La Fecha");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(28, 28, 28)
                            .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(319, 319, 319)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(boton1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(boton2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(boton1))
                    .addComponent(boton2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getAccessibleContext().setAccessibleDescription("VantanaDatosHuesped");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton2ActionPerformed
        try {
            int cel=datos.getSelectedRow();
            if(cel>-1){
                VistaReserva.txtNombre.setText(String.valueOf(datos.getValueAt(cel, 0)));
                VistaReserva.txtDni.setText(String.valueOf(datos.getValueAt(cel, 1)));
                VistaReserva.txtDomicilio.setText(String.valueOf(datos.getValueAt(cel, 2)));
                VistaReserva.txtCorreo.setText(String.valueOf(datos.getValueAt(cel, 3)));
                VistaReserva.txtCelular.setText(String.valueOf(datos.getValueAt(cel, 4)));
                VistaReserva.txtId.setText(String.valueOf(datos.getValueAt(cel, 5)));
                 this.setClosed(true);
            }else{JOptionPane.showMessageDialog(null, "Debe Seleccionar un Huesped");}
           
        } catch (PropertyVetoException ex) {
            Logger.getLogger(VentanaDatosHuesped.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_boton2ActionPerformed

    private void boton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton1ActionPerformed
        
            int cel=datos.getSelectedRow();
            if(cel>-1){
                try {
                    VistaGestionReserva.txtNombre.setText(String.valueOf(datos.getValueAt(cel, 0)));
                    VistaGestionReserva.txtDni.setText(String.valueOf(datos.getValueAt(cel, 1)));
                    VistaGestionReserva.txtDomicilio.setText(String.valueOf(datos.getValueAt(cel, 2)));
                    VistaGestionReserva.txtCorreo.setText(String.valueOf(datos.getValueAt(cel, 3)));
                    VistaGestionReserva.txtCelular.setText(String.valueOf(datos.getValueAt(cel, 4)));
                    VistaGestionReserva.txtId.setText(String.valueOf(datos.getValueAt(cel, 5)));
                    this.setClosed(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(VentanaDatosHuesped.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    }//GEN-LAST:event_boton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton boton1;
    public static javax.swing.JButton boton2;
    public static javax.swing.JTable datos;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
