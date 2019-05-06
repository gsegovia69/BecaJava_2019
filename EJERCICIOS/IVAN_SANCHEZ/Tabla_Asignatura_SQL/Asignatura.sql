CREATE TABLE ASIGNATURA
(AsignaturaID int PRIMAR KEY NOT NULL,
Nombre varchar (25) NOT NULL,
Orden int (10) NOT NULL,
Clase_ID int,
FOREIGN KEY (Clase_ID) REFERENCES Clase(ID)
    ON DELETE CASCADE    
    ON UPDATE CASCADE  );
GO




INSERT ASIGNATURA (AsignaturaID, Nombre, Orden,Clase)
    VALUES (1, 'JAVA', 1, 1)
    VALUES (2, 'SQL', 2, 1)
    VALUES (3, 'SPRING', 3, 1)
    VALUES (4, 'SPRING JPA ', 4, 1)
    VALUES (5, 'SPRING CORE', 5, 1)
    VALUES (6, 'SPRING BOOT', 6, 1)
    VALUES (7, 'SPRING REST', 7, 1)
    VALUES (8, 'SPRING MVC', 8, 1)
    GO