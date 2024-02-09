package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.PetCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PetDTO;
import br.com.dbc.vemser.pessoaapi.dto.mapper.PetMapper;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.entity.PetEntity;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PetService {

    public final PetRepository petRepository;
    public final PessoaService pessoaService;

    public List<PetEntity> list() throws RegraDeNegocioException {
        return petRepository.findAll();
    }
    public PetDTO create(PetCreateDTO pet) throws RegraDeNegocioException {
        PetEntity petEntity = PetMapper.toEntity(pet);
        petEntity.setPessoa(pessoaService.findById(pet.getIdPessoa()));
        return PetMapper.toDTO(petRepository.save(petEntity));
    }

    public PetDTO update(PetCreateDTO pet) throws RegraDeNegocioException {
        PetEntity petEntity = PetMapper.toEntity(pet);
        petEntity.setPessoa(pessoaService.findById(pet.getIdPessoa()));
        return PetMapper.toDTO(petRepository.save(petEntity));
    }

    public void delete(Integer idPet) throws Exception {
        PetEntity petEntity = petRepository.getById(idPet);
        log.info("PetEntity recuperado: {}", petEntity);
        PessoaEntity pessoaEntityRecuperada = pessoaService.findById(petEntity.getPessoa().getIdPessoa());
        pessoaEntityRecuperada.setPets(null);
        petEntity.setPessoa(null);
        pessoaService.save(pessoaEntityRecuperada);
        petRepository.delete(petEntity);
    }
    public List<PetDTO> getAll() throws RegraDeNegocioException {
        return list().stream()
                .map(PetMapper::toDTO)
                .toList();
    }
}
