/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MetodosClientes {

    // Método para agregar un cliente
    public static boolean agregarCliente(String idCliente, String dni, String nombre, String apellidoPaterno, 
                                         String apellidoMaterno, String telefono, String correo, String estado) {
        boolean exito = false;
        try (Connection conn = Conexion.getConexion()) {
            String sql = "{CALL InsertarCliente(?, ?, ?, ?, ?, ?, ?, ?)}";
            try (CallableStatement stmt = conn.prepareCall(sql)) {
                stmt.setString(1, idCliente);
                stmt.setString(2, dni);
                stmt.setString(3, nombre);
                stmt.setString(4, apellidoPaterno);
                stmt.setString(5, apellidoMaterno);
                stmt.setString(6, telefono);
                stmt.setString(7, correo);
                stmt.setString(8, estado);  // Estado del cliente (ACTIVO o ELIMINADO)

                int filasAfectadas = stmt.executeUpdate();

                if (filasAfectadas > 0) {
                    JOptionPane.showMessageDialog(null, "Cliente agregado correctamente.");
                    exito = true;
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo agregar el cliente.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar el cliente: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return exito;
    }

    // Método para verificar si el cliente existe por id utilizando el procedimiento adecuado
    public static boolean existeCliente(String idCliente) {
        boolean existe = false;
        try (Connection conn = Conexion.getConexion(); PreparedStatement stmt = conn.prepareStatement("SELECT id_cliente FROM clientes WHERE id_cliente = ?")) {
            stmt.setString(1, idCliente);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                existe = true;
            }

        } catch (SQLException e) {
            System.out.println("Error al verificar existencia de cliente: " + e.getMessage());
        }
        return existe;
    }

   public static boolean actualizarCliente(String idCliente, String dni, String nombre, String apellidoPaterno, 
                                        String apellidoMaterno, String telefono, String correo, String estado) {
    try (Connection conn = Conexion.getConexion()) {
        // Aquí se eliminó el parámetro 'estado'
        String sql = "{CALL ActualizarCliente(?, ?, ?, ?, ?, ?, ?, ?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setString(1, idCliente);
            stmt.setString(2, dni);
            stmt.setString(3, nombre);
            stmt.setString(4, apellidoPaterno);
            stmt.setString(5, apellidoMaterno);
            stmt.setString(6, telefono);
            stmt.setString(7, correo);
            stmt.setString(8, estado);  // Aquí se mantuvo 'estado' en el código
            int filasActualizadas = stmt.executeUpdate();
            return filasActualizadas > 0;
        }
    } catch (SQLException e) {
        System.out.println("Error al actualizar cliente: " + e.getMessage());
        return false;
    }
}


    // Método para eliminar (desactivar) un cliente
    public static boolean eliminarCliente(String idCliente, String estado) {
        try (Connection conn = Conexion.getConexion()) {
            String sql = "{CALL EliminarCliente(?, ?)}";  // Pasar el parámetro de estado
            try (CallableStatement stmt = conn.prepareCall(sql)) {
                stmt.setString(1, idCliente);
                stmt.setString(2, estado);  // Cambiar el estado a 'ELIMINADO'
                int filasAfectadas = stmt.executeUpdate();
                return filasAfectadas > 0;
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar el cliente: " + e.getMessage());
            return false;
        }
    }

    // Método para consultar clientes por nombre utilizando el procedimiento consultar_cliente_por_nombre
    public static DefaultTableModel consultarClientesPorNombre(String nombreParcial) {
        String sql = "{CALL consultar_cliente_por_nombre(?)}";  // Llamada al procedimiento
        DefaultTableModel modelo = new DefaultTableModel();

        try (Connection conn = Conexion.getConexion(); CallableStatement stmt = conn.prepareCall(sql)) {

            // Usamos el nombre parcial para obtener los clientes que coinciden
            stmt.setString(1, nombreParcial);
            ResultSet rs = stmt.executeQuery();

            ResultSetMetaData rsMetaData = rs.getMetaData();
            int cols = rsMetaData.getColumnCount();
            String[] etiquetas = new String[cols];

            // Obtener los nombres de las columnas
            for (int i = 1; i <= cols; i++) {
                etiquetas[i - 1] = rsMetaData.getColumnLabel(i);
            }
            modelo.setColumnIdentifiers(etiquetas);

            // Recorrer los resultados y agregar filas al modelo
            while (rs.next()) {
                Object[] fila = new Object[cols];
                for (int i = 0; i < cols; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                modelo.addRow(fila);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener clientes desde la base de datos: " + e.getMessage());
        }
        return modelo;
    }

    // Método para consultar todos los clientes activos
    public static ResultSet consultarClientesActivos() {
        ResultSet rs = null;
        try (Connection conn = Conexion.getConexion()) {
            String sql = "SELECT * FROM clientes WHERE estado = 'ACTIVO'";  // Filtrar solo clientes activos
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                rs = stmt.executeQuery();
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar clientes activos: " + e.getMessage());
        }
        return rs;
    }

    // Método para obtener clientes eliminados (si es necesario)
    public static ResultSet consultarClientesEliminados() {
        ResultSet rs = null;
        try (Connection conn = Conexion.getConexion()) {
            String sql = "SELECT * FROM clientes WHERE estado = 'ELIMINADO'";  // Filtrar clientes eliminados
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                rs = stmt.executeQuery();
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar clientes eliminados: " + e.getMessage());
        }
        return rs;
    }
}
