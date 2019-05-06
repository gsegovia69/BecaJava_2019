CREATE TABLE ASIGNATURA(
   id_asignatura   INT  IDENTITY(1,1) NOT NULL,
   nombre VARCHAR (40),
   orden  INT,
   id_clase  INT,

   PRIMARY KEY (id_asignatura),
   FOREIGN KEY (id_clase) REFERENCES clase(id)
);

INSERT ASIGNATURA (nombre, orden, id_clase) VALUES ('JAVA',0,1);
INSERT ASIGNATURA (nombre, orden, id_clase) VALUES ('SQL',0,1);
INSERT ASIGNATURA (nombre, orden, id_clase) VALUES ('SPRING',0,1);
INSERT ASIGNATURA (nombre, orden, id_clase) VALUES ('SPRING JPA',0,1);
INSERT ASIGNATURA (nombre, orden, id_clase) VALUES ('SPRING CORE',0,1);
INSERT ASIGNATURA (nombre, orden, id_clase) VALUES ('SPRING BOOT',0,1);
INSERT ASIGNATURA (nombre, orden, id_clase) VALUES ('SPRING REST',0,1);
INSERT ASIGNATURA (nombre, orden, id_clase) VALUES ('SPRING MVC',0,1);

