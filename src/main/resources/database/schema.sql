CREATE TABLE IF NOT EXISTS users (
    ID INT NOT NULL AUTO_INCREMENT,
    USERNAME VARCHAR(64) NOT NULL,
    PASSWORD VARCHAR(64) NOT NULL,
    MAIL VARCHAR(128) NOT NULL,
    NICKNAME VARCHAR(64) NOT NULL,
    STATUS VARCHAR(2) NOT NULL,
    PRIMARY KEY (ID)
);