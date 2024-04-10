CREATE DATABASE;
USE task_db;
SELECT * FROM m_user;
SELECT * FROM m_category;
SELECT * FROM m_status;
SELECT * FROM t_task;

CREATE TABLE m_category (
category_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT ,
category_name VARCHAR(20) UNIQUE NOT NULL ,
update_datetime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE m_status (
status_code CHAR(2)  NOT NULL PRIMARY KEY ,
status_name  VARCHAR(20) UNIQUE NOT NULL ,
update_datetime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE t_task( 
    task_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT
    , task_name VARCHAR (50) NOT NULL
    , category_id INT NOT NULL FOREIGN KEY REFERENCES m_category(category_id)
    , limit_date DATE
    , user_id VARCHAR (24) NOT NULL FOREIGN KEY REFERENCES m_user(user_id)
    , status_code CHAR (2) NOT NULL FOREIGN KEY REFERENCES m_status(status_code)
    , memo VARCHAR (100)
    , create_datetime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
    , update_datetime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP 
        ON UPDATE CURRENT_TIMESTAMP
); 

CREATE TABLE t_task( 
    task_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT
    , task_name VARCHAR (50) NOT NULL
    , category_id INT NOT NULL
    , FOREIGN KEY (category_id) REFERENCES m_category(category_id)
    , limit_date DATE
    , user_id VARCHAR (24) NOT NULL
    , FOREIGN KEY (user_id) REFERENCES m_user(user_id)
    , status_code CHAR (2) NOT NULL
    , FOREIGN KEY (status_code) REFERENCES m_status(status_code)
    , memo VARCHAR (100)
    , create_datetime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
    , update_datetime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP 
        ON UPDATE CURRENT_TIMESTAMP
);