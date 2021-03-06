/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package electronica.visual;
import java.sql.*;
import electronica.basedatos.ModuloConexion;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
/**
 *
 * @author Windows
 */
public class pantallalogin extends javax.swing.JFrame {
    Connection conexion = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    /**
     * Creates new form pantallalogin
     */
    public void logar (){
        String sql ="select * from tbusuarios where login=? and senha =? ";
        try {
            //lineas abajo preparan para la consulta de banco de datos
            pst = conexion.prepareStatement(sql);
            pst.setString(1,txt.getText());
            String captura = new String(txtsenha.getPassword());
            pst.setString(2,captura);
            //linea abajo exect aa query
            rs= pst.executeQuery();
            //si existe los datos
            if(rs.next()){
                //linea abajo contenido del perfil 
                String perfil=rs.getString(6);
                //System.out.println(perfil);
                //linea abajo muestra el el usuario en la ventana
                if (perfil.equals("admin")){
                //linea abajo te lleva a la otra ventana
            pantallaprincipal principal = new pantallaprincipal();
            principal.setVisible(true);
            pantallaprincipal.MenRela.setEnabled(true);
            pantallaprincipal.MenUsua.setEnabled(true);
            pantallaprincipal.lblUsuario.setText(rs.getString(2));
            pantallaprincipal.lblUsuario.setForeground(Color.red);
            this.dispose();
            conexion.close();
                }else{
                    pantallaprincipal principal = new pantallaprincipal();
                    principal.setVisible(true);
                     pantallaprincipal.lblUsuario.setText(rs.getString(2));
                    this.dispose();
                }
            }else{
                JOptionPane.showMessageDialog(null,"usuario o contrase??a invalido(s)");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public pantallalogin() {
        initComponents();
        conexion = ModuloConexion.conector();
        //linea abajo sirve como apoyo de estado de conexion
       // System.out.println(conexion);
        if (conexion != null) {
        status.setIcon(new javax.swing.ImageIcon(getClass().getResource("/electronica/icones/on.png")));
    }else{
            status.setIcon(new javax.swing.ImageIcon(getClass().getResource("/electronica/icones/error.png")));
            }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt = new javax.swing.JTextField();
        txtsenha = new javax.swing.JPasswordField();
        btnacceder = new javax.swing.JButton();
        status = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setResizable(false);

        jLabel1.setText("Usuario");

        jLabel2.setText("Contrase??a");

        txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKeyPressed(evt);
            }
        });

        txtsenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtsenhaKeyPressed(evt);
            }
        });

        btnacceder.setText("Acceder");
        btnacceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaccederActionPerformed(evt);
            }
        });
        btnacceder.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnaccederKeyPressed(evt);
            }
        });

        status.setIcon(new javax.swing.ImageIcon(getClass().getResource("/electronica/icones/error.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                            .addComponent(txtsenha))
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnacceder)
                        .addGap(39, 39, 39))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtsenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnacceder)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        setSize(new java.awt.Dimension(340, 224));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnaccederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaccederActionPerformed
 //llamando el metodo 
        logar();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnaccederActionPerformed

    private void txtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
        txtsenha.requestFocus();
        txt.setBackground(Color.YELLOW);
        txtsenha.setBackground(Color.RED);
        }
    }//GEN-LAST:event_txtKeyPressed

    private void txtsenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsenhaKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
        logar();
        
        }
    }//GEN-LAST:event_txtsenhaKeyPressed

    private void btnaccederKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnaccederKeyPressed
        // TODO add your handling code here:
    
    }//GEN-LAST:event_btnaccederKeyPressed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(pantallalogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pantallalogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pantallalogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pantallalogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pantallalogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnacceder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel status;
    private javax.swing.JTextField txt;
    private javax.swing.JPasswordField txtsenha;
    // End of variables declaration//GEN-END:variables
}
