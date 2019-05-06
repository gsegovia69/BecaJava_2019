
DROP TABLE IF EXISTS asignatura;
CREATE TABLE asignatura (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    orden INT(100)  NOT NULL,
    id_clase INT(10) NOT NULL,
    FOREIGN KEY(id_clase) REFERENCES clase(id)
   
);

INSERT INTO asignatura VALUES (1, 'Java', 1, 1);
INSERT INTO asignatura VALUES (2, 'Sql', 2 , 1);
INSERT INTO asignatura VALUES (3, 'Spring', 3, 1);
INSERT INTO asignatura VALUES (4, 'Spring Jpa', 4, 1);
INSERT INTO asignatura VALUES (5, 'Spring Core', 5, 1);
INSERT INTO asignatura VALUES (6, 'Spring Boot', 6, 1);
INSERT INTO asignatura VALUES (7, 'Spring Rest', 7, 1);
INSERT INTO asignatura VALUES (8, 'Spring Mvc', 8, 1);


 