package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.ContatoEntity;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContatoRepository extends JpaRepository<ContatoEntity, Integer> {

    List<ContatoEntity> findByPessoaEntity(PessoaEntity pessoaEntity);

    @Query(value = "SELECT * FROM CONTATO WHERE CONTATO.TIPO = ?1",
            nativeQuery = true)
    List<ContatoEntity> findAllByTipoContato(String tipoContato);

}
