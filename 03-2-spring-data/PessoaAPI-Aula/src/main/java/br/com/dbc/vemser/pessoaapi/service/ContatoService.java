package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.dto.mapper.ContatoMapper;
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

    public ContatoDTO create(@Valid ContatoCreateDTO contato) throws Exception {
        contato.setIdContato(contatoRepository.getNewIdContato());
        contato.setIdPessoa(pessoaService.getById(contato.getIdPessoa()).getIdPessoa());
        return ContatoMapper.contatoToContatoResponseDto(
                contatoRepository.create(
                        ContatoMapper.createContatoDtoToContato(contato)));
    }

    public List<ContatoDTO> list(){
        return contatoRepository.list().stream().map(ContatoMapper::contatoToContatoResponseDto)
                .toList();
    }
    public ContatoDTO update(Integer id, ContatoCreateDTO contatoAtualizar) throws Exception {
        ContatoEntity contatoEntityRecuperado = getContato(id);

        contatoEntityRecuperado.setIdPessoa(getContato(contatoAtualizar.getIdPessoa()).getIdContato());
        contatoEntityRecuperado.setNumero(contatoAtualizar.getNumero());
        contatoEntityRecuperado.setDescricao(contatoAtualizar.getDescricao());
        contatoEntityRecuperado.setTipoContato(contatoAtualizar.getTipoContato());

        return ContatoMapper.contatoToContatoResponseDto(contatoEntityRecuperado);
    }
    public void delete(Integer id) throws Exception {
        ContatoEntity contatoEntityRecuperado = getContato(id);
        contatoRepository.delete(contatoEntityRecuperado);
    }
    public List<ContatoDTO> listByIdPessoa(Integer idPessoa) throws Exception {
        return contatoRepository.listByIdPessoa(idPessoa).stream().map(ContatoMapper::contatoToContatoResponseDto)
                .toList();
    }
    private ContatoEntity getContato(Integer id) throws Exception {

        return contatoRepository.list().stream()
                .filter(contatoEntity -> contatoEntity.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("ContatoEntity não encontrado!"));
    }

}
