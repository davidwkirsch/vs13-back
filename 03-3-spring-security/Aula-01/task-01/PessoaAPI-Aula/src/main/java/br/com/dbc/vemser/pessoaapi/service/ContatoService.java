package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaContatoDTO;
import br.com.dbc.vemser.pessoaapi.dto.mapper.ContatoMapper;
import br.com.dbc.vemser.pessoaapi.dto.mapper.PessoaMapper;
import br.com.dbc.vemser.pessoaapi.entity.ContatoEntity;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ContatoService {

    private final ContatoRepository contatoRepository;

    private final PessoaService pessoaService;

    //Listar todos
    public List<ContatoDTO> list() throws RegraDeNegocioException {
        return contatoRepository.findAll().stream()
                .map(ContatoMapper::contatoToContatoResponseDto)
                .toList();
    }

    //Criar
    public ContatoDTO create(@Valid ContatoCreateDTO contato) throws Exception {
        contato.setPessoaEntity(pessoaService.findById(contato.getIdPessoa()));
        ContatoEntity contatoCreate = ContatoMapper.createContatoDtoToContato(contato);
        return ContatoMapper.contatoToContatoResponseDto(contatoRepository.save(contatoCreate));
    }

    //Encontrar por ID do contato
    public ContatoEntity findById(Integer id) throws RegraDeNegocioException {
        return contatoRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado!"));
    }

    //Encontrar por ID da pessoa
    public List<ContatoEntity> findByIdPessoa(Integer idPessoa) throws RegraDeNegocioException {
        return contatoRepository.findByPessoaEntity(pessoaService.findById(idPessoa));
    }

    public ContatoDTO getById(Integer id) throws RegraDeNegocioException {
        return ContatoMapper.contatoToContatoResponseDto(findById(id));
    }

    public ContatoDTO listByIdContato(Integer idContato) throws Exception {
        ContatoEntity contato = findById(idContato);
        return ContatoMapper.contatoToContatoResponseDto(contato);
    }

    public List<PessoaContatoDTO> listByIdPessoa(Integer idPessoa) throws Exception {
        return findByIdPessoa(idPessoa).stream()
                .map(PessoaMapper::toPessoaContatoDto)
                .toList();
    }

    public ContatoDTO update(Integer id, ContatoCreateDTO contatoAtualizar) throws Exception {
        ContatoEntity contatoEntityRecuperado = findById(id);

        contatoEntityRecuperado.setPessoaEntity(pessoaService.findById(contatoAtualizar.getIdPessoa()));
        contatoEntityRecuperado.setNumero(contatoAtualizar.getNumero());
        contatoEntityRecuperado.setDescricao(contatoAtualizar.getDescricao());
        contatoEntityRecuperado.setTipoContato(contatoAtualizar.getTipoContato());
        contatoRepository.save(contatoEntityRecuperado);
        return ContatoMapper.contatoToContatoResponseDto(contatoEntityRecuperado);
    }

    public void delete(Integer id) throws Exception {
        ContatoEntity contatoEntityRecuperado = findById(id);
        contatoRepository.delete(contatoEntityRecuperado);
    }



}
