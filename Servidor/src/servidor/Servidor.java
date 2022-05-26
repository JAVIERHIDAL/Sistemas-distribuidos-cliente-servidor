/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author alvar
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    conectar cc = new conectar();
    java.sql.Connection cn = cc.conexion();

    boolean conexion;
    String respuesta = "";
    String mensaje = "";

    boolean validacion = true;
    public static void main(String[] args) {
        // TODO code application logic here
        Servidor a = new Servidor();
        a.conectar();
        a.sockerServidor();
        
    }
    
     public void conectar() {
        if (cn == null) {
            JOptionPane.showMessageDialog(null, "No conectado");
            conexion = false;
        } else {
            //JOptionPane.showMessageDialog(null, "Conectado");
            conexion = true;
        }
    }

    public void sockerServidor() {
        if (conexion) {

            ServerSocket servidor = null;
            Socket sc = null;   
            DataInputStream in; 
            DataOutputStream out;   
            final int PUERTO = 5000;

            try {
                servidor = new ServerSocket(PUERTO);
                System.out.println("------------------- Servidor iniciado HP NEGRA ------------------- ");

                while (true) {
                    sc = servidor.accept();

                    in = new DataInputStream(sc.getInputStream()); //recibe/lee mensajes del cliente
                    out = new DataOutputStream(sc.getOutputStream());

                    mensaje = in.readUTF();  //lee el mensaje

                    if (mensaje.contains("Bye")) {
                        out.writeUTF("Desconectado de servidor HP GRIS");
                        sc.close(); //cerramos/desconectamos el cliente
                        System.out.println("Mensaje del cliente: " + mensaje);
                        System.out.println("Respuesta del servidor: Desconectado de servidor HP GRIS");
                        System.out.println("------------------- Servidor apagado HP GRIS ------------------- ");
                        break;

                    } else {

                        System.out.println("Mensaje del cliente: " + mensaje); //imprim el mensaje
                        System.out.print("Respuesta del servidor:");

                        validacion();

                        out.writeUTF(respuesta); // manda/escribe un mensaje al cliente
                    }
                }

            } catch (IOException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void consulta() {

        int cont = 0;
        respuesta = "";
        String[] consulta = new String[4];

        try {
            Statement q = cn.createStatement();
            ResultSet w = q.executeQuery(mensaje);

            while (w.next()) {

                respuesta += consulta[0] = w.getString(1) + "*";

                respuesta += consulta[1] = w.getString(2) + "*";

                respuesta += consulta[2] = w.getString(3) + "*";

                respuesta += ((consulta[3] = w.getString(4)) + ",");

                cont++;
            }
            respuesta = "(" + cont + ")" + respuesta;
        } catch (SQLException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.WARNING_MESSAGE);
        }
        System.out.println(respuesta);
    }

    public void actualizar() {
        respuesta = "";
        try {
            PreparedStatement pst = cn.prepareStatement(mensaje);
            int x = pst.executeUpdate();
            if (x > 0) {

                System.out.println("Se actualizó correctamente");
                respuesta = "Se actualizó correctarmente";
            }
        } catch (Exception e) {
            System.out.println("SocketServidor - Linea 138");
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.WARNING_MESSAGE);
            System.out.print(e.getMessage());
        }
    }

    public void insertar() {
        respuesta = "";
        try {
            PreparedStatement pst = cn.prepareStatement(mensaje);
            int x = pst.executeUpdate();
            if (x > 0) {
                System.out.println("Se insertó correctamente");
                respuesta = "Se insertó correctarmente";
            }
        } catch (Exception we) {
            System.out.println("linea 156 - SocketServidor");
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, we);
            JOptionPane.showMessageDialog(null, we, "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void eliminar() {
        respuesta = "";
        try {
            PreparedStatement pst = cn.prepareStatement(mensaje);
            int x = pst.executeUpdate();
            if (x > 0) {
                System.out.println("Se Ha sido borrado exitosamente");
                respuesta = "Ha sido borrado exitosamente";
            }
        } catch (Exception e) {
            System.out.println("linea 174 - SocketServidor");
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void validacion() {
        validacion = mensaje.matches("SELECT.*");

        if (validacion) {
            consulta();
        } else {
            validacion = mensaje.matches("UPDATE.*");
            if (validacion) {
                actualizar();

            } else {
                validacion = mensaje.matches("INSERT.*");
                if (validacion) {
                    insertar();

                } else {
                    validacion = mensaje.matches("DELETE.*");
                    if (validacion) {
                        eliminar();
                    } else {
                        respuesta = "Conectado a servidor DELL";
                        System.out.println(respuesta);
                    }
                }
            }
        }
    }
    
}
