
CREATE TABLE asignatura  
{
   (id INT PRIMARY KEY NOT NULL,  
    nombre VARCHAR(50) NOT NULL,  
    orden INT NOT NULL,  
    id_clase INT NOT NULL,
	FOREING KEY (id_clase) REFERENCES clase(id)
);

INSERT INTO asignatura (id, nombre, orden, id_clase) VALUES (1, 'Java', 1, 1);
INSERT INTO asignatura (id, nombre, orden, id_clase) VALUES (2, 'Sql', 2, 1);
INSERT INTO asignatura (id, nombre, orden, id_clase) VALUES (3, 'Spring', 3, 1);
INSERT INTO asignatura (id, nombre, orden, id_clase) VALUES (4, 'Spring jpa', 4, 1);
INSERT INTO asignatura (id, nombre, orden, id_clase) VALUES (5, 'Spring core', 5, 1);
INSERT INTO asignatura (id, nombre, orden, id_clase) VALUES (6, 'Spring boot', 6, 1);
INSERT INTO asignatura (id, nombre, orden, id_clase) VALUES (7, 'Spring rest', 7, 1);
INSERT INTO asignatura (id, nombre, orden, id_clase) VALUES (8, 'Spring mvc', 8, 1);