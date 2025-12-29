ALTER TABLE sinapses 
ADD COLUMN aluno_matricula VARCHAR(20),
ADD CONSTRAINT fk_sinapses_aluno 
    FOREIGN KEY (aluno_matricula) 
    REFERENCES alunos(matricula);