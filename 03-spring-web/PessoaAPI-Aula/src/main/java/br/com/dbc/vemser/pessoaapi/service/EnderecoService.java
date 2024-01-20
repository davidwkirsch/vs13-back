package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.CreateContatoDto;
import br.com.dbc.vemser.pessoaapi.dto.CreateEnderecoDto;
import br.com.dbc.vemser.pessoaapi.dto.ResponseEnderecoDto;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.mapper.EnderecoMapper;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final PessoaService pessoaService;

    public EnderecoService(EnderecoRepository enderecoRepository, PessoaService pessoaService){
        this.enderecoRepository = enderecoRepository;
        this.pessoaService = pessoaService;
    }

    public ResponseEnderecoDto create(Integer idPessoa, CreateEnderecoDto endereco) throws Exception{
        endereco.setIdEndereco(enderecoRepository.getNewIdEndereco());
        endereco.setIdPessoa(pessoaService.getPessoa(idPessoa).getIdPessoa());
        return EnderecoMapper.enderecoToEnderecoResponseDto(
                enderecoRepository.create(
                        EnderecoMapper.createEnderecoDtoToEndereco(endereco)));
    }

    public List<ResponseEnderecoDto> list(){
        return enderecoRepository.list().stream().map(EnderecoMapper::enderecoToEnderecoResponseDto)
                .toList();
    }


    public ResponseEnderecoDto update(CreateEnderecoDto enderecoAtualizar) throws Exception {
        Endereco enderecoRecuperado = getEnderecoById(enderecoAtualizar.getIdEndereco());

        enderecoRecuperado.setIdPessoa(pessoaService.getPessoa(enderecoAtualizar.getIdPessoa()).getIdPessoa());
        enderecoRecuperado.setTipo(enderecoAtualizar.getTipo());
        enderecoRecuperado.setLogradouro(enderecoAtualizar.getLogradouro());
        enderecoRecuperado.setNumero(enderecoAtualizar.getNumero());
        enderecoRecuperado.setComplemento(enderecoAtualizar.getComplemento());
        enderecoRecuperado.setCep(enderecoAtualizar.getCep());
        enderecoRecuperado.setCidade(enderecoAtualizar.getCidade());
        enderecoRecuperado.setEstado(enderecoAtualizar.getEstado());
        enderecoRecuperado.setPais(enderecoAtualizar.getPais());

        return EnderecoMapper.enderecoToEnderecoResponseDto(enderecoRecuperado);
    }
    public void delete(Integer id) throws Exception {
        Endereco enderecoRecuperado = getEnderecoById(id);
        enderecoRepository.delete(enderecoRecuperado);
    }
    public List<ResponseEnderecoDto> getByIdPessoa(Integer idPessoa) throws Exception {
        return enderecoRepository.list()
                .stream()
                .filter(endereco -> Objects.equals(endereco.getIdPessoa(), idPessoa))
                .map(EnderecoMapper::enderecoToEnderecoResponseDto)
                .toList();
    }
    public Endereco getEnderecoById(Integer id) throws Exception {

        return enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Endereco não encontrado!"));
    }

}
