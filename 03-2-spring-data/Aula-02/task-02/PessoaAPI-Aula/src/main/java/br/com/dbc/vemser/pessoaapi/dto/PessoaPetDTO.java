package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.PetEntity;
import lombok.Data;

@Data
public class PessoaPetDTO extends PessoaDTO {
    private PetEntity pets;
}
