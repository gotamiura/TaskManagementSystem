CREATE DATABASE;
USE task_db;

CREATE TABLE m_user (
 user_id   VARCHAR(24) NOT NULL PRIMARY KEY ,
password  VARCHAR(64) NOT NULL ,
user_name VARCHAR(20) UNIQUE  NOT NULL ,
update_datetime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

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

CREATE TABLE t_comment( 
    comment_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT
    , task_id INT NOT NULL
    , user_id VARCHAR (24) NOT NULL
    , comment VARCHAR (100) NOT NULL
    , update_datetime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP 
        ON UPDATE CURRENT_TIMESTAMP
        , FOREIGN KEY (task_id) REFERENCES t_task(task_id)
        , FOREIGN KEY (user_id) REFERENCES m_user(user_id)
); 

insert into task_db.m_user(user_id,password,user_name,update_datetime) values 
    ('miura','miu','三浦',TIMESTAMP '2024-04-10 16:59:05.000')
  , ('shanmathi','shan','シャンマティ',TIMESTAMP '2024-04-10 16:57:56.000');
  
insert into task_db.m_category(category_name,update_datetime) values 
    ('新商品：開発プロジェクト',TIMESTAMP '2024-04-11 11:16:24.000')
  , ('既存商品：改良プロジェクト',TIMESTAMP '2024-04-11 11:16:50.000');

insert into task_db.m_status(status_code,status_name,update_datetime) values 
    ('00','未着手',TIMESTAMP '2024-04-11 11:13:56.000')
  , ('50','着手',TIMESTAMP '2024-04-11 11:14:17.000')
  , ('99','完了',TIMESTAMP '2024-04-11 11:14:35.000');
  
insert into task_db.t_task(task_name,category_id,limit_date,user_id,status_code,memo,create_datetime,update_datetime) values 
    ('市場調査の実施',1,DATE '2024-05-10','miura','00','市場確認する',TIMESTAMP '2024-04-11 11:24:56.000',TIMESTAMP '2024-04-11 11:56:11.000')
  , ('ブランディング戦略の検討',1,DATE '2024-05-15','miura','00','既存商品を参考にする',TIMESTAMP '2024-04-11 12:01:07.000',TIMESTAMP '2024-04-11 12:01:13.000')
  , ('マーケティングプランの策定',2,DATE '2024-05-29','shanmathi','50','方針を決める',TIMESTAMP '2024-04-11 13:07:01.000',TIMESTAMP '2024-04-11 13:07:05.000')
  , ('製品ローンチの準備',1,DATE '2024-06-11','shanmathi','00','最終チェックをする',TIMESTAMP '2024-04-11 13:09:21.000',TIMESTAMP '2024-04-11 13:09:26.000');
