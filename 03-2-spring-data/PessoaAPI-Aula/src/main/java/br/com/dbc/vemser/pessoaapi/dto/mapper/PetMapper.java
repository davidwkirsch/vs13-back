package br.com.dbc.vemser.pessoaapi.dto.mapper;

import br.com.dbc.vemser.pessoaapi.dto.PetCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PetDTO;
import br.com.dbc.vemser.pessoaapi.entity.PetEntity;

public class PetMapper {

    public static PetDTO toDTO(PetEntity petEntity) {
        PetDTO petDTO = new PetDTO();
        petDTO.setIdPet(petEntity.getIdPet());
        petDTO.setNome(petEntity.getNome());
        petDTO.setTipo(petEntity.getTipo());
        petDTO.setPessoa(PessoaMapper.pessoaToPessoaResponseDto(petEntity.getPessoa()));
        return petDTO;
    }

    public static PetEntity toEntity(PetCreateDTO petDTO) {
        PetEntity petEntity = new PetEntity();
        petEntity.setIdPet(petDTO.getIdPet());
        petEntity.setNome(petDTO.getNome());
        petEntity.setTipo(petDTO.getTipo());
        return petEntity;
    }
}
