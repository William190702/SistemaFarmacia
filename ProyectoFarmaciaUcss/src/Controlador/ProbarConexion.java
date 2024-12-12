package Controlador;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProbarConexion {

    public static void main(String[] args) {
        Connection conn = null;

        System.out.println("Intentando obtener una conexión desde Conexion...");
        conn = Conexion.getConexion();
        if (conn != null) {
            System.out.println("¡Conexión exitosa a la base de datos MySQL!");
        } else {
            System.out.println("No se pudo establecer la conexión.");
        }
        try {
            if (conn != null) {
                conn.close(); // Cerrar la conexión
                System.out.println("Conexión cerrada.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProbarConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
