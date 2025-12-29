CREATE TABLE sinapses (
    id SERIAL PRIMARY KEY,

    title VARCHAR(255) NOT NULL,
    description TEXT,
    category VARCHAR(100),
    date DATE,
    link VARCHAR(255),
    keyword TEXT

);