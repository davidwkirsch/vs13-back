package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.config.PropertieReader;
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
    private final PropertieReader propertieReader;
    private final EmailService emailService;

    public EnderecoDTO create(Integer idPessoa, EnderecoCreateDTO endereco) throws Exception{
        endereco.setIdEndereco(enderecoRepository.getNewIdEndereco());
        endereco.setIdPessoa(pessoaService.getPessoa(idPessoa).getIdPessoa());
        EnderecoDTO createdEndereco = EnderecoMapper.enderecoToEnderecoResponseDto(enderecoRepository.create(
                EnderecoMapper.createEnderecoDtoToEndereco(endereco)));
        emailService.sendEmail(pessoaService.getPessoaDTO(idPessoa), "Endereço criado!", EmailTemplates.ENDERECO_CRIADO);
        log.info("E-mail enviado!");
        return createdEndereco;
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

        emailService.sendEmail(pessoaService.getPessoaDTO(enderecoRecuperado.getIdPessoa()), "Endereço alterado!", EmailTemplates.ENDERECO_EDITADO);
        log.info("E-mail enviado!");
        return EnderecoMapper.enderecoToEnderecoResponseDto(enderecoRecuperado);
    }

    public void delete(Integer id) throws Exception {
        if (!propertieReader.getAdmin()) throw new RegraDeNegocioException("Não é possível deletar pessoas sem ser o administrador");
        EnderecoDTO enderecoRecuperado = EnderecoMapper.enderecoToEnderecoResponseDto(getEnderecoById(id));
        enderecoRepository.delete(getEnderecoById(id));
        emailService.sendEmail(pessoaService.getPessoaDTO(enderecoRecuperado.getIdPessoa()), "Endereço deletado!", EmailTemplates.ENDERECO_DELETADO);
        log.info("E-mail enviado!");
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
