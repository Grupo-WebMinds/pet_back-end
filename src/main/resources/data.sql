drop database pets;
CREATE database PETS;
USE PETS;

CREATE TABLE IF NOT EXISTS auth_user (
                                         id INT NOT NULL auto_increment,
                                         name VARCHAR(255) NOT NULL,
    cell_phone VARCHAR(15) NOT NULL,
    telephone VARCHAR(15) NOT NULL,
    date_birth DATE NOT NULL,
    cpf CHAR(11) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    date_creation DATETIME NOT NULL,
    user_type TINYINT NOT NULL,
    PRIMARY KEY (id));


CREATE TABLE IF NOT EXISTS pet (
                                   id INT NOT NULL auto_increment,
                                   name VARCHAR(45) NOT NULL,
    type_pet VARCHAR(45) NOT NULL,
    race VARCHAR(45) NOT NULL,
    weight DOUBLE NOT NULL,
    size TINYINT NOT NULL,
    gender TINYINT NOT NULL,
    date_birth DATE,
    date_creation DATETIME,
    auth_user_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (auth_user_id)
    REFERENCES auth_user (id));


CREATE TABLE IF NOT EXISTS pet_shop (
                                        id INT NOT NULL auto_increment,
                                        nome VARCHAR(45) NULL,
    cnpj VARCHAR(45) NULL,
    cep CHAR(8) NULL,
    logradouro VARCHAR(255) NULL,
    complemento VARCHAR(45) NULL,
    bairro VARCHAR(45) NULL,
    localidade VARCHAR(45) NULL,
    uf CHAR(2) NULL,
    auth_user_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (auth_user_id)
    REFERENCES auth_user (id)
    );


CREATE TABLE IF NOT EXISTS employee (
                                        id INT NOT NULL auto_increment,
                                        time_start TIME NULL,
                                        time_end TIME NULL,
                                        pet_shop_id INT NOT NULL,
                                        auth_user_id INT NOT NULL,
                                        PRIMARY KEY (id),
    FOREIGN KEY (pet_shop_id)
    REFERENCES pet_shop (id),
    FOREIGN KEY (auth_user_id)
    REFERENCES auth_user (id));


CREATE TABLE IF NOT EXISTS service_pet (
                                           id INT NOT NULL auto_increment,
                                           name VARCHAR(45) NULL,
    size TINYINT NULL,
    price DECIMAL(7,2) NULL,
    pet_shop_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (pet_shop_id)
    REFERENCES pet_shop (id));


CREATE TABLE IF NOT EXISTS scheduling (
                                          id INT NOT NULL auto_increment,
                                          date_scheduling DATETIME NULL,
                                          observation TEXT NULL,
                                          pet_id INT NOT NULL,
                                          employee_id INT NOT NULL,
                                          service_pet_id INT NOT NULL,
                                          PRIMARY KEY (id),
    FOREIGN KEY (pet_id)
    REFERENCES pet (id),
    FOREIGN KEY (employee_id)
    REFERENCES employee (id),
    FOREIGN KEY (service_pet_id)
    REFERENCES service_pet (id));


CREATE TABLE IF NOT EXISTS assignment_service_employee (
                                                           time_work TIME NULL,
                                                           employee_id INT NOT NULL,
                                                           service_pet_id INT NOT NULL,
                                                           PRIMARY KEY (employee_id, service_pet_id),
    FOREIGN KEY (employee_id) REFERENCES employee (id),
    FOREIGN KEY (service_pet_id) REFERENCES service_pet (id)
    );



CREATE TABLE IF NOT EXISTS closed_week_pet_shop (
                                                    id INT NOT NULL auto_increment,
                                                    is_closed BOOLEAN NOT NULL,
                                                    pet_shop_id INT NOT NULL,
                                                    PRIMARY KEY (id),
    FOREIGN KEY (pet_shop_id)
    REFERENCES pet_shop (id)
    );

CREATE TABLE IF NOT EXISTS closed_days_pet_shop (
                                                    id INT NOT NULL auto_increment,
                                                    date_close DATE NOT NULL,
                                                    pet_shop_id INT NOT NULL,
                                                    PRIMARY KEY (id),
    FOREIGN KEY (pet_shop_id)
    REFERENCES pet_shop (id)
    );


CREATE TABLE IF NOT EXISTS closed_week_employee (
                                                    id INT NOT NULL auto_increment,
                                                    is_closed TINYINT NOT NULL,
                                                    employee_id INT NOT NULL,
                                                    PRIMARY KEY (id),
    FOREIGN KEY (employee_id) REFERENCES employee (id)
    );


CREATE TABLE IF NOT EXISTS closed_days_employee (
                                                    id INT NOT NULL auto_increment,
                                                    date_close DATE NOT NULL,
                                                    employee_id INT NOT NULL,
                                                    PRIMARY KEY (id),
    FOREIGN KEY (employee_id) REFERENCES employee (id)
    );

