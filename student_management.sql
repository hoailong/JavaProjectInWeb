CREATE DATABASE student_management;
USE student_management;

CREATE TABLE province(
    province_id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50),
    PRIMARY KEY(province_id)
);

CREATE TABLE student(
    student_id INT NOT NULL,
    name VARCHAR(50),
    dob VARCHAR(10),
    gender BOOLEAN,
    math FLOAT,
    physical FLOAT,
    chemistry FLOAT,
    province_id INT DEFAULT 0,
    PRIMARY KEY(student_id)
);

ALTER TABLE student ADD FOREIGN KEY(province_id) REFERENCES province(province_id);

    