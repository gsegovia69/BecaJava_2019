CREATE TABLE IF NOT EXISTS 'ASIGNATURA' (
    'id' int(11) NOT NULL AUTO-INCREMENT,
    'nombre' varchar(50),
    'orden' int(11),
    'id_clase' int(11),
    PRIMARY KEY ('id'),
    FOREIGN KEY ('id_clase') REFERENCES 'clase' ('id'),
)
INSERT INTO ASIGNATURA VALUES ('JAVA', '1', '1');
INSERT INTO ASIGNATURA VALUES ('SQL', '2', '1');
INSERT INTO ASIGNATURA VALUES ('SPRING', '3', '1');
INSERT INTO ASIGNATURA VALUES ('SPRING JPS', '4', '1');
INSERT INTO ASIGNATURA VALUES ('SPRING CORE', '5', '1');
INSERT INTO ASIGNATURA VALUES ('SPRING BOOT', '6', '1');
INSERT INTO ASIGNATURA VALUES ('SPRING REST', '7', '1');
INSERT INTO ASIGNATURA VALUES ('SPRING MVC', '8', '1');

