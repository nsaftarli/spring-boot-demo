DROP TABLE IF EXISTS CUSTOMERS;

CREATE TABLE CUSTOMERS (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(250) NOT NULL,
    last_name VARCHAR(250) NOT NULL,
    address BLOB
);

INSERT INTO CUSTOMERS (first_name, last_name) VALUES
    ('First', 'Customer'),
    ('Second', 'Customer'),
    ('Third', 'Person');
