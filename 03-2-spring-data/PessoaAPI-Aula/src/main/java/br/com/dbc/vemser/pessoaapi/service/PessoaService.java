package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.config.PropertieReader;
import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDadosPessoaisDTO;
import br.com.dbc.vemser.pessoaapi.dto.mapper.PessoaMapper;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.exception.EntidadeNaoEncontradaException;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    private final PropertieReader propertieReader;
    private final EmailService emailService;

    public PessoaDTO create(PessoaCreateDTO pessoa) throws Exception {
        PessoaEntity createdPessoaEntity = PessoaMapper.createPessoaDtoToPessoa(pessoa);
        PessoaDTO pessoaDTO = PessoaMapper.pessoaToPessoaResponseDto(pessoaRepository.save(createdPessoaEntity));
        emailService.sendEmail(pessoaDTO, "Seja bem vindo!", EmailTemplates.BEM_VINDO);
        log.info("E-mail enviado!");
        return pessoaDTO;
    }

    //Listar todos
    public List<PessoaDTO> list() throws RegraDeNegocioException {
        return pessoaRepository.findAll().stream()
                .map(PessoaMapper::pessoaToPessoaResponseDto)
                .toList();
    }

    //Encontrar por ID
    public PessoaEntity findById(Integer id) throws RegraDeNegocioException {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("PessoaEntity não encontrada!"));
    }

    //Encontrar por CPF
    public PessoaEntity findByCpf(String cpf) throws RegraDeNegocioException {
        return pessoaRepository.findByCpf(cpf).stream().findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("PessoaEntity não encontrada!"));
    }

    //Encontrar por Nome
    public List<PessoaDTO> listByName(String nome) {
        return pessoaRepository.findAll().stream()
                .filter(pessoa -> pessoa.getNome().toUpperCase().contains(nome.toUpperCase()))
                .map(PessoaMapper::pessoaToPessoaResponseDto)
                .collect(Collectors.toList());
    }

    public PessoaDTO getById(Integer id) throws RegraDeNegocioException {
        return PessoaMapper.pessoaToPessoaResponseDto(findById(id));
    }

    public PessoaDTO getByCpf(String cpf) throws RegraDeNegocioException {
        return PessoaMapper.pessoaToPessoaResponseDto(findByCpf(cpf));
    }

    public PessoaDTO update(Integer id, PessoaCreateDTO pessoaDto) throws Exception {

        PessoaEntity pessoaEntityRecuperada = findById(id);

        pessoaEntityRecuperada.setCpf(pessoaDto.getCpf());
        pessoaEntityRecuperada.setNome(pessoaDto.getNome());
        pessoaEntityRecuperada.setDataNascimento(pessoaDto.getDataNascimento());
        pessoaEntityRecuperada.setEmail(pessoaDto.getEmail());
        PessoaDTO updatedPessoa = PessoaMapper.pessoaToPessoaResponseDto(pessoaEntityRecuperada);
        emailService.sendEmail(updatedPessoa, "Seus dados foram alterados!", EmailTemplates.EDITAR_CONTA);
        log.info("E-mail enviado!");
        return updatedPessoa;
    }


    public void delete(Integer id) throws Exception {
        if (!propertieReader.getAdmin()) throw new RegraDeNegocioException("Não é possível deletar pessoas sem ser o administrador");
        try {
            PessoaEntity pessoaEntityRecuperada = findById(id);
            pessoaRepository.delete(pessoaEntityRecuperada);
            emailService.sendEmail(PessoaMapper.pessoaToPessoaResponseDto(pessoaEntityRecuperada), "Sua conta foi deletada!", EmailTemplates.DELETAR_CONTA);
            log.info("E-mail enviado!");
        } catch (EntidadeNaoEncontradaException ex) {
            ex.printStackTrace();
        }
    }

    public void delete(String cpf) throws Exception {
        if (!propertieReader.getAdmin()) throw new RegraDeNegocioException("Não é possível deletar pessoas sem ser o administrador");
        try {
            PessoaEntity pessoaEntityRecuperada = findByCpf(cpf);
            pessoaRepository.delete(pessoaEntityRecuperada);
            emailService.sendEmail(PessoaMapper.pessoaToPessoaResponseDto(pessoaEntityRecuperada), "Sua conta foi deletada!", EmailTemplates.DELETAR_CONTA);
            log.info("E-mail enviado!");
        } catch (EntidadeNaoEncontradaException ex) {
            ex.printStackTrace();
        }
    }

    public PessoaDTO getPessoaDTO(Integer id) throws Exception {
        return getById(id);
    }
}
