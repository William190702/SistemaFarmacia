/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Clases.DetalleVenta;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;


public class MetodosDetalleVenta {

    // Método para agregar un producto al detalle de la venta
    public boolean agregarDetalleVenta(DetalleVenta detalleVenta) {
        String sql = "INSERT INTO detalle_ventas (id_detalle, id_venta, id_medicamento, cantidad, precio_unitario) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, detalleVenta.getIdDetalle());
            stmt.setString(2, detalleVenta.getIdVenta());
            stmt.setString(3, detalleVenta.getIdMedicamento());
            stmt.setInt(4, detalleVenta.getCantidad());
            stmt.setDouble(5, detalleVenta.getPrecioUnitario());

            int filasAfectadas = stmt.executeUpdate();
            if (filasAfectadas > 0) {
                // Si se agregó correctamente, actualizamos el stock
                return actualizarStockMedicamento(detalleVenta.getIdMedicamento(), detalleVenta.getCantidad());
            }
        } catch (SQLException e) {
            System.out.println("Error al agregar detalle de venta: " + e.getMessage());
        }
        return false;
    }

    // Método para actualizar el stock de un medicamento
    private boolean actualizarStockMedicamento(String idMedicamento, int cantidadVendida) {
        String sql = "UPDATE medicamentos SET stock = stock - ? WHERE id_medicamento = ?";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, cantidadVendida);
            stmt.setString(2, idMedicamento);

            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar el stock del medicamento: " + e.getMessage());
        }
        return false;
    } 
    
}
