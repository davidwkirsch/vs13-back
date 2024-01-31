package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.config.PropertieReader;
import br.com.dbc.vemser.pessoaapi.dto.*;
import br.com.dbc.vemser.pessoaapi.dto.mapper.PessoaMapper;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.exception.EntidadeNaoEncontradaException;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    private final PropertieReader propertieReader;
    private final EmailService emailService;


    //Listar todos
    public List<PessoaDTO> list() throws RegraDeNegocioException {
        return pessoaRepository.findAll().stream()
                .map(PessoaMapper::pessoaToPessoaResponseDto)
                .toList();
    }

    //Criar
    public PessoaDTO create(PessoaCreateDTO pessoa) throws Exception {
        PessoaEntity createdPessoaEntity = PessoaMapper.createPessoaDtoToPessoa(pessoa);
        PessoaDTO pessoaDTO = PessoaMapper.pessoaToPessoaResponseDto(pessoaRepository.save(createdPessoaEntity));
        emailService.sendEmail(pessoaDTO, "Seja bem vindo!", EmailTemplates.BEM_VINDO);
        log.info("E-mail enviado!");
        return pessoaDTO;
    }

    //Encontrar por ID
    public PessoaEntity findById(Integer id) throws RegraDeNegocioException {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada!"));
    }

    public PessoaDTO getById(Integer id) throws RegraDeNegocioException {
        return PessoaMapper.pessoaToPessoaResponseDto(findById(id));
    }

    //Encontrar por CPF
    public PessoaEntity findByCpf(String cpf) throws RegraDeNegocioException {
        return pessoaRepository.findByCpf(cpf).stream().findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada!"));
    }


    public List<PessoaEnderecoDTO> getByIdEndereco(Integer id) throws RegraDeNegocioException {
        if (id == null) {return pessoaRepository.findAll().stream().map(PessoaMapper::pessoaToPessoaEnderecoDto).toList();}
        return List.of(PessoaMapper.pessoaToPessoaEnderecoDto(findById(id)));
    }

    public List<PessoaContatoDTO> getByIdContato(Integer id) throws RegraDeNegocioException {
        if (id == null) {return pessoaRepository.findAll().stream().map(PessoaMapper::toPessoaContatoDto).toList();}
        return List.of(PessoaMapper.toPessoaContatoDto(findById(id)));
    }

    public List<PessoaPetDTO> getByIdPet(Integer id) throws RegraDeNegocioException {
        if (id == null) {return pessoaRepository.findAll().stream().map(PessoaMapper::toPessoaPetDto).toList();}
        return List.of(PessoaMapper.toPessoaPetDto(findById(id)));
    }

    public PessoaDTO getByCpf(String cpf) throws RegraDeNegocioException {
        return PessoaMapper.pessoaToPessoaResponseDto(findByCpf(cpf));
    }

    //Encontrar por Nome
    public List<PessoaDTO> listByName(String nome) {
        return pessoaRepository.findAllByNomeContainsIgnoreCase(nome).stream()
                .map(PessoaMapper::pessoaToPessoaResponseDto)
                .toList();
    }

    public PessoaDTO update(Integer id, PessoaCreateDTO pessoaDto) throws Exception {

        PessoaEntity pessoaEntityRecuperada = findById(id);

        pessoaEntityRecuperada.setCpf(pessoaDto.getCpf());
        pessoaEntityRecuperada.setNome(pessoaDto.getNome());
        pessoaEntityRecuperada.setDataNascimento(pessoaDto.getDataNascimento());
        pessoaEntityRecuperada.setEmail(pessoaDto.getEmail());
        pessoaRepository.save(pessoaEntityRecuperada);
        PessoaDTO updatedPessoa = PessoaMapper.pessoaToPessoaResponseDto(pessoaEntityRecuperada);
        //emailService.sendEmail(updatedPessoa, "Seus dados foram alterados!", EmailTemplates.EDITAR_CONTA);
        log.info("E-mail enviado!");
        return updatedPessoa;
    }

    public PessoaEntity save(PessoaEntity pessoaEntity) throws Exception {
        return pessoaRepository.save(pessoaEntity);
    }


    public void delete(Integer id) throws Exception {
        if (!propertieReader.getAdmin()) throw new RegraDeNegocioException("Não é possível deletar pessoas sem ser o administrador");
        PessoaEntity pessoaEntityRecuperada = findById(id);
        pessoaEntityRecuperada.setPets(null);
        pessoaRepository.save(pessoaEntityRecuperada);
        pessoaRepository.delete(pessoaEntityRecuperada);
//            emailService.sendEmail(PessoaMapper.pessoaToPessoaResponseDto(pessoaEntityRecuperada), "Sua conta foi deletada!", EmailTemplates.DELETAR_CONTA);
        log.info("E-mail enviado!");
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

    public List<PessoaDTO> getByDataNascimento(String dataInicio, String dataFinal) {

        return pessoaRepository.findAllByDataNascimentoGreaterThanAndDataNascimentoLessThan(LocalDate.parse(dataInicio), LocalDate.parse(dataFinal)).stream()
                .map(PessoaMapper::pessoaToPessoaResponseDto)
                .toList();
    }

}
