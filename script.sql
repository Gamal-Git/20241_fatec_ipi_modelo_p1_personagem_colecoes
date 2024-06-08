CREATE TABLE tb_atividade (
    cod_atividade INT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(200),
    data_de_ocorrencia TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

SELECT * FROM tb_atividade;