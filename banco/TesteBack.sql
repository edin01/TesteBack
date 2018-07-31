DROP DATABASE IF EXISTS TesteBack;

CREATE DATABASE TesteBack;

USE TesteBack;

CREATE TABLE tb_customer_account(
id_customer INT NOT NULL AUTO_INCREMENT,
cpf_cnpj LONG NOT NULL,
nm_customer VARCHAR(100) NOT NULL,
is_active VARCHAR (3) NOT NULL,
vl_total FLOAT NOT NULL,
KEY (id_customer));

select * from tb_customer_account;

SELECT * FROM tb_customer_account WHERE vl_total > 560 AND id_customer BETWEEN 1 AND 5 ORDER BY vl_total DESC;

TRUNCATE TABLE tb_customer_account;