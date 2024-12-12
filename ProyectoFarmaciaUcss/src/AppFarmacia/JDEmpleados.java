/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package AppFarmacia;

import Controlador.Conexion;
import Controlador.MetodosEmpleados;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JDEmpleados extends javax.swing.JDialog {

    /**
     * Creates new form JDEmpleados
     */
    public JDEmpleados(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        inicializarTabla();
        cargarTablaEmpleados();
        tbEmpleados.setDefaultEditor(Object.class, null);
    }

    private void inicializarTabla() {
        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.setColumnIdentifiers(new String[]{
            "ID Empleado", "DNI", "Nombre", "Apellido Paterno", "Apellido Materno",
            "Dirección", "Fecha Nacimiento", "Teléfono", "Correo", "Puesto", "Estado", "Usuario", "Clave"
        });
        tbEmpleados.setModel(modeloTabla);
    }

    private void cargarTablaEmpleados() {
        DefaultTableModel modelo = new DefaultTableModel();
        String[] columnHeaders = {
            "ID Empleado", "DNI", "Nombre", "Apellido Paterno", "Apellido Materno",
            "Dirección", "Fecha Nacimiento", "Teléfono", "Correo", "Puesto", "Estado", "Usuario", "Clave"
        };
        modelo.setColumnIdentifiers(columnHeaders); // Establece los encabezados de las columnas

        try (Connection conn = Conexion.getConexion(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM empleados")) {

            while (rs.next()) {
                Object[] fila = new Object[columnHeaders.length];
                fila[0] = rs.getString("id_empleado");
                fila[1] = rs.getString("dni");
                fila[2] = rs.getString("nombre");
                fila[3] = rs.getString("apellido_paterno");
                fila[4] = rs.getString("apellido_materno");
                fila[5] = rs.getString("direccion");
                fila[6] = rs.getDate("fecha_nacimiento");
                fila[7] = rs.getString("telefono");
                fila[8] = rs.getString("correo");
                fila[9] = rs.getString("puesto");
                fila[10] = rs.getString("estado");
                fila[11] = rs.getString("usuario");  // Añadir usuario
                fila[12] = rs.getString("clave");    // Añadir clave

                modelo.addRow(fila);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar los empleados: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        tbEmpleados.setModel(modelo); // Asigna el modelo a la tabla
        tbEmpleados.repaint();
    }

    private void cargarTablaPorNombreEmpleado(String nombreParcial) {
        DefaultTableModel modelo = new DefaultTableModel();
        String[] columnHeaders = {
            "ID Empleado", "DNI", "Nombre", "Apellido Paterno", "Apellido Materno",
            "Dirección", "Fecha Nacimiento", "Teléfono", "Correo", "Puesto", "Estado", "Usuario", "Clave"
        };
        modelo.setColumnIdentifiers(columnHeaders);  // Establece los encabezados de las columnas

        // Llamamos al método que consulta los empleados por nombre
        try (Connection conn = Conexion.getConexion(); CallableStatement stmt = conn.prepareCall("{CALL consultar_empleado_por_nombre(?)}")) {

            // Pasamos el nombre parcial al procedimiento almacenado
            stmt.setString(1, "%" + nombreParcial + "%");
            ResultSet rs = stmt.executeQuery();  // Ejecuta la consulta

            // Recorrer los resultados y agregar filas al modelo de la tabla
            while (rs.next()) {
                Object[] fila = new Object[columnHeaders.length];
                fila[0] = rs.getString("id_empleado");
                fila[1] = rs.getString("dni");
                fila[2] = rs.getString("nombre");
                fila[3] = rs.getString("apellido_paterno");
                fila[4] = rs.getString("apellido_materno");
                fila[5] = rs.getString("direccion");
                fila[6] = rs.getDate("fecha_nacimiento");
                fila[7] = rs.getString("telefono");
                fila[8] = rs.getString("correo");
                fila[9] = rs.getString("puesto");
                fila[10] = rs.getString("estado");
                fila[11] = rs.getString("usuario");
                fila[12] = rs.getString("clave");

                modelo.addRow(fila);  // Agregar la fila al modelo de la tabla
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar los empleados: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        tbEmpleados.setModel(modelo);  // Asignar el modelo a la tabla
        tbEmpleados.repaint();         // Refrescar la tabla
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel12 = new javax.swing.JLabel();
        rbtnActivo = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        rbtnEliminado = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtIDemp = new javax.swing.JTextField();
        txtDniemp = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtNombreemp = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtapPaternoemp = new javax.swing.JTextField();
        txtClave = new javax.swing.JTextField();
        txtapMaternoemp = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        txtDireccionemp = new javax.swing.JTextField();
        btnSeleemp = new javax.swing.JButton();
        txtTelefonoemp = new javax.swing.JTextField();
        txtCorreoemp = new javax.swing.JTextField();
        txtPuestoemp = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtBuscaremp = new javax.swing.JTextField();
        Jdtfechanacemp = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbEmpleados = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnAgregaremp = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnLimpiarDatosemp = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnActualizaremp = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Estado:");

        rbtnActivo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbtnActivo.setText("Activo");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Telefono:");

        rbtnEliminado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbtnEliminado.setText("Eliminado");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Correo:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("ID Empleado:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Puesto Laboral:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Usuario:");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Clave:");

        txtapPaternoemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtapPaternoempActionPerformed(evt);
            }
        });

        txtapMaternoemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtapMaternoempActionPerformed(evt);
            }
        });

        txtDireccionemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionempActionPerformed(evt);
            }
        });

        btnSeleemp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSeleemp.setText("SELECCIONAR EMPLEADO");
        btnSeleemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleempActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Buscar Empleado:");

        txtBuscaremp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarempKeyPressed(evt);
            }
        });

        tbEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbEmpleados);

        jLabel1.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        jLabel1.setText("Registro del Empleado");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("DNI:");

        btnRegresar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/back.png"))); // NOI18N
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Nombre:");

        btnAgregaremp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAgregaremp.setText("AGREGAR");
        btnAgregaremp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarempActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Ap Paterno:");

        btnLimpiarDatosemp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLimpiarDatosemp.setText("LIMPIAR DATOS");
        btnLimpiarDatosemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarDatosempActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Ap Materno:");

        btnActualizaremp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnActualizaremp.setText("ACTUALIZAR");
        btnActualizaremp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarempActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Direccion:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Fecha Nac:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIDemp, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(155, 155, 155)
                        .addComponent(Jdtfechanacemp, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPuestoemp, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(153, 153, 153)
                                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTelefonoemp, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombreemp, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(153, 153, 153)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtapPaternoemp, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCorreoemp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(264, 264, 264)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel9)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(jLabel15)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDniemp, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccionemp, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtapMaternoemp, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbtnActivo)
                        .addGap(18, 18, 18)
                        .addComponent(rbtnEliminado))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(542, 542, 542)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtBuscaremp, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(591, 591, 591)
                                .addComponent(btnAgregaremp)
                                .addGap(18, 18, 18)
                                .addComponent(btnSeleemp, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnLimpiarDatosemp)
                                .addGap(18, 18, 18)
                                .addComponent(btnActualizaremp))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1333, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtIDemp, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7))
                                    .addComponent(Jdtfechanacemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(txtNombreemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel4)
                                            .addComponent(txtapPaternoemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(17, 17, 17)
                                .addComponent(txtTelefonoemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addGap(20, 20, 20))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel9)
                                                    .addComponent(txtCorreoemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtPuestoemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel14)
                                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel2)
                                            .addComponent(txtDniemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel5)
                                            .addComponent(txtapMaternoemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(17, 17, 17)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel6)
                                            .addComponent(txtDireccionemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel15)
                                            .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rbtnActivo)
                                    .addComponent(jLabel12)
                                    .addComponent(rbtnEliminado))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtBuscaremp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregaremp)
                            .addComponent(btnSeleemp)
                            .addComponent(btnLimpiarDatosemp)
                            .addComponent(btnActualizaremp))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtapPaternoempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtapPaternoempActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtapPaternoempActionPerformed

    private void txtapMaternoempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtapMaternoempActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtapMaternoempActionPerformed

    private void txtDireccionempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionempActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionempActionPerformed

    private void btnSeleempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleempActionPerformed
        int selectedRow = tbEmpleados.getSelectedRow();
        if (selectedRow != -1) {
            try {
                // Obtener los valores necesarios de la fila seleccionada
                String idemp = tbEmpleados.getValueAt(selectedRow, 0).toString();
                String nomb = tbEmpleados.getValueAt(selectedRow, 2).toString();
                String estado = tbEmpleados.getValueAt(selectedRow, 10).toString(); // Estado del empleado

                // Verificar si el estado es "desactivado"
                if (estado.equalsIgnoreCase("ELIMINADO")) {
                    JOptionPane.showMessageDialog(this, "Empleado ELIMINADO. No se puede seleccionar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    return; // Salir del método si el empleado está desactivado
                }

                // Pasar los datos al formulario principal si está activo
                if (FrmVentas.instancia != null) {
                    FrmVentas.instancia.FrmEmp(idemp, nomb);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontró el formulario principal.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Ocurrió un error al procesar la información.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un empleado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSeleempActionPerformed

    private void txtBuscarempKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarempKeyPressed
        String textoBusqueda = txtBuscaremp.getText().trim();

        // Llamamos al método para actualizar la tabla con los empleados filtrados
        cargarTablaPorNombreEmpleado(textoBusqueda);
    }//GEN-LAST:event_txtBuscarempKeyPressed

    private void tbEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbEmpleadosMouseClicked
        // Obtener la fila seleccionada
        // Obtener la fila seleccionada
        int filaSeleccionada = tbEmpleados.getSelectedRow();

        if (filaSeleccionada != -1) {
            // Obtener el modelo de la tabla
            DefaultTableModel modelo = (DefaultTableModel) tbEmpleados.getModel();

            // Asignar los valores de la fila seleccionada a los campos del formulario
            txtIDemp.setText(modelo.getValueAt(filaSeleccionada, 0).toString());       // ID Empleado
            txtDniemp.setText(modelo.getValueAt(filaSeleccionada, 1).toString());      // DNI
            txtNombreemp.setText(modelo.getValueAt(filaSeleccionada, 2).toString());   // Nombre
            txtapPaternoemp.setText(modelo.getValueAt(filaSeleccionada, 3).toString());// Apellido Paterno
            txtapMaternoemp.setText(modelo.getValueAt(filaSeleccionada, 4).toString());// Apellido Materno
            txtDireccionemp.setText(modelo.getValueAt(filaSeleccionada, 5).toString());// Dirección
            Jdtfechanacemp.setDate(java.sql.Date.valueOf(modelo.getValueAt(filaSeleccionada, 6).toString())); // Fecha Nacimiento
            txtTelefonoemp.setText(modelo.getValueAt(filaSeleccionada, 7).toString());// Teléfono
            txtCorreoemp.setText(modelo.getValueAt(filaSeleccionada, 8).toString());  // Correo
            txtPuestoemp.setText(modelo.getValueAt(filaSeleccionada, 9).toString());  // Puesto

            // Asignar usuario y clave
            txtUsuario.setText(modelo.getValueAt(filaSeleccionada, 11).toString());  // Usuario
            txtClave.setText(modelo.getValueAt(filaSeleccionada, 12).toString());    // Clave

            // Seleccionar el estado en los RadioButtons
            String estado = modelo.getValueAt(filaSeleccionada, 10).toString();       // Estado
            if (estado.equals("ACTIVO")) {
                rbtnActivo.setSelected(true);
                rbtnEliminado.setSelected(false);
            } else if (estado.equals("ELIMINADO")) {
                rbtnActivo.setSelected(false);
                rbtnEliminado.setSelected(true);
            }

            // Deshabilitar el campo de ID para evitar ediciones accidentales
            txtIDemp.setEditable(false);
        } else {
            JOptionPane.showMessageDialog(this, "Por favor seleccione una fila válida.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_tbEmpleadosMouseClicked

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        FrmOpciones frm = new FrmOpciones();
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnAgregarempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarempActionPerformed
        try {
            // Capturar los datos del formulario para los empleados
            String idEmpleado = txtIDemp.getText().trim().toUpperCase();
            String dni = txtDniemp.getText().trim();
            String nombre = txtNombreemp.getText().trim();
            String apellidoPaterno = txtapPaternoemp.getText().trim();
            String apellidoMaterno = txtapMaternoemp.getText().trim();
            String direccion = txtDireccionemp.getText().trim();
            java.util.Date fechaNacimiento = Jdtfechanacemp.getDate();
            String telefono = txtTelefonoemp.getText().trim();
            String correo = txtCorreoemp.getText().trim();
            String puesto = txtPuestoemp.getText().trim();
            String usuario = txtUsuario.getText().trim();
            String clave = txtClave.getText().trim();

            // Validar que los campos no estén vacíos
            if (idEmpleado.isEmpty() || dni.isEmpty() || nombre.isEmpty() || apellidoPaterno.isEmpty()
                    || apellidoMaterno.isEmpty() || direccion.isEmpty() || fechaNacimiento == null || usuario.isEmpty() || clave.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor complete todos los campos obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Validar que el DNI tenga 8 caracteres
            if (dni.length() != 8) {
                JOptionPane.showMessageDialog(this, "El DNI debe tener 8 caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Obtener el estado del empleado desde los radio buttons
            String estado = "";
            if (rbtnActivo.isSelected()) {
                estado = "ACTIVO";
            } else if (rbtnEliminado.isSelected()) {
                estado = "ELIMINADO";
            }

            if (estado.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor seleccione un estado para el empleado.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Verificar si el empleado ya existe
            if (MetodosEmpleados.existeEmpleado(idEmpleado)) {
                JOptionPane.showMessageDialog(this, "El empleado con este código ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Convertir java.util.Date a java.sql.Date
            java.sql.Date sqlFechaNacimiento = new java.sql.Date(fechaNacimiento.getTime());  // Conversión correcta

            // Llamar al método para agregar el empleado
            boolean exito = MetodosEmpleados.agregarEmpleado(idEmpleado, dni, nombre, apellidoPaterno, apellidoMaterno,
                    direccion, sqlFechaNacimiento, telefono, correo, puesto, usuario, clave, estado);

            if (exito) {
                cargarTablaEmpleados();
                btnLimpiarDatosempActionPerformed(evt); // Limpiar los campos
                JOptionPane.showMessageDialog(this, "Empleado agregado correctamente.");
            } else {
                JOptionPane.showMessageDialog(this, "Hubo un error al agregar el empleado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarempActionPerformed

    private void btnLimpiarDatosempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarDatosempActionPerformed
        txtIDemp.setText("");
        txtDniemp.setText("");
        txtNombreemp.setText("");
        txtapMaternoemp.setText("");
        txtapPaternoemp.setText("");
        txtDireccionemp.setText("");
        Jdtfechanacemp.setDate(null);
        txtTelefonoemp.setText("");
        txtCorreoemp.setText("");
        txtPuestoemp.setText("");
        txtUsuario.setText("");
        txtClave.setText("");
        txtIDemp.setEditable(true);
        txtIDemp.requestFocus();
        rbtnActivo.setSelected(true);
        rbtnEliminado.setSelected(false);
    }//GEN-LAST:event_btnLimpiarDatosempActionPerformed

    private void btnActualizarempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarempActionPerformed
        try {
            // Capturar los datos del formulario para los empleados
            String idEmpleado = txtIDemp.getText().trim().toUpperCase();
            String dni = txtDniemp.getText().trim();
            String nombre = txtNombreemp.getText().trim();
            String apellidoPaterno = txtapPaternoemp.getText().trim();
            String apellidoMaterno = txtapMaternoemp.getText().trim();
            String direccion = txtDireccionemp.getText().trim();
            java.util.Date fechaNacimiento = Jdtfechanacemp.getDate();
            String telefono = txtTelefonoemp.getText().trim();
            String correo = txtCorreoemp.getText().trim();
            String puesto = txtPuestoemp.getText().trim();
            String usuario = txtUsuario.getText().trim();
            String clave = txtClave.getText().trim();

            // Validar que los campos no estén vacíos
            if (idEmpleado.isEmpty() || dni.isEmpty() || nombre.isEmpty() || apellidoPaterno.isEmpty()
                    || apellidoMaterno.isEmpty() || direccion.isEmpty() || fechaNacimiento == null || usuario.isEmpty() || clave.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor complete todos los campos obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Validar que el DNI tenga 8 caracteres
            if (dni.length() != 8) {
                JOptionPane.showMessageDialog(this, "El DNI debe tener 8 caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Obtener el estado del empleado desde los radio buttons
            String estado = "";
            if (rbtnActivo.isSelected()) {
                estado = "ACTIVO";
            } else if (rbtnEliminado.isSelected()) {
                estado = "ELIMINADO";
            }

            if (estado.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor seleccione un estado para el empleado.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Convertir java.util.Date a java.sql.Date
            java.sql.Date sqlFechaNacimiento = new java.sql.Date(fechaNacimiento.getTime());  // Conversión correcta

            // Llamar al método para actualizar el empleado
            boolean exito = MetodosEmpleados.actualizarEmpleado(idEmpleado, dni, nombre, apellidoPaterno, apellidoMaterno,
                    direccion, sqlFechaNacimiento, telefono, correo, puesto, usuario, clave, estado);

            if (exito) {
                cargarTablaEmpleados();
                btnLimpiarDatosempActionPerformed(evt); // Limpiar los campos
                JOptionPane.showMessageDialog(this, "Empleado actualizado correctamente.");
            } else {
                JOptionPane.showMessageDialog(this, "Hubo un error al actualizar el empleado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnActualizarempActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JDEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDEmpleados dialog = new JDEmpleados(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser Jdtfechanacemp;
    private javax.swing.JButton btnActualizaremp;
    private javax.swing.JButton btnAgregaremp;
    private javax.swing.JButton btnLimpiarDatosemp;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnSeleemp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rbtnActivo;
    private javax.swing.JRadioButton rbtnEliminado;
    private javax.swing.JTable tbEmpleados;
    private javax.swing.JTextField txtBuscaremp;
    private javax.swing.JTextField txtClave;
    private javax.swing.JTextField txtCorreoemp;
    private javax.swing.JTextField txtDireccionemp;
    private javax.swing.JTextField txtDniemp;
    private javax.swing.JTextField txtIDemp;
    private javax.swing.JTextField txtNombreemp;
    private javax.swing.JTextField txtPuestoemp;
    private javax.swing.JTextField txtTelefonoemp;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JTextField txtapMaternoemp;
    private javax.swing.JTextField txtapPaternoemp;
    // End of variables declaration//GEN-END:variables
}
