-- Crear base de datos
CREATE DATABASE SistemaFarmacia;

-- Usar la base de datos
USE SistemaFarmacia;

-- Tabla de Medicamentos
CREATE TABLE medicamentos (
    id_medicamento VARCHAR(20) PRIMARY KEY, -- Ahora permite letras y números
    nombre VARCHAR(100) NOT NULL,
    categoria VARCHAR(50) NOT NULL,
    unidad VARCHAR(20) NOT NULL,
    precio DECIMAL(10, 2) NOT NULL,
    stock INT NOT NULL,
    estado VARCHAR(20) DEFAULT 'ACTIVO' -- 'ACTIVO' o 'ELIMINADO'
);

-- Tabla de Empleados
CREATE TABLE empleados (
    id_empleado VARCHAR(20) PRIMARY KEY, -- Ahora permite letras y números
    dni CHAR(8) NOT NULL UNIQUE,
    nombre VARCHAR(50) NOT NULL,
    apellido_paterno VARCHAR(50) NOT NULL,
    apellido_materno VARCHAR(50) NOT NULL,
    direccion VARCHAR(255),
    fecha_nacimiento DATE NOT NULL,
    telefono VARCHAR(15),
    correo VARCHAR(100),
    puesto VARCHAR(50) NOT NULL,
    usuario VARCHAR(50) UNIQUE NOT NULL, -- Usuario único para login
    clave VARCHAR(100) NOT NULL -- Contraseña para login
);
ALTER TABLE empleados
ADD COLUMN estado VARCHAR(20) DEFAULT 'ACTIVO';



-- Tabla de Clientes
CREATE TABLE clientes (
    id_cliente VARCHAR(20) PRIMARY KEY, -- Ahora permite letras y números
    dni CHAR(8) NOT NULL UNIQUE,
    nombre VARCHAR(50) NOT NULL,
    apellido_paterno VARCHAR(50) NOT NULL,
    apellido_materno VARCHAR(50) NOT NULL,
    telefono VARCHAR(15),
    correo VARCHAR(100)
);
ALTER TABLE clientes
ADD COLUMN estado VARCHAR(20) DEFAULT 'ACTIVO';
ALTER TABLE ventas
ADD COLUMN id_empleado VARCHAR(20),
ADD FOREIGN KEY (id_empleado) REFERENCES empleados(id_empleado);



-- Tabla de Ventas
CREATE TABLE ventas (
    id_venta VARCHAR(20) PRIMARY KEY, -- Ahora permite letras y números
    id_cliente VARCHAR(20) NOT NULL,
    fecha_venta DATETIME DEFAULT CURRENT_TIMESTAMP,
    total DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente)
);
ALTER TABLE ventas
ADD COLUMN id_empleado VARCHAR(20) NOT NULL,
ADD FOREIGN KEY (id_empleado) REFERENCES empleados(id_empleado);
ALTER TABLE ventas
DROP PRIMARY KEY;

select * from ventas;
DELETE FROM ventas
WHERE id_venta = 'V003';

DELETE FROM ventas
WHERE id_venta = 'V003' AND id_cliente = 'C006' AND fecha_venta = '2024-12-21' AND total = 37.50 AND id_empleado = 'E004';

select * from detalle_ventas;
DELETE FROM detalle_ventas
WHERE id_venta = 'V003' AND id_medicamento = 'M001';

-- Tabla de Detalle de Ventas
CREATE TABLE detalle_ventas (
    id_detalle VARCHAR(20), -- Permite duplicados
    id_venta VARCHAR(20) NOT NULL,
    id_medicamento VARCHAR(20) NOT NULL,
    cantidad INT NOT NULL,
    precio_unitario DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (id_venta) REFERENCES ventas(id_venta),
    FOREIGN KEY (id_medicamento) REFERENCES medicamentos(id_medicamento),
    PRIMARY KEY (id_venta, id_medicamento) -- Clave primaria compuesta
);

CREATE VIEW vista_ventas AS
SELECT 
    v.id_venta AS CodigoVenta,
    dv.id_detalle AS CodigoDetalle,
	e.usuario AS UsuarioEmpleado,
    c.nombre AS NombreCliente,
    c.apellido_paterno AS ApellidoCliente,
    v.fecha_venta AS FechaVenta,
    dv.id_medicamento AS CodigoMedicamento,
    m.nombre AS NombreMedicamento,
    dv.cantidad AS Cantidad,
    dv.precio_unitario AS PrecioUnitario,
     dv.precio_unitario*dv.cantidad AS TotalVenta
FROM 
    ventas v
JOIN 
    clientes c ON v.id_cliente = c.id_cliente
JOIN 
    detalle_ventas dv ON v.id_venta = dv.id_venta
JOIN 
    medicamentos m ON dv.id_medicamento = m.id_medicamento
JOIN 
    empleados e ON v.id_empleado = e.id_empleado;  -- Ahora el JOIN es correcto con id_empleado en ventas

SELECT * FROM vista_ventas;

DELIMITER //
-- Procedimiento para insertar un medicamento
CREATE PROCEDURE InsertarMedicamento(
    IN p_idMedicamento VARCHAR(20), 
    IN p_nombre VARCHAR(100), 
    IN p_categoria VARCHAR(50), 
    IN p_unidad VARCHAR(20),
    IN p_precio DECIMAL(10, 2), 
    IN p_stock INT,
    IN p_estado VARCHAR(20) -- Agregar el parámetro 'estado'
)
BEGIN
    INSERT INTO medicamentos (id_medicamento, nombre, categoria, unidad, precio, stock, estado)
    VALUES (p_idMedicamento, p_nombre, p_categoria, p_unidad, p_precio, p_stock, p_estado);
END //

-- Procedimiento para actualizar un medicamento
CREATE PROCEDURE ActualizarMedicamento(
    IN p_idMedicamento VARCHAR(20), 
    IN p_nombre VARCHAR(100), 
    IN p_categoria VARCHAR(50), 
    IN p_unidad VARCHAR(20),
    IN p_precio DECIMAL(10, 2), 
    IN p_stock INT,
    IN p_estado VARCHAR(20)  -- Agregar el parámetro estado
)
BEGIN
    UPDATE medicamentos
    SET nombre = p_nombre, 
        categoria = p_categoria,
        unidad = p_unidad,
        precio = p_precio, 
        stock = p_stock,
        estado = p_estado  -- Cambiar el estado también
    WHERE id_medicamento = p_idMedicamento;
END //

-- Procedimiento para eliminar (desactivar) un medicamento
CREATE PROCEDURE EliminarMedicamento(
    IN p_idMedicamento VARCHAR(20),
    IN p_estado VARCHAR(20)  -- Agregar el parámetro estado
)
BEGIN
    UPDATE medicamentos
    SET estado = p_estado  -- Cambiar el estado del producto
    WHERE id_medicamento = p_idMedicamento AND estado = 'ACTIVO';  -- Solo cambia el estado si el producto está activo
END //

-- Procedimiento para consultar medicamentos por nombre
CREATE PROCEDURE consultar_medicamento_por_nombre(IN nombreParcial VARCHAR(100))
BEGIN
    SELECT * FROM medicamentos
    WHERE nombre LIKE CONCAT('%', nombreParcial, '%');
END //
DELIMITER ;

-- Insertar medicamentos en la tabla 'medicamentos'
INSERT INTO medicamentos (id_medicamento, nombre, categoria, unidad, precio, stock, estado)
VALUES ('M001', 'Paracetamol', 'Analgésico', 'Caja', 12.50, 100, 'ACTIVO');

INSERT INTO medicamentos (id_medicamento, nombre, categoria, unidad, precio, stock, estado)
VALUES ('M002', 'Ibuprofeno', 'Antiinflamatorio', 'Frasco', 18.00, 50, 'ACTIVO');

INSERT INTO medicamentos (id_medicamento, nombre, categoria, unidad, precio, stock, estado)
VALUES ('M003', 'Amoxicilina', 'Antibiótico', 'Caja', 15.00, 200, 'ACTIVO');

INSERT INTO medicamentos (id_medicamento, nombre, categoria, unidad, precio, stock, estado)
VALUES ('M004', 'Cetirizina', 'Antihistamínico', 'Caja', 10.00, 150, 'ACTIVO');

INSERT INTO medicamentos (id_medicamento, nombre, categoria, unidad, precio, stock, estado)
VALUES ('M005', 'Loratadina', 'Antialérgico', 'Caja', 9.00, 80, 'ACTIVO');

INSERT INTO medicamentos (id_medicamento, nombre, categoria, unidad, precio, stock, estado)
VALUES ('M006', 'Omeprazol', 'Antiinflamatorio', 'Caja', 25.00, 120, 'ACTIVO');

INSERT INTO medicamentos (id_medicamento, nombre, categoria, unidad, precio, stock, estado)
VALUES ('M007', 'Paracetamol Forte', 'Analgésico', 'Caja', 18.00, 60, 'ACTIVO');

INSERT INTO medicamentos (id_medicamento, nombre, categoria, unidad, precio, stock, estado)
VALUES ('M008', 'Acetaminofén', 'Analgésico', 'Caja', 11.00, 140, 'ACTIVO');

INSERT INTO medicamentos (id_medicamento, nombre, categoria, unidad, precio, stock, estado)
VALUES ('M009', 'Dipirona', 'Antiinflamatorio', 'Frasco', 13.50, 90, 'ACTIVO');

INSERT INTO medicamentos (id_medicamento, nombre, categoria, unidad, precio, stock, estado)
VALUES ('M010', 'Clorfenamina', 'Antihistamínico', 'Caja', 8.50, 110, 'ACTIVO');

DELIMITER //

-- Procedimiento para Insertar un Empleado
CREATE PROCEDURE InsertarEmpleado(
    IN p_idEmpleado VARCHAR(20), 
    IN p_dni CHAR(8),
    IN p_nombre VARCHAR(50), 
    IN p_apellidoPaterno VARCHAR(50), 
    IN p_apellidoMaterno VARCHAR(50),
    IN p_direccion VARCHAR(255),
    IN p_fechaNacimiento DATE,
    IN p_telefono VARCHAR(15),
    IN p_correo VARCHAR(100),
    IN p_puesto VARCHAR(50), 
    IN p_usuario VARCHAR(50), 
    IN p_clave VARCHAR(100),
    IN p_estado VARCHAR(20) -- Estado del empleado (ACTIVO o ELIMINADO)
)
BEGIN
    INSERT INTO empleados (id_empleado, dni, nombre, apellido_paterno, apellido_materno, direccion, 
                            fecha_nacimiento, telefono, correo, puesto, usuario, clave, estado)
    VALUES (p_idEmpleado, p_dni, p_nombre, p_apellidoPaterno, p_apellidoMaterno, p_direccion, 
            p_fechaNacimiento, p_telefono, p_correo, p_puesto, p_usuario, p_clave, p_estado);
END //

-- Procedimiento para Actualizar un Empleado
CREATE PROCEDURE ActualizarEmpleado(
    IN p_idEmpleado VARCHAR(20), 
    IN p_dni CHAR(8),
    IN p_nombre VARCHAR(50), 
    IN p_apellidoPaterno VARCHAR(50), 
    IN p_apellidoMaterno VARCHAR(50),
    IN p_direccion VARCHAR(255),
    IN p_fechaNacimiento DATE,
    IN p_telefono VARCHAR(15),
    IN p_correo VARCHAR(100),
    IN p_puesto VARCHAR(50), 
    IN p_usuario VARCHAR(50), 
    IN p_clave VARCHAR(100),
    IN p_estado VARCHAR(20) -- Estado del empleado (ACTIVO o ELIMINADO)
)
BEGIN
    UPDATE empleados
    SET dni = p_dni, 
        nombre = p_nombre, 
        apellido_paterno = p_apellidoPaterno,
        apellido_materno = p_apellidoMaterno,
        direccion = p_direccion,
        fecha_nacimiento = p_fechaNacimiento,
        telefono = p_telefono,
        correo = p_correo,
        puesto = p_puesto,
        usuario = p_usuario,
        clave = p_clave,
        estado = p_estado
    WHERE id_empleado = p_idEmpleado;
END //

-- Procedimiento para Eliminar un Empleado (Cambiar Estado a 'ELIMINADO')
CREATE PROCEDURE EliminarEmpleado(
    IN p_idEmpleado VARCHAR(20)
)
BEGIN
    UPDATE empleados
    SET estado = 'ELIMINADO'
    WHERE id_empleado = p_idEmpleado AND estado = 'ACTIVO'; -- Solo cambia el estado si el empleado está activo
END //

-- Procedimiento para Consultar Empleados Activos
CREATE PROCEDURE ConsultarEmpleadosActivos()
BEGIN
    SELECT id_empleado, nombre, apellido_paterno, apellido_materno, estado
    FROM empleados
    WHERE estado = 'ACTIVO';
END //

-- Procedimiento para Consultar Empleados Eliminados
CREATE PROCEDURE ConsultarEmpleadosEliminados()
BEGIN
    SELECT id_empleado, nombre, apellido_paterno, apellido_materno, estado
    FROM empleados
    WHERE estado = 'ELIMINADO';
END //

DELIMITER ;
DELIMITER //

CREATE PROCEDURE consultar_empleado_por_nombre(IN nombreParcial VARCHAR(100))
BEGIN
    SELECT id_empleado, dni, nombre, apellido_paterno, apellido_materno, direccion, 
           fecha_nacimiento, telefono, correo, puesto, estado, usuario, clave
    FROM empleados
    WHERE nombre LIKE CONCAT('%', nombreParcial, '%');
END //

DELIMITER ;

select *  FROM empleados;  -- Esto eliminará todos los registros de la tabla empleados
DELETE FROM empleados WHERE id_empleado IN ('E011');

INSERT INTO empleados (id_empleado, dni, nombre, apellido_paterno, apellido_materno, direccion, 
                       fecha_nacimiento, telefono, correo, puesto, usuario, clave, estado)
VALUES 
('E001', '11223344', 'Andrés', 'Torres', 'Martínez', 'Calle Nueva 456', '1991-04-10', '963258741', 'andres@example.com', 'Director', 'andresT', 'passwordT1', 'ACTIVO'),
('E002', '22334455', 'Paola', 'Rojas', 'Méndez', 'Av. Libertad 567', '1987-11-12', '987654321', 'paola@example.com', 'Gerente', 'paolaR', 'passwordPaola', 'ACTIVO'),
('E003', '33445566', 'Esteban', 'Pérez', 'Ruiz', 'Calle Río 789', '1993-02-15', '912345678', 'esteban@example.com', 'Vendedor', 'estebanP', 'estebanPass1', 'ACTIVO'),
('E004', '44556677', 'Verónica', 'García', 'López', 'Pasaje Sol 101', '1985-09-20', '965478132', 'veronica@example.com', 'Contadora', 'veronicaG', 'contadora2024', 'ACTIVO'),
('E005', '55667788', 'David', 'Fernández', 'Suárez', 'Av. Centro 202', '1990-06-25', '934567891', 'david@example.com', 'Marketing', 'davidF', 'davidKey2024', 'ACTIVO'),
('E006', '66778899', 'Sofía', 'Vargas', 'Mora', 'Jirón de la Luna 345', '1994-03-30', '934567892', 'sofia@example.com', 'Logística', 'sofiaV', 'logisticaSof1', 'ACTIVO'),
('E007', '77889900', 'Javier', 'Castillo', 'Pérez', 'Calle 22 678', '1992-07-18', '902345678', 'javier@example.com', 'Supervisor', 'javierC', 'supervisor1', 'ACTIVO'),
('E008', '88990011', 'Beatriz', 'Álvarez', 'González', 'Av. España 891', '1988-12-22', '915678234', 'beatriz@example.com', 'Asistente', 'beatrizA', 'asistente2024', 'ACTIVO'),
('E009', '99001122', 'Ricardo', 'Morales', 'Paredes', 'Calle Girasol 123', '1995-01-10', '934567899', 'ricardo@example.com', 'Recepcionista', 'ricardoM', 'recepcionista01', 'ACTIVO'),
('E010', '00112233', 'Gloria', 'Jiménez', 'Martínez', 'Av. Fenix 234', '1990-04-05', '912345679', 'gloria@example.com', 'Secretaria', 'gloriaJ', 'clave123Gloria', 'ACTIVO');

DELIMITER //

CREATE PROCEDURE consultar_cliente_por_nombre(IN nombreParcial VARCHAR(100))
BEGIN
    SELECT id_cliente, dni, nombre, apellido_paterno, apellido_materno, telefono, correo, estado
    FROM clientes
    WHERE nombre LIKE CONCAT('%', nombreParcial, '%');
END //

DELIMITER ;


DELIMITER //

CREATE PROCEDURE InsertarCliente(
    IN idCliente VARCHAR(20),
    IN dni VARCHAR(8),
    IN nombre VARCHAR(50),
    IN apellidoPaterno VARCHAR(50),
    IN apellidoMaterno VARCHAR(50),
    IN telefono VARCHAR(15),
    IN correo VARCHAR(100),
    IN estado VARCHAR(20)
)
BEGIN
    INSERT INTO clientes (id_cliente, dni, nombre, apellido_paterno, apellido_materno, telefono, correo, estado)
    VALUES (idCliente, dni, nombre, apellidoPaterno, apellidoMaterno, telefono, correo, estado);
END //

DELIMITER ;

DELIMITER //

DELIMITER //

CREATE PROCEDURE ActualizarCliente(
    IN p_id_cliente VARCHAR(20),
    IN p_dni CHAR(8),
    IN p_nombre VARCHAR(50),
    IN p_apellido_paterno VARCHAR(50),
    IN p_apellido_materno VARCHAR(50),
    IN p_telefono VARCHAR(15),
    IN p_correo VARCHAR(100),
    IN p_estado VARCHAR(20)  -- Incluir el parámetro 'estado'
)
BEGIN
    UPDATE clientes
    SET dni = p_dni,
        nombre = p_nombre,
        apellido_paterno = p_apellido_paterno,
        apellido_materno = p_apellido_materno,
        telefono = p_telefono,
        correo = p_correo,
        estado = p_estado  -- Actualizar estado
    WHERE id_cliente = p_id_cliente;
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE EliminarCliente(
    IN idCliente VARCHAR(20),
    IN estado VARCHAR(20)
)
BEGIN
    UPDATE clientes
    SET estado = estado
    WHERE id_cliente = idCliente AND estado = 'ACTIVO';  -- Solo cambia el estado si el cliente está activo
END //

DELIMITER ;



INSERT INTO clientes (id_cliente, dni, nombre, apellido_paterno, apellido_materno, telefono, correo, estado)
VALUES
('C001', '12345678', 'Juan', 'Pérez', 'González', '987654321', 'juan.perez@email.com', 'ACTIVO'),
('C002', '23456789', 'Ana', 'Gómez', 'Rodríguez', '987654322', 'ana.gomez@email.com', 'ACTIVO'),
('C003', '34567890', 'Luis', 'Martínez', 'Hernández', '987654323', 'luis.martinez@email.com', 'ACTIVO'),
('C004', '45678901', 'Maria', 'López', 'Fernández', '987654324', 'maria.lopez@email.com', 'ACTIVO'),
('C005', '56789012', 'Carlos', 'Sánchez', 'García', '987654325', 'carlos.sanchez@email.com', 'ACTIVO'),
('C006', '67890123', 'Lucía', 'Moreno', 'Torres', '987654326', 'lucia.moreno@email.com', 'ACTIVO'),
('C007', '78901234', 'José', 'Díaz', 'Ruiz', '987654327', 'jose.diaz@email.com', 'ACTIVO'),
('C008', '89012345', 'Pedro', 'Vázquez', 'Jiménez', '987654328', 'pedro.vazquez@email.com', 'ACTIVO'),
('C009', '90123456', 'Carmen', 'Ramírez', 'Pérez', '987654329', 'carmen.ramirez@email.com', 'ACTIVO'),
('C010', '01234567', 'Rosa', 'García', 'Morales', '987654330', 'rosa.garcia@email.com', 'ACTIVO');





