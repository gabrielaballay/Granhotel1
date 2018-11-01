package VistasHotel;

import hotelidealuno.Conexion;
import hotelidealuno.Huesped;
import hotelidealuno.HuespedData;
import hotelidealuno.Reserva;
import hotelidealuno.ReservaData;
import java.beans.PropertyVetoException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aballay Gabriel
 */
public class VentanaDatosHuesped extends javax.swing.JInternalFrame {
    private HuespedData huespedData;
    private ReservaData reservaData;
    private Conexion conexion;
    private ArrayList<Huesped> listaHuespedes;
    private ArrayList<Reserva> listaReservas;
    private DefaultTableModel modelo;
    private LocalDate fecha;
    
    public VentanaDatosHuesped() {
        try {
            initComponents();
            conexion=new Conexion("jdbc:mysql://localhost/hotelideal1","root","");
            huespedData=new HuespedData(conexion);
            reservaData=new ReservaData(conexion);
            modelo=new DefaultTableModel();
            listaHuespedes=(ArrayList)huespedData.obtenerHuespedes();
            listaReservas=(ArrayList)reservaData.obtenerResevas();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VentanaDatosHuesped.class.getName()).log(Level.SEVERE, null, ex);
        }
        armaCabezeraTabla();
        borraFilasTabla();
        cargaDatos();
    }

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
        buscarFecha = new javax.swing.JFormattedTextField();
        tituloBuscar = new javax.swing.JLabel();
        btnBuscarFecha = new javax.swing.JButton();
        etiquetaSeleccione = new javax.swing.JLabel();
        btnSeleccionarPorFecha = new javax.swing.JButton();

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
        boton2.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        boton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton2ActionPerformed(evt);
            }
        });

        boton1.setText("Seleccionar");
        boton1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        boton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton1ActionPerformed(evt);
            }
        });

        try {
            buscarFecha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        tituloBuscar.setText("Ingrese La Fecha");

        btnBuscarFecha.setText("Buscar");
        btnBuscarFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarFechaActionPerformed(evt);
            }
        });

        etiquetaSeleccione.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        etiquetaSeleccione.setForeground(new java.awt.Color(255, 0, 0));
        etiquetaSeleccione.setText("Seleccione un Huesped...");

        btnSeleccionarPorFecha.setText("Seleccionar");
        btnSeleccionarPorFecha.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        btnSeleccionarPorFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarPorFechaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addComponent(tituloBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(buscarFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(344, 344, 344)
                        .addComponent(btnBuscarFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(etiquetaSeleccione, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(180, 180, 180)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSeleccionarPorFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(tituloBuscar))
                    .addComponent(buscarFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(btnBuscarFecha)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(etiquetaSeleccione))
                    .addComponent(boton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeleccionarPorFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                .addContainerGap())
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
            }else{JOptionPane.showMessageDialog(null, "Debe Seleccionar un Huesped","ATENCION!!!",JOptionPane.WARNING_MESSAGE);}
           
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

    private void btnBuscarFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarFechaActionPerformed
        datos.setVisible(true);
        etiquetaSeleccione.setVisible(true);
        cargaDatosFechas();
    }//GEN-LAST:event_btnBuscarFechaActionPerformed

    //****Boton para seleccionar un huesped por fecha de reserva****
    private void btnSeleccionarPorFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarPorFechaActionPerformed
        int cel=datos.getSelectedRow();
        if(cel>-1){
            try {
                VistaGestionReserva.txtNombre.setText(String.valueOf(datos.getValueAt(cel, 0)));
                VistaGestionReserva.txtDni.setText(String.valueOf(datos.getValueAt(cel, 1)));
                VistaGestionReserva.txtDomicilio.setText(String.valueOf(datos.getValueAt(cel, 2)));
                VistaGestionReserva.txtCorreo.setText(String.valueOf(datos.getValueAt(cel, 3)));
                VistaGestionReserva.txtCelular.setText(String.valueOf(datos.getValueAt(cel, 4)));
                VistaGestionReserva.txtId.setText(String.valueOf(datos.getValueAt(cel, 5)));
                VistaGestionReserva.modelofecha.addRow(new Object[]{fecha});
                this.setClosed(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(VentanaDatosHuesped.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{JOptionPane.showMessageDialog(null, "Debe Seleccionar un Huesped","ATENCION!!!",JOptionPane.WARNING_MESSAGE);}
    }//GEN-LAST:event_btnSeleccionarPorFechaActionPerformed

    public void cargaDatosFechas(){
        borraFilasTabla();
        LocalDate estaFecha=LocalDate.parse((CharSequence)buscarFecha.getValue(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        for (Huesped m:listaHuespedes){
            for (Reserva r:listaReservas){
                if (estaFecha.equals(r.getFechaEntrada())&& m.getId_huesped()==r.getId_huesped()){
                    modelo.addRow(new Object[]{m.getNombre(),m.getDni(),m.getDomicilio(),m.getCorreo(),m.getCelular(),m.getId_huesped()});
                    fecha=r.getFechaEntrada();
                }
            }
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton boton1;
    public static javax.swing.JButton boton2;
    public static javax.swing.JButton btnBuscarFecha;
    public static javax.swing.JButton btnSeleccionarPorFecha;
    public static javax.swing.JFormattedTextField buscarFecha;
    public static javax.swing.JTable datos;
    public static javax.swing.JLabel etiquetaSeleccione;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel tituloBuscar;
    // End of variables declaration//GEN-END:variables
}
