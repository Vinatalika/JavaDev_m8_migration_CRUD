
CREATE TABLE worker (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    NAME VARCHAR(1000) NOT NULL CHECK (LENGTH(NAME) >= 2 AND LENGTH(NAME) <= 1000),
    BIRTHDAY DATE CHECK (YEAR(BIRTHDAY) > 1900),
    LEVEL ENUM('Trainee', 'Junior', 'Middle', 'Senior') NOT NULL,
    SALARY INT CHECK (SALARY >= 100 AND SALARY <= 100000)
);


CREATE TABLE client (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    NAME VARCHAR(1000) NOT NULL CHECK (LENGTH(NAME) >= 2 AND LENGTH(NAME) <= 1000)
);


CREATE TABLE project (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    CLIENT_ID INT,
    START_DATE DATE,
    FINISH_DATE DATE,
    FOREIGN KEY (CLIENT_ID) REFERENCES client(ID)
);


CREATE TABLE IF NOT EXISTS project_worker (
    PROJECT_ID INT,
    WORKER_ID INT,
    PRIMARY KEY (PROJECT_ID, WORKER_ID),
    FOREIGN KEY (PROJECT_ID) REFERENCES project(ID),
    FOREIGN KEY (WORKER_ID) REFERENCES worker(ID)
);
