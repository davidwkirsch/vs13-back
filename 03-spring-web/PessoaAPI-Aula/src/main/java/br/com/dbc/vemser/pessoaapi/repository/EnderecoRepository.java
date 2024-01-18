package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.entity.TipoEndereco;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class EnderecoRepository {
    private static final List<Endereco> listaEnderecos = new ArrayList<>();
    private final AtomicInteger COUNTER = new AtomicInteger();

    public EnderecoRepository() {
        listaEnderecos.add(new Endereco(1, COUNTER.incrementAndGet() /*1*/, TipoEndereco.ofTipo(2),
                "R. teste 1", 1001, "casa",
               "90900-000", "Ivoti", "RS", "Brasil"));
        listaEnderecos.add(new Endereco(2, COUNTER.incrementAndGet() /*1*/, TipoEndereco.ofTipo(1),
                "R. teste 2", 1002, "casa azul",
                "90900-000", "Ivoti", "RS", "Brasil"));
        listaEnderecos.add(new Endereco(3, COUNTER.incrementAndGet() /*1*/, TipoEndereco.ofTipo(1),
                "R. teste 3", 1003, "apartamento",
                "90900-000", "Ivoti", "RS", "Brasil"));
        listaEnderecos.add(new Endereco(4, COUNTER.incrementAndGet() /*1*/, TipoEndereco.ofTipo(2),
                "R. teste 4", 1004, "casa",
                "90900-000", "Ivoti", "RS", "Brasil"));
        listaEnderecos.add(new Endereco(4, COUNTER.incrementAndGet() /*1*/, TipoEndereco.ofTipo(1),
                "R. teste 5", 1005, "ap",
                "90900-000", "Ivoti", "RS", "Brasil"));
    }
    
    public Endereco create(Integer idPessoa, Endereco endereco) {
        endereco.setIdEndereco(COUNTER.incrementAndGet());
        endereco.setIdPessoa(idPessoa);
        listaEnderecos.add(endereco);
        return endereco;
    }

    public List<Endereco> list() {
        return listaEnderecos;
    }

    public void delete(Endereco endereco) {
        listaEnderecos.remove(endereco);
    }

}
