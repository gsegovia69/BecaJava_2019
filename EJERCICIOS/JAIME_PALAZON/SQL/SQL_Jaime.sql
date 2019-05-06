CREATE TABLE IF NOT EXISTS asignatura (
id INT NOT NULL AUTO_INCREMENT,
nombre VARCHAR,
orden INT,
id_clase INT,
PRIMARY KEY (id),
FOREIGN KEY fk_asignatura_clase (id_clase) REFERENCES clase (id) 
ON UPDATE CASCADE   
);

INSERT INTO asignatura (nombre,orden,id_clase) VALUES ('java', 1, 1);
INSERT INTO asignatura (nombre,orden,id_clase) VALUES ('sql', 2, 1);
INSERT INTO asignatura (nombre,orden,id_clase) VALUES ('spring', 3, 1);
INSERT INTO asignatura (nombre,orden,id_clase) VALUES ('spring jpa', 4, 1);
INSERT INTO asignatura (nombre,orden,id_clase) VALUES ('spring core', 5, 1);
INSERT INTO asignatura (nombre,orden,id_clase) VALUES ('spring boot', 6, 1);
INSERT INTO asignatura (nombre,orden,id_clase) VALUES ('spring rest', 7, 1);