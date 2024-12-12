package Controlador;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class VistaMedicamentos {

    // Método para obtener todos los medicamentos desde la base de datos
    public static DefaultTableModel getModeloTbl() {
        String sql = "{CALL consultar_medicamento_por_nombre(?)}";  // Llamada al procedimiento
        DefaultTableModel modelo = new DefaultTableModel();

        try (Connection conn = Conexion.getConexion(); CallableStatement stmt = conn.prepareCall(sql)) {

            // Usamos un nombre parcial vacío para obtener todos los medicamentos
            stmt.setString(1, "");
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

    // Método privado para ejecutar una consulta SQL genérica
    private static DefaultTableModel ejecutarConsulta(String sql) {
        DefaultTableModel modelo = new DefaultTableModel();
        try (Connection conn = Conexion.getConexion(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            ResultSetMetaData rsMetaData = rs.getMetaData();
            int cols = rsMetaData.getColumnCount();
            String[] etiquetas = new String[cols];

            // Obtener etiquetas de las columnas
            for (int i = 1; i <= cols; i++) {
                etiquetas[i - 1] = rsMetaData.getColumnLabel(i);
            }
            modelo.setColumnIdentifiers(etiquetas);

            // Agregar filas al modelo
            while (rs.next()) {
                Object[] fila = new Object[cols];
                for (int i = 0; i < cols; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                modelo.addRow(fila);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el modelo de tabla de medicamentos: " + e.getMessage());
        }
        return modelo;
    }

}
