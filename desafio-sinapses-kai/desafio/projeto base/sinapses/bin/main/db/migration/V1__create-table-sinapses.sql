CREATE TABLE sinapses (
    id SERIAL PRIMARY KEY,

    titulo VARCHAR(255) NOT NULL,
    descricao TEXT,
    categoria VARCHAR(100),
    data DATE,
    link VARCHAR(255),
    keyword TEXT

);