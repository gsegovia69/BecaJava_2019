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
	
	insert into_value ASIGNATURA VALUES ('JAVA' ,1, 1);
	insert into_value ASIGNATURA VALUES ('SQL',2, 1);
	INSERT into_value ASIGNATURA VALUES ('SPRING' ,3 , 1);
	INSERT INTO_VALUE ASIGNATURA VALUES ('SPRING CORE' , 4 , 1 );
	INSERT INTO_VALUE ASIGNATURA VALUES ('SPRING BOOT' , 5 , 1 );
	INSERT INTO_VALUE ASIGNATURA VALUES ('SPRING REST', 6 , 1 );
	INSERT INTO_VALUE ASIGNATURA VALUES ('SPRINT MVC' , 7 , 1 );
	
	GO
	
	
	