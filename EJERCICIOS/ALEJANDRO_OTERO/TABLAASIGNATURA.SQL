CREATE TABLE ASIGNATURA (
	'id' int(12) not null,
	'nombre' varchar(12),
	'orden' int(12),
	'clase' int(30),
	primary key ('id'),
	foreign key ('id_clase') references 'clase',
	)
	ON DELETE CASCADE
	ON UPDATE CASCADE );
	
	insert into_value ASIGNATURA VALUES (1,'JAVA' ,1, 1);
	insert into_value ASIGNATURA VALUES (2,'SQL',2, 1);
	INSERT into_value ASIGNATURA VALUES (3,'SPRING' ,3 , 1);
	INSERT INTO_VALUE ASIGNATURA VALUES (4,'SPRING CORE' , 4 , 1 );
	INSERT INTO_VALUE ASIGNATURA VALUES (5,'SPRING BOOT' , 5 , 1 );
	INSERT INTO_VALUE ASIGNATURA VALUES (6,'SPRING REST', 6 , 1 );
	INSERT INTO_VALUE ASIGNATURA VALUES (7,'SPRINT MVC' , 7 , 1 );
	
	GO
	
	
	