/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.sql.*;
import javax.swing.JOptionPane;

public class MetodoReportes {

    // Método general para mostrar reportes
    public static void mostrarReporte(String sql, String tituloReporte) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConexion();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            // Crear el StringBuilder para mostrar los resultados
            StringBuilder reporte = new StringBuilder();
            reporte.append(tituloReporte).append(":\n\n");

            // Procesar los resultados
            while (rs.next()) {
                StringBuilder fila = new StringBuilder();
                int columnCount = rs.getMetaData().getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    fila.append(rs.getString(i)).append(" | ");
                }
                fila.setLength(fila.length() - 3);
                reporte.append(fila.toString()).append("\n");
            }

            // Mostrar el reporte en un JOptionPane
            JOptionPane.showMessageDialog(null, reporte.toString(), tituloReporte, JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al generar el reporte: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    // Reporte de medicamentos más vendidos
    public static void reporteMedicamentosMasVendidos() {
        String sql = "SELECT m.nombre AS Medicamento, SUM(dv.cantidad) AS TotalVendidos "
                + "FROM detalle_ventas dv "
                + "JOIN medicamentos m ON dv.id_medicamento = m.id_medicamento "
                + "GROUP BY m.nombre "
                + "ORDER BY TotalVendidos DESC";
        mostrarReporte(sql, "Reporte de Medicamentos Más Vendidos");
    }

    // Reporte de medicamentos por categoría
    public static void reporteMedicamentosPorCategoria() {
        String sql = "SELECT m.categoria AS Categoria, COUNT(m.id_medicamento) AS TotalMedicamentos "
                + "FROM medicamentos m "
                + "GROUP BY m.categoria "
                + "ORDER BY Categoria";
        mostrarReporte(sql, "Reporte de Medicamentos por Categoría");
    }
}
