package Controlador;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MetodoMedicamentos {

    // Método para agregar un medicamento
    public static boolean agregarMedicamento(String idMedicamento, String nombre, String categoria, String unidad,
            double precio, int stock, String estado) {
        boolean exito = false;
        try (Connection conn = Conexion.getConexion()) {
            String sql = "{CALL InsertarMedicamento(?, ?, ?, ?, ?, ?, ?)}";
            try (CallableStatement stmt = conn.prepareCall(sql)) {
                stmt.setString(1, idMedicamento);
                stmt.setString(2, nombre);
                stmt.setString(3, categoria);
                stmt.setString(4, unidad);
                stmt.setDouble(5, precio);
                stmt.setInt(6, stock);
                stmt.setString(7, estado);

                int filasAfectadas = stmt.executeUpdate();

                if (filasAfectadas > 0) {
                    JOptionPane.showMessageDialog(null, "Medicamento agregado correctamente.");
                    exito = true;
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo agregar el medicamento.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar el medicamento: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return exito;
    }

    // Método para verificar si el medicamento existe por id utilizando el procedimiento adecuado
    public static boolean existeMedicamento(String idMedicamento) {
        boolean existe = false;
        try (Connection conn = Conexion.getConexion(); PreparedStatement stmt = conn.prepareStatement("SELECT id_medicamento FROM medicamentos WHERE id_medicamento = ?")) {
            stmt.setString(1, idMedicamento);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                existe = true;
            }

        } catch (SQLException e) {
            System.out.println("Error al verificar existencia de medicamento: " + e.getMessage());
        }
        return existe;
    }

    // Método para actualizar un medicamento
    public static boolean actualizarMedicamento(String idMedicamento, String nombre, String categoria, String unidad,
            double precio, int stock, String estado) {
        try (Connection conn = Conexion.getConexion()) {
            String sql = "{CALL ActualizarMedicamento(?, ?, ?, ?, ?, ?, ?)}";
            try (CallableStatement stmt = conn.prepareCall(sql)) {
                stmt.setString(1, idMedicamento);
                stmt.setString(2, nombre);
                stmt.setString(3, categoria);
                stmt.setString(4, unidad);
                stmt.setDouble(5, precio);
                stmt.setInt(6, stock);
                stmt.setString(7, estado);  // Pasar el parámetro 'estado'

                int filasActualizadas = stmt.executeUpdate();
                return filasActualizadas > 0;
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar medicamento: " + e.getMessage());
            return false;
        }
    }

    // Método para eliminar (desactivar) un medicamento
    public static boolean eliminarMedicamento(String idMedicamento, String estado) {
        try (Connection conn = Conexion.getConexion()) {
            String sql = "{CALL EliminarMedicamento(?, ?)}";  // Pasar el parámetro de estado
            try (CallableStatement stmt = conn.prepareCall(sql)) {
                stmt.setString(1, idMedicamento);
                stmt.setString(2, estado);  // Cambiar el estado a 'ELIMINADO'
                int filasAfectadas = stmt.executeUpdate();
                return filasAfectadas > 0;
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar el medicamento: " + e.getMessage());
            return false;
        }
    }

    // Método para consultar medicamentos por nombre utilizando el procedimiento consultar_medicamento_por_nombre
    public static DefaultTableModel consultarMedicamentosPorNombre(String nombreParcial) {
        String sql = "{CALL consultar_medicamento_por_nombre(?)}";  // Llamada al procedimiento
        DefaultTableModel modelo = new DefaultTableModel();

        try (Connection conn = Conexion.getConexion(); CallableStatement stmt = conn.prepareCall(sql)) {

            // Usamos el nombre parcial para obtener los medicamentos que coinciden
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
            System.out.println("Error al obtener medicamentos desde la base de datos: " + e.getMessage());
        }
        return modelo;
    }

    // Método para consultar todos los medicamentos activos
    public static ResultSet consultarMedicamentosActivos() {
        ResultSet rs = null;
        try (Connection conn = Conexion.getConexion()) {
            String sql = "SELECT * FROM medicamentos WHERE estado = 'ACTIVO'";  // Filtrar solo medicamentos activos
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                rs = stmt.executeQuery();
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar medicamentos activos: " + e.getMessage());
        }
        return rs;
    }

    // Método para obtener medicamentos eliminados (si es necesario)
    public static ResultSet consultarMedicamentosEliminados() {
        ResultSet rs = null;
        try (Connection conn = Conexion.getConexion()) {
            String sql = "SELECT * FROM medicamentos WHERE estado = 'ELIMINADO'";  // Filtrar medicamentos eliminados
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                rs = stmt.executeQuery();
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar medicamentos eliminados: " + e.getMessage());
        }
        return rs;
    }
}
