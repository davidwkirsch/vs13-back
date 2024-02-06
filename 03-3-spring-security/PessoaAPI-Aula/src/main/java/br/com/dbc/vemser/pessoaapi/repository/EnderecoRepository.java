package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Integer> {

    List<EnderecoEntity> findAllByPessoas(PessoaEntity pessoaEntity);

    @Query(value = "SELECT * FROM ENDERECO_PESSOA WHERE ENDERECO_PESSOA.PAIS LIKE %?1%",
            nativeQuery = true)
    List<EnderecoEntity> findAllByPais(String pais);

    @Query(value = """
            SELECT * FROM ENDERECO_PESSOA
            JOIN PESSOA_X_PESSOA_ENDERECO ON PESSOA_X_PESSOA_ENDERECO.ID_ENDERECO = ENDERECO_PESSOA.ID_ENDERECO
            JOIN PESSOA ON PESSOA.ID_PESSOA = PESSOA_X_PESSOA_ENDERECO.ID_PESSOA = PESSOA.ID_PESSOA
            WHERE PESSOA.ID_PESSOA = ?1
            """,
            nativeQuery = true)
    List<EnderecoEntity> findAllByPessoasId(Integer idPessoa);

}
