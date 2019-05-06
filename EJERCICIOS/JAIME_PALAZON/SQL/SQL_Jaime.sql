CREATE TABLE if not exists 'asignatura' (
id INT not null auto-increment,
nombre varchar,
orden int,
id_clase varchar
PRIMARY KEY (id),
foreign key id_clase references 'clase' (id), 
);

insert asignatura values ('java', 1, 1);
insert asignatura values ('sql', 2, 1);
insert asignatura values ('spring', 3, 1);
insert asignatura values ('spring jpa', 1, 1);
insert asignatura values ('spring core', 1, 1);
insert asignatura values ('spring boot', 1, 1);
insert asignatura values ('spring rest', 1, 1);