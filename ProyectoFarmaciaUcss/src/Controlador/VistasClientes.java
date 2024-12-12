/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class VistasClientes {

    // Método para obtener todos los clientes activos desde la base de datos
    public static DefaultTableModel getModeloTbl() {
        String sql = "{CALL ConsultarClientesActivos()}";  // Llamada al procedimiento almacenado
        DefaultTableModel modelo = new DefaultTableModel();

        try (Connection conn = Conexion.getConexion(); CallableStatement stmt = conn.prepareCall(sql)) {

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

    // Método para consultar clientes eliminados desde la base de datos
    public static DefaultTableModel consultarClientesEliminados() {
        String sql = "{CALL ConsultarClientesEliminados()}";  // Llamada al procedimiento almacenado
        DefaultTableModel modelo = new DefaultTableModel();

        try (Connection conn = Conexion.getConexion(); CallableStatement stmt = conn.prepareCall(sql)) {

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
            System.out.println("Error al obtener clientes eliminados desde la base de datos: " + e.getMessage());
        }
        return modelo;
    }

}
