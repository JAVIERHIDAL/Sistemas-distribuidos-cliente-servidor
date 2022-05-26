
package Clases;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import javax.swing.table.DefaultTableModel;

public class Productos extends javax.swing.JFrame {

     String IP = "127.0.0.1";
    
    String IP1 = "192.168.43.135"; // clientes
    String IP2 = "192.168.43.70"; // ´productos
    String IP3 = "192.168.43.183"; // usuarios
    int PUERTO = 5000;

    boolean conexion = false, existencia = false;
    String respuesta, mensaje, HOST, sql, nomTabla;

    conectar cc = new conectar();
    java.sql.Connection cn = cc.conexion();
    
    public Productos() {
        initComponents();
        setLocationRelativeTo(null);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        menuEliminar = new javax.swing.JMenuItem();
        menuActualizar = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmdInsertar = new javax.swing.JButton();
        cmdActualizar = new javax.swing.JButton();
        cmdVerTodo = new javax.swing.JButton();
        cmdBuscar = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtStock = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDatos = new javax.swing.JTable();
        cmdMenu = new javax.swing.JButton();

        menuEliminar.setText("Eliminar");
        menuEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEliminarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(menuEliminar);

        menuActualizar.setText("Actualizart");
        menuActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuActualizarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(menuActualizar);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));
        jPanel2.setForeground(new java.awt.Color(0, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
        jLabel1.setText("PRODUCTOS");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, -1, -1));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jLabel2.setText("ID");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jLabel3.setText("NOMBRE");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jLabel4.setText("STOCK");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jLabel5.setText("PRECIO");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, -1, -1));

        cmdInsertar.setText("INSERTAR");
        cmdInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdInsertarActionPerformed(evt);
            }
        });
        jPanel1.add(cmdInsertar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 90, -1, -1));

        cmdActualizar.setText("ACTUALIZAR");
        cmdActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(cmdActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 140, -1, -1));

        cmdVerTodo.setText("VER TODO");
        cmdVerTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdVerTodoActionPerformed(evt);
            }
        });
        jPanel1.add(cmdVerTodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 180, -1, -1));

        cmdBuscar.setText("BUSCAR");
        cmdBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(cmdBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 220, -1, -1));
        jPanel1.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 60, 30));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 110, 30));
        jPanel1.add(txtStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 140, 30));
        jPanel1.add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 140, 30));

        tbDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE", "DIRECCION", "TELEFONO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbDatos.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(tbDatos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 530, 230));

        cmdMenu.setText("Menu");
        cmdMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdMenuActionPerformed(evt);
            }
        });
        jPanel1.add(cmdMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 350, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdInsertarActionPerformed
        nomTabla = "productos";
        comprobarExistencia("SHOW TABLES like '%" + nomTabla + "%'");
        if (existencia) {
            try {
                PreparedStatement pst = cn.prepareStatement("INSERT INTO " + nomTabla + " (id, nombre, stock, precio) VALUES (?,?,?,?);");
                pst.setString(1, txtID.getText());
                pst.setString(2, txtNombre.getText());
                pst.setString(3, txtStock.getText());
                pst.setString(4, txtPrecio.getText());
                int x = pst.executeUpdate();
                if (x > 0) {
                    JOptionPane.showMessageDialog(null, "Se guardó correctarmente");

                    sql = "SELECT * FROM " + nomTabla + ";";

                    txtID.setText("");
                    txtNombre.setText("");
                    txtStock.setText("");
                    txtPrecio.setText("");

                    MostrarDatos();
                }
            } catch (Exception we) {
                JOptionPane.showMessageDialog(null, we, "Error", JOptionPane.WARNING_MESSAGE);
            }
        } else {

            HOST = IP2;
            mensaje = "INSERT INTO " + nomTabla + " (id, nombre, stock, precio) VALUES ('" + txtID.getText() + "','" + txtNombre.getText() + "','" + txtStock.getText() + "','" + txtPrecio.getText() + "');";
            sockerCliente();

        }
    }//GEN-LAST:event_cmdInsertarActionPerformed

    private void cmdActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdActualizarActionPerformed
        // TODO add your handling code here:
        nomTabla = "productos";

        comprobarExistencia("SHOW TABLES like '%" + nomTabla + "%'");
        if (existencia) {

            try {
                PreparedStatement pst = cn.prepareStatement("UPDATE " + nomTabla + " SET nombre='" + txtNombre.getText()
                    + "',stock='" + txtStock.getText()
                    + "',precio='" + txtPrecio.getText()
                    + "' WHERE id = '" + txtID.getText() + "'");

                int x = pst.executeUpdate();
                if (x > 0) {

                    JOptionPane.showMessageDialog(null, "Se actualizó correctarmente");
                    String sql = "SELECT * FROM " + nomTabla + " WHERE id = '" + txtID.getText() + "'";
                    MostrarDatos();

                    txtID.setText("");
                    txtStock.setText("");
                    txtPrecio.setText("");
                    txtID.setEditable(true);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.WARNING_MESSAGE);
            }
        } else {

            HOST = IP2;
            mensaje = "UPDATE "+nomTabla+" SET nombre='"+txtNombre.getText()+"',stock='"+txtStock.getText()+"',precio='"+txtPrecio.getText()+"' WHERE id='"+txtID.getText()+";";
            sockerCliente();
            txtID.setEditable(true);
        }
    }//GEN-LAST:event_cmdActualizarActionPerformed

    private void cmdVerTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdVerTodoActionPerformed
        // TODO add your handling code here

        nomTabla = "productos"; // Definimosel nombre de la tabla

        comprobarExistencia("SHOW TABLES like '%" + nomTabla + "%'");
        if (existencia) {

            sql = "SELECT * FROM " + nomTabla + ";";

            MostrarDatos();
        } else {
            HOST = IP2;
            mensaje = "SELECT * FROM " + nomTabla + ";";
            sockerCliente();
        }
    }//GEN-LAST:event_cmdVerTodoActionPerformed

    private void cmdBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdBuscarActionPerformed
        nomTabla = "productos";
        comprobarExistencia("SHOW TABLES like '%" + nomTabla + "%'");
        if (existencia) {

            if (txtID.getText().isEmpty()) {
                if (txtNombre.getText().isEmpty()) {

                    if (txtStock.getText().isEmpty()) {
                        if (txtPrecio.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(this, "Especifique un criterio de búsqueda ", "Error", JOptionPane.WARNING_MESSAGE);
                        } else {

                            sql = "SELECT * FROM " + nomTabla + " WHERE precio LIKE '%" + txtPrecio.getText() + "%'";
                            MostrarDatos();
                        }

                    } else {
                        sql = "SELECT * FROM " + nomTabla + " WHERE stock LIKE '%" + txtStock.getText() + "%'";
                        MostrarDatos();
                    }
                } else {
                    sql = "SELECT * FROM " + nomTabla + " WHERE nombre LIKE '%" + txtNombre.getText() + "%'";
                    MostrarDatos();
                }

            } else {

                sql = "SELECT * FROM " + nomTabla + " WHERE id LIKE '%" + txtID.getText() + "%'";
                MostrarDatos();

            }
        } else {

            if (txtID.getText().isEmpty()) {
                if (txtNombre.getText().isEmpty()) {

                    if (txtStock.getText().isEmpty()) {
                        if (txtPrecio.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(this, "Especifique un criterio de búsqueda ", "Error", JOptionPane.WARNING_MESSAGE);
                        } else {
                            HOST = IP2;
                            mensaje = "SELECT * FROM " + nomTabla + " WHERE precio LIKE '%" + txtPrecio.getText() + "%'";
                            sockerCliente();
                        }

                    } else {
                        HOST = IP2;
                        mensaje = "SELECT * FROM " + nomTabla + " WHERE stock LIKE '%" + txtStock.getText() + "%'";
                        sockerCliente();
                    }
                } else {
                    HOST = IP2;
                    mensaje = "SELECT * FROM " + nomTabla + " WHERE nombre LIKE '%" + txtNombre.getText() + "%'";
                    sockerCliente();
                }

            } else {
                HOST = IP2;
                mensaje = "SELECT * FROM " + nomTabla + " WHERE id LIKE '%" + txtID.getText() + "%'";
                sockerCliente();
            }
        }
    }//GEN-LAST:event_cmdBuscarActionPerformed

    private void cmdMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdMenuActionPerformed
        // TODOuctos add your handling code here:
        Inicio u = new Inicio();
        u.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cmdMenuActionPerformed

    private void menuEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEliminarActionPerformed
        // TODO add your handling code here:
              nomTabla = "productos";

        String cod = "";

        comprobarExistencia("SHOW TABLES like '%" + nomTabla + "%'");
        if (existencia) {

            int fila = tbDatos.getSelectedRow();

            cod = tbDatos.getValueAt(fila, 0).toString();

            int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro que quieres eliminar el registro?", "Alerta!", JOptionPane.YES_NO_OPTION);
            if (resp == YES_NO_OPTION) {
                try {
                    PreparedStatement pst = cn.prepareStatement("DELETE FROM " + nomTabla + " WHERE id ='" + cod + "'");
                    int x = pst.executeUpdate();
                    if (x > 0) {
                        getToolkit().beep();
                        JOptionPane.showMessageDialog(null, "Ha sido borrado exitosamente", "Confirmación de borrado", JOptionPane.INFORMATION_MESSAGE);
                        String sql = "SELECT * FROM " + nomTabla + ";";
                        MostrarDatos();
                    }
                } catch (Exception e) {
                    Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        } else {
            int fila = tbDatos.getSelectedRow();
            cod = tbDatos.getValueAt(fila, 0).toString();

            int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro que quieres eliminar el registro?", "Alerta!", JOptionPane.YES_NO_OPTION);
            if (resp == YES_NO_OPTION) {

                HOST = IP2;
                mensaje = "DELETE FROM " + nomTabla + " WHERE id ='" + cod + "'";
                sockerCliente();

            }
        }
    }//GEN-LAST:event_menuEliminarActionPerformed

    private void menuActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuActualizarActionPerformed
        // TODO add your handling code here:
             nomTabla = "productos";

        txtID.setEditable(false);

        int fila = tbDatos.getSelectedRow();
        if (fila >= 0) {
            txtID.setText(tbDatos.getValueAt(fila, 0).toString());
            txtNombre.setText(tbDatos.getValueAt(fila, 1).toString());
            txtStock.setText(tbDatos.getValueAt(fila, 2).toString());
            txtPrecio.setText(tbDatos.getValueAt(fila, 3).toString());
        } else {
            JOptionPane.showMessageDialog(null, "No selecciono fila", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_menuActualizarActionPerformed

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
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Productos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdActualizar;
    private javax.swing.JButton cmdBuscar;
    private javax.swing.JButton cmdInsertar;
    private javax.swing.JButton cmdMenu;
    private javax.swing.JButton cmdVerTodo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem menuActualizar;
    private javax.swing.JMenuItem menuEliminar;
    private javax.swing.JTable tbDatos;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables

     public void conectar() {
        if (cn == null) {
            JOptionPane.showMessageDialog(null, "No conectado");
            conexion = false;
        } else {
            //JOptionPane.showMessageDialog(null, "Conectado");
            conexion = true;
        }
    }

    public void comprobarExistencia(String sql) {
        try {
            Statement q = cn.createStatement();
            ResultSet w = q.executeQuery(sql);

            String[] consulta = new String[1];
            String aux = "";

            while (w.next()) {
                // codigo
                aux = consulta[0] = w.getString(1);
            }

            if (aux.isEmpty()) {
                existencia = false;
            } else {
                 existencia = true;
            //    existencia = false;

            }

        } catch (SQLException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.WARNING_MESSAGE);

        }
    }

    public void sockerCliente() {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("STOCK");
        modelo.addColumn("PRECIO");
        String[] datos = new String[4];

        int cont = 0, fin = 0;
        String aux = "";

        DataInputStream in;  
        DataOutputStream out;  

        try {
         
            Socket sc = new Socket(HOST, PUERTO);

            in = new DataInputStream(sc.getInputStream()); 
            out = new DataOutputStream(sc.getOutputStream()); 

            out.writeUTF(mensaje); 

            System.out.println("Mensaje del cliente: " + mensaje); 

            respuesta = in.readUTF(); 
            System.out.println("Respuesta del servidor: " + respuesta); 

            if ((respuesta.contains("Conectado")) || respuesta.contains("Desconectado") || respuesta.contains("Se") || respuesta.contains("Ha")) {
                if (respuesta.contains("insertó")) {
                    JOptionPane.showMessageDialog(null, "Se guardó correctarmente");

                    txtID.setText("");
                    txtNombre.setText("");
                    txtStock.setText("");
                    txtPrecio.setText("");

                } else {
                    if (respuesta.contains("actualizó")) {
                        JOptionPane.showMessageDialog(null, "Se actualizó correctarmente");

                        txtID.setText("");
                        txtNombre.setText("");
                        txtStock.setText("");
                        txtPrecio.setText("");
                    } else {
                        if (respuesta.contains("borrado")) {
                            JOptionPane.showMessageDialog(null, "Ha sido borrado exitosamente");
                        } else {

                        }
                    }
                }

            } else {
                if (respuesta.equals("(0)")) {

                } else {

                    fin = respuesta.lastIndexOf(",");
                    cont = Integer.parseInt(respuesta.substring(1, 2));
                    respuesta = respuesta.substring(3, fin + 1);
                    for (int x = 1; x <= cont; x++) {
                        separarRegistros(modelo, datos);
                    }
                }
            }

            if (respuesta.equals("")) {
                sc.close();
            }

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Servidor no encontrado - Verifique la dirección IP", "Error", JOptionPane.WARNING_MESSAGE);
        }
        modelo = null;
        datos = null;

    }

    public void MostrarDatos() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("STOCK");
        modelo.addColumn("PRECIO");
        String[] consulta = new String[4];
        try {

            Statement q = cn.createStatement();
            ResultSet w = q.executeQuery(sql);

            while (w.next()) {

                // id
                consulta[0] = w.getString(1);

                // nombre
                consulta[1] = w.getString(2);

                // direccion
                consulta[2] = w.getString(3);

                // telefono
                consulta[3] = w.getString(4);

                String[] datos = new String[4];
                datos[0] = consulta[0];
                datos[1] = consulta[1];
                datos[2] = consulta[2];
                datos[3] = consulta[3];
                modelo.addRow(datos);
            }

            tbDatos.setModel(modelo);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void separarRegistros(DefaultTableModel modelo, String[] datos) {
        String registro = "";
        int inicio = respuesta.indexOf(",");
        int fin = respuesta.lastIndexOf(",");
        registro = respuesta.substring(0, inicio);
        respuesta = respuesta.substring(inicio + 1, respuesta.length());

        separarColumnas(registro, modelo, datos);

    }

    public void separarColumnas(String registro, DefaultTableModel modelo, String[] datos) {
        char[] vector = new char[registro.length()];
        String aux, col;
        int cont = 0;

        for (int x = 0; x < registro.length(); x++) {
            aux = String.valueOf(vector[x] = registro.charAt(x));
            if (aux.equals(" ")) {
                cont++;
            }
        }

        int[] vector2 = new int[cont];
        String[] valores = new String[cont];

        int c = 0;
        for (int x = 0; x < registro.length(); x++) {
            aux = String.valueOf(vector[x] = registro.charAt(x));
            if (aux.equals(" ")) {
                vector2[c] = x;
            }
        }
        String aux2;
        for (int y = 0; y < cont; y++) {
            int inicio = registro.indexOf(" ");
            aux2 = registro.substring(0, inicio);
            registro = registro.substring(inicio + 1, registro.length());

            System.out.println("aux2: " + aux2);
            datos[y] = aux2;

            if (y == (cont - 1)) {
                System.out.println("a: " + registro);
                datos[y + 1] = registro;
            }
        }
        modelo.addRow(datos);
        tbDatos.setModel(modelo);
    }
}
