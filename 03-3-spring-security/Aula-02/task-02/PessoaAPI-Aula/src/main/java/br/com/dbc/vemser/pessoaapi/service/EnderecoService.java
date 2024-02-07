package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.config.PropertieReader;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoUpdateDTO;
import br.com.dbc.vemser.pessoaapi.dto.mapper.EnderecoMapper;
import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final PessoaService pessoaService;
    private final PropertieReader propertieReader;
    private final EmailService emailService;

    public List<EnderecoDTO> list(){
        return enderecoRepository.findAll().stream().map(EnderecoMapper::enderecoToEnderecoResponseDto)
                .toList();
    }

    public EnderecoEntity findById(Integer idEndereco) throws RegraDeNegocioException {
        return enderecoRepository.findById(idEndereco)
                .orElseThrow(() -> new RegraDeNegocioException("EnderecoEntity não encontrado!"));
    }

    public EnderecoDTO getById(Integer idEndereco) throws RegraDeNegocioException {
        return EnderecoMapper.enderecoToEnderecoResponseDto(findById(idEndereco));
    }

    public EnderecoDTO create(Integer idPessoa, EnderecoCreateDTO endereco) throws Exception{
        PessoaEntity pessoaEntity = pessoaService.findById(idPessoa);
        endereco.setPessoaEntity(pessoaEntity);
        EnderecoEntity createdEndereco = EnderecoMapper.createEnderecoDtoToEndereco(endereco);
        pessoaEntity.getEnderecos().add(createdEndereco);
        EnderecoDTO enderecoDTO = EnderecoMapper.enderecoToEnderecoResponseDto(enderecoRepository.save(createdEndereco));
        //emailService.sendEmail(pessoaService.getPessoaDTO(idPessoa), "Endereço criado!", EmailTemplates.ENDERECO_CRIADO);
        log.info("E-mail enviado!");
        return enderecoDTO;
    }

    public EnderecoDTO update(EnderecoUpdateDTO enderecoAtualizar) throws Exception {
        EnderecoEntity enderecoEntityRecuperado = findById(enderecoAtualizar.getIdEndereco());

        // falta fazer algo com o id de pessoa
        enderecoEntityRecuperado.setTipo(enderecoAtualizar.getTipo());
        enderecoEntityRecuperado.setLogradouro(enderecoAtualizar.getLogradouro());
        enderecoEntityRecuperado.setNumero(enderecoAtualizar.getNumero());
        enderecoEntityRecuperado.setComplemento(enderecoAtualizar.getComplemento());
        enderecoEntityRecuperado.setCep(enderecoAtualizar.getCep());
        enderecoEntityRecuperado.setCidade(enderecoAtualizar.getCidade());
        enderecoEntityRecuperado.setEstado(enderecoAtualizar.getEstado());
        enderecoEntityRecuperado.setPais(enderecoAtualizar.getPais());

        enderecoRepository.save(enderecoEntityRecuperado);
        //emailService.sendEmail(pessoaService.getPessoaDTO(enderecoEntityRecuperado.getIdPessoa()), "Endereço alterado!", EmailTemplates.ENDERECO_EDITADO);
        log.info("E-mail enviado!");
        return EnderecoMapper.enderecoToEnderecoResponseDto(enderecoEntityRecuperado);
    }

    public void delete(Integer id) throws Exception {
        if (!propertieReader.getAdmin()) throw new RegraDeNegocioException("Não é possível deletar pessoas sem ser o administrador");
        EnderecoEntity enderecoRecuperado = findById(id);
        enderecoRepository.delete(enderecoRecuperado);
        EnderecoDTO enderecoDTO = EnderecoMapper.enderecoToEnderecoResponseDto(enderecoRecuperado);
        //emailService.sendEmail(pessoaService.getPessoaDTO(enderecoRecuperado.getIdPessoa()), "Endereço deletado!", EmailTemplates.ENDERECO_DELETADO);
        log.info("E-mail enviado!");
    }

    public EnderecoDTO adicionarPessoa(Integer idEndereco, Integer idPessoa) throws RegraDeNegocioException {
        EnderecoEntity enderecoEntity = enderecoRepository.findById(idEndereco).orElseThrow();
        PessoaEntity pessoaEntity = pessoaService.findById(idPessoa);
        enderecoEntity.getPessoas().add(pessoaEntity);
        pessoaEntity.getEnderecos().add(enderecoEntity);
        enderecoRepository.save(enderecoEntity);
        return EnderecoMapper.enderecoToEnderecoResponseDto(enderecoEntity);
    }
}
