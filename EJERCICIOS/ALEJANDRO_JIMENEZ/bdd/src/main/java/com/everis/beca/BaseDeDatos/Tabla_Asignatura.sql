CREATE TABLE IF NOT EXISTS Asignatura (
	id int(20)  AUTO_INCREMENT,
	nombre VARCHAR (40) NOT NULL,
	orden  int(20) AUTO_INCREMENT,
	id_clase int (20)  NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (id_clase) REFERENCES Clase(id) 
);

INSERT INTO asignatura(nombre,id_clase) VALUES ('JAVA', 1 );
INSERT INTO asignatura(nombre,id_clase) VALUES ('SQL', 1 );
INSERT INTO asignatura(nombre,id_clase) VALUES ('SPRING',1);
INSERT INTO asignatura(nombre,id_clase) VALUES ('CORE', 1 );
INSERT INTO asignatura(nombre,id_clase) VALUES ('BOOT', 1 );
INSERT INTO asignatura(nombre,id_clase) VALUES ('REST', 1 );
INSERT INTO asignatura(nombre,id_clase) VALUES ('MVC', 1  );