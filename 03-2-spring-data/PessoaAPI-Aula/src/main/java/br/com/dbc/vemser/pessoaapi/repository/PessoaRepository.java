package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {

    List<PessoaEntity> findByCpf(String cpf);

    List<PessoaEntity> findAllByNomeContainsIgnoreCase(String nome);

//    @Query(value = "SELECT * FROM PESSOA WHERE PESSOA.DATA_NASCIMENTO BETWEEN :dataInicio AND :dataFinal",
//            nativeQuery = true)
//    List<PessoaEntity> findAllByDataNascimentoBetween(@Param("dataInicio") LocalDate dataInicio, @Param("dataFinal") LocalDate dataFinal);

    List<PessoaEntity> findAllByDataNascimentoGreaterThanAndDataNascimentoLessThan(LocalDate dataInicio, LocalDate dataFinal);
}
