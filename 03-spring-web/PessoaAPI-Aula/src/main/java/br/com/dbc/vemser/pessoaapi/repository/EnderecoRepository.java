package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.entity.TipoEndereco;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class EnderecoRepository {
    private static final List<Endereco> listaEnderecos = new ArrayList<>();
    private final AtomicInteger COUNTER = new AtomicInteger();

//    public EnderecoRepository() {
//        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet() /*1*/, 1, TipoEndereco.ofTipo(1), "51990908080", "whats"));
//        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet() /*1*/, 2, TipoEndereco.ofTipo(2), "5135352020", "fixo"));
//        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet() /*1*/, 2, TipoEndereco.ofTipo(1), "51910012002", "pessoal"));
//        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet() /*1*/, 4, TipoEndereco.ofTipo(2), "51888888888", "cel"));
//        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet() /*1*/, 5, TipoEndereco.ofTipo(2), "51920604090", "celular"));
//    }
    
    public Endereco create(Endereco endereco) {
        endereco.setIdEndereco(COUNTER.incrementAndGet());
        listaEnderecos.add(endereco);
        return endereco;
    }

    public List<Endereco> list() {
        return listaEnderecos;
    }

    public void delete(Endereco endereco) {
        listaEnderecos.remove(endereco);
    }

    public List<Endereco> listByIdPessoa(Integer idPessoa) {
        return listaEnderecos.stream()
                .filter(endereco -> Objects.equals(endereco.getIdPessoa(), idPessoa))
                .collect(Collectors.toList());
    }
}
