/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import javax.swing.JComponent;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author jhess
 */
public class InicioUsuario extends javax.swing.JInternalFrame {
   private final JComponent northPane;
   private Border border;
    /**
     * Creates new form InicioUsuario
     */
    public InicioUsuario() {
        initComponents();
        northPane = ((BasicInternalFrameUI) getUI()).getNorthPane();
        border = getBorder();
        this.setUndecorated(true);
        //        btnAd.setOpaque(false);

        btnIngs.setOpaque(false);
        btnIngs.setBorderPainted(false);
        btnIngs.setContentAreaFilled(false);
        Time ventana = new Time();
        Tiempos.add(ventana);
        ventana.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel17 = new javax.swing.JLabel();
        jButton1s = new javax.swing.JButton();
        btnIngs = new javax.swing.JButton();
        Tiempos = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setAutoscrolls(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setDoubleBuffered(true);
        setEnabled(false);
        setVisible(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Castellar", 2, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("POR FAVOR INGRESE SUS CREDENCIALES PARA GESTIONAR SU CUENTA");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jButton1s.setBackground(new java.awt.Color(0, 153, 0));
        jButton1s.setFont(new java.awt.Font("Castellar", 1, 14)); // NOI18N
        jButton1s.setForeground(new java.awt.Color(255, 255, 255));
        jButton1s.setText("INGRESAR");
        jButton1s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1sActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1s, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, 220, 50));

        btnIngs.setFont(new java.awt.Font("Castellar", 1, 18)); // NOI18N
        btnIngs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Ingresar.png"))); // NOI18N
        btnIngs.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnIngs.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnIngs.setOpaque(false);
        btnIngs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngsActionPerformed(evt);
            }
        });
        getContentPane().add(btnIngs, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 220, 170));

        Tiempos.setPreferredSize(new java.awt.Dimension(260, 70));

        javax.swing.GroupLayout TiemposLayout = new javax.swing.GroupLayout(Tiempos);
        Tiempos.setLayout(TiemposLayout);
        TiemposLayout.setHorizontalGroup(
            TiemposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );
        TiemposLayout.setVerticalGroup(
            TiemposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        getContentPane().add(Tiempos, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 490, -1, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/backgr.jpg"))); // NOI18N
        jLabel1.setOpaque(true);
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 770, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngsActionPerformed
        // TODO add your handling code here:
        //        Login vt = new Login();
        //        vt.setVisible(true);
        Login vt = new Login();
        vt.setVisible(true);
    }//GEN-LAST:event_btnIngsActionPerformed

    private void jButton1sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1sActionPerformed
        // TODO add your handling code here:
        
        System.out.println(this.getCursor());
        Login vt = new Login();
        vt.setVisible(true);
    }//GEN-LAST:event_jButton1sActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseClicked
    public void setRootPaneCheckingEnabled(boolean enabled)
    {
        super.setRootPaneCheckingEnabled(enabled);
    }
    
    public void setUndecorated(boolean val)
    {
        setBorder(val ? null : border);

        setRootPaneCheckingEnabled(false);
        ((BasicInternalFrameUI) getUI()).setNorthPane(val ? null : northPane);
        setRootPaneCheckingEnabled(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Tiempos;
    private javax.swing.JButton btnIngs;
    private javax.swing.JButton jButton1s;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    // End of variables declaration//GEN-END:variables
}
