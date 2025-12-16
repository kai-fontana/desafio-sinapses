CREATE TABLE sinapses (
    id INT NOT NULL AUTO_INCREMENT,
    matricula_aluno INT NOT NULL,

    titulo VARCHAR(255) NOT NULL,
    descricao TEXT,
    categoria VARCHAR(100),
    data_de_aprendizado DATE,
    fonte_do_aprendizado VARCHAR(255),

    PRIMARY KEY (id, matricula_aluno)
);