CREATE TABLE ASIGNATURA(
   id_asignatura   INT NOT NULL AUTO_INCERMENT PRIMARY KEY,
   nombre VARCHAR (40),
   orden  INT,
   id_clase  INT,

   FOREIGN KEY fk_asig_clase(id_clase) REFERENCES clase(id)
   ON UPDATE CASCADE
   ON DELETE RESTRICT
);

INSERT ASIGNATURA (nombre, orden, id_clase) VALUES ('JAVA',0,1);
INSERT ASIGNATURA (nombre, orden, id_clase) VALUES ('SQL',0,1);
INSERT ASIGNATURA (nombre, orden, id_clase) VALUES ('SPRING',0,1);
INSERT ASIGNATURA (nombre, orden, id_clase) VALUES ('SPRING JPA',0,1);
INSERT ASIGNATURA (nombre, orden, id_clase) VALUES ('SPRING CORE',0,1);
INSERT ASIGNATURA (nombre, orden, id_clase) VALUES ('SPRING BOOT',0,1);
INSERT ASIGNATURA (nombre, orden, id_clase) VALUES ('SPRING REST',0,1);
INSERT ASIGNATURA (nombre, orden, id_clase) VALUES ('SPRING MVC',0,1);

