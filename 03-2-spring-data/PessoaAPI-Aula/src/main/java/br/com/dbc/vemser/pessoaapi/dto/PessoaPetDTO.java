package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.PetEntity;
import lombok.Data;

import java.util.Set;

@Data
public class PessoaPetDTO extends PessoaDTO {
    private Set<PetEntity> pets;
}
