package VistasHotel;

import Imagen.ImagenFondo;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

/**
 *
 * @author Aballay Gabriel
 */
public class Principal extends javax.swing.JFrame {
    public Principal() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);//Hacemos que la ventana principal se maximize
        escritorio.setBorder(new ImagenFondo());//Insertamos una imagen en el escritorio
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1026, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 534, Short.MAX_VALUE)
        );

        jMenu1.setText("HUESPED");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenu1.setMargin(new java.awt.Insets(0, 0, 0, 10));

        jMenuItem1.setText("Registrar Huesped");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("HABITACIONES");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenu2.setMargin(new java.awt.Insets(0, 0, 0, 10));

        jMenuItem2.setText("Tipos de Habitaciones");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem3.setText("Gestionar Habitaciones");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("RESERVAS");
        jMenu3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenu3.setMargin(new java.awt.Insets(0, 0, 0, 10));

        jMenuItem4.setText("Crear Reserva");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuItem5.setText("Gestion de Reservas");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenuItem6.setText("Informe");
        jMenu3.add(jMenuItem6);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("SALIR");
        jMenu4.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });
        jMenu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu4ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //*********Llamado a la vista de Huesped********************************
    //**********************************************************************
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        VistaHuesped vhd=new VistaHuesped();
        centrarVentana(vhd);
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    //*********Llamado a la vista de Tipos de Habitacion********************
    //**********************************************************************
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        VistaTipoHabitacion vth=new VistaTipoHabitacion();
        centrarVentana(vth);
    }//GEN-LAST:event_jMenuItem2ActionPerformed
    //*********Llamado a la vista de Reservas*******************************
    //**********************************************************************
    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        VistaReserva vr=new VistaReserva();
        centrarVentana(vr);
    }//GEN-LAST:event_jMenuItem4ActionPerformed
    //*********Llamado a la vista de las Habitaciones***********************
    //**********************************************************************
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        VistaHabitaciones vh=new VistaHabitaciones();
        centrarVentana(vh);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu4ActionPerformed

    }//GEN-LAST:event_jMenu4ActionPerformed

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu4MouseClicked
    //*********Llamado a la vista de Gestion de Reservas********************
    //**********************************************************************
    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        VistaGestionReserva vgr=new VistaGestionReserva();
        centrarVentana(vgr);
    }//GEN-LAST:event_jMenuItem5ActionPerformed
    //********Metodo para centrar todos los internalframe del proyecto**********
    //**************************************************************************
    public static void centrarVentana(JInternalFrame ventana){
        int x=(escritorio.getWidth()/2)-ventana.getWidth()/2;
        int y=(escritorio.getHeight()/2)-ventana.getHeight()/2;
        if(ventana.isShowing()){
            ventana.setLocation(x, y);
        }else{
            escritorio.add(ventana);
            ventana.setLocation(x, y);
            ventana.show();
        }
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    // End of variables declaration//GEN-END:variables
}
