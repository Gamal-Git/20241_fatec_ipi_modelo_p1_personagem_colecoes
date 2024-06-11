-- Active: 1717874623742@@localhost@5432@postgres
CREATE TABLE tb_atividade (
    cod_atividade INT NOT NULL,     
    descricao VARCHAR(200) NOT NULL,     
    data_de_ocorrencia TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE tb_usuario (
    cod_usuario SERIAL PRIMARY KEY,
    login VARCHAR(50) NOT NULL,
    senha VARCHAR(255) NOT NULL,
);

CREATE TABLE tb_ranking (
    cod_usuario int NOT NULL,
    login VARCHAR(50) NOT NULL,
    pontuacao int NOT NULL,
    data_de_ocorrencia TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (cod_usuario) REFERENCES tb_usuario (cod_usuario)
)

INSERT INTO tb_usuario (login, senha) VALUES ('admin', 'admin');


ALTER TABLE tb_atividade
ADD COLUMN cod_usuario INT;

ALTER TABLE tb_atividade
ADD CONSTRAINT fk_usuario
FOREIGN KEY (cod_usuario) REFERENCES tb_usuario(cod_usuario);