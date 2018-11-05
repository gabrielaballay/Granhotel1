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
    private LocalDate fecha;
    private HuespedData huespedData;
    private ReservaData reservaData;
    private Huesped huesped;
    private Conexion conexion;
    private ArrayList<Huesped> listaHuespedes;
    private ArrayList<Reserva> listaReservas;
    private DefaultTableModel modelo;

    
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
            modelo.addRow(new Object[]{m.getNombre(),m.getDni(),m.getDomicilio(),m.getCorreo(),
                m.getCelular(),m.getId_huesped()});
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        datos = new javax.swing.JTable();
        btnBuscarHuesped = new javax.swing.JButton();
        btnBuscarHuespedYFechas = new javax.swing.JButton();
        txtBuscarFecha = new javax.swing.JFormattedTextField();
        tituloBuscar = new javax.swing.JLabel();
        btnBuscarFecha = new javax.swing.JButton();
        etiquetaSeleccione = new javax.swing.JLabel();
        btnSeleccionarPorFecha = new javax.swing.JButton();
        buscarInforme = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 153));
        setClosable(true);

        datos =new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndes){
                return false;
            }
        };
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
        datos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(datos);

        btnBuscarHuesped.setText("Seleccionar");
        btnBuscarHuesped.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        btnBuscarHuesped.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarHuespedActionPerformed(evt);
            }
        });

        btnBuscarHuespedYFechas.setText("Seleccionar");
        btnBuscarHuespedYFechas.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        btnBuscarHuespedYFechas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarHuespedYFechasActionPerformed(evt);
            }
        });

        try {
            txtBuscarFecha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
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

        buscarInforme.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        buscarInforme.setText("Seleccionar");
        buscarInforme.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buscarInforme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarInformeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(tituloBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(txtBuscarFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(btnBuscarFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buscarInforme, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarHuespedYFechas, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeleccionarPorFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarHuesped, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(etiquetaSeleccione, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tituloBuscar)
                    .addComponent(txtBuscarFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscarFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscarInforme, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarHuespedYFechas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeleccionarPorFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarHuesped, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(etiquetaSeleccione)
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getAccessibleContext().setAccessibleDescription("VantanaDatosHuesped");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarHuespedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarHuespedActionPerformed
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
    }//GEN-LAST:event_btnBuscarHuespedActionPerformed

    private void btnBuscarHuespedYFechasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarHuespedYFechasActionPerformed
        
            int cel=datos.getSelectedRow();
            if(cel>-1){
                try {
                    VistaGestionReserva.txtNombre.setText(String.valueOf(datos.getValueAt(cel, 0)));
                    VistaGestionReserva.txtDni.setText(String.valueOf(datos.getValueAt(cel, 1)));
                    VistaGestionReserva.txtDomicilio.setText(String.valueOf(datos.getValueAt(cel, 2)));
                    VistaGestionReserva.txtCorreo.setText(String.valueOf(datos.getValueAt(cel, 3)));
                    VistaGestionReserva.txtCelular.setText(String.valueOf(datos.getValueAt(cel, 4)));
                    VistaGestionReserva.txtId.setText(String.valueOf(datos.getValueAt(cel, 5)));
                    int dni=Integer.parseInt(String.valueOf(datos.getValueAt(cel, 1)));
                    cargaFechas(dni);
                    this.setClosed(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(VentanaDatosHuesped.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{JOptionPane.showMessageDialog(null, "Debe Seleccionar un Huesped","ATENCION!!!",JOptionPane.WARNING_MESSAGE);}
    }//GEN-LAST:event_btnBuscarHuespedYFechasActionPerformed

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

    private void buscarInformeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarInformeActionPerformed
        try {
            int cel=datos.getSelectedRow();
            if(cel>-1){
                String cambio=String.valueOf(datos.getValueAt(cel, 1));
                cargarInforme(Integer.parseInt(cambio));
            }else{JOptionPane.showMessageDialog(null, "Debe Seleccionar un Huesped","ATENCION!!!",JOptionPane.WARNING_MESSAGE);}
            this.setClosed(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(VentanaDatosHuesped.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buscarInformeActionPerformed

    public void cargaDatosFechas(){
        listaReservas=(ArrayList)reservaData.obtenerResevas();
        borraFilasTabla();
        LocalDate estaFecha=LocalDate.parse((CharSequence)txtBuscarFecha.getValue(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        for (Reserva r:listaReservas){
            if (estaFecha.equals(r.getFechaEntrada())){
                modelo.addRow(new Object[]{r.getHuesped().getNombre(),r.getHuesped().getDni(),
                    r.getHuesped().getDomicilio(),r.getHuesped().getCorreo(),r.getHuesped().getCelular(),
                    r.getHuesped().getId_huesped()});
                fecha=r.getFechaEntrada();
            }
        }
    }

    /****Metodo para cargar las fechas de las reservas de un 
     ****Huesped buscadas por dni***************************/
    public void cargaFechas(int dni){
        if (dni!=0){
            listaReservas=(ArrayList)reservaData.obtenerResevas();
            huesped=huespedData.buscarHuesped(dni);
            int idhues;
            idhues=huesped.getId_huesped();
            int a =VistaGestionReserva.modelofecha.getRowCount()-1;
            for(int i=a;i>=0;i--){
                VistaGestionReserva.modelofecha.removeRow(i);
            }
            for(Reserva r:listaReservas){
                if (idhues==r.getHuesped().getId_huesped()) {
                    VistaGestionReserva.modelofecha.addRow(new Object[]{r.getFechaEntrada()});
                }
            }
        }
    }

    public void cargarInforme(int deneis){
        for(Reserva r:listaReservas){
            if (deneis==r.getHuesped().getDni()){
                String estado;
                String nombre="Nombre y Apellido : "+r.getHuesped().getNombre()+"\n";
                String direccion="Drirecion\t     : "+r.getHuesped().getDomicilio()+"\n";
                String correo="Correo\t     : "+r.getHuesped().getCorreo()+"\n";
                String dni="DNI\t     : "+r.getHuesped().getDni()+"\n";
                String celular="Celular\t     : "+r.getHuesped().getCelular()+"\n";
                if (r.getHabitacio().isEstado()){
                    estado="  Libre  \t";
                }else{estado="  Ocupada\t";}
                VistaInforme.model.addRow(new Object[]{r.getFechaReserva(),r.getHabitacio().getNroHabitacion(),"Ocupado",
                    r.getHabitacio().getPiso(),r.getHabitacio().getId_tipoHabitacion().getTipo(),
                    r.getHabitacio().getId_tipoHabitacion().getCodigo(),r.getHabitacio().getId_tipoHabitacion().getTipoCama(),
                    r.getHabitacio().getId_tipoHabitacion().getCantCamas(),r.getHabitacio().getId_tipoHabitacion().getCantPersonasMax(),
                    r.getFechaEntrada(),r.getFechaSalida(),r.getHabitacio().getId_tipoHabitacion().getPrecioPorNoche()});

                String camposHuesped=nombre+direccion+correo+dni+celular;
                VistaInforme.textArea.setText(camposHuesped);
            }
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnBuscarFecha;
    public static javax.swing.JButton btnBuscarHuesped;
    public static javax.swing.JButton btnBuscarHuespedYFechas;
    public static javax.swing.JButton btnSeleccionarPorFecha;
    public static javax.swing.JButton buscarInforme;
    public static javax.swing.JTable datos;
    public static javax.swing.JLabel etiquetaSeleccione;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel tituloBuscar;
    public static javax.swing.JFormattedTextField txtBuscarFecha;
    // End of variables declaration//GEN-END:variables
}
