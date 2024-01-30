package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.ContatoEntity;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class ContatoRepository {
    private static final List<ContatoEntity> LISTA_CONTATO_ENTITIES = new ArrayList<>();
    private final AtomicInteger COUNTER = new AtomicInteger();

    public Integer getNewIdContato() {
        return COUNTER.incrementAndGet();
    }
    public ContatoEntity create(ContatoEntity contatoEntity) {
        contatoEntity.setIdContato(COUNTER.incrementAndGet());
        LISTA_CONTATO_ENTITIES.add(contatoEntity);
        return contatoEntity;
    }

    public List<ContatoEntity> list() {
        return LISTA_CONTATO_ENTITIES;
    }

    public void delete(ContatoEntity contatoEntity) {
        LISTA_CONTATO_ENTITIES.remove(contatoEntity);
    }

    public List<ContatoEntity> listByIdPessoa(Integer idPessoa) throws RegraDeNegocioException {
        List<ContatoEntity> listaContatoEntities = LISTA_CONTATO_ENTITIES.stream()
                .filter(contatoEntity -> Objects.equals(contatoEntity.getIdPessoa(), idPessoa))
                .collect(Collectors.toList());
        if (listaContatoEntities.isEmpty()) {
            throw new RegraDeNegocioException("Nenhum resultado encontrado!");
        }
        return listaContatoEntities;
    }
}
