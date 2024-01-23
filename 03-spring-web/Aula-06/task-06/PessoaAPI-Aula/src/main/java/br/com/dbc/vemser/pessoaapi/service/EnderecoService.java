package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.dto.mapper.EnderecoMapper;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final PessoaService pessoaService;

    public EnderecoDTO create(Integer idPessoa, EnderecoCreateDTO endereco) throws Exception{
        endereco.setIdEndereco(enderecoRepository.getNewIdEndereco());
        endereco.setIdPessoa(pessoaService.getPessoa(idPessoa).getIdPessoa());
        return EnderecoMapper.enderecoToEnderecoResponseDto(
                enderecoRepository.create(
                        EnderecoMapper.createEnderecoDtoToEndereco(endereco)));
    }

    public List<EnderecoDTO> list(){
        return enderecoRepository.list().stream().map(EnderecoMapper::enderecoToEnderecoResponseDto)
                .toList();
    }


    public EnderecoDTO update(EnderecoCreateDTO enderecoAtualizar) throws Exception {
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
    public EnderecoDTO delete(Integer id) throws Exception {
        EnderecoDTO enderecoRecuperado = EnderecoMapper.enderecoToEnderecoResponseDto(getEnderecoById(id));
        enderecoRepository.delete(getEnderecoById(id));
        return enderecoRecuperado;
    }
    public List<EnderecoDTO> getByIdPessoa(Integer idPessoa) throws Exception {
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
