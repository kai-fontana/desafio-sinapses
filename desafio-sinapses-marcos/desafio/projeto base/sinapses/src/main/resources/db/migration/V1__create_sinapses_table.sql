CREATE TABLE sinapses (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    descricao TEXT,
    categoria VARCHAR(100),
    data_criacao DATE NOT NULL,
    url_conteudo VARCHAR(2048)
);