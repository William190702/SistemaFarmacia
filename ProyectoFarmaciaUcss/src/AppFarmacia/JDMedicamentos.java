/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package AppFarmacia;

import Controlador.MetodoMedicamentos;
import Controlador.VistaMedicamentos;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JDMedicamentos extends javax.swing.JDialog {

    /**
     * Creates new form JDMedicamentos
     */
    public JDMedicamentos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        inicializarTabla();
        inicializarTabla();
        setLocationRelativeTo(null);
        cargarTablaMedicamentos();
    }

    private void inicializarTabla() {
        DefaultTableModel modeloTabla = new DefaultTableModel();  // Crea un modelo vacío
        modeloTabla.setColumnIdentifiers(new String[]{
            "ID Medicamento", "Nombre", "Categoría", "Unidad", "Precio", "Stock", "Estado"
        });

        // Asocia el modelo a la tabla
        tbMedicamentos.setModel(modeloTabla);
    }

    // Método para cargar los detalles de los medicamentos desde la base de datos
    private void cargarTablaMedicamentos() {
        DefaultTableModel modelo = VistaMedicamentos.getModeloTbl();

        // Cambiar los nombres de las columnas a nombres amigables
        String[] columnHeaders = {
            "ID Medicamento", "Nombre", "Categoría", "Unidad", "Precio", "Stock", "Estado"
        };
        modelo.setColumnIdentifiers(columnHeaders);

        tbMedicamentos.setModel(modelo);
        tbMedicamentos.repaint();
    }

    private void cargarTablapornombre(String nombreParcial) {
        DefaultTableModel modelo = (DefaultTableModel) MetodoMedicamentos.consultarMedicamentosPorNombre(nombreParcial);

        // Cambiar los nombres de las columnas a nombres amigables
        String[] columnHeaders = {
            "ID Medicamento", "Nombre", "Categoría", "Unidad", "Precio", "Stock", "Estado"
        };
        modelo.setColumnIdentifiers(columnHeaders);

        tbMedicamentos.setModel(modelo);
        tbMedicamentos.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtStockmed = new javax.swing.JTextField();
        btnRegresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtUnidadmed = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombremed = new javax.swing.JTextField();
        txtBuscarmec = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCategoriamed = new javax.swing.JTextField();
        btnSelemed = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        rbtnActivo = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        rbtnEliminado = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMedicamentos = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnAgregarmed = new javax.swing.JButton();
        txtIDmed = new javax.swing.JTextField();
        btnLimpiarDatos = new javax.swing.JButton();
        txtPreciomed = new javax.swing.JTextField();
        btnActualizarmed = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnRegresar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/back.png"))); // NOI18N
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Historic", 3, 36)); // NOI18N
        jLabel1.setText("Catalogo de Medicamentos");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Buscar Medicamento:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("ID Medicamento:");

        txtBuscarmec.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarmecKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Precio:");

        btnSelemed.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSelemed.setText("SELECCIONAR MEDICAMENTO");
        btnSelemed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelemedActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Stock:");

        rbtnActivo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbtnActivo.setText("Activo");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Unidad:");

        rbtnEliminado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbtnEliminado.setText("Eliminado");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Nombre:");

        tbMedicamentos.setModel(new javax.swing.table.DefaultTableModel(
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
        tbMedicamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMedicamentosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbMedicamentos);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Categoria");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Estado:");

        btnAgregarmed.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAgregarmed.setText("AGREGAR");
        btnAgregarmed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarmedActionPerformed(evt);
            }
        });

        btnLimpiarDatos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLimpiarDatos.setText("LIMPIAR DATOS");
        btnLimpiarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarDatosActionPerformed(evt);
            }
        });

        btnActualizarmed.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnActualizarmed.setText("ACTUALIZAR");
        btnActualizarmed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarmedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtUnidadmed)
                                    .addComponent(txtStockmed)
                                    .addComponent(txtPreciomed)
                                    .addComponent(txtIDmed, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel9))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtNombremed, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                                            .addComponent(txtCategoriamed)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(rbtnActivo)
                                            .addComponent(jLabel10))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtBuscarmec, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(59, 59, 59)
                                                .addComponent(rbtnEliminado)))))
                                .addGap(32, 32, 32))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(119, 119, 119)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAgregarmed)
                                .addGap(18, 18, 18)
                                .addComponent(btnSelemed)
                                .addGap(18, 18, 18)
                                .addComponent(btnLimpiarDatos)
                                .addGap(18, 18, 18)
                                .addComponent(btnActualizarmed))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 905, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtIDmed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtPreciomed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtStockmed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtUnidadmed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtNombremed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtCategoriamed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(rbtnActivo)
                            .addComponent(rbtnEliminado))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtBuscarmec, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAgregarmed)
                        .addComponent(btnLimpiarDatos)
                        .addComponent(btnActualizarmed)
                        .addComponent(btnSelemed))
                    .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        FrmOpciones frm = new FrmOpciones();
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void txtBuscarmecKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarmecKeyPressed
        String textoBusqueda = txtBuscarmec.getText();

        // Llamamos al método para actualizar la tabla con los medicamentos filtrados
        cargarTablapornombre(textoBusqueda);
    }//GEN-LAST:event_txtBuscarmecKeyPressed

    private void btnSelemedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelemedActionPerformed
        int selectedRow = tbMedicamentos.getSelectedRow();
        if (selectedRow != -1) {
            try {
                // Obtener los valores de la fila seleccionada
                String idMedicamento = tbMedicamentos.getValueAt(selectedRow, 0).toString(); // ID del medicamento
                String precioStr = tbMedicamentos.getValueAt(selectedRow, 4).toString(); // Precio
                String stockStr = tbMedicamentos.getValueAt(selectedRow, 5).toString(); // Stock
                String estado = tbMedicamentos.getValueAt(selectedRow, 6).toString(); // Estado del medicamento

                // Verificar si el medicamento está eliminado
                if (estado.equalsIgnoreCase("ELIMINADO")) {
                    JOptionPane.showMessageDialog(this, "Medicamento ELIMINADO. Imposible realizar la venta.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // Convertir a números
                double precio = Double.parseDouble(precioStr);
                int stock = Integer.parseInt(stockStr);

                // Obtener la instancia del formulario principal ya abierto
                if (FrmVentas.instancia != null) {
                    FrmVentas.instancia.FrmMed(idMedicamento, precio, stock); // Pasar datos al formulario principal
                    this.dispose();
                } else {
                    // Si no se encuentra el formulario principal, mostrar un mensaje de error
                    JOptionPane.showMessageDialog(this, "No se encontró el formulario principal.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Error al convertir los datos numéricos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un medicamento.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSelemedActionPerformed

    private void tbMedicamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMedicamentosMouseClicked
        int filaSeleccionada = tbMedicamentos.getSelectedRow(); // Obtener la fila seleccionada en la tabla
        if (filaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) tbMedicamentos.getModel();

            // Asignar los valores de las celdas de la fila seleccionada a los campos de texto
            txtIDmed.setText(modelo.getValueAt(filaSeleccionada, 0).toString()); // ID Medicamento
            txtNombremed.setText(modelo.getValueAt(filaSeleccionada, 1).toString()); // Nombre
            txtCategoriamed.setText(modelo.getValueAt(filaSeleccionada, 2).toString()); // Categoría
            txtUnidadmed.setText(modelo.getValueAt(filaSeleccionada, 3).toString()); // Unidad
            txtPreciomed.setText(modelo.getValueAt(filaSeleccionada, 4).toString()); // Precio
            txtStockmed.setText(modelo.getValueAt(filaSeleccionada, 5).toString()); // Stock

            // Obtener el estado del medicamento (suponiendo que está en la columna 6)
            String estado = modelo.getValueAt(filaSeleccionada, 6).toString(); // Columna donde está el estado

            // Deshabilitar el campo de ID Medicamento para que no se edite
            txtIDmed.setEditable(false);

            // Seleccionar el radio button correspondiente según el estado
            if (estado.equals("ACTIVO")) {
                rbtnActivo.setSelected(true);  // Selecciona el RadioButton de "Activo"
                rbtnEliminado.setSelected(false);  // Asegura que el RadioButton de "Eliminado" esté deseleccionado
            } else if (estado.equals("ELIMINADO")) {
                rbtnActivo.setSelected(false);  // Desmarca el RadioButton de "Activo"
                rbtnEliminado.setSelected(true);  // Selecciona el RadioButton de "Eliminado"
            }
        } else {
            // Si no se selecciona ninguna fila, mostrar un mensaje
            JOptionPane.showMessageDialog(this, "Por favor seleccione una fila.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_tbMedicamentosMouseClicked

    private void btnAgregarmedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarmedActionPerformed
        try {
            // Capturar los datos del formulario para los medicamentos
            String idMedicamento = txtIDmed.getText().trim().toUpperCase();
            String nombre = txtNombremed.getText().trim();
            String categoria = txtCategoriamed.getText().trim();
            String unidad = txtUnidadmed.getText().trim();
            double precio = Double.parseDouble(txtPreciomed.getText().trim());
            int stock = Integer.parseInt(txtStockmed.getText().trim());

            // Validar que los campos no estén vacíos
            if (idMedicamento.isEmpty() || nombre.isEmpty() || categoria.isEmpty() || unidad.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Validar que el precio y el stock no sean negativos
            if (precio < 0 || stock < 0) {
                JOptionPane.showMessageDialog(this, "El precio y el stock deben ser valores positivos.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Verificar si el medicamento ya existe
            if (MetodoMedicamentos.existeMedicamento(idMedicamento)) {
                JOptionPane.showMessageDialog(this, "El medicamento con este código ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Obtener el estado del medicamento desde los radio buttons
            String estado = "";
            if (rbtnActivo.isSelected()) {
                estado = "ACTIVO";  // Si el rbtnActivo está seleccionado, el estado es "ACTIVO"
            } else if (rbtnEliminado.isSelected()) {
                estado = "ELIMINADO";  // Si el rbtnEliminado está seleccionado, el estado es "ELIMINADO"
            }

            // Validar que uno de los radio buttons esté seleccionado
            if (estado.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor seleccione un estado para el medicamento.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Llamar al método para agregar el medicamento con el estado seleccionado
            boolean exito = MetodoMedicamentos.agregarMedicamento(idMedicamento, nombre, categoria, unidad, precio, stock, estado);

            if (exito) {
                cargarTablaMedicamentos();
                // Limpiar los campos después de agregar
                txtIDmed.setText("");
                txtPreciomed.setText("");
                txtStockmed.setText("");
                txtUnidadmed.setText("");
                txtNombremed.setText("");
                txtCategoriamed.setText("");
                txtIDmed.requestFocus();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese valores numéricos válidos para precio y stock.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarmedActionPerformed

    private void btnLimpiarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarDatosActionPerformed
        txtIDmed.setText("");
        txtPreciomed.setText("");
        txtStockmed.setText("");
        txtUnidadmed.setText("");
        txtNombremed.setText("");
        txtCategoriamed.setText("");
        txtIDmed.setEditable(true);
        txtIDmed.requestFocus();
        rbtnActivo.setSelected(false);
        rbtnEliminado.setSelected(false);
    }//GEN-LAST:event_btnLimpiarDatosActionPerformed

    private void btnActualizarmedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarmedActionPerformed
        try {
            // Capturar los datos del formulario para los medicamentos
            String idMedicamento = txtIDmed.getText().trim().toUpperCase();
            String nombre = txtNombremed.getText().trim();
            String categoria = txtCategoriamed.getText().trim();
            String unidad = txtUnidadmed.getText().trim();
            double precio = Double.parseDouble(txtPreciomed.getText().trim());
            int stock = Integer.parseInt(txtStockmed.getText().trim());

            // Verificar si los campos obligatorios están vacíos
            if (idMedicamento.isEmpty() || nombre.isEmpty() || categoria.isEmpty() || unidad.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Verificar si el precio y el stock son válidos (no negativos)
            if (precio < 0 || stock < 0) {
                JOptionPane.showMessageDialog(this, "El precio y el stock deben ser valores positivos.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Obtener el estado del medicamento desde los radio buttons
            String estado = "";
            if (rbtnActivo.isSelected()) {
                estado = "ACTIVO";  // Si el rbtnActivo está seleccionado, el estado es "ACTIVO"
            } else if (rbtnEliminado.isSelected()) {
                estado = "ELIMINADO";  // Si el rbtnEliminado está seleccionado, el estado es "ELIMINADO"
            }

            // Llamar al método de actualización en la base de datos
            boolean exito = MetodoMedicamentos.actualizarMedicamento(idMedicamento, nombre, categoria, unidad, precio, stock, estado);

            if (exito) {
                JOptionPane.showMessageDialog(this, "Medicamento actualizado correctamente.");
                // Limpiar los campos después de actualizar
                txtIDmed.setText("");
                txtPreciomed.setText("");
                txtStockmed.setText("");
                txtUnidadmed.setText("");
                txtNombremed.setText("");
                txtCategoriamed.setText("");
                txtIDmed.requestFocus();
                txtIDmed.setEditable(true);
                rbtnActivo.setSelected(false);
                rbtnEliminado.setSelected(false);
                cargarTablaMedicamentos();

            } else {
                JOptionPane.showMessageDialog(this, "Hubo un error al actualizar el medicamento.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnActualizarmedActionPerformed

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
            java.util.logging.Logger.getLogger(JDMedicamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDMedicamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDMedicamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDMedicamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDMedicamentos dialog = new JDMedicamentos(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnActualizarmed;
    private javax.swing.JButton btnAgregarmed;
    private javax.swing.JButton btnLimpiarDatos;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnSelemed;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbtnActivo;
    private javax.swing.JRadioButton rbtnEliminado;
    private javax.swing.JTable tbMedicamentos;
    private javax.swing.JTextField txtBuscarmec;
    private javax.swing.JTextField txtCategoriamed;
    private javax.swing.JTextField txtIDmed;
    private javax.swing.JTextField txtNombremed;
    private javax.swing.JTextField txtPreciomed;
    private javax.swing.JTextField txtStockmed;
    private javax.swing.JTextField txtUnidadmed;
    // End of variables declaration//GEN-END:variables
}
