
package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class conectar {
    
      Connection conectar = null;
     public Connection conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
             conectar = DriverManager.getConnection("jdbc:mysql://localhost/servidor3?user=root&password=");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.print(e.getMessage());
        }
        return conectar;
    }
    
}
