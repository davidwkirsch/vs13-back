package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository){
        this.enderecoRepository = enderecoRepository;
    }

    public Endereco create(Integer idPessoa, Endereco endereco){
        return enderecoRepository.create(idPessoa, endereco);
    }

    public List<Endereco> list(){
        return enderecoRepository.list();
    }

    public Endereco update(Integer id,
                         Endereco enderecoAtualizar) throws Exception {
        Endereco enderecoRecuperado = getEnderecoById(id);

        enderecoRecuperado.setIdPessoa(enderecoAtualizar.getIdPessoa());
        enderecoRecuperado.setTipoEndereco(enderecoAtualizar.getTipoEndereco());
        enderecoRecuperado.setLogradouro(enderecoAtualizar.getLogradouro());
        enderecoRecuperado.setNumero(enderecoAtualizar.getNumero());
        enderecoRecuperado.setComplemento(enderecoAtualizar.getComplemento());
        enderecoRecuperado.setCep(enderecoAtualizar.getCep());
        enderecoRecuperado.setCidade(enderecoAtualizar.getCidade());
        enderecoRecuperado.setEstado(enderecoAtualizar.getEstado());
        enderecoRecuperado.setPais(enderecoAtualizar.getPais());

        return enderecoRecuperado;
    }

    public void delete(Integer id) throws Exception {
        Endereco enderecoRecuperado = getEnderecoById(id);
        enderecoRepository.delete(enderecoRecuperado);
    }

    public List<Endereco> getByIdPessoa(Integer idPessoa) throws Exception {
        return enderecoRepository.list()
                .stream()
                .filter(endereco -> Objects.equals(endereco.getIdPessoa(), idPessoa))
                .collect(Collectors.toList());
    }

    public Endereco getEnderecoById(Integer id) throws Exception {

        Endereco enderecoRecuperado = enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Endereco não encontrado!"));
        return enderecoRecuperado;
    }

}
