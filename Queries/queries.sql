gcloud sql connect data-vishnu --user=postgres


CREATE TABLE employees (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    department VARCHAR(50)
);


INSERT INTO employees (name, department)
VALUES ('John Doe', 'Engineering'),
       ('Jane Smith', 'Marketing'),
       ('Michael Brown', 'Sales');

UPDATE employees                                                                                                                                                                       
SET department = 'IT'                                                                                                                                                                             
WHERE name = 'John Doe';


SELECT * FROM employees;

SELECT * FROM employees
WHERE department = 'Sales';

DELETE FROM employees
WHERE name = 'Jane Smith';

