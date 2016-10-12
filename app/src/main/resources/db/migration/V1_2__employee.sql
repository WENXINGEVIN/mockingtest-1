CREATE TABLE EMPLOYEE(
    id INT NOT NULL auto_increment, 
    last_name VARCHAR(50) NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    joining_date DATE NOT NULL,
    salary DOUBLE NOT NULL,
    ssn VARCHAR(30) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);