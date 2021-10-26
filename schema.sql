/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  enzom
 * Created: 26/10/2021
 */

CREATE DATABASE IF NOT EXISTS agendajfx;
USE agendajfx;

/* */
CREATE TABLE provincias
(
	id TINYINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR(32) NOT NULL
);
INSERT INTO provincias (nombre)
VALUES
	('Capital Federal'),
	('Buenos Aires'),
	('Catamarca'),
	('Chubut'),
	('Chaco'),
	('Corrientes'),
	('Córdoba'),
	('Entre Ríos'),
	('Jujuy'),
	('Formosa'),
	('La Pampa'),
	('La Rioja'),
	('Misiones'),
	('Mendoza'),
	('Neuquén'),
	('Río Negro'),
	('Salta'),
	('San Juan'),
	('San Luis'),
	('Santa Cruz'),
	('Santa Fe'),
	('Santiago del Estero'),
	('Tierra del Fuego'),
	('Tucumán')
;

/* */
CREATE TABLE ciudades
(
	id SMALLINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(64) NOT NULL,
    cpa CHAR(4),
    provinciaId TINYINT NOT NULL,
    CONSTRAINT provinciaId FOREIGN KEY (provinciaId) REFERENCES provincias(id)
);
INSERT INTO ciudades (nombre, cpa, provinciaId) 
VALUES
	('Castelli', '3705', 5),
    ('Resistencia', '3500', 5),
    ('Tres Isletas', '3703', 5),
    ('Paso de la Patria', '3635', 6)
;

/* */
CREATE TABLE contactos
(
	id SMALLINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(32) NOT NULL,
    apellido VARCHAR(32) NOT NULL,
    telefono VARCHAR(16) NOT NULL,
    email VARCHAR(16),
    direccion VARCHAR(32) NOT NULL,
    notas VARCHAR(64),
    ciudadId SMALLINT,
    CONSTRAINT ciudadId FOREIGN KEY (ciudadId) REFERENCES ciudades(id)
);
INSERT INTO contactos (nombre, apellido, telefono, email, direccion, notas, ciudadId)
VALUES
	('Enzo', 'Sierra', '3644382805', 'enzo@mail.com', 'B San Cayetano', '', 1),
	('Pity', 'Soria', '3644382805', 'pity@mail.com', 'Av. San Martin, 455', '', 1),
	('Nelson', 'Medina', '3644382805', 'nelson@mail.com', 'Av. Alberdi, 555', 'Cree en lo imposible', 1),
	('Joel', 'Paredes', '3644382805', 'joel@mail.com', 'Calle Schultz, 987', 'Naruto fanboy', 1),
	('Marcelo', 'Soraire', '3644382805', 'marcelo@mail.com', 'Av. Castelli, 1200', 'Es baterista', 2)
;
