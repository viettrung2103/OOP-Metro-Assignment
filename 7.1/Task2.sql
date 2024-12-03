
-- 5.Drop a user account appuser, if it exists
DROP USER IF EXISTS 'appuser'@'localhost';

-- 6.Create a user account appuser

CREATE USER 'appuser'@'localhost' IDENTIFIED BY 'password';