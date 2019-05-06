CREATE TABLE IF NOT EXISTS'Asignatura' (
    id INT not null auto-increment;
    nombre varchar,
    orden INT,
    clase INT,
    PRIMARY KEY (id),
    FOREIGN KEY id_clase references 'clase' (id),
    );
insert asignatura values ('java', 1, 1);
insert asignatura values ('sql', 2, 1);
insert asignatura values ('spring', 3, 1);
insert asignatura values ('spring jpa', 4, 1);
insert asignatura values ('spring core', 5, 1);
insert asignatura values ('spring boot', 6, 1);
insert asignatura values ('spring rest', 7, 1);
insert asignatura values ('spring mvc', 8, 1);
