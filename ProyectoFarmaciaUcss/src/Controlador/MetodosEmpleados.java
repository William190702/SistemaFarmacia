/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MetodosEmpleados {

    // Método para agregar un empleado
    public static boolean agregarEmpleado(String idEmpleado, String dni, String nombre, String apellidoPaterno, 
                                          String apellidoMaterno, String direccion, Date fechaNacimiento, 
                                          String telefono, String correo, String puesto, 
                                          String usuario, String clave, String estado) {
        boolean exito = false;
        try (Connection conn = Conexion.getConexion()) {
            String sql = "{CALL InsertarEmpleado(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
            try (CallableStatement stmt = conn.prepareCall(sql)) {
                stmt.setString(1, idEmpleado);
                stmt.setString(2, dni);
                stmt.setString(3, nombre);
                stmt.setString(4, apellidoPaterno);
                stmt.setString(5, apellidoMaterno);
                stmt.setString(6, direccion);
                stmt.setDate(7, fechaNacimiento);
                stmt.setString(8, telefono);
                stmt.setString(9, correo);
                stmt.setString(10, puesto);
                stmt.setString(11, usuario);
                stmt.setString(12, clave);
                stmt.setString(13, estado); // Estado del empleado (ACTIVO o ELIMINADO)

                int filasAfectadas = stmt.executeUpdate();

                if (filasAfectadas > 0) {
                    JOptionPane.showMessageDialog(null, "Empleado agregado correctamente.");
                    exito = true;
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo agregar el empleado.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar el empleado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return exito;
    }

    // Método para verificar si el empleado existe por id utilizando el procedimiento adecuado
    public static boolean existeEmpleado(String idEmpleado) {
        boolean existe = false;
        try (Connection conn = Conexion.getConexion(); PreparedStatement stmt = conn.prepareStatement("SELECT id_empleado FROM empleados WHERE id_empleado = ?")) {
            stmt.setString(1, idEmpleado);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                existe = true;
            }

        } catch (SQLException e) {
            System.out.println("Error al verificar existencia de empleado: " + e.getMessage());
        }
        return existe;
    }

    // Método para actualizar un empleado
    public static boolean actualizarEmpleado(String idEmpleado, String dni, String nombre, String apellidoPaterno, 
                                             String apellidoMaterno, String direccion, Date fechaNacimiento, 
                                             String telefono, String correo, String puesto, 
                                             String usuario, String clave, String estado) {
        try (Connection conn = Conexion.getConexion()) {
            String sql = "{CALL ActualizarEmpleado(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
            try (CallableStatement stmt = conn.prepareCall(sql)) {
                stmt.setString(1, idEmpleado);
                stmt.setString(2, dni);
                stmt.setString(3, nombre);
                stmt.setString(4, apellidoPaterno);
                stmt.setString(5, apellidoMaterno);
                stmt.setString(6, direccion);
                stmt.setDate(7, fechaNacimiento);
                stmt.setString(8, telefono);
                stmt.setString(9, correo);
                stmt.setString(10, puesto);
                stmt.setString(11, usuario);
                stmt.setString(12, clave);
                stmt.setString(13, estado);  // Pasar el parámetro 'estado'

                int filasActualizadas = stmt.executeUpdate();
                return filasActualizadas > 0;
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar empleado: " + e.getMessage());
            return false;
        }
    }

    // Método para eliminar (desactivar) un empleado
    public static boolean eliminarEmpleado(String idEmpleado, String estado) {
        try (Connection conn = Conexion.getConexion()) {
            String sql = "{CALL EliminarEmpleado(?, ?)}";  // Pasar el parámetro de estado
            try (CallableStatement stmt = conn.prepareCall(sql)) {
                stmt.setString(1, idEmpleado);
                stmt.setString(2, estado);  // Cambiar el estado a 'ELIMINADO'
                int filasAfectadas = stmt.executeUpdate();
                return filasAfectadas > 0;
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar el empleado: " + e.getMessage());
            return false;
        }
    }

    // Método para consultar empleados por nombre utilizando el procedimiento consultar_empleado_por_nombre
    public static DefaultTableModel consultarEmpleadosPorNombre(String nombreParcial) {
        String sql = "{CALL consultar_empleado_por_nombre(?)}";  // Llamada al procedimiento
        DefaultTableModel modelo = new DefaultTableModel();

        try (Connection conn = Conexion.getConexion(); CallableStatement stmt = conn.prepareCall(sql)) {

            // Usamos el nombre parcial para obtener los empleados que coinciden
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
            System.out.println("Error al obtener empleados desde la base de datos: " + e.getMessage());
        }
        return modelo;
    }

    // Método para consultar todos los empleados activos
    public static ResultSet consultarEmpleadosActivos() {
        ResultSet rs = null;
        try (Connection conn = Conexion.getConexion()) {
            String sql = "SELECT * FROM empleados WHERE estado = 'ACTIVO'";  // Filtrar solo empleados activos
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                rs = stmt.executeQuery();
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar empleados activos: " + e.getMessage());
        }
        return rs;
    }

    // Método para obtener empleados eliminados (si es necesario)
    public static ResultSet consultarEmpleadosEliminados() {
        ResultSet rs = null;
        try (Connection conn = Conexion.getConexion()) {
            String sql = "SELECT * FROM empleados WHERE estado = 'ELIMINADO'";  // Filtrar empleados eliminados
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                rs = stmt.executeQuery();
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar empleados eliminados: " + e.getMessage());
        }
        return rs;
    }
}

