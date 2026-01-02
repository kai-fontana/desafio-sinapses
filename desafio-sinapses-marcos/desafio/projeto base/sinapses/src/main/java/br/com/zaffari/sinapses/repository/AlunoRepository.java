package br.com.zaffari.sinapses.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zaffari.sinapses.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    Optional<Aluno> findByMatricula(String matricula);
}
