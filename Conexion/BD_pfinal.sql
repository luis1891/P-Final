DROP DATABASE Registro;
CREATE DATABASE Registro;
USE Registro;

CREATE TABLE Persona (
ci INT PRIMARY KEY,
Nom_completo VARCHAR(100) NOT NULL,
contraseña VARCHAR(10) NOT NULL,
ubicacion VARCHAR(100) NOT NULL
);

CREATE TABLE proveedor (
ci2 INT NOT NULL PRIMARY KEY REFERENCES persona (ci),
nombre_c VARCHAR(40) NOT NULL,
contraseña_p VARCHAR(10) NOT NULL,
contacto INT NOT NULL,
disponibilidad VARCHAR(10) NOT NULL
);

CREATE TABLE servicio (
id_s VARCHAR(20) PRIMARY KEY,
descripcion VARCHAR(100) NOT NULL
);

CREATE TABLE hace (
id_se VARCHAR(20) NOT NULL,
ci3 INT NOT NULL,
precio INT NOT NULL,
horario VARCHAR(20) NOT NULL,
zona VARCHAR(20) NOT NULL,
primary key (id_se, ci3),
CONSTRAINT FOREIGN KEY(id_se) REFERENCES servicio (id_s),
CONSTRAINT FOREIGN KEY(ci3) REFERENCES Persona (ci)
);

CREATE TABLE contrata (
ci4 INT NOT NULL,
id_ser VARCHAR(20) NOT NULL,
fecha_c VARCHAR(20) NOT NULL,
hora_tra VARCHAR(20) NOT NULL,
primary key(ci4, id_ser),
CONSTRAINT FOREIGN KEY(ci4) REFERENCES Persona (ci),
CONSTRAINT FOREIGN KEY(id_ser) REFERENCES servicio (id_s)
);

CREATE TABLE horario (
id_h VARCHAR(20) PRIMARY KEY NOT NULL,
fecha_hor_in VARCHAR(10) NOT NULL,
fecha_hor_fin VARCHAR(10) NOT NULL,
estado VARCHAR(10) NOT NULL
);