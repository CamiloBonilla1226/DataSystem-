/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ventanas;

import java.sql.*;
import clases.Conexion;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;

/**
 *
 * @author PINKILORA
 */
public class InformacionEquipo extends javax.swing.JFrame {
     Border redBorder = BorderFactory.createLineBorder(Color.RED, 2);
    int IDcliente = 0, IDequipo = 0;
    String user = "", nom_cliente = "";

    /**
     * Creates new form InformacionEquipo
     */
    public InformacionEquipo() {
        initComponents();
        user = Login.user;

        IDcliente = GestionarClientes.IDcliente_update;
        IDequipo = InformacionCliente.IDequipo;

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select nombre_cliente from clientes where id_cliente = '" + IDcliente + "'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                nom_cliente = rs.getString("nombre_cliente");

            }
        } catch (Exception e) {
            System.err.println("Error al consulktar el nombre del cliente " + e);
        }

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select * from equipos where id_equipo = '" + IDequipo + "'");

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                cmb_tipoequipo.setSelectedItem(rs.getString("tipo_equipo"));
                cmb_marcas.setSelectedItem(rs.getString("marca"));
                cmb_estatus.setSelectedItem(rs.getString("estatus"));
                txt_modelo.setText(rs.getString("modelo"));
                txt_numserie.setText(rs.getString("num_serie"));
                txt_ultimamod.setText(rs.getString("ultima_modificacion"));

                String dia = "", mes = "", annio = "";
                dia = rs.getString("dia_ingreso");
                mes = rs.getString("mes_ingreso");
                annio = rs.getString("annio_ingreso");
                txt_fecha.setText(dia + "del" + mes + "del" + annio);

                jTextPane_observaciones.setText(rs.getString("observaciones"));
                jTextPane_comentarios.setText(rs.getString("comentarios_tecnicos"));
                jLabel_revision.setText("Comentarios y actualizacion del técnico: " + rs.getString("revision_tecnica_de"));

            }
        } catch (Exception e) {
            System.err.println("Error al consulktar el nombre del cliente " + e);
        }
        
        setTitle("Equipo del cliente " + nom_cliente);
        setSize(670, 530);
        setResizable(false);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(), jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
        jLabel_Wallpaper.setIcon(icono); //Acomoda ancho y largo
        this.repaint();
        
        txt_nombrecliente.setText(nom_cliente);
    }

    @Override
    public Image getIconImage() {
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
        jLabel_Nombre7 = new javax.swing.JLabel();
        jLabel_Nombre8 = new javax.swing.JLabel();
        jLabel_revision = new javax.swing.JLabel();
        txt_nombrecliente = new javax.swing.JTextField();
        txt_modelo = new javax.swing.JTextField();
        txt_numserie = new javax.swing.JTextField();
        txt_ultimamod = new javax.swing.JTextField();
        txt_fecha = new javax.swing.JTextField();
        cmb_tipoequipo = new javax.swing.JComboBox<>();
        cmb_marcas = new javax.swing.JComboBox<>();
        cmb_estatus = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPane_observaciones = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextPane_comentarios = new javax.swing.JTextPane();
        jButton_Actualizar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_titulo.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_titulo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel_titulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_titulo.setText("Información de equipo");
        getContentPane().add(jLabel_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        jLabel_Nombre.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre.setText("Nombre del cliente:");
        getContentPane().add(jLabel_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jLabel_Nombre1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre1.setText("Tipo de equipo:");
        getContentPane().add(jLabel_Nombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jLabel_Nombre2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre2.setText("Marca:");
        getContentPane().add(jLabel_Nombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        jLabel_Nombre3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre3.setText("Modelo:");
        getContentPane().add(jLabel_Nombre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        jLabel_Nombre4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre4.setText("Num de serie:");
        getContentPane().add(jLabel_Nombre4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, -1));

        jLabel_Nombre5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre5.setText("Fecha de ingreso:");
        getContentPane().add(jLabel_Nombre5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, -1, -1));

        jLabel_Nombre6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre6.setText("Modificación por: ");
        getContentPane().add(jLabel_Nombre6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, -1));

        jLabel_Nombre7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre7.setText("Estatus:");
        getContentPane().add(jLabel_Nombre7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 60, -1, -1));

        jLabel_Nombre8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre8.setText("Daño reportado y observaciones:");
        getContentPane().add(jLabel_Nombre8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, -1, -1));

        jLabel_revision.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_revision.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_revision.setText("Comentarios y actualizacion del técnico:");
        getContentPane().add(jLabel_revision, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, -1, -1));

        txt_nombrecliente.setBackground(new java.awt.Color(153, 153, 255));
        txt_nombrecliente.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_nombrecliente.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombrecliente.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_nombrecliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_nombrecliente.setEnabled(false);
        getContentPane().add(txt_nombrecliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 210, -1));

        txt_modelo.setBackground(new java.awt.Color(153, 153, 255));
        txt_modelo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_modelo.setForeground(new java.awt.Color(255, 255, 255));
        txt_modelo.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_modelo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 210, -1));

        txt_numserie.setBackground(new java.awt.Color(153, 153, 255));
        txt_numserie.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_numserie.setForeground(new java.awt.Color(255, 255, 255));
        txt_numserie.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_numserie.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_numserie, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 210, -1));

        txt_ultimamod.setBackground(new java.awt.Color(153, 153, 255));
        txt_ultimamod.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_ultimamod.setForeground(new java.awt.Color(255, 255, 255));
        txt_ultimamod.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_ultimamod.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_ultimamod.setEnabled(false);
        getContentPane().add(txt_ultimamod, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 210, -1));

        txt_fecha.setBackground(new java.awt.Color(153, 153, 255));
        txt_fecha.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_fecha.setForeground(new java.awt.Color(255, 255, 255));
        txt_fecha.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_fecha.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_fecha.setEnabled(false);
        getContentPane().add(txt_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 180, -1));

        cmb_tipoequipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laptop", "Desktop", "Impresora", "Multifuncional" }));
        getContentPane().add(cmb_tipoequipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        cmb_marcas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lenovo", "Hp", "Acer", "Samsung", "Apple", "Dell", "Asus", "Brother", "Toshiba", "Xerox" }));
        getContentPane().add(cmb_marcas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        cmb_estatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nuevo ingreso ", "Reparado ", "No reparado", "En revision ", "Entregado" }));
        getContentPane().add(cmb_estatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, -1, -1));

        jScrollPane3.setViewportView(jTextPane_observaciones);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, 330, 120));

        jTextPane_comentarios.setEnabled(false);
        jScrollPane4.setViewportView(jTextPane_comentarios);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 280, 330, 120));

        jButton_Actualizar.setBackground(new java.awt.Color(153, 153, 255));
        jButton_Actualizar.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jButton_Actualizar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Actualizar.setText("Actualizar equipo");
        jButton_Actualizar.setBorder(null);
        jButton_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 400, 210, 35));

        jLabel2.setText("Creado por acbonilla");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 460, -1, -1));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 524));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ActualizarActionPerformed
        int validacion = 0;
        Border softBevelBorder = new SoftBevelBorder(BevelBorder.RAISED);
        String tipo_equipo , marca, modelo, num_serie, estatus, observaciones;
        
        tipo_equipo = cmb_tipoequipo.getSelectedItem().toString();
        marca = cmb_marcas.getSelectedItem().toString();
        estatus = cmb_estatus.getSelectedItem().toString();
        
        modelo = txt_modelo.getText().trim();
        num_serie = txt_numserie.getText().trim();
        observaciones = jTextPane_observaciones.getText();
        
        if (modelo.equals("")) {
            validacion++;
            txt_modelo.setBorder(redBorder);
        } else {
            txt_modelo.setBorder(softBevelBorder);
        }
        if ( num_serie.equals("")) {
            validacion++;
            txt_numserie.setBorder(redBorder);
        } else {
            txt_numserie.setBorder(softBevelBorder);
        }
        if (observaciones.equals("")) {
            jTextPane_observaciones.setText("Sin validaciones");
        }
        
        if (validacion == 0) {
            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement("select * from equipos where id_equipo = '" + IDequipo + "'");
            } catch (Exception e) {
            }
            
        }
        

    }//GEN-LAST:event_jButton_ActualizarActionPerformed

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
            java.util.logging.Logger.getLogger(InformacionEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformacionEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformacionEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformacionEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformacionEquipo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmb_estatus;
    private javax.swing.JComboBox<String> cmb_marcas;
    private javax.swing.JComboBox<String> cmb_tipoequipo;
    private javax.swing.JButton jButton_Actualizar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel_Nombre;
    private javax.swing.JLabel jLabel_Nombre1;
    private javax.swing.JLabel jLabel_Nombre2;
    private javax.swing.JLabel jLabel_Nombre3;
    private javax.swing.JLabel jLabel_Nombre4;
    private javax.swing.JLabel jLabel_Nombre5;
    private javax.swing.JLabel jLabel_Nombre6;
    private javax.swing.JLabel jLabel_Nombre7;
    private javax.swing.JLabel jLabel_Nombre8;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JLabel jLabel_revision;
    private javax.swing.JLabel jLabel_titulo;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextPane jTextPane_comentarios;
    private javax.swing.JTextPane jTextPane_observaciones;
    private javax.swing.JTextField txt_fecha;
    private javax.swing.JTextField txt_modelo;
    private javax.swing.JTextField txt_nombrecliente;
    private javax.swing.JTextField txt_numserie;
    private javax.swing.JTextField txt_ultimamod;
    // End of variables declaration//GEN-END:variables
}
