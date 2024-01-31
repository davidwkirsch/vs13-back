package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.ProfessorCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ProfessorDTO;
import br.com.dbc.vemser.pessoaapi.dto.mapper.ProfessorMapper;
import br.com.dbc.vemser.pessoaapi.entity.ProfessorEntity;
import br.com.dbc.vemser.pessoaapi.entity.ProfessorPK;
import br.com.dbc.vemser.pessoaapi.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    public List<ProfessorEntity> findAll() throws Exception{
        return professorRepository.findAll();
    }

    public List<ProfessorDTO> getAll() throws Exception {
        return findAll().stream().map(ProfessorMapper::toDTO).toList();
    }

    public ProfessorDTO save(ProfessorCreateDTO professorEntity) {
        return ProfessorMapper.toDTO(professorRepository.save(ProfessorMapper.toEntity(professorEntity)));
    }

    public ProfessorDTO update(ProfessorCreateDTO professorEntity) {
        ProfessorEntity professor = professorRepository.findByProfessorPK(professorEntity.getProfessorPK());
        professor.setNome(professorEntity.getNome());
        professor.setSalario(professorEntity.getSalario());
        return ProfessorMapper.toDTO(professorRepository.save(professor));
    }

    public ProfessorEntity findById(ProfessorPK id) {
        return professorRepository.findById(id).orElse(null);
    }

    public ProfessorDTO getById(ProfessorPK id) {
        return ProfessorMapper.toDTO(findById(id));
    }

    public List<ProfessorEntity> listByName(String nome) {
        return professorRepository.findByNomeContainsIgnoreCase(nome);
    }

    public List<ProfessorDTO> getByName(String nome) {
        return listByName(nome).stream().map(ProfessorMapper::toDTO).collect(Collectors.toList());
    }
    public void deleteById(Integer idProfessor, Integer idUniversidade) {
        professorRepository.deleteById(new ProfessorPK(idProfessor, idUniversidade));
    }


}
