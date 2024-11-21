/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ventanas;
import java.sql.*;
import clases.Conexion;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;

/**
 *
 * @author PINKILORA
 */
public class informacionUsuario extends javax.swing.JFrame {
    Border redBorder = BorderFactory.createLineBorder(Color.RED, 2);
    Border greenBorder = BorderFactory.createLineBorder(Color.GREEN, 2);
    String user ="", user_update = "";
    int ID;
    
    

    /**
     * Creates new form informacionUsuario
     */
    public informacionUsuario() {
        initComponents();
        user = Login.user;
        user_update = GestionarUsuarios.user_update;
        
        setTitle("Usiarios registrados - Sesion de "+ user);
         setSize(630,450);
         setResizable(false);
         setLocationRelativeTo(null);
         
         setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
         
          ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
          Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
          jLabel_Wallpaper.setIcon(icono); //Acomoda ancho y largo
          this.repaint();
          
          jLabel_titulo.setText("Información del usuario "+ user_update);
          
          try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement( "select * from usuarios where username = '" + user_update + "'" );
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                ID = rs.getInt("id_usuario");
                txt_nombre.setText(rs.getString("nombre_usuario"));
                txt_mail.setText(rs.getString("email"));
                txt_telefono.setText(rs.getString("telefono"));
                txt_username.setText(rs.getString("username"));
                txt_registradopor.setText(rs.getString("registrado_por"));
                
                cmb_niveles.setSelectedItem(rs.getString("tipo_nivel"));
                cmb_estatus.setSelectedItem(rs.getString("estatus"));
            }
            cn.close();
            
                
        } catch (SQLException e) {
             System.err.println("Error en cargar usurario "+e);
             JOptionPane.showMessageDialog(null,"CONTACTE CON ADMIN");
        }
          
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

        jLabel_titulo = new javax.swing.JLabel();
        jLabel_Nombre = new javax.swing.JLabel();
        jLabel_Nombre1 = new javax.swing.JLabel();
        jLabel_Nombre2 = new javax.swing.JLabel();
        jLabel_Nombre3 = new javax.swing.JLabel();
        jLabel_Nombre4 = new javax.swing.JLabel();
        jLabel_Nombre5 = new javax.swing.JLabel();
        jLabel_Nombre6 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_mail = new javax.swing.JTextField();
        txt_telefono = new javax.swing.JTextField();
        txt_username = new javax.swing.JTextField();
        txt_registradopor = new javax.swing.JTextField();
        cmb_estatus = new javax.swing.JComboBox<>();
        cmb_niveles = new javax.swing.JComboBox<>();
        jButton_Actualizar = new javax.swing.JButton();
        jButton_RestauraPass = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_titulo.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_titulo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel_titulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_titulo.setText("Información del usuario");
        getContentPane().add(jLabel_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, -1, -1));

        jLabel_Nombre.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre.setText("Nombre: ");
        getContentPane().add(jLabel_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel_Nombre1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel_Nombre1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre1.setText("Email: ");
        getContentPane().add(jLabel_Nombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel_Nombre2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel_Nombre2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre2.setText("Telefono: ");
        getContentPane().add(jLabel_Nombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel_Nombre3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel_Nombre3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre3.setText("Permisos de: ");
        getContentPane().add(jLabel_Nombre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel_Nombre4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel_Nombre4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre4.setText("Username: ");
        getContentPane().add(jLabel_Nombre4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, -1, -1));

        jLabel_Nombre5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel_Nombre5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre5.setText("Estatus: ");
        getContentPane().add(jLabel_Nombre5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, -1, -1));

        jLabel_Nombre6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel_Nombre6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre6.setText("Registrado por: ");
        getContentPane().add(jLabel_Nombre6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, -1, -1));

        txt_nombre.setBackground(new java.awt.Color(153, 153, 255));
        txt_nombre.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_nombre.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombre.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_nombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 210, -1));

        txt_mail.setBackground(new java.awt.Color(153, 153, 255));
        txt_mail.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_mail.setForeground(new java.awt.Color(255, 255, 255));
        txt_mail.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_mail.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_mail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 210, -1));

        txt_telefono.setBackground(new java.awt.Color(153, 153, 255));
        txt_telefono.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_telefono.setForeground(new java.awt.Color(255, 255, 255));
        txt_telefono.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_telefono.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_telefonoActionPerformed(evt);
            }
        });
        getContentPane().add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 210, -1));

        txt_username.setBackground(new java.awt.Color(153, 153, 255));
        txt_username.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_username.setForeground(new java.awt.Color(255, 255, 255));
        txt_username.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_username.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 210, -1));

        txt_registradopor.setBackground(new java.awt.Color(153, 153, 255));
        txt_registradopor.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_registradopor.setForeground(new java.awt.Color(255, 255, 255));
        txt_registradopor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_registradopor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_registradopor.setEnabled(false);
        txt_registradopor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_registradoporActionPerformed(evt);
            }
        });
        getContentPane().add(txt_registradopor, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, 210, -1));

        cmb_estatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        getContentPane().add(cmb_estatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, -1, -1));

        cmb_niveles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Capturista", "Tecnico" }));
        getContentPane().add(cmb_niveles, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        jButton_Actualizar.setBackground(new java.awt.Color(153, 153, 255));
        jButton_Actualizar.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jButton_Actualizar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Actualizar.setText("Actualizar usuario");
        jButton_Actualizar.setBorder(null);
        jButton_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, 210, 35));

        jButton_RestauraPass.setBackground(new java.awt.Color(153, 153, 255));
        jButton_RestauraPass.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jButton_RestauraPass.setForeground(new java.awt.Color(255, 255, 255));
        jButton_RestauraPass.setText("Restaurar Password");
        jButton_RestauraPass.setBorder(null);
        jButton_RestauraPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RestauraPassActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_RestauraPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 300, 210, 35));

        jLabel2.setText("Creado por acbonilla");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 370, -1, -1));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_registradoporActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_registradoporActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_registradoporActionPerformed

    private void jButton_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ActualizarActionPerformed
        
        Border softBevelBorder = new SoftBevelBorder(BevelBorder.RAISED); 
        int permisos_cmb, estatus_cmb, validacion = 0;
        String nombre, mail, telefono, username, pass, permisos_string = "", estatus_string = "";
        mail = txt_mail.getText().trim();
        username = txt_username.getText().trim();
        nombre = txt_nombre.getText().trim();
        telefono = txt_telefono.getText().trim();
        permisos_cmb = cmb_niveles.getSelectedIndex() + 1;
        estatus_cmb = cmb_estatus.getSelectedIndex() + 1;
              
        if(mail.equals("")){
            validacion++;
            txt_mail.setBorder(redBorder);
        } else {
            txt_mail.setBorder(softBevelBorder);
        }
        
        if(username.equals("")){
            validacion++;
            txt_username.setBorder(redBorder);
        } else {
            txt_username.setBorder(softBevelBorder);
        }
        
        if(nombre.equals("")){
            validacion++;
            txt_nombre.setBorder(redBorder);
        } else {
            txt_nombre.setBorder(softBevelBorder);
        }
        
        if(telefono.equals("")){
            validacion++;
            txt_telefono.setBorder(redBorder);
        } else {
            txt_telefono.setBorder(softBevelBorder);
        }
        
        if (validacion == 0) {
            
            if(permisos_cmb==1){
                permisos_string = "Administrador";
            } else if (permisos_cmb==2){
                permisos_string = "Capturista";
            } else if (permisos_cmb == 3){
                permisos_string = "Tecnico";
            }
            
            if(estatus_cmb == 1){
                estatus_string = "Activo";
            } else if (estatus_cmb == 2){
                estatus_string = "Inactivo";
            }
            
            try {
               Connection cn = Conexion.conectar();
               PreparedStatement pst = cn.prepareStatement("select username from usuarios where username = '" + username + "' and not id_usuario = '" + ID + "'");
               
               ResultSet rs = pst.executeQuery();
               
                if (rs.next()) {
                    txt_username.setBorder(redBorder);
                    JOptionPane.showMessageDialog(null,"Nombre de usuario no disponible");
                    cn.close();
                    
                } else {
                    Connection cn2 = Conexion.conectar();
                    PreparedStatement pst2 = cn2.prepareStatement("update usuarios set nombre_usuario = ?, email = ?, telefono=?, username=?, tipo_nivel=?, estatus=? "
                    + "where id_usuario = '" + ID + "'");
                    
                    pst2.setString(1, nombre);
                    pst2.setString(2, mail);
                    pst2.setString(3, telefono);
                    pst2.setString(4, username);
                    pst2.setString(5, permisos_string);
                    pst2.setString(6, estatus_string);
                    
                    pst2.executeUpdate();
                    cn2.close();
                    JOptionPane.showMessageDialog(null,"Modificación correcta");
                }
                
            } catch (SQLException e) {
                System.err.println("Error al actualizar en "+ e);              
            }
            
        } else {
            JOptionPane.showMessageDialog(null,"Debes llenar todos los campos");
        }
        
    }//GEN-LAST:event_jButton_ActualizarActionPerformed

    private void txt_telefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_telefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_telefonoActionPerformed

    private void jButton_RestauraPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RestauraPassActionPerformed

        Password restaurar = new Password();
        restaurar.setVisible(true);
            // TODO add your handling code here:
    }//GEN-LAST:event_jButton_RestauraPassActionPerformed

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
            java.util.logging.Logger.getLogger(informacionUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(informacionUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(informacionUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(informacionUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new informacionUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmb_estatus;
    private javax.swing.JComboBox<String> cmb_niveles;
    private javax.swing.JButton jButton_Actualizar;
    private javax.swing.JButton jButton_RestauraPass;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel_Nombre;
    private javax.swing.JLabel jLabel_Nombre1;
    private javax.swing.JLabel jLabel_Nombre2;
    private javax.swing.JLabel jLabel_Nombre3;
    private javax.swing.JLabel jLabel_Nombre4;
    private javax.swing.JLabel jLabel_Nombre5;
    private javax.swing.JLabel jLabel_Nombre6;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JLabel jLabel_titulo;
    private javax.swing.JTextField txt_mail;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_registradopor;
    private javax.swing.JTextField txt_telefono;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
