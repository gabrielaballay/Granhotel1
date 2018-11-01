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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author Aballay Gabriel
 * ********Aballay Nelson
 * 
 */
public final class VistaGestionReserva extends javax.swing.JInternalFrame {
    private int idHabitacion;
    private int nroHabitacion;
    private int cantPersonas;
    private TipoHabitacionData tipoHabitacionData;
    private HabitacionData habitacionData;
    private ArrayList<TipoHabitacion> listaTipoHabitaciones;
    private DefaultTableModel modelo;
    public static DefaultTableModel modelofecha;
    private ArrayList<Habitacion> listaHabitaciones;
    private ArrayList<Reserva> listaReservas;
    private ReservaData reservaData;
    private Huesped huesped;
    private HuespedData huespedData;
    private Conexion conexion;
    private static int idhues=0;
    private LocalDate fechaelejida;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;

    public VistaGestionReserva() {
        try {
            initComponents();
            
            conexion=new Conexion("jdbc:mysql://localhost/hotelideal1","root","");
            huespedData=new HuespedData(conexion);
            reservaData=new ReservaData(conexion);
            tipoHabitacionData=new TipoHabitacionData(conexion);
            habitacionData=new HabitacionData(conexion);
            modelo=new DefaultTableModel();
            modelofecha=new DefaultTableModel();
            modelofecha.addColumn("Fechas");
            tablaFechas.setModel(modelofecha);
               
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VistaGestionReserva.class.getName()).log(Level.SEVERE, null, ex);
        }
        cabezeraTabla();
        etiqueta.setVisible(false);
        etiquetaBoton.setVisible(false);
        btnBuscarH.setVisible(false);
        borrarFilasTabla();
    }

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
        public void cargaDatos(){
            listaTipoHabitaciones=(ArrayList)tipoHabitacionData.obtenerTipoHabitaciones();
            listaHabitaciones=(ArrayList)habitacionData.obtenerHabitaciones();
            listaReservas=(ArrayList)reservaData.obtenerResevas();
            borrarFilasTabla();
            
            for (TipoHabitacion m:listaTipoHabitaciones){
                for (Habitacion hab:listaHabitaciones){
                    for(Reserva r:listaReservas){
                        if (r.getFechaEntrada().equals(this.fechaelejida)&&m.getId()==hab.getId_tipoHabitacion()&&idhues==r.getId_huesped() && hab.getIdHabitacion()==r.getId_habitacion()) {
                            modelo.addRow(new Object[]{m.getCodigo(),hab.getNroHabitacion(),"Ocupado",hab.getPiso()
                            ,m.getTipo(),m.getTipoCama(),m.getCantCamas(),m.getCantPersonasMax(),m.getPrecioPorNoche()});
                            
                            txtFechaEntrada.setText(r.getFechaEntrada().toString());
                            txtFechaSalida.setText(r.getFechaSalida().toString());
                            txtCantidad.setText(r.getCantidadPersonas()+"");
                            txtTotal.setText(r.getImporteTotal()+"");
                            
                            if(r.getEstadoReserva()){
                                chcActiva.setSelected(true);
                            }else{chcInactiva.setSelected(false);}
                        }
                    }
                }
            }
        }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblTiposHabitaciones = new javax.swing.JTable();
        txtModificarReserva = new javax.swing.JButton();
        btnCancelarReserva = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtDni = new javax.swing.JTextField();
        txtDomicilio = new javax.swing.JTextField();
        txtCelular = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        chcActiva = new javax.swing.JCheckBox();
        chcInactiva = new javax.swing.JCheckBox();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cbxTipoHabitacion = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaFechas = new javax.swing.JTable();
        etiqueta = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        btnCargarHuesped = new javax.swing.JButton();
        btnBuscarH = new javax.swing.JButton();
        txtFechaEntrada = new javax.swing.JFormattedTextField();
        txtFechaSalida = new javax.swing.JFormattedTextField();
        btnCalcularNuevoImporte = new javax.swing.JButton();
        btnBuscarH1 = new javax.swing.JButton();
        etiquetaBoton = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setClosable(true);
        setTitle("GESTION DE RESERVAS");

        tblTiposHabitaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Numero", "Estado", "Piso", "Tipo de Habitacion", "Tipo de Cama", "Nro de Camas", "Nro de Personas", "Precio por Noche"
            }
        ));
        tblTiposHabitaciones.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tblTiposHabitacionesAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(tblTiposHabitaciones);
        if (tblTiposHabitaciones.getColumnModel().getColumnCount() > 0) {
            tblTiposHabitaciones.getColumnModel().getColumn(0).setMaxWidth(50);
            tblTiposHabitaciones.getColumnModel().getColumn(1).setMaxWidth(50);
            tblTiposHabitaciones.getColumnModel().getColumn(2).setMaxWidth(50);
            tblTiposHabitaciones.getColumnModel().getColumn(3).setMaxWidth(50);
            tblTiposHabitaciones.getColumnModel().getColumn(4).setMaxWidth(140);
            tblTiposHabitaciones.getColumnModel().getColumn(5).setMaxWidth(140);
            tblTiposHabitaciones.getColumnModel().getColumn(6).setMaxWidth(90);
            tblTiposHabitaciones.getColumnModel().getColumn(7).setMaxWidth(100);
            tblTiposHabitaciones.getColumnModel().getColumn(8).setMaxWidth(110);
        }

        txtModificarReserva.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtModificarReserva.setText("Modificar Reserva");
        txtModificarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtModificarReservaActionPerformed(evt);
            }
        });

        btnCancelarReserva.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCancelarReserva.setText("Cancelar Reserva");
        btnCancelarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarReservaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("DATOS DEL HUESPED");

        jLabel2.setText("Nombre");

        jLabel3.setText("DNI");

        jLabel4.setText("Domicilio");

        jLabel5.setText("Correo");

        jLabel6.setText("Celular");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 255));
        jLabel8.setText("RESERVAS");

        jLabel9.setText("Importe Total");

        txtTotal.setEditable(false);
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });

        jLabel10.setText("Fecha Entrada ");

        jLabel11.setText("Fecha Salida ");

        jLabel12.setText("Cantidad de Personas");

        chcActiva.setText("Activa");

        chcInactiva.setText("Inactiva");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 0, 0));
        jLabel13.setText("ESTADO DE RESERVA");

        jLabel15.setText("Tipo de Habitacion");

        cbxTipoHabitacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar...", "Estándar Simple", "Doble", "Triple", "Suite Lujo", " " }));
        cbxTipoHabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipoHabitacionActionPerformed(evt);
            }
        });

        jLabel16.setText("ID");

        txtId.setInheritsPopupMenu(true);
        txtId.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                txtIdComponentAdded(evt);
            }
        });
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });
        txtId.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                txtIdVetoableChange(evt);
            }
        });

        tablaFechas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Título 1"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaFechas.setInheritsPopupMenu(true);
        tablaFechas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaFechasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaFechas);

        etiqueta.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        etiqueta.setForeground(new java.awt.Color(255, 0, 0));
        etiqueta.setText("Selecciones una Fecha!!!");

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/hotelucho.jpg"))); // NOI18N

        btnCargarHuesped.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCargarHuesped.setText("Cargar Huesped");
        btnCargarHuesped.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCargarHuesped.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarHuespedActionPerformed(evt);
            }
        });

        btnBuscarH.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnBuscarH.setText("Buscar");
        btnBuscarH.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBuscarH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarHActionPerformed(evt);
            }
        });

        txtFechaEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaEntradaActionPerformed(evt);
            }
        });

        btnCalcularNuevoImporte.setBackground(new java.awt.Color(204, 204, 204));
        btnCalcularNuevoImporte.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        btnCalcularNuevoImporte.setForeground(new java.awt.Color(255, 0, 0));
        btnCalcularNuevoImporte.setText("Calcular Nuevo Importe");
        btnCalcularNuevoImporte.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCalcularNuevoImporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularNuevoImporteActionPerformed(evt);
            }
        });

        btnBuscarH1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnBuscarH1.setText("Buscar por Fecha");
        btnBuscarH1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBuscarH1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarH1ActionPerformed(evt);
            }
        });

        etiquetaBoton.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        etiquetaBoton.setForeground(new java.awt.Color(255, 153, 0));
        etiquetaBoton.setText("Precione Buscar!!!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(btnCargarHuesped, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnBuscarH, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79)
                        .addComponent(btnBuscarH1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(btnCancelarReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(txtModificarReserva))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(41, 41, 41)
                                .addComponent(etiquetaBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(jLabel16)
                                .addGap(18, 18, 18)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etiqueta, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(70, 70, 70)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel13)
                        .addGap(222, 222, 222)
                        .addComponent(jLabel15))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(chcActiva)
                        .addGap(10, 10, 10)
                        .addComponent(chcInactiva)
                        .addGap(197, 197, 197)
                        .addComponent(cbxTipoHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(742, 742, 742)
                        .addComponent(btnCalcularNuevoImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addGap(10, 10, 10)
                        .addComponent(txtFechaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel11)
                        .addGap(10, 10, 10)
                        .addComponent(txtFechaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 940, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscarH)
                    .addComponent(btnCancelarReserva)
                    .addComponent(txtModificarReserva)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCargarHuesped)
                            .addComponent(btnBuscarH1))))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel2)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(17, 17, 17)
                        .addComponent(jLabel5)
                        .addGap(17, 17, 17)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(etiquetaBoton))
                        .addGap(18, 18, 18)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel16))
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addComponent(txtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(etiqueta)
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel15)))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chcActiva)
                    .addComponent(chcInactiva)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(cbxTipoHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7)
                .addComponent(btnCalcularNuevoImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel10))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(txtFechaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel11))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFechaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //*********Metodo Cancelar Reserva*************
    //*********************************************
    private void btnCancelarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarReservaActionPerformed
        
        
    }//GEN-LAST:event_btnCancelarReservaActionPerformed
    //**********METODO BOTON MODIFICAR RESERVA**************
    private void txtModificarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtModificarReservaActionPerformed


        
    }//GEN-LAST:event_txtModificarReservaActionPerformed
    
    //*****Combo Box ******
    private void cbxTipoHabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipoHabitacionActionPerformed
        String tipo;
        tipo=(String)cbxTipoHabitacion.getSelectedItem();
        borrarFilasTabla();
        cargaHabitaciones(tipo);
    }//GEN-LAST:event_cbxTipoHabitacionActionPerformed

    //******Tabla Fechas******
    private void tablaFechasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaFechasMouseClicked
            idhues=Integer.parseInt(txtId.getText());
            int cel=tablaFechas.getSelectedRow();
            String fec=tablaFechas.getValueAt(cel, 0).toString();
            fechaelejida=LocalDate.parse((CharSequence)fec, DateTimeFormatter.ISO_DATE);
            cargaDatos();
    }//GEN-LAST:event_tablaFechasMouseClicked

    //*metodos creados por error sin funcionalidad
    private void txtIdComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_txtIdComponentAdded
    }//GEN-LAST:event_txtIdComponentAdded

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
    }//GEN-LAST:event_txtIdActionPerformed

    private void txtIdVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_txtIdVetoableChange
    }//GEN-LAST:event_txtIdVetoableChange

    //*******Boton para cargar un huesped *****
    private void btnCargarHuespedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarHuespedActionPerformed
        btnBuscarH.setVisible(true);
        etiqueta.setVisible(false);
        etiquetaBoton.setVisible(true);
        limpiar();    
        VentanaDatosHuesped vdh=new VentanaDatosHuesped();
        Principal.centrarVentana(vdh);
        vdh.setTitle("Buscar Huesped");
        VentanaDatosHuesped.boton2.setVisible(false);
        VentanaDatosHuesped.btnBuscarFecha.setVisible(false);
        VentanaDatosHuesped.buscarFecha.setVisible(false);
        VentanaDatosHuesped.tituloBuscar.setVisible(false);
        VentanaDatosHuesped.btnSeleccionarPorFecha.setVisible(false);
       
    }//GEN-LAST:event_btnCargarHuespedActionPerformed

    //******Boton para buscar las fechas de reserva de un huesped******
    private void btnBuscarHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarHActionPerformed
        if(!(txtNombre.getText().equals(""))){
            String dnis=txtDni.getText();
            int dniH=0;
            if(dnis!=null){
                dniH=Integer.parseInt(dnis);
                cargaHuesped(dniH);
            }
        }else{JOptionPane.showMessageDialog(null,"Debe Cargar un Huesped","ATENCION!!!",JOptionPane.WARNING_MESSAGE);}
    }//GEN-LAST:event_btnBuscarHActionPerformed

    private void tblTiposHabitacionesAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tblTiposHabitacionesAncestorAdded
        
    }//GEN-LAST:event_tblTiposHabitacionesAncestorAdded

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
    }//GEN-LAST:event_txtTotalActionPerformed

    private void txtFechaEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaEntradaActionPerformed
    }//GEN-LAST:event_txtFechaEntradaActionPerformed

    //****Boton para calcular el nuevo importe para la modificacion de la reserva****
    private void btnCalcularNuevoImporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularNuevoImporteActionPerformed
        int suma=0;
        double impTotal;
        int cel=tblTiposHabitaciones.getSelectedRow();
        if (cel>-1){
            cantPersonas=Integer.parseInt(txtCantidad.getText());
            fechaEntrada=LocalDate.parse((CharSequence) txtFechaEntrada.getText());
            fechaSalida=LocalDate.parse((CharSequence) txtFechaSalida.getText());
            idhues=Integer.parseInt(txtId.getText());
            JOptionPane.showMessageDialog(null, fechaEntrada);
            suma=fechaSalida.getDayOfYear()-fechaEntrada.getDayOfYear();
            impTotal=  (double) tblTiposHabitaciones.getValueAt(cel, 8)*suma;
            nroHabitacion=(int) tblTiposHabitaciones.getValueAt(cel, 1);
            txtTotal.setText(impTotal+"");
        }else{JOptionPane.showMessageDialog(null, "Debe Seleccionar un campo de la tabla de tipos de habitaciones");}
    }//GEN-LAST:event_btnCalcularNuevoImporteActionPerformed
    
    //****Boton para la busqueda por fecha****
    private void btnBuscarH1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarH1ActionPerformed
        btnBuscarH.setVisible(false);
        int a =modelofecha.getRowCount()-1;
        for(int i=a;i>=0;i--){
            modelofecha.removeRow(i);
        }
        etiqueta.setVisible(true);
        etiquetaBoton.setVisible(false);
        VentanaDatosHuesped vdh=new VentanaDatosHuesped();
        Principal.centrarVentana(vdh);
        vdh.setTitle("BUSCAR POR FECHA");
        VentanaDatosHuesped.boton2.setVisible(false);
        VentanaDatosHuesped.boton1.setVisible(false);
        VentanaDatosHuesped.datos.setVisible(false);
    }//GEN-LAST:event_btnBuscarH1ActionPerformed
    
    //****Metodo para cargar un Huesped por dni***
    public void cargaHuesped(int dni){
        listaReservas=(ArrayList)reservaData.obtenerResevas();
        huesped=huespedData.buscarHuesped(dni);
        idhues=huesped.getId_huesped();
        int a =modelofecha.getRowCount()-1;
        for(int i=a;i>=0;i--){
            modelofecha.removeRow(i);
        }
        for(Reserva r:listaReservas){
            if (idhues==r.getId_huesped()) {
                modelofecha.addRow(new Object[]{r.getFechaEntrada()});
            }
        }
    }

    //*****Metodo para limpiar el formulario
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
            borrarFilasTabla();
            int b=modelofecha.getRowCount()-1;
            for(int z=b;z>=0;z--){
                modelofecha.removeRow(z);
            }
    }
    
    //********Metodo para cargar habitaciones por un tipo de habitacion*****
    public void cargaHabitaciones(String tipo){
        listaTipoHabitaciones=(ArrayList)tipoHabitacionData.obtenerTipoHabitaciones();
        listaHabitaciones=(ArrayList)habitacionData.obtenerHabitaciones();
        borrarFilasTabla();
        int valorSpinner=Integer.parseInt(txtCantidad.getText());
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
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarH;
    private javax.swing.JButton btnBuscarH1;
    private javax.swing.JButton btnCalcularNuevoImporte;
    private javax.swing.JButton btnCancelarReserva;
    private javax.swing.JButton btnCargarHuesped;
    private javax.swing.JComboBox<String> cbxTipoHabitacion;
    private javax.swing.JCheckBox chcActiva;
    private javax.swing.JCheckBox chcInactiva;
    private javax.swing.JLabel etiqueta;
    private javax.swing.JLabel etiquetaBoton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable tablaFechas;
    private javax.swing.JTable tblTiposHabitaciones;
    private javax.swing.JTextField txtCantidad;
    public static javax.swing.JTextField txtCelular;
    public static javax.swing.JTextField txtCorreo;
    public static javax.swing.JTextField txtDni;
    public static javax.swing.JTextField txtDomicilio;
    private javax.swing.JFormattedTextField txtFechaEntrada;
    private javax.swing.JFormattedTextField txtFechaSalida;
    public static javax.swing.JTextField txtId;
    private javax.swing.JButton txtModificarReserva;
    public static javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
