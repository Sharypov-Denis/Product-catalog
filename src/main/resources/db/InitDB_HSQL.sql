DROP TABLE products IF EXISTS;
DROP SEQUENCE global_seq IF EXISTS;

CREATE SEQUENCE global_seq AS INTEGER START WITH 1;

CREATE TABLE products
(
    id          INTEGER GENERATED BY DEFAULT AS SEQUENCE global_seq PRIMARY KEY,
    name        VARCHAR(255) UNIQUE NOT NULL,
    description VARCHAR(255)        NOT NULL
);

INSERT INTO products (name, description)
VALUES ('Молоко', 'описание продукта'),
       ('Молоко2', 'описание продукта'),
       ('Молоко3', 'описание продукта'),
       ('Творог', 'описание продукта'),
       ('Творог2', 'описание продукта'),
       ('Сливки', 'описание продукта'),
       ('Сок', 'описание продукта'),
       ('Хлопья', 'описание продукта'),
       ('Масло сливочное', 'описание продукта'),
       ('Сыр', 'описание продукта'),
       ('Йогурт', 'описание продукта');
