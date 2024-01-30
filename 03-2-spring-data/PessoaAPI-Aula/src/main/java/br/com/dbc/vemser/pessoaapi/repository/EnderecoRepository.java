package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.dbc.vemser.pessoaapi.entity.TipoEndereco;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class EnderecoRepository {
    private static final List<EnderecoEntity> LISTA_ENDERECO_ENTITIES = new ArrayList<>();
    private final AtomicInteger COUNTER = new AtomicInteger();

    public EnderecoRepository() {
        LISTA_ENDERECO_ENTITIES.add(new EnderecoEntity(1, COUNTER.incrementAndGet() /*1*/, TipoEndereco.ofTipo(2),
                "R. teste 1", 1001, "casa",
               "90900-000", "Ivoti", "RS", "Brasil"));
        LISTA_ENDERECO_ENTITIES.add(new EnderecoEntity(2, COUNTER.incrementAndGet() /*1*/, TipoEndereco.ofTipo(1),
                "R. teste 2", 1002, "casa azul",
                "90900-000", "Ivoti", "RS", "Brasil"));
        LISTA_ENDERECO_ENTITIES.add(new EnderecoEntity(3, COUNTER.incrementAndGet() /*1*/, TipoEndereco.ofTipo(1),
                "R. teste 3", 1003, "apartamento",
                "90900-000", "Ivoti", "RS", "Brasil"));
        LISTA_ENDERECO_ENTITIES.add(new EnderecoEntity(4, COUNTER.incrementAndGet() /*1*/, TipoEndereco.ofTipo(2),
                "R. teste 4", 1004, "casa",
                "90900-000", "Ivoti", "RS", "Brasil"));
        LISTA_ENDERECO_ENTITIES.add(new EnderecoEntity(4, COUNTER.incrementAndGet() /*1*/, TipoEndereco.ofTipo(1),
                "R. teste 5", 1005, "ap",
                "90900-000", "Ivoti", "RS", "Brasil"));
    }
    public Integer getNewIdEndereco() {
        return COUNTER.incrementAndGet();
    }
    
    public EnderecoEntity create(EnderecoEntity enderecoEntity) throws Exception{
        if (enderecoEntity == null) {
            throw new Exception("PessoaCreateDTO não pode ser nula!");
        }
        LISTA_ENDERECO_ENTITIES.add(enderecoEntity);
        return enderecoEntity;
    }

    public List<EnderecoEntity> list() {
        return LISTA_ENDERECO_ENTITIES;
    }

    public void delete(EnderecoEntity enderecoEntity) {
        LISTA_ENDERECO_ENTITIES.remove(enderecoEntity);
    }

}
