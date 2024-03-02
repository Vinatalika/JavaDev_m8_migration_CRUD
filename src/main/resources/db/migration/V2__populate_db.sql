
INSERT INTO worker (NAME, BIRTHDAY, LEVEL, SALARY) VALUES
    ('Anna Smith', '2003-01-15', 'Trainee', 800),
    ('Dmytro Sokol', '2001-03-20', 'Junior', 1100),
    ('Ruslan Kopsha', '1980-11-10', 'Middle', 2500),
    ('Olga Polunina', '1983-08-11', 'Middle', 2200),
    ('Ivan Lomin', '2000-02-17', 'Junior', 1000),
    ('Pavlo Sled', '2000-01-06', 'Senior', 7000),
    ('Alex Pirogov', '2005-07-22', 'Trainee', 850),
    ('Oleg Palkov', '1977-02-14', 'Middle', 3000),
    ('Natali Stepanenko', '2000-12-10', 'Junior', 1200),
    ('Alice Groony', '1992-03-25', 'Senior', 6000);


INSERT INTO client (NAME) VALUES
    ('Mirsasoft'),
    ('Opensoft'),
    ('Word Work Shop'),
    ('Miracle OS'),
    ('SoftForAll'),
    ('SoftForAll New'),
    ('Armo Amor'),
    ('Final'),
    ('StartSequre'),
    ('Amicon');


INSERT INTO project (CLIENT_ID, START_DATE, FINISH_DATE) VALUES
    (1, '2021-10-01', '2022-12-31'),
    (2, '2021-11-15', '2023-04-30'),
    (3, '2022-01-01', '2022-06-30'),
    (4, '2023-02-01', '2023-09-20'),
    (5, '2023-06-01', '2024-01-15'),
    (6, '2023-06-15', '2023-12-31'),
    (7, '2023-07-01', '2024-02-10'),
    (8, '2023-07-12', '2024-01-31'),
    (9, '2023-08-01', '2024-02-03'),
    (10, '2023-10-01', '2024-03-22');


INSERT INTO project_worker (PROJECT_ID, WORKER_ID) VALUES
        (1, 1),
        (1, 2),
        (2, 3),
        (3, 4),
        (3, 5),
        (3, 6),
        (4, 1),
        (4, 5),
        (4, 6),
        (5, 5),
        (5, 6),
        (5, 7),
        (5, 8),
        (5, 9),
        (6, 10),
        (7, 3),
        (7, 4),
        (8, 5),
        (8, 9),
        (9, 9);

