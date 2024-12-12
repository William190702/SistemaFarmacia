/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Clases.Venta;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MetodosVenta {

    public boolean registrarVenta(Venta venta) {
        String sql = "INSERT INTO ventas (id_venta, id_cliente, id_empleado, fecha_venta, total) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, venta.getIdVenta());
            stmt.setString(2, venta.getIdCliente());
            stmt.setString(3, venta.getIdEmpleado());
            stmt.setDate(4, new java.sql.Date(venta.getFechaVenta().getTime()));
            stmt.setDouble(5, venta.getTotal());

            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.out.println("Error al registrar la venta: " + e.getMessage());
        }
        return false;
    }
    public boolean idVentaExiste(String idVenta) {
        String query = "SELECT COUNT(*) FROM ventas WHERE id_venta = ?";
        try (Connection conn = Conexion.getConexion(); // Conexión a la base de datos
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, idVenta);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0; // Retorna true si el ID ya existe
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false; // Retorna false si ocurre un error o no encuentra el ID
    }

    // Método para actualizar el total de la venta después de agregar un producto
    public boolean actualizarTotalVenta(String idVenta, double nuevoTotal) {
        String sql = "UPDATE ventas SET total = ? WHERE id_venta = ?";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, nuevoTotal);
            stmt.setString(2, idVenta);

            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar el total de la venta: " + e.getMessage());
        }
        return false;
    }
}
