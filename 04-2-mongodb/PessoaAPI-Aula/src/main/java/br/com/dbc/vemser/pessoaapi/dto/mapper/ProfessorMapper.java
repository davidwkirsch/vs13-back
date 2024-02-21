package br.com.dbc.vemser.pessoaapi.dto.mapper;

import br.com.dbc.vemser.pessoaapi.dto.ProfessorCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ProfessorDTO;
import br.com.dbc.vemser.pessoaapi.entity.ProfessorEntity;

public class ProfessorMapper {

    public static ProfessorDTO toDTO(ProfessorEntity professorEntity) {
        ProfessorDTO professorDTO = new ProfessorDTO();
        professorDTO.setProfessorPK(professorEntity.getProfessorPK());
        professorDTO.setNome(professorEntity.getNome());
        professorDTO.setSalario(professorEntity.getSalario());
        return professorDTO;
    }

    public static ProfessorEntity toEntity(ProfessorCreateDTO professorDTO) {
        ProfessorEntity professorEntity = new ProfessorEntity();
        professorEntity.setProfessorPK(professorDTO.getProfessorPK());
        professorEntity.setNome(professorDTO.getNome());
        professorEntity.setSalario(professorDTO.getSalario());
        return professorEntity;
    }

}
