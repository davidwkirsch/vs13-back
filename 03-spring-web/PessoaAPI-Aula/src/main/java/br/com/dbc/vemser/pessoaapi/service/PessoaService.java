package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.dto.mapper.PessoaMapper;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import br.com.dbc.vemser.pessoaapi.utils.PropertieReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    private final PropertieReader propertieReader;

    public PessoaDTO create(PessoaCreateDTO pessoa) throws Exception {
        return PessoaMapper.pessoaToPessoaResponseDto(
                pessoaRepository.create(
                        PessoaMapper.createPessoaDtoToPessoa(pessoa)));
    }

    public List<PessoaDTO> list() throws RegraDeNegocioException {
        return pessoaRepository.list().stream()
                .map(PessoaMapper::pessoaToPessoaResponseDto)
                .toList();
    }

    public PessoaDTO update(
                            PessoaCreateDTO pessoaAtualizar) throws Exception {

        Pessoa pessoaRecuperada = getPessoa(pessoaAtualizar.getIdPessoa());

        pessoaRecuperada.setCpf(pessoaAtualizar.getCpf());
        pessoaRecuperada.setNome(pessoaAtualizar.getNome());
        pessoaRecuperada.setDataNascimento(pessoaAtualizar.getDataNascimento());


        return PessoaMapper.pessoaToPessoaResponseDto(pessoaRecuperada);
    }

    public void delete(Integer id) throws Exception {
        if (!propertieReader.getAdmin()) throw new RegraDeNegocioException("Não é possível deletar pessoas sem ser o administrador");
        pessoaRepository.delete(getPessoa(id));
    }

    public List<PessoaDTO> listByName(String nome) throws Exception{
        return pessoaRepository.listByName(nome).stream().map(PessoaMapper::pessoaToPessoaResponseDto)
                .toList();
    }

    public Pessoa getPessoa(Integer id) throws Exception {
        return pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada!"));
    }
}
