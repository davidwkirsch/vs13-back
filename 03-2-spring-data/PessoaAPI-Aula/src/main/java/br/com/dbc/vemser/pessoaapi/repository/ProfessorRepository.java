package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.ProfessorEntity;
import br.com.dbc.vemser.pessoaapi.entity.pk.ProfessorPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorRepository extends JpaRepository<ProfessorEntity, ProfessorPK> {

    ProfessorEntity findByProfessorPK(ProfessorPK professorPK);

    List<ProfessorEntity> findByNomeContainsIgnoreCase(String nome);

}
