CREATE TABLE IF NOT EXISTS'Asignatura' (
    id INT not null auto-increment;
    nombre varchar,
    orden INT,
    clase INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY fk_asig_clase(id_clase) references 'clase' (id),
    );

insert into asignatura values ('java', 1, 1);
insert into asignatura values ('sql', 2, 1);
insert into asignatura values ('spring', 3, 1);
insert into asignatura values ('spring jpa', 4, 1);
insert into asignatura values ('spring core', 5, 1);
insert into asignatura values ('spring boot', 6, 1);
insert into asignatura values ('spring rest', 7, 1);
insert into asignatura values ('spring mvc', 8, 1);
