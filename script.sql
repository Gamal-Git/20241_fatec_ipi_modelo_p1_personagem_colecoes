-- Active: 1717874623742@@localhost@5432@postgres
CREATE TABLE tb_atividade (
cod_atividade INT,     
descricao VARCHAR(200),     
data_de_ocorrencia TIMESTAMP DEFAULT CURRENT_TIMESTAMP 
);

CREATE TABLE tb_usuario (
    cod_usuario SERIAL PRIMARY KEY,
    login VARCHAR(50) NOT NULL,
    senha VARCHAR(255) NOT NULL
);
-- Inserção de um usuário padrão
INSERT INTO tb_usuario (login, senha) VALUES ('admin', 'admin');