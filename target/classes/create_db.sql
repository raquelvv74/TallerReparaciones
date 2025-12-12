DROP DATABASE IF EXISTS jdbc_tallerreparaciones;
CREATE DATABASE jdbc_tallerreparaciones;
USE jdbc_tallerreparaciones;

-- Tabla cliente
CREATE TABLE cliente (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    dni VARCHAR(12) NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    telefono VARCHAR(20),
    email VARCHAR(100)
);

-- Tabla usuario
CREATE TABLE usuario (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre_usuario VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL,
    rol VARCHAR(20) NOT NULL,
    dni VARCHAR(12)
);

-- Tabla vehiculo
CREATE TABLE vehiculo (
    id_vehiculo INT AUTO_INCREMENT PRIMARY KEY,
    matricula VARCHAR(15) NOT NULL,
    marca VARCHAR(50),
    modelo VARCHAR(50),
    cliente_id INT,
    FOREIGN KEY (cliente_id) REFERENCES cliente(id_cliente)
);

-- Tabla reparacion
CREATE TABLE reparacion (
    id_reparacion INT AUTO_INCREMENT PRIMARY KEY,
    vehiculo_id INT,
    descripcion VARCHAR(300),
    fecha_entrada DATE,
    coste_estimado DOUBLE,
    estado VARCHAR(20),
    usuario_id INT,
    FOREIGN KEY (vehiculo_id) REFERENCES vehiculo(id_vehiculo),
    FOREIGN KEY (usuario_id) REFERENCES usuario(id_usuario)
);

-- Insertar clientes
INSERT INTO cliente (dni, nombre, telefono, email) VALUES
('12345678A', 'Cliente Uno', '600111222', 'cliente1@mail.com'),
('87654321B', 'Cliente Dos', '600222333', 'cliente2@mail.com');

-- Insertar usuarios (admin y mecánico)
INSERT INTO usuario (nombre_usuario, password, rol, dni) VALUES
('admin', 'admin123', 'admin', '11111111A'),
('mecanico', 'meca123', 'mecanico', '22222222B');

-- Insertar vehículos
INSERT INTO vehiculo (matricula, marca, modelo, cliente_id) VALUES
('ABC1234', 'Toyota', 'Corolla', 1),
('XYZ5678', 'Ford', 'Focus', 2);

-- Insertar reparaciones (una finalizada y una pendiente)
INSERT INTO reparacion (vehiculo_id, descripcion, fecha_entrada, coste_estimado, estado, usuario_id) VALUES
(1, 'Cambio de aceite', '2025-02-01', 120, 'finalizada', 2),
(2, 'Revisión de frenos', '2025-02-10', 200, 'pendiente', 2);
