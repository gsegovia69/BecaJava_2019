
Create table Asignatura(
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre varchar(50),
    orden int,
    id_clase int,
    CONSTRAINT fk_id_clase FOREIGN KEY id_clase references clase(id)
	 );
    
INSERT INTO ASIGNATURA(nombre, orden, id_clase) VALUES ('JAVA', '1', '1');
INSERT INTO ASIGNATURA(nombre, orden, id_clase) VALUES ('SQL', '2', '1');
INSERT INTO ASIGNATURA(nombre, orden, id_clase) VALUES ('SPRING', '3', '1');
INSERT INTO ASIGNATURA(nombre, orden, id_clase) VALUES ('SPRING JPS', '4', '1');
INSERT INTO ASIGNATURA(nombre, orden, id_clase) VALUES ('SPRING CORE', '5', '1');
INSERT INTO ASIGNATURA(nombre, orden, id_clase) VALUES ('SPRING BOOT', '6', '1');
INSERT INTO ASIGNATURA(nombre, orden, id_clase) VALUES ('SPRING REST', '7', '1');
INSERT INTO ASIGNATURA(nombre, orden, id_clase) VALUES ('SPRING MVC', '8', '1');

