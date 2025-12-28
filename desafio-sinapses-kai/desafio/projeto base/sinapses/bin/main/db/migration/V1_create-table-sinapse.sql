CREATE TABLE sinapses (
    id BIGINT PRIMARY KEY UNIQUE AUTO_INCREMENT,

    title VARCHAR(255) NOT NULL,
    description TEXT,
    category VARCHAR(100),
    date DATE,
    link VARCHAR(255),
    keyword TEXT,

    PRIMARY KEY (id)
);