/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package AppFarmacia;

import Clases.DetalleVenta;
import Clases.Venta;
import Controlador.MetodosDetalleVenta;
import Controlador.MetodosVenta;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FrmVentas extends javax.swing.JFrame {

    private String idEmpleado;
    private String nombreemp;
    private String nombrecli;
    private String idCliente;
    private String idMedicamento;
    private double precio;
    private double stock;
    public static FrmVentas instancia;
    private final List<DetalleVenta> listaDetalles = new ArrayList<>();

    public FrmVentas() {

        initComponents();
        instancia = this;
        setLocationRelativeTo(null);
        btnagregar.setEnabled(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void FrmCli(String idCliente, String nombrecli) {
        txtidcliente.setText(idCliente);
        txtnomcliv.setText(nombrecli);
    }

    // Método para actualizar el idEmpleado en el formulario
    public void FrmEmp(String idEmpleado, String nombreemp) {
        this.idEmpleado = idEmpleado;
        this.nombreemp = nombreemp;
        txtidEmpleado.setText(idEmpleado);
        txtnomempv.setText(nombreemp);
    }

    // Método para actualizar los datos del medicamento en el formulario
    public void FrmMed(String idMedicamento, double precio, double stock) {
        this.idMedicamento = idMedicamento;
        this.precio = precio;
        this.stock = stock;
        txtStock.setText(String.valueOf(stock));  // Actualizar el JTextField correspondiente
        txtPrecioven.setText(String.valueOf(precio));  // Actualizar el JTextField correspondiente
        txtidmedicamento.setText(idMedicamento);  // Actualizar el JTextField correspondiente
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtmostrar = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtidVenta = new javax.swing.JTextField();
        txtidPedido = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jdtFechaventa = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtidEmpleado = new javax.swing.JTextField();
        txtidcliente = new javax.swing.JTextField();
        txtidmedicamento = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        txtPrecioven = new javax.swing.JTextField();
        txtCantidadaComprar = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtTotalVen = new javax.swing.JTextField();
        btnseleemp = new javax.swing.JButton();
        btnselecli = new javax.swing.JButton();
        btnselemed = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtnomempv = new javax.swing.JTextField();
        txtnomcliv = new javax.swing.JTextField();
        btnagregar = new javax.swing.JButton();
        btnconfirmar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        btnregistrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 36)); // NOI18N
        jLabel1.setText("Registro de Ventas");

        txtmostrar.setEditable(false);
        txtmostrar.setColumns(20);
        txtmostrar.setRows(5);
        jScrollPane1.setViewportView(txtmostrar);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Clientes:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Empleados:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Medicamentos:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("ID Venta:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("ID Pedido:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Fecha:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("ID empleado:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("ID Cliente:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("ID Medicamento:");

        txtidEmpleado.setEditable(false);

        txtidcliente.setEditable(false);

        txtidmedicamento.setEditable(false);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Stock:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Precio:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Cantidad a comprar:");

        txtStock.setEditable(false);

        txtPrecioven.setEditable(false);

        txtCantidadaComprar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadaComprarKeyPressed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Total:");

        txtTotalVen.setEditable(false);

        btnseleemp.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnseleemp.setText("SELECCIONAR");
        btnseleemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnseleempActionPerformed(evt);
            }
        });

        btnselecli.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnselecli.setText("SELECCIONAR");
        btnselecli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnselecliActionPerformed(evt);
            }
        });

        btnselemed.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnselemed.setText("SELECCIONAR");
        btnselemed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnselemedActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Nombre Empleado:");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setText("Nombre Cliente:");

        txtnomempv.setEditable(false);

        txtnomcliv.setEditable(false);

        btnagregar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnagregar.setText("AGREGAR PRODUCTO");
        btnagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarActionPerformed(evt);
            }
        });

        btnconfirmar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnconfirmar.setText("CONFIRMAR VENTA");
        btnconfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconfirmarActionPerformed(evt);
            }
        });

        btnRegresar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/back.png"))); // NOI18N
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnregistrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnregistrar.setText("REGISTRAR PRODUCTO");
        btnregistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(357, 357, 357))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(60, 60, 60)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel3))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtidVenta)
                                        .addComponent(btnseleemp, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(37, 37, 37)
                                    .addComponent(jLabel11)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel15)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtnomempv, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(48, 48, 48)
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtidEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnselecli, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtidPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtidcliente, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                                    .addComponent(txtPrecioven, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtnomcliv))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel13))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(112, 112, 112)
                                .addComponent(jLabel14)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jdtFechaventa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtidmedicamento, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTotalVen, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                            .addComponent(txtCantidadaComprar)
                            .addComponent(btnselemed, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnregistrar)
                        .addGap(28, 28, 28)
                        .addComponent(btnagregar)
                        .addGap(29, 29, 29)
                        .addComponent(btnconfirmar)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(txtidPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(btnselecli))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(txtidcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16)
                                    .addComponent(txtnomcliv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(txtPrecioven, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(txtidVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(btnseleemp))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8)
                                        .addComponent(txtidEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel15)
                                        .addComponent(txtnomempv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel11)
                                        .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(jdtFechaventa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(btnselemed))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel10)
                                        .addComponent(txtidmedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel13)
                                        .addComponent(txtCantidadaComprar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel14)
                                        .addComponent(txtTotalVen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnconfirmar)
                                .addComponent(btnagregar)
                                .addComponent(btnregistrar))
                            .addComponent(btnRegresar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnseleempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnseleempActionPerformed
        JDEmpleados jdemp = new JDEmpleados(this, rootPaneCheckingEnabled);
        jdemp.setVisible(true);
    }//GEN-LAST:event_btnseleempActionPerformed

    private void btnselecliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnselecliActionPerformed
        JDCliente jdcli = new JDCliente(this, rootPaneCheckingEnabled);
        jdcli.setVisible(true);
    }//GEN-LAST:event_btnselecliActionPerformed

    private void btnselemedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnselemedActionPerformed
        JDMedicamentos jdmed = new JDMedicamentos(this, rootPaneCheckingEnabled);
        jdmed.setVisible(true);
    }//GEN-LAST:event_btnselemedActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        FrmOpciones frm = new FrmOpciones();
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnregistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistrarActionPerformed
        // Obtener los datos del formulario
        String idVent = txtidVenta.getText();  // idVenta
        String idClie = txtidcliente.getText();  // idCliente
        String idEmple = txtidEmpleado.getText();  // idEmpleado
        Date fechaVen = jdtFechaventa.getDate();  // Fecha de la venta
        double tota = 0;  // Inicializar total

        // Validar que el campo de total no esté vacío y sea un número válido
        try {
            tota = Double.parseDouble(txtTotalVen.getText());  // Convertir el total a double
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El total debe ser un número válido.");
            return;  // Si el total no es válido, salimos del método
        }

        // Verificar si el ID de venta ya existe
        MetodosVenta metodosVenta = new MetodosVenta();
        if (metodosVenta.idVentaExiste(idVent)) {
            JOptionPane.showMessageDialog(null, "El ID de venta ya existe en la base de datos. Intente con otro ID.");
            return; // Salir del método si el ID ya existe
        }

        // Crear el objeto Venta con los datos obtenidos
        Venta venta = new Venta(idVent, idClie, idEmple, fechaVen, tota);

        // Registrar la venta en la base de datos
        if (metodosVenta.registrarVenta(venta)) {
            txtmostrar.append("Venta registrada: " + idVent + "\n");

            // Aquí agregamos los productos directamente a la venta
            String idMedicame = txtidmedicamento.getText();  // ID del medicamento
            double canti = Double.parseDouble(txtCantidadaComprar.getText()); // Cantidad
            double precioUnita = Double.parseDouble(txtPrecioven.getText()); // Precio unitario

            // Calcular el subtotal
            double subtotal = canti * precioUnita;

            // Mostrar el detalle de la venta directamente
            txtmostrar.append("Producto agregado: " + idMedicame
                    + " | Cantidad: " + canti
                    + " | Precio Unitario: " + precioUnita
                    + " | Subtotal: " + subtotal + "\n");

            // Registrar el detalle de la venta en la base de datos
            MetodosDetalleVenta metodosDetalle = new MetodosDetalleVenta();
            DetalleVenta detalleVenta = new DetalleVenta(idEmple, idVent, idMedicame, (int) canti, precioUnita);
            if (metodosDetalle.agregarDetalleVenta(detalleVenta)) {
                // Si el detalle se registra exitosamente, actualizamos el total
                double total = tota + subtotal;
                txtTotalVen.setText(String.valueOf(total));
            } else {
                txtmostrar.append("Error al agregar el producto al detalle.\n");
            }

            // Bloquear el campo ID de la venta para evitar modificaciones
            txtidVenta.setEditable(false);

            // Habilitar el botón para agregar productos
            btnagregar.setEnabled(true);
            btnconfirmar.setEnabled(true);

            // Deshabilitar el botón de registrar
            btnregistrar.setEnabled(false);
        } else {
            txtmostrar.append("Error al registrar la venta\n");
        }
    }//GEN-LAST:event_btnregistrarActionPerformed

    private void btnagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarActionPerformed
        try {
            // Obtener los datos del producto
            String idVent = txtidVenta.getText(); // ID de la venta
            String idDetal = txtidPedido.getText(); // ID del detalle de venta
            String idMedicam = txtidmedicamento.getText(); // ID del medicamento
            double cantod = Double.parseDouble(txtCantidadaComprar.getText()); // Cantidad
            double precioUnita = Double.parseDouble(txtPrecioven.getText()); // Precio unitario

            // Validar que los campos obligatorios no estén vacíos
            if (idVent.isEmpty() || idDetal.isEmpty() || idMedicam.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos obligatorios.");
                return;
            }

            // Calcular el subtotal
            double subtotal = precioUnita * cantod;

            // Crear el objeto DetalleVenta
            DetalleVenta detalleVenta = new DetalleVenta(idDetal, idVent, idMedicam, (int) cantod, precioUnita);

            // Agregar el detalle a la lista
            listaDetalles.add(detalleVenta);

            // Mostrar el detalle agregado con el mismo formato
            txtmostrar.append("Producto agregado: " + idMedicam
                    + " | Cantidad: " + (int) cantod
                    + " | Precio Unitario: " + String.format("%.2f", precioUnita)
                    + " | Subtotal: " + String.format("%.2f", subtotal) + "\n");

            // Registrar el detalle de la venta en la base de datos
            MetodosDetalleVenta metodosDetalle = new MetodosDetalleVenta();
            if (metodosDetalle.agregarDetalleVenta(detalleVenta)) {
                JOptionPane.showMessageDialog(null, "Detalle de venta registrado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar el detalle de la venta.");
            }

            // Actualizar el total de la venta
            double total = Double.parseDouble(txtTotalVen.getText()) + subtotal;
            txtTotalVen.setText(String.format("%.2f", total));

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese valores numéricos válidos para cantidad y precio.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error: " + e.getMessage());
        }
    }//GEN-LAST:event_btnagregarActionPerformed

    private void btnconfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconfirmarActionPerformed
        // Validar que la venta ya esté registrada
        String idVent = txtidVenta.getText();  // ID de la venta
        if (idVent.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe registrar la venta antes de confirmar.");
            return;
        }

        // Validar que haya detalles agregados
        if (listaDetalles == null || listaDetalles.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe agregar al menos un producto antes de confirmar la venta.");
            return;
        }

        // Confirmar la venta
        int confirmacion = JOptionPane.showConfirmDialog(null,
                "¿Está seguro de confirmar esta venta?", "Confirmar Venta", JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            // Inicializar total a pagar
            double totalPagar = 0.0;

            // Agregar los productos al área de texto
            for (DetalleVenta detalle : listaDetalles) {
                double subtotal = detalle.getCantidad() * detalle.getPrecioUnitario();
                txtmostrar.append("Producto agregado: " + detalle.getIdMedicamento() + " | Cantidad: " + detalle.getCantidad()
                        + " | Precio Unitario: " + detalle.getPrecioUnitario() + " | Subtotal: " + subtotal + "\n");
                totalPagar += subtotal;
            }

            // Separación entre los productos y el total
            txtmostrar.append("--------------\n");

            // Mostrar el total a pagar
            txtmostrar.append("Total a pagar: S/ " + String.format("%.2f", totalPagar) + "\n");

            // Limpiar el formulario de venta
            limpiarFormularioVenta();

            // Deshabilitar botones relacionados
            btnregistrar.setEnabled(true);
            btnagregar.setEnabled(false);
            btnconfirmar.setEnabled(true);

            // Mostrar confirmación
            JOptionPane.showMessageDialog(null, "La venta ha sido confirmada exitosamente.");
        }
    }//GEN-LAST:event_btnconfirmarActionPerformed

    private void txtCantidadaComprarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadaComprarKeyPressed
        try {
            // Obtener la cantidad y el precio desde los campos de texto
            double cantidad = Double.parseDouble(txtCantidadaComprar.getText());
            double precio = Double.parseDouble(txtPrecioven.getText());

            // Realizar la multiplicación
            double total = cantidad * precio;

            // Mostrar el resultado en txtTotalVen
            txtTotalVen.setText(String.format("%.2f", total)); // Formato a 2 decimales
        } catch (NumberFormatException e) {
            // En caso de que no sea un número válido
            txtTotalVen.setText("0.00");
        }

    }//GEN-LAST:event_txtCantidadaComprarKeyPressed
    private void limpiarFormularioVenta() {
        txtidVenta.setText("");
        txtidcliente.setText("");
        txtidEmpleado.setText("");
        txtnomempv.setText("");
        txtnomcliv.setText("");
        jdtFechaventa.setDate(null);
        txtTotalVen.setText("");
        txtmostrar.setText("");
        listaDetalles.clear();  
        txtidVenta.setEditable(true); 
        txtStock.setText("");
        txtPrecioven.setText("");
        txtCantidadaComprar.setText("");
        txtidmedicamento.setText("");
        txtidPedido.setText("");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmVentas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnagregar;
    private javax.swing.JButton btnconfirmar;
    private javax.swing.JButton btnregistrar;
    private javax.swing.JButton btnselecli;
    private javax.swing.JButton btnseleemp;
    private javax.swing.JButton btnselemed;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdtFechaventa;
    private javax.swing.JTextField txtCantidadaComprar;
    private javax.swing.JTextField txtPrecioven;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtTotalVen;
    private javax.swing.JTextField txtidEmpleado;
    private javax.swing.JTextField txtidPedido;
    private javax.swing.JTextField txtidVenta;
    private javax.swing.JTextField txtidcliente;
    private javax.swing.JTextField txtidmedicamento;
    private javax.swing.JTextArea txtmostrar;
    private javax.swing.JTextField txtnomcliv;
    private javax.swing.JTextField txtnomempv;
    // End of variables declaration//GEN-END:variables
}
