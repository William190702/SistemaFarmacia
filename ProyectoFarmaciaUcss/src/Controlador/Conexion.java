package Controlador;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public static synchronized Connection getConexion() {
        Connection conex = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost/SistemaFarmacia?serverTimezone=UTC";
            String usr = "root";
            String psw = "";
            conex = DriverManager.getConnection(url, usr, psw);
            System.out.println("Conexion Realizada");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error >> Driver no Instalado!!");
        } catch (SQLException ex) {
            System.out.println(ex + "Error >> de conexion con la BD");
        }
        return conex;
    }
}
