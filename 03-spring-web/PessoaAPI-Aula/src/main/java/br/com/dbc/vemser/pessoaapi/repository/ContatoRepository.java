package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.TipoContato;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class ContatoRepository {
    private static final List<Contato> listaContatos = new ArrayList<>();
    private final AtomicInteger COUNTER = new AtomicInteger();

    public ContatoRepository() {
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*1*/, 1, TipoContato.ofTipo(1), "51990908080", "whats"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*1*/, 2, TipoContato.ofTipo(2), "5135352020", "fixo"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*1*/, 2, TipoContato.ofTipo(1), "51910012002", "pessoal"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*1*/, 4, TipoContato.ofTipo(2), "51888888888", "cel"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*1*/, 5, TipoContato.ofTipo(2), "51920604090", "celular"));


    }

    public Integer getNewIdContato() {
        return COUNTER.incrementAndGet();
    }
    public Contato create(Contato contato) {
        contato.setIdContato(COUNTER.incrementAndGet());
        listaContatos.add(contato);
        return contato;
    }

    public List<Contato> list() {
        return listaContatos;
    }

    public void delete(Contato contato) {
        listaContatos.remove(contato);
    }

    public List<Contato> listByIdPessoa(Integer idPessoa) {
        return listaContatos.stream()
                .filter(contato -> Objects.equals(contato.getIdPessoa(), idPessoa))
                .collect(Collectors.toList());
    }
}
