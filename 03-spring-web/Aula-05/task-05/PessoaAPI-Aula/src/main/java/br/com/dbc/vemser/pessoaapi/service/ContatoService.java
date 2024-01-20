package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.CreateContatoDto;
import br.com.dbc.vemser.pessoaapi.dto.ResponseContatoDto;
import br.com.dbc.vemser.pessoaapi.dto.ResponsePessoaDto;
import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.mapper.ContatoMapper;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
@Slf4j
public class ContatoService {

    private final ContatoRepository contatoRepository;

    private final PessoaService pessoaService;

    public ContatoService(ContatoRepository contatoRepository, PessoaService pessoaService){
        this.contatoRepository = contatoRepository;
        this.pessoaService = pessoaService;
    }

    public ResponseContatoDto create(@Valid CreateContatoDto contato) throws Exception {
        contato.setIdContato(contatoRepository.getNewIdContato());
        contato.setIdPessoa(pessoaService.getPessoa(contato.getIdPessoa()).getIdPessoa());
        return ContatoMapper.contatoToContatoResponseDto(
                contatoRepository.create(
                        ContatoMapper.createContatoDtoToContato(contato)));
    }

    public List<ResponseContatoDto> list(){
        return contatoRepository.list().stream().map(ContatoMapper::contatoToContatoResponseDto)
                .toList();
    }
    public ResponseContatoDto update(Integer id, CreateContatoDto contatoAtualizar) throws Exception {
        Contato contatoRecuperado = getContato(id);

        contatoRecuperado.setIdPessoa(getContato(contatoAtualizar.getIdPessoa()).getIdContato());
        contatoRecuperado.setNumero(contatoAtualizar.getNumero());
        contatoRecuperado.setDescricao(contatoAtualizar.getDescricao());
        contatoRecuperado.setTipoContato(contatoAtualizar.getTipoContato());

        return ContatoMapper.contatoToContatoResponseDto(contatoRecuperado);
    }
    public void delete(Integer id) throws Exception {
        Contato contatoRecuperado = getContato(id);
        contatoRepository.delete(contatoRecuperado);
    }
    public List<ResponseContatoDto> listByIdPessoa(Integer idPessoa) throws Exception {
        return contatoRepository.listByIdPessoa(idPessoa).stream().map(ContatoMapper::contatoToContatoResponseDto)
                .toList();
    }
    private Contato getContato(Integer id) throws Exception {

        return contatoRepository.list().stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado!"));
    }

}
