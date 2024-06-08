-- Active: 1717874623742@@localhost@5432@postgres
CREATE TABLE tb_atividade (
cod_atividade SERIAL PRIMARY KEY,     
descricao VARCHAR(200),     
data_de_ocorrencia TIMESTAMP DEFAULT CURRENT_TIMESTAMP 
);

SELECT * FROM tb_atividade;