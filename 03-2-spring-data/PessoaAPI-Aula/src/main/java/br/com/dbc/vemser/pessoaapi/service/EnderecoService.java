package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.config.PropertieReader;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.dto.mapper.EnderecoMapper;
import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.dbc.vemser.pessoaapi.entity.EnderecoPessoaEntity;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoPessoaRepository;
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
    private final EnderecoPessoaService enderecoPessoaService;
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

    public List<EnderecoEntity> findByIdPessoa(Integer idPessoa) throws RegraDeNegocioException {
        pessoaService.getById(idPessoa);
        List<EnderecoPessoaEntity> listEndereco = enderecoPessoaService.findByIdPessoa(idPessoa);
        return listEndereco.stream().map(enderecoPessoaEntity -> {
            try {
                return findById(enderecoPessoaEntity.getIdEndereco());
            } catch (RegraDeNegocioException e) {
                e.printStackTrace();
            }
            return null;
        }).toList();
    }

    public EnderecoDTO getById(Integer idEndereco) throws RegraDeNegocioException {
        return EnderecoMapper.enderecoToEnderecoResponseDto(findById(idEndereco));
    }

    public List<EnderecoDTO> getByIdPessoa(Integer idPessoa) throws RegraDeNegocioException {
        return findByIdPessoa(idPessoa).stream()
                .map(EnderecoMapper::enderecoToEnderecoResponseDto)
                .toList();
    }


    public EnderecoDTO create(Integer idPessoa, EnderecoCreateDTO endereco) throws Exception{
        EnderecoDTO createdEndereco = EnderecoMapper.enderecoToEnderecoResponseDto(enderecoRepository.save(
                EnderecoMapper.createEnderecoDtoToEndereco(endereco)));
        //emailService.sendEmail(pessoaService.getPessoaDTO(idPessoa), "Endereço criado!", EmailTemplates.ENDERECO_CRIADO);
        log.info("E-mail enviado!");
        return createdEndereco;
    }

    public EnderecoDTO update(EnderecoCreateDTO enderecoAtualizar) throws Exception {
        EnderecoEntity enderecoEntityRecuperado = findById(enderecoAtualizar.getIdEndereco());

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

}
