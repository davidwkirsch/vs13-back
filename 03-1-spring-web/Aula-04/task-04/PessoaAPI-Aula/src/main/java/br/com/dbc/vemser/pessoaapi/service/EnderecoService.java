package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final PessoaService pessoaService;

    public EnderecoService(EnderecoRepository enderecoRepository, PessoaService pessoaService){
        this.enderecoRepository = enderecoRepository;
        this.pessoaService = pessoaService;
    }

    public Endereco create(Integer idPessoa, Endereco endereco) throws Exception{
        endereco.setIdEndereco(enderecoRepository.getNewIdEndereco());
        endereco.setIdPessoa(pessoaService.getPessoa(idPessoa).getIdPessoa());
        return enderecoRepository.create(endereco);
    }

    public List<Endereco> list(){
        return enderecoRepository.list();
    }


    public Endereco update(Endereco enderecoAtualizar) throws Exception {
        Endereco enderecoRecuperado = getEnderecoById(enderecoAtualizar.getIdEndereco());

        enderecoRecuperado.setIdPessoa(pessoaService.getPessoa(enderecoAtualizar.getIdPessoa()).getIdPessoa());
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
        List<Endereco> listaEnderecos = enderecoRepository.list()
                .stream()
                .filter(endereco -> Objects.equals(endereco.getIdPessoa(), idPessoa))
                .collect(Collectors.toList());
        if (listaEnderecos.isEmpty()) {
            throw new RegraDeNegocioException("Nenhum endereço cadastrado para esse ID de Pessoa!");
        }
        return listaEnderecos;
    }
    public Endereco getEnderecoById(Integer id) throws Exception {

        return enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Endereco não encontrado!"));
    }

}
