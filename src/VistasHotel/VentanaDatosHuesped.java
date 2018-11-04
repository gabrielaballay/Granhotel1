package VistasHotel;

import hotelidealuno.Conexion;
import hotelidealuno.Habitacion;
import hotelidealuno.HabitacionData;
import hotelidealuno.Huesped;
import hotelidealuno.HuespedData;
import hotelidealuno.Reserva;
import hotelidealuno.ReservaData;
import hotelidealuno.TipoHabitacion;
import hotelidealuno.TipoHabitacionData;
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
    private HabitacionData habitacionData;
    private TipoHabitacionData tipoHabitacionData;
    private ReservaData reservaData;
    private Conexion conexion;
    private ArrayList<Huesped> listaHuespedes;
    private ArrayList<Habitacion> listaHabitaciones;
    private ArrayList<TipoHabitacion> listaTipoHab;
    private ArrayList<Reserva> listaReservas;
    private Huesped huesped;
    private DefaultTableModel modelo;
    private LocalDate fecha;

    
    public VentanaDatosHuesped() {
        try {
            initComponents();
            conexion=new Conexion("jdbc:mysql://localhost/hotelideal1","root","");
            huespedData=new HuespedData(conexion);
            reservaData=new ReservaData(conexion);
            habitacionData=new HabitacionData(conexion);
            tipoHabitacionData=new TipoHabitacionData(conexion);
            modelo=new DefaultTableModel();
            listaHuespedes=(ArrayList)huespedData.obtenerHuespedes();
            listaReservas=(ArrayList)reservaData.obtenerResevas();
            listaHabitaciones=(ArrayList)habitacionData.obtenerHabitaciones();
            listaTipoHab=(ArrayList)tipoHabitacionData.obtenerTipoHabitaciones();
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
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 104, 743, 194));

        btnBuscarHuesped.setText("Seleccionar");
        btnBuscarHuesped.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        btnBuscarHuesped.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarHuespedActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscarHuesped, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, 100, 30));

        btnBuscarHuespedYFechas.setText("Seleccionar");
        btnBuscarHuespedYFechas.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        btnBuscarHuespedYFechas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarHuespedYFechasActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscarHuespedYFechas, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, 97, 30));

        try {
            txtBuscarFecha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(txtBuscarFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(344, 5, 106, -1));

        tituloBuscar.setText("Ingrese La Fecha");
        getContentPane().add(tituloBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 8, 103, -1));

        btnBuscarFecha.setText("Buscar");
        btnBuscarFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarFechaActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscarFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(344, 31, 106, -1));

        etiquetaSeleccione.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        etiquetaSeleccione.setForeground(new java.awt.Color(255, 0, 0));
        etiquetaSeleccione.setText("Seleccione un Huesped...");
        getContentPane().add(etiquetaSeleccione, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 79, 147, -1));

        btnSeleccionarPorFecha.setText("Seleccionar");
        btnSeleccionarPorFecha.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        btnSeleccionarPorFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarPorFechaActionPerformed(evt);
            }
        });
        getContentPane().add(btnSeleccionarPorFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, 100, 30));

        buscarInforme.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        buscarInforme.setText("Seleccionar");
        buscarInforme.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buscarInforme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarInformeActionPerformed(evt);
            }
        });
        getContentPane().add(buscarInforme, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, 100, 30));

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
        borraFilasTabla();
        LocalDate estaFecha=LocalDate.parse((CharSequence)txtBuscarFecha.getValue(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        for (Huesped m:listaHuespedes){
            for (Reserva r:listaReservas){
                if (estaFecha.equals(r.getFechaEntrada())&& m.getId_huesped()==r.getId_huesped()){
                    modelo.addRow(new Object[]{m.getNombre(),m.getDni(),m.getDomicilio(),m.getCorreo(),m.getCelular(),m.getId_huesped()});
                    fecha=r.getFechaEntrada();
                }
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
                if (idhues==r.getId_huesped()) {
                    VistaGestionReserva.modelofecha.addRow(new Object[]{r.getFechaEntrada()});
                }
            }
        }
    }

    public void cargarInforme(int deneis){
        String habi="";
        for (Huesped h:listaHuespedes){
            for(Reserva r:listaReservas){
                for(Habitacion hab:listaHabitaciones){
                    for (TipoHabitacion th:listaTipoHab){
                        if (deneis==h.getDni()&&r.getId_huesped()==h.getId_huesped()&&r.getId_habitacion()==hab.getIdHabitacion()&&hab.getId_tipoHabitacion()==th.getId()){
                            String estado;
                            String nombre="Nombre y Apellido : "+h.getNombre()+"\n";
                            String direccion="Drirecion\t     : "+h.getDomicilio()+"\n";
                            String correo="Correo\t     : "+h.getCorreo()+"\n";
                            String dni="DNI\t     : "+h.getDni()+"\n";
                            String celular="Celular\t     : "+h.getCelular()+"\n\n\n";
                            String NroHab=hab.getNroHabitacion()+"  \t";
                            if (hab.isEstado()){
                                estado="  Libre  \t";
                            }else{estado="  Ocupada\t";}
                            VistaInforme.model.addRow(new Object[]{hab.getNroHabitacion(),"Ocupado",hab.getPiso()
                                ,th.getTipo(),th.getCodigo(),th.getTipoCama(),th.getCantCamas(),th.getCantPersonasMax(),r.getFechaEntrada(),r.getFechaSalida(),th.getPrecioPorNoche()});
    
                            /*String piso=hab.getPiso()+"\t"+th.getTipo()+"\t";
                            String codigo=th.getCodigo()+"\t"+th.getTipoCama()+"\t";
                            String nrocam=th.getCantCamas()+"\t   "+th.getCantPersonasMax()+"   \t   ";
                            String fecEnt=r.getFechaEntrada()+"    \t";
                            String fecSal="        "+r.getFechaSalida()+"\t";
                            String precio=th.getPrecioPorNoche()+"\n\n";*/
                            //habi=habi+NroHab+estado+piso+codigo+nrocam+fecEnt+fecSal+precio;
                            String camposHuesped=nombre+direccion+correo+dni+celular+habi;
                            VistaInforme.textArea.setText(camposHuesped);
                        }
                    }
                }
            }
        }
    
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnBuscarFecha;
    public static javax.swing.JButton btnBuscarHuesped;
    public static javax.swing.JButton btnBuscarHuespedYFechas;
    public static javax.swing.JButton btnSeleccionarPorFecha;
    private javax.swing.JButton buscarInforme;
    public static javax.swing.JTable datos;
    public static javax.swing.JLabel etiquetaSeleccione;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel tituloBuscar;
    public static javax.swing.JFormattedTextField txtBuscarFecha;
    // End of variables declaration//GEN-END:variables
}
