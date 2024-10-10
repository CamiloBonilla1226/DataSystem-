/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ventanas;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.sql.*;
import clases.Conexion;
import javax.swing.JOptionPane;
/**
 *
 * @author PINKILORA
 */
public class Login extends javax.swing.JFrame {
    
    public static String user = "";
    String pass = "";

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        setSize(400,550);
        setResizable(false);
        setTitle("Acceso al Sistema");
        setLocationRelativeTo(null);
        
        
        //Imagen de fondo
        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
        jLabel_Wallpaper.setIcon(icono); //Acomoda ancho y largo
        this.repaint();
        
        ImageIcon wallpaper_logo = new ImageIcon("src/images/DS.png");
        Icon icono_logo = new ImageIcon(wallpaper_logo.getImage().getScaledInstance(jLabel_Logo.getWidth(), jLabel_Logo.getHeight(), Image.SCALE_DEFAULT));
        jLabel_Logo.setIcon(icono_logo);
        this.repaint();
    }
    
    @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png"));
        return retValue;
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton_Acceder = new javax.swing.JButton();
        jLabel_Footer = new javax.swing.JLabel();
        txt_user = new javax.swing.JTextField();
        txt_pass = new javax.swing.JPasswordField();
        jLabel_Logo = new javax.swing.JLabel();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton_Acceder.setBackground(new java.awt.Color(153, 153, 255));
        jButton_Acceder.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton_Acceder.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Acceder.setText("Acceder");
        jButton_Acceder.setBorder(null);
        jButton_Acceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AccederActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Acceder, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 420, 210, 35));

        jLabel_Footer.setText("Creador por acbonilla");
        getContentPane().add(jLabel_Footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 470, -1, -1));

        txt_user.setBackground(new java.awt.Color(153, 153, 255));
        txt_user.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt_user.setForeground(new java.awt.Color(255, 255, 255));
        txt_user.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_user.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 330, 210, -1));

        txt_pass.setBackground(new java.awt.Color(153, 153, 255));
        txt_pass.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt_pass.setForeground(new java.awt.Color(255, 255, 255));
        txt_pass.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_pass.setToolTipText("");
        txt_pass.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 370, 210, -1));
        getContentPane().add(jLabel_Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 270, 270));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_AccederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AccederActionPerformed
        user = txt_user.getText().trim();
        pass = txt_pass.getText().trim();
        
        if(user.equals("") || pass.equals("")){
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
        }else{
            try{
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                            "select tipo_nivel, estatus from usuarios where username = '" + user
                        + "' and password = '" + pass + "'");
                
                ResultSet rs = pst.executeQuery();
                if(rs.next()){
                    String tipo = rs.getString("tipo_nivel");
                    String estatus = rs.getString("estatus");
                    if(tipo.equalsIgnoreCase("Administrador")&& estatus.equalsIgnoreCase("Activo")){
                        dispose(); //cierra esa interfaz
                        new Administrador().setVisible(true);
                        
                    }else if(tipo.equalsIgnoreCase("Capturista")&& estatus.equalsIgnoreCase("Activo")){
                        dispose(); //cierra esa interfaz
                        new Capturista().setVisible(true);
                    }else if(tipo.equalsIgnoreCase("Tecnico")&& estatus.equalsIgnoreCase("Activo")){
                        dispose(); //cierra esa interfaz
                        new Tecnico().setVisible(true);
                    }else System.err.println("El usuario no está activo");
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Información incorrecta, intente de nuevo");
                    txt_user.setText("");
                    txt_pass.setText("");
                }
                        
            }catch( SQLException e){
                System.err.println("Error en el botón de Acceder");
                JOptionPane.showMessageDialog(null, "Error del sistema, contacte con el administrador");
                
            }
        }
        
    }//GEN-LAST:event_jButton_AccederActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Acceder;
    private javax.swing.JLabel jLabel_Footer;
    private javax.swing.JLabel jLabel_Logo;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JPasswordField txt_pass;
    private javax.swing.JTextField txt_user;
    // End of variables declaration//GEN-END:variables
}
