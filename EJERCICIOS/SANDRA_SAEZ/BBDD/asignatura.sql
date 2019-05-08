
DROP TABLE IF EXISTS asignatura;
CREATE TABLE asignatura (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    orden INT(100)  NOT NULL,
    id_clase INT(10) NOT NULL,
    FOREIGN KEY(id_clase) REFERENCES clase(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
   
);

INSERT INTO asignatura VALUES ('Java', 1, 1);
INSERT INTO asignatura VALUES ('Sql', 2 , 1);
INSERT INTO asignatura VALUES ('Spring', 3, 1);
INSERT INTO asignatura VALUES ('Spring Jpa', 4, 1);
INSERT INTO asignatura VALUES ('Spring Core', 5, 1);
INSERT INTO asignatura VALUES ('Spring Boot', 6, 1);
INSERT INTO asignatura VALUES ('Spring Rest', 7, 1);
INSERT INTO asignatura VALUES ('Spring Mvc', 8, 1);


 