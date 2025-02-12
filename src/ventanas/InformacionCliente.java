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
import static ventanas.GestionarClientes.IDcliente_update;


/**
 *
 * @author PINKILORA
 */
public class InformacionCliente extends javax.swing.JFrame {

    Border redBorder = BorderFactory.createLineBorder(Color.RED, 2);
    Border greenBorder = BorderFactory.createLineBorder(Color.GREEN, 2);
    String user = "", user_update = "";
    int ID;
    DefaultTableModel model = new DefaultTableModel();
    int IDcliente = 0;
    public static int IDequipo = 0;

    /**
     * Creates new form InformacionCliente
     */
    public InformacionCliente() {
        initComponents();
        user = Login.user;
        user_update = GestionarClientes.user_update;
        IDcliente = GestionarClientes.IDcliente_update;

        setTitle("Clientes registrados - Sesion de " + user);
        setSize(630, 450);
        setResizable(false);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(), jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
        jLabel_Wallpaper.setIcon(icono); //Acomoda ancho y largo
        this.repaint();

        jLabel_titulo.setText("Información del cliente " + user_update);

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select * from clientes where id_cliente = '" + IDcliente + "'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                ID = rs.getInt("id_cliente");
                txt_nombre.setText(rs.getString("nombre_cliente"));
                txt_mail.setText(rs.getString("email_cliente"));
                txt_telefono.setText(rs.getString("tel_cliente"));
                txt_direccion.setText(rs.getString("dir_cliente"));
                txt_registradopor.setText(rs.getString("ultima_modificacion"));

            }
            cn.close();

        } catch (SQLException e) {
            System.err.println("Error en cargar usurario " + e);
            JOptionPane.showMessageDialog(null, "CONTACTE CON ADMIN");
        }

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select id_equipo, tipo_equipo, marca, estatus from equipos where id_cliente = '" + IDcliente + "'");
            ResultSet rs = pst.executeQuery();

            jTable_equipos = new JTable(model);
            jScrollPane1.setViewportView(jTable_equipos);

            model.addColumn("ID equipo");
            model.addColumn("Tipo de equipo");
            model.addColumn("Marca");
            model.addColumn("Estatus");

            while (rs.next()) {
                Object[] fila = new Object[4];

                for (int i = 0; i < 4; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }
            cn.close();

        } catch (Exception e) {

            System.err.println("Error en el llenado de equipos " + e);
            JOptionPane.showMessageDialog(null, "CONTACTE CON ADMIN");

        }

        jTable_equipos.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jTable_equipos.rowAtPoint(e.getPoint());
                int columan_point = 0;  //para recuperar el username de cuando se da click

                if (fila_point > -1) {
                    IDequipo = (int) model.getValueAt(fila_point, columan_point);
                    InformacionEquipo info = new InformacionEquipo();
                    info.setVisible(true);
                }
            }

        });

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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_equipos = new javax.swing.JTable();
        jLabel_titulo = new javax.swing.JLabel();
        jLabel_Nombre = new javax.swing.JLabel();
        jLabel_Nombre1 = new javax.swing.JLabel();
        jLabel_Nombre2 = new javax.swing.JLabel();
        jLabel_Nombre4 = new javax.swing.JLabel();
        jLabel_Nombre6 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_mail = new javax.swing.JTextField();
        txt_telefono = new javax.swing.JTextField();
        txt_direccion = new javax.swing.JTextField();
        txt_registradopor = new javax.swing.JTextField();
        jButton_Actualizar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton_RegistarEquipo = new javax.swing.JButton();
        jButton_ImprimirReporte = new javax.swing.JButton();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_equipos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable_equipos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 68, 380, 170));

        jLabel_titulo.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_titulo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel_titulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_titulo.setText("Información del cliente");
        getContentPane().add(jLabel_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

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

        jLabel_Nombre4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel_Nombre4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre4.setText("Direccion:");
        getContentPane().add(jLabel_Nombre4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel_Nombre6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel_Nombre6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre6.setText("Ultima modificacion:");
        getContentPane().add(jLabel_Nombre6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

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

        txt_direccion.setBackground(new java.awt.Color(153, 153, 255));
        txt_direccion.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_direccion.setForeground(new java.awt.Color(255, 255, 255));
        txt_direccion.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_direccion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 210, -1));

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
        getContentPane().add(txt_registradopor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 210, -1));

        jButton_Actualizar.setBackground(new java.awt.Color(153, 153, 255));
        jButton_Actualizar.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jButton_Actualizar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Actualizar.setText("Actualizar cliente");
        jButton_Actualizar.setBorder(null);
        jButton_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 300, 210, 35));

        jLabel2.setText("Creado por acbonilla");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 390, -1, -1));

        jButton_RegistarEquipo.setBackground(new java.awt.Color(153, 153, 255));
        jButton_RegistarEquipo.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jButton_RegistarEquipo.setForeground(new java.awt.Color(255, 255, 255));
        jButton_RegistarEquipo.setText("Registrar equipo");
        jButton_RegistarEquipo.setBorder(null);
        jButton_RegistarEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RegistarEquipoActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_RegistarEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 250, 210, 35));

        jButton_ImprimirReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/impresora.png"))); // NOI18N
        jButton_ImprimirReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ImprimirReporteActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_ImprimirReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 240, 120, 100));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_telefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_telefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_telefonoActionPerformed

    private void txt_registradoporActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_registradoporActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_registradoporActionPerformed

    private void jButton_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ActualizarActionPerformed

        Border softBevelBorder = new SoftBevelBorder(BevelBorder.RAISED);
        int validacion = 0;
        String nombre, mail, telefono, direccion;
        mail = txt_mail.getText().trim();
        direccion = txt_direccion.getText().trim();
        nombre = txt_nombre.getText().trim();
        telefono = txt_telefono.getText().trim();

        if (mail.equals("")) {
            validacion++;
            txt_mail.setBorder(redBorder);
        } else {
            txt_mail.setBorder(softBevelBorder);
        }

        if (direccion.equals("")) {
            validacion++;
            txt_direccion.setBorder(redBorder);
        } else {
            txt_direccion.setBorder(softBevelBorder);
        }

        if (nombre.equals("")) {
            validacion++;
            txt_nombre.setBorder(redBorder);
        } else {
            txt_nombre.setBorder(softBevelBorder);
        }

        if (telefono.equals("")) {
            validacion++;
            txt_telefono.setBorder(redBorder);
        } else {
            txt_telefono.setBorder(softBevelBorder);
        }

        if (validacion == 0) {
            try {
                Connection cn2 = Conexion.conectar();
                PreparedStatement pst2 = cn2.prepareStatement("update clientes set nombre_cliente = ?, email_cliente = ?, tel_cliente=?, dir_cliente=? "
                        + "where id_cliente = '" + ID + "'");

                pst2.setString(1, nombre);
                pst2.setString(2, mail);
                pst2.setString(3, telefono);
                pst2.setString(4, direccion);

                pst2.executeUpdate();
                cn2.close();
                JOptionPane.showMessageDialog(null, "Modificación correcta");
            } catch (SQLException e) {

                System.err.println("Error en cargar cliente " + e);
                JOptionPane.showMessageDialog(null, "CONTACTE CON ADMIN");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
        }

    }//GEN-LAST:event_jButton_ActualizarActionPerformed

    private void jButton_RegistarEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RegistarEquipoActionPerformed

        RegistrarEquipo reg = new RegistrarEquipo();
        reg.setVisible(true);

    }//GEN-LAST:event_jButton_RegistarEquipoActionPerformed

    private void jButton_ImprimirReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ImprimirReporteActionPerformed

        Document documento = new Document();
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/" + txt_nombre.getText().trim() + ".pdf"));

            com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("src/images/BannerPDF.jpg");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);

            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Informacion del cliente. \n \n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.DARK_GRAY));

            documento.open();
            documento.add(header);
            documento.add(parrafo);

            PdfPTable tablaCliente = new PdfPTable(5);
            tablaCliente.addCell("ID");
            tablaCliente.addCell("Nombre");
            tablaCliente.addCell("email");
            tablaCliente.addCell("Télefono");
            tablaCliente.addCell("Dirección");

            try {

                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement("select * from clientes where id_cliente = '" + IDcliente + "'");

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    do {
                        tablaCliente.addCell(rs.getString(1));
                        tablaCliente.addCell(rs.getString(2));
                        tablaCliente.addCell(rs.getString(3));
                        tablaCliente.addCell(rs.getString(4));
                        tablaCliente.addCell(rs.getString(5));

                    } while (rs.next());

                    documento.add(tablaCliente);

                }

                Paragraph parrafo2 = new Paragraph();
                parrafo2.setAlignment(Paragraph.ALIGN_CENTER);
                parrafo2.add("\n \n Equipos Registrados. \n \n");
                parrafo2.setFont(FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.DARK_GRAY));

                documento.add(parrafo2);

                PdfPTable tablaEquipos = new PdfPTable(4);

                tablaEquipos.addCell("ID equipo");
                tablaEquipos.addCell("Tippo");
                tablaEquipos.addCell("Marca");
                tablaEquipos.addCell("Estatus");

                try {
                    Connection cn2 = Conexion.conectar();
                    PreparedStatement pst2 = cn2.prepareStatement
                    ("select id_equipo, tipo_equipo, marca, estatus from equipos where id_cliente = '" + IDcliente_update + "'");
                    
                    ResultSet rs2 = pst2.executeQuery();
                    
                    if (rs2.next()) {
                        do {                            
                            tablaEquipos.addCell(rs2.getString(1));
                            tablaEquipos.addCell(rs2.getString(2));
                            tablaEquipos.addCell(rs2.getString(3));
                            tablaEquipos.addCell(rs2.getString(4));
                        } while (rs2.next());
                        
                        documento.add(tablaEquipos);
                        
                    }
                    
                    
                } catch (SQLException e) {
                    
                    System.err.println("Error al cargar equipos " + e);
                }
            } catch (SQLException e) {
                System.err.println("Error al obtener los datos del cliente" + e);
            }
            
            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte creado correctamente");

        } catch (DocumentException | IOException e) {
            System.err.println("Error al cargar PDF " + e);
            JOptionPane.showMessageDialog(null, "Error al generar PDF, contacte con el admin");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_ImprimirReporteActionPerformed

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
            java.util.logging.Logger.getLogger(InformacionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformacionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformacionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformacionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformacionCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Actualizar;
    private javax.swing.JButton jButton_ImprimirReporte;
    private javax.swing.JButton jButton_RegistarEquipo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel_Nombre;
    private javax.swing.JLabel jLabel_Nombre1;
    private javax.swing.JLabel jLabel_Nombre2;
    private javax.swing.JLabel jLabel_Nombre4;
    private javax.swing.JLabel jLabel_Nombre6;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JLabel jLabel_titulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_equipos;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_mail;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_registradopor;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables

}
