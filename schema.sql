/**
 * Author:  alexander baikalov
 */

CREATE DATABASE IF NOT EXISTS agendajfx;
USE agendajfx;

/* */
CREATE TABLE contactos
(
	id SMALLINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(32) NOT NULL,
    apellido VARCHAR(32) NOT NULL,
    telefono VARCHAR(16) NOT NULL,
    email VARCHAR(16),
    notas VARCHAR(64)
);
INSERT INTO contactos (nombre, apellido, telefono, email, notas)
VALUES
	('Alex', 'Baik', '3644382805', 'alex@mail.ru', 'Le gusta programar'),
	('Nel', 'Ruoti', '3644382805', 'nel@hotmail.com', ''),
	('Daniel', 'Beucar', '3644382805', 'daniel@mail.com', 'Cree en lo imposible'),
	('Joel', 'Losd', '3644382805', 'joel@gmail.com', 'fanboy Dragon Ball'),
	('Carmen', 'Soraire', '3644382805', 'carmen@mail.com', 'Es baterista')
;
