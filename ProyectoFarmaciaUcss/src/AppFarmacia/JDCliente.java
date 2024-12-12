/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package AppFarmacia;

import Controlador.Conexion;
import Controlador.MetodosClientes;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JDCliente extends javax.swing.JDialog {

    public JDCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        inicializarTabla();
        cargarTablaClientes();
        tbClientes.setDefaultEditor(Object.class, null);
    }

    private void inicializarTabla() {
        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.setColumnIdentifiers(new String[]{
            "ID Cliente", "DNI", "Nombre", "Apellido Paterno", "Apellido Materno",
            "Teléfono", "Correo", "Estado"
        });
        tbClientes.setModel(modeloTabla);
    }

    private void cargarTablaClientes() {
        DefaultTableModel modelo = new DefaultTableModel();
        String[] columnHeaders = {
            "ID Cliente", "DNI", "Nombre", "Apellido Paterno", "Apellido Materno",
            "Teléfono", "Correo", "Estado"
        };
        modelo.setColumnIdentifiers(columnHeaders); // Establece los encabezados de las columnas

        try (Connection conn = Conexion.getConexion(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM clientes")) {

            while (rs.next()) {
                Object[] fila = new Object[columnHeaders.length];
                fila[0] = rs.getString("id_cliente");
                fila[1] = rs.getString("dni");
                fila[2] = rs.getString("nombre");
                fila[3] = rs.getString("apellido_paterno");
                fila[4] = rs.getString("apellido_materno");
                fila[5] = rs.getString("telefono");
                fila[6] = rs.getString("correo");
                fila[7] = rs.getString("estado");  // Estado (ACTIVO o ELIMINADO)

                modelo.addRow(fila);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar los clientes: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        tbClientes.setModel(modelo); // Asigna el modelo a la tabla
        tbClientes.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbClientes = new javax.swing.JTable();
        txtIdcli = new javax.swing.JTextField();
        txtNombrecli = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtapPaternocli = new javax.swing.JTextField();
        txtTelefonocli = new javax.swing.JTextField();
        txtApMaternocli = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCorreocli = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        rbtnActivo = new javax.swing.JRadioButton();
        rbtnEliminado = new javax.swing.JRadioButton();
        btnActualizarCli = new javax.swing.JButton();
        btnSelecli = new javax.swing.JButton();
        btnAgregarCli = new javax.swing.JButton();
        btnLimpiarDatosCli = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        txtDnicli = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbClientes.setModel(new javax.swing.table.DefaultTableModel(
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
        tbClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbClientes);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setText("Registro de Clientes");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Nombre:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Ap Paterno:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("DNI:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("ID Cliente:");

        txtApMaternocli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApMaternocliActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Ap Materno:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Telefono:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Correo:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Estado:");

        rbtnActivo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbtnActivo.setText("Activo");

        rbtnEliminado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbtnEliminado.setText("Eliminado");

        btnActualizarCli.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnActualizarCli.setText("ACTUALIZAR");
        btnActualizarCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarCliActionPerformed(evt);
            }
        });

        btnSelecli.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSelecli.setText("SELECCIONAR CLIENTE");
        btnSelecli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecliActionPerformed(evt);
            }
        });

        btnAgregarCli.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAgregarCli.setText("AGREGAR");
        btnAgregarCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCliActionPerformed(evt);
            }
        });

        btnLimpiarDatosCli.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLimpiarDatosCli.setText("LIMPIAR DATOS");
        btnLimpiarDatosCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarDatosCliActionPerformed(evt);
            }
        });

        btnRegresar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/back.png"))); // NOI18N
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(txtDnicli, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(852, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(401, 401, 401)
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addGap(12, 12, 12)
                            .addComponent(txtIdcli, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(47, 47, 47)
                            .addComponent(jLabel3)
                            .addGap(12, 12, 12)
                            .addComponent(txtNombrecli, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(31, 31, 31)
                            .addComponent(jLabel5)
                            .addGap(18, 18, 18)
                            .addComponent(txtApMaternocli, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel7)
                            .addGap(18, 18, 18)
                            .addComponent(txtCorreocli, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(39, 39, 39)
                            .addComponent(jLabel2)
                            .addGap(133, 133, 133)
                            .addComponent(jLabel4)
                            .addGap(12, 12, 12)
                            .addComponent(txtapPaternocli, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(52, 52, 52)
                            .addComponent(jLabel6)
                            .addGap(18, 18, 18)
                            .addComponent(txtTelefonocli, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(21, 21, 21)
                            .addComponent(jLabel12)
                            .addGap(18, 18, 18)
                            .addComponent(rbtnActivo)
                            .addGap(32, 32, 32)
                            .addComponent(rbtnEliminado))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1021, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(11, 11, 11)
                            .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLimpiarDatosCli)
                            .addGap(27, 27, 27)
                            .addComponent(btnAgregarCli)
                            .addGap(26, 26, 26)
                            .addComponent(btnSelecli, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(26, 26, 26)
                            .addComponent(btnActualizarCli)
                            .addGap(28, 28, 28)))
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(txtDnicli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(332, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(59, 59, 59)
                    .addComponent(jLabel1)
                    .addGap(28, 28, 28)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addComponent(jLabel9))
                        .addComponent(txtIdcli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(jLabel3))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(txtNombrecli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(jLabel5))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(txtApMaternocli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(jLabel7))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(txtCorreocli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(15, 15, 15)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(jLabel4)
                        .addComponent(txtapPaternocli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(jLabel6))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(txtTelefonocli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addComponent(jLabel12))
                        .addComponent(rbtnActivo)
                        .addComponent(rbtnEliminado))
                    .addGap(12, 12, 12)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(17, 17, 17)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnRegresar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLimpiarDatosCli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAgregarCli)
                            .addComponent(btnSelecli)
                            .addComponent(btnActualizarCli)))
                    .addContainerGap(59, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbClientesMouseClicked
        int filaSeleccionada = tbClientes.getSelectedRow();

        if (filaSeleccionada != -1) {
            // Obtener el modelo de la tabla
            DefaultTableModel modelo = (DefaultTableModel) tbClientes.getModel();

            // Asignar los valores de la fila seleccionada a los campos del formulario
            txtIdcli.setText(modelo.getValueAt(filaSeleccionada, 0).toString());       // ID Cliente
            txtDnicli.setText(modelo.getValueAt(filaSeleccionada, 1).toString());      // DNI
            txtNombrecli.setText(modelo.getValueAt(filaSeleccionada, 2).toString());   // Nombre
            txtapPaternocli.setText(modelo.getValueAt(filaSeleccionada, 3).toString());// Apellido Paterno
            txtApMaternocli.setText(modelo.getValueAt(filaSeleccionada, 4).toString());// Apellido Materno
            txtTelefonocli.setText(modelo.getValueAt(filaSeleccionada, 5).toString());// Teléfono
            txtCorreocli.setText(modelo.getValueAt(filaSeleccionada, 6).toString());  // Correo

            // Obtener el estado del cliente (suponiendo que está en la columna 7)
            String estado = modelo.getValueAt(filaSeleccionada, 7).toString();       // Estado
            if (estado.equals("ACTIVO")) {
                rbtnActivo.setSelected(true);  // Selecciona el RadioButton de "Activo"
                rbtnEliminado.setSelected(false);  // Asegura que el RadioButton de "Eliminado" esté deseleccionado
            } else if (estado.equals("ELIMINADO")) {
                rbtnActivo.setSelected(false);  // Desmarca el RadioButton de "Activo"
                rbtnEliminado.setSelected(true);  // Selecciona el RadioButton de "Eliminado"
            }

            // Deshabilitar el campo de ID para evitar ediciones accidentales
            txtIdcli.setEditable(false);
        } else {
            // Si no se selecciona ninguna fila, mostrar un mensaje
            JOptionPane.showMessageDialog(this, "Por favor seleccione una fila válida.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_tbClientesMouseClicked

    private void txtApMaternocliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApMaternocliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApMaternocliActionPerformed

    private void btnActualizarCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarCliActionPerformed
        try {
            // Capturar los datos del formulario para los clientes
            String idCliente = txtIdcli.getText().trim().toUpperCase();
            String dni = txtDnicli.getText().trim();
            String nombre = txtNombrecli.getText().trim();
            String apellidoPaterno = txtapPaternocli.getText().trim();
            String apellidoMaterno = txtApMaternocli.getText().trim();
            String telefono = txtTelefonocli.getText().trim();
            String correo = txtCorreocli.getText().trim();

            // Validar que los campos no estén vacíos
            if (idCliente.isEmpty() || dni.isEmpty() || nombre.isEmpty() || apellidoPaterno.isEmpty()
                    || apellidoMaterno.isEmpty() || telefono.isEmpty() || correo.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor complete todos los campos obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Validar que el DNI tenga 8 caracteres
            if (dni.length() != 8) {
                JOptionPane.showMessageDialog(this, "El DNI debe tener 8 caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Obtener el estado del cliente desde los radio buttons
            String estado = "";
            if (rbtnActivo.isSelected()) {
                estado = "ACTIVO";
            } else if (rbtnEliminado.isSelected()) {
                estado = "ELIMINADO";
            }

            if (estado.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor seleccione un estado para el cliente.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Llamar al método para actualizar el cliente
            boolean exito = MetodosClientes.actualizarCliente(idCliente, dni, nombre, apellidoPaterno, apellidoMaterno,
                    telefono, correo, estado);

            if (exito) {
                cargarTablaClientes();
                btnLimpiarDatosCliActionPerformed(evt); // Limpiar los campos
                JOptionPane.showMessageDialog(this, "Cliente actualizado correctamente.");
            } else {
                JOptionPane.showMessageDialog(this, "Hubo un error al actualizar el cliente.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnActualizarCliActionPerformed

    private void btnSelecliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecliActionPerformed
        int selectedRow = tbClientes.getSelectedRow();
        if (selectedRow != -1) {
            try {
                // Obtener los valores necesarios de la fila seleccionada
                String idclicl = tbClientes.getValueAt(selectedRow, 0).toString(); // ID del cliente
                String nomb = tbClientes.getValueAt(selectedRow, 2).toString();   // Nombre del cliente
                String estado = tbClientes.getValueAt(selectedRow, 7).toString(); // Estado del cliente

                // Verificar si el cliente está inactivo
                if (estado.equalsIgnoreCase("ELIMINADO")) {
                    JOptionPane.showMessageDialog(this, "Cliente ELIMINADO. No se puede seleccionar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    return; // Salir del método si el cliente está inactivo
                }

                // Cerrar el formulario actual y pasar los datos al formulario principal
                if (FrmVentas.instancia != null) {
                    FrmVentas.instancia.FrmCli(idclicl, nomb);
                    this.dispose();
                } else {
                    // Si no se encuentra el formulario principal, mostrar un mensaje de error
                    JOptionPane.showMessageDialog(this, "No se encontró el formulario principal.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Ocurrió un error al procesar la información.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un cliente.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSelecliActionPerformed

    private void btnAgregarCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCliActionPerformed
        try {
            // Capturar los datos del formulario para los clientes
            String idCliente = txtIdcli.getText().trim().toUpperCase();
            String dni = txtDnicli.getText().trim();
            String nombre = txtNombrecli.getText().trim();
            String apellidoPaterno = txtapPaternocli.getText().trim();
            String apellidoMaterno = txtApMaternocli.getText().trim();
            String telefono = txtTelefonocli.getText().trim();
            String correo = txtCorreocli.getText().trim();

            // Validar que los campos no estén vacíos
            if (idCliente.isEmpty() || dni.isEmpty() || nombre.isEmpty() || apellidoPaterno.isEmpty()
                    || apellidoMaterno.isEmpty() || telefono.isEmpty() || correo.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor complete todos los campos obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Validar que el DNI tenga 8 caracteres
            if (dni.length() != 8) {
                JOptionPane.showMessageDialog(this, "El DNI debe tener 8 caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Obtener el estado del cliente desde los radio buttons
            String estado = "";
            if (rbtnActivo.isSelected()) {
                estado = "ACTIVO";
            } else if (rbtnEliminado.isSelected()) {
                estado = "ELIMINADO";
            }

            if (estado.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor seleccione un estado para el cliente.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Verificar si el cliente ya existe
            if (MetodosClientes.existeCliente(idCliente)) {
                JOptionPane.showMessageDialog(this, "El cliente con este código ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Llamar al método para agregar el cliente
            boolean exito = MetodosClientes.agregarCliente(idCliente, dni, nombre, apellidoPaterno, apellidoMaterno,
                    telefono, correo, estado);

            if (exito) {
                cargarTablaClientes();
                btnLimpiarDatosCliActionPerformed(evt); // Limpiar los campos
                JOptionPane.showMessageDialog(this, "Cliente agregado correctamente.");
            } else {
                JOptionPane.showMessageDialog(this, "Hubo un error al agregar el cliente.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarCliActionPerformed

    private void btnLimpiarDatosCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarDatosCliActionPerformed
        txtIdcli.setText("");
        txtDnicli.setText("");
        txtNombrecli.setText("");
        txtapPaternocli.setText("");
        txtApMaternocli.setText("");
        txtTelefonocli.setText("");
        txtCorreocli.setText("");
        txtIdcli.setEditable(true);  // Permite modificar el ID nuevamente
        txtIdcli.requestFocus();
        rbtnActivo.setSelected(true); // Establecer el estado predeterminado
        rbtnEliminado.setSelected(false);
    }//GEN-LAST:event_btnLimpiarDatosCliActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        FrmOpciones frm = new FrmOpciones();
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

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
            java.util.logging.Logger.getLogger(JDCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDCliente dialog = new JDCliente(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnActualizarCli;
    private javax.swing.JButton btnAgregarCli;
    private javax.swing.JButton btnLimpiarDatosCli;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnSelecli;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbtnActivo;
    private javax.swing.JRadioButton rbtnEliminado;
    private javax.swing.JTable tbClientes;
    private javax.swing.JTextField txtApMaternocli;
    private javax.swing.JTextField txtCorreocli;
    private javax.swing.JTextField txtDnicli;
    private javax.swing.JTextField txtIdcli;
    private javax.swing.JTextField txtNombrecli;
    private javax.swing.JTextField txtTelefonocli;
    private javax.swing.JTextField txtapPaternocli;
    // End of variables declaration//GEN-END:variables
}
