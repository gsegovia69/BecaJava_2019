-- BOOKING 

INSERT INTO `garage`.`booking` (`entry`, `exit`, `disscount`, `idclient`, `idinvoice`) 
VALUES ('?', '?', '?', '?', '?');

-- CLIENT 

INSERT INTO `garage`.`client` (`name`, `surname`, `email`, `telephone`, `nif`, `idvehicle`) 
VALUES ('?', '?', '?', '?', '?', '?');

-- VEHICLE

INSERT INTO `garage`.`vehicle` (`plate`, `brand`, `model`, `colour`, `type`, `idclient`, `idplace`) 
VALUES ('?', '?', '?', '?', '?', '?');

-- INVOICE

INSERT INTO `garage`.`invoice` (`number`, `price`) 
VALUES ('?', '?');

-- Plazas libres/ocupadas (NUMERO_PLAZA,LIBRE/OCUPADA,PRECIO,TAMAÑO)

SELECT p.number, p.price, p.size, v.idplace AS occupied
FROM place p
LEFT JOIN vehicle v ON v.idplace=p.idplace;

-- Listado reservas por cliente (CODIGO_RESERVA,NIF,MATRICULA,PLAZA,PRECIO)

SELECT b.idbooking, c.nif, v.plate, p.number AS place, p.price
FROM client_booking cb
INNER JOIN booking b ON b.idbooking=cb.idbooking
INNER JOIN client c ON c.idclient=cb.idclient
INNER JOIN vehicle v ON c.idvehicle=c.idvehicle
INNER JOIN place p ON p.idplace=v.idplace;

-- Ingresos Mensuales por cliente (NIF,NOMBRE,APELLIDOS,CANTIDAD)

SELECT c.nif, c.name, c.surname, SUM(i.price) AS amount
FROM invoice i
INNER JOIN booking b ON b.idinvoice=i.idinvoice
INNER JOIN client c ON c.idclient=b.idclient
GROUP BY c.nif ORDER BY amount DESC;

-- Ingresos Mensuales por plaza   (PLAZA,CANTIDAD)

SELECT p.number, SUM(i.price) AS amount
FROM vehicle v
INNER JOIN place p ON p.idplace=v.idplace
INNER JOIN client c ON c.idvehicle=v.idvehicle
INNER JOIN booking b ON b.idclient=c.idclient
INNER JOIN invoice i ON i.idinvoice=b.idinvoice
GROUP BY p.number ORDER BY amount DESC;

-- Entradas/Salidas (MATRICULA,NIF,FECHA ENTRADA,FECHA SALIDA,IMPORTE ACTUAL)

SELECT v.plate, c.nif, b.entry, b.exit, i.price
FROM booking b
INNER JOIN client c ON c.idclient=b.idclient
INNER JOIN vehicle v ON v.idvehicle=c.idvehicle
INNER JOIN invoice i ON i.idinvoice=b.idinvoice;
