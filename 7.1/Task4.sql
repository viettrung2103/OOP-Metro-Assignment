
-- 1.Drop previous database if it is existed
DROP DATABASE IF EXISTS currency_converter;

-- 2.Create a database
CREATE DATABASE currency_converter;
USE currency_converter;

-- 3.Create a table for storing the C
CREATE TABLE CURRENCY (
	id INT NOT NULL AUTO_INCREMENT,
	abbreviation VARCHAR(50) NOT NULL,
	rate DECIMAL(10,4) NOT NULL,
	PRIMARY KEY (id)
);


-- 4.Populate the data, at least 8 data
INSERT INTO CURRENCY (abbreviation, rate) VALUES
("USD",1.0),
("EUR",0.9518),
("VND",25418.4),
("GBP",0.7892),
("JPY",149.455),
("SEK",11.0152 ),
("CNY",7.2852),
("CAD",1.4066);


-- 5.Drop a user account appuser, if it exists
DROP USER IF EXISTS 'appuser'@'localhost';

-- 6.Create a user account appuser

CREATE USER 'appuser'@'localhost' IDENTIFIED BY 'password';

-- Grant privileges to the user account appuser
GRANT SELECT, INSERT, UPDATE, DELETE ON currency_converter.* TO 'appuser'@'localhost';employee