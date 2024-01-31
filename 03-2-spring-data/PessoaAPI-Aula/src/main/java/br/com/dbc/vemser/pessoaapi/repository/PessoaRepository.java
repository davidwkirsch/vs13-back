package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {

    List<PessoaEntity> findByCpf(String cpf);

    List<PessoaEntity> findAllByNomeContainsIgnoreCase(String nome);


    List<PessoaEntity> findAllByDataNascimentoBetween(LocalDate dataInicial, LocalDate dataFinal);
}
