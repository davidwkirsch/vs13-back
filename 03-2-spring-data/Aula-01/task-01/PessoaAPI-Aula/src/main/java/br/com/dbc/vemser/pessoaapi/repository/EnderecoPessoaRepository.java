package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.ContatoEntity;
import br.com.dbc.vemser.pessoaapi.entity.EnderecoPessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnderecoPessoaRepository extends JpaRepository<EnderecoPessoaEntity, Integer> {

    List<EnderecoPessoaEntity> findByIdPessoa(Integer idPessoa);
    List<EnderecoPessoaEntity> findByIdEndereco(Integer idEndereco);
}
