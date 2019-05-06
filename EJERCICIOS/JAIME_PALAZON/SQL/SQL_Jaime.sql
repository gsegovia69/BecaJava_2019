CREATE TABLE IF NOT EXISTS asignatura (
id INT NOT NULL AUTO_INCREMENT,
nombre VARCHAR,
orden INT,
id_clase INT,
PRIMARY KEY (id),
CONSTRAINT fk_asignatura_clase  FOREIGN KEY  id_clase REFERENCES clase (id) 
ON UPDATE CASCADE   
);

INSERT INTO asignatura (nombre,orden,id_clase) VALUES ('java', 1, 1);
INSERT INTO asignatura (nombre,orden,id_clase) VALUES ('sql', 2, 1);
INSERT INTO asignatura (nombre,orden,id_clase) VALUES ('spring', 3, 1);
INSERT INTO asignatura (nombre,orden,id_clase) VALUES ('spring jpa', 4, 1);
INSERT INTO asignatura (nombre,orden,id_clase) VALUES ('spring core', 5, 1);
INSERT INTO asignatura (nombre,orden,id_clase) VALUES ('spring boot', 6, 1);
INSERT INTO asignatura (nombre,orden,id_clase) VALUES ('spring rest', 7, 1);


SELECT DISTINCT alumno.nombre, clase.nombre, asigntura.nombre FROM alumno, clase, asignatura where asignatura.id_clase = clase.id and alumno.id_clase= clase.id;