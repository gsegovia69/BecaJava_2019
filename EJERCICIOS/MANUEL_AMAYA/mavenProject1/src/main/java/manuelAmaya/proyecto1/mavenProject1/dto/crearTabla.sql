create table Asignatura (Id INT NOT NULL, Nombre VARCHAR(25), Orden INT, Clase INT()
PRIMARY KEY(Id), 
FOREIGN KEY(Clase) REFERENCES Clase(id));
insert into Asignatura(Id, Nombre, Orden, Clase) values(1, "JAVA", 1, 1);
insert into Asignatura(Id, Nombre, Orden, Clase) values(2, "SQL", 2, 1);
insert into Asignatura(Id, Nombre, Orden, Clase) values(3, "SPRING", 3, 1);
insert into Asignatura(Id, Nombre, Orden, Clase) values(4, "SPRING JPA", 4, 1);
insert into Asignatura(Id, Nombre, Orden, Clase) values(5, "SPRING CORE", 5, 1);
insert into Asignatura(Id, Nombre, Orden, Clase) values(6, "SPRING BOOT", 6, 1);
insert into Asignatura(Id, Nombre, Orden, Clase) values(7, "SPRING REST", 7, 1);
insert into Asignatura(Id, Nombre, Orden, Clase) values(8, "SPRING MVC", 8, 1);