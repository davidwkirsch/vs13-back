package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.config.PropertieReader;
import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDadosPessoaisDTO;
import br.com.dbc.vemser.pessoaapi.dto.mapper.PessoaMapper;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
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
    private final EmailService emailService;

    public PessoaDTO create(PessoaCreateDTO pessoa) throws Exception {
        Pessoa createdPessoa = pessoaRepository.create(PessoaMapper.createPessoaDtoToPessoa(pessoa));
        PessoaDTO pessoaDTO = PessoaMapper.pessoaToPessoaResponseDto(createdPessoa);
        emailService.sendEmail(pessoaDTO, "Seja bem vindo!", EmailTemplates.BEM_VINDO);
        log.info("E-mail enviado!");
        return pessoaDTO;
    }

    public PessoaDTO create(PessoaDadosPessoaisDTO pessoa) throws Exception {
        Pessoa createdPessoa = pessoaRepository.create(PessoaMapper.pessoaDadosPessoaisToPessoaDto(pessoa));
        PessoaDTO pessoaDTO = PessoaMapper.pessoaToPessoaResponseDto(createdPessoa);
        emailService.sendEmail(pessoaDTO, "Seja bem vindo!", EmailTemplates.BEM_VINDO);
        log.info("E-mail enviado!");
        return pessoaDTO;
    }

    public List<PessoaDTO> list() throws RegraDeNegocioException {
        return pessoaRepository.list().stream()
                .map(PessoaMapper::pessoaToPessoaResponseDto)
                .toList();
    }

    public PessoaDTO update(PessoaCreateDTO pessoaAtualizar) throws Exception {

        Pessoa pessoaRecuperada = getPessoa(pessoaAtualizar.getIdPessoa());
        pessoaRecuperada.setCpf(pessoaAtualizar.getCpf());
        pessoaRecuperada.setNome(pessoaAtualizar.getNome());
        pessoaRecuperada.setDataNascimento(pessoaAtualizar.getDataNascimento());
        PessoaDTO updatedPessoa = PessoaMapper.pessoaToPessoaResponseDto(pessoaRecuperada);
        emailService.sendEmail(updatedPessoa, "Seus dados foram alterados!", EmailTemplates.EDITAR_CONTA);
        log.info("E-mail enviado!");
        return updatedPessoa;
    }

    public void delete(Integer id) throws Exception {
        if (!propertieReader.getAdmin()) throw new RegraDeNegocioException("Não é possível deletar pessoas sem ser o administrador");
        PessoaDTO pessoaDeletada = PessoaMapper.pessoaToPessoaResponseDto(getPessoa(id));
        pessoaRepository.delete(getPessoa(id));
        emailService.sendEmail(pessoaDeletada, "Sua conta foi deletada!", EmailTemplates.DELETAR_CONTA);
        log.info("E-mail enviado!");
    }

    public void delete(String cpf) throws Exception {
        if (!propertieReader.getAdmin()) throw new RegraDeNegocioException("Não é possível deletar pessoas sem ser o administrador");
        PessoaDTO pessoaDeletada = getPessoaByCpf(cpf);
        delete(pessoaDeletada.getIdPessoa());
        emailService.sendEmail(pessoaDeletada, "Sua conta foi deletada!", EmailTemplates.DELETAR_CONTA);
        log.info("E-mail enviado!");
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

    public PessoaDTO getPessoaByCpf(String cpf) throws Exception {
        return pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getCpf().equals(cpf))
                .map(PessoaMapper::pessoaToPessoaResponseDto)
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada!"));
    }
    public PessoaDTO getPessoaDTO(Integer id) throws Exception {
        return PessoaMapper.pessoaToPessoaResponseDto(getPessoa(id));
    }
}
