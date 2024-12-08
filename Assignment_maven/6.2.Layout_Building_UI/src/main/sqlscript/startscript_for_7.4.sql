-- 1.Drop a user account appuser, if it exists
DROP USER IF EXISTS 'metrouser'@'localhost';

-- 2.Create a user account appuser

CREATE USER 'metrouser'@'localhost' IDENTIFIED BY 'password';

-- 3.Grant privileges to the user account appuser
GRANT SELECT, INSERT, UPDATE, DELETE ON currency_converter2.* TO 'metrouser'@'localhost';

-- 4.Grant create,drop priviliege to metrouser to user hibernate
GRANT CREATE, DROP ON currency_converter2.* TO 'metrouser'@'localhost';

-- 5.Drop previous database if it is existed
DROP DATABASE IF EXISTS currency_converter2;

-- 6.Create a database
CREATE DATABASE currency_converter2;
USE currency_converter2;


