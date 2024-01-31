package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.entity.TipoPet;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.Data;

@Data
public class PetCreateDTO {

    @Hidden
    private Integer idPet;

    private String nome;

    private TipoPet tipo;

    private Integer idPessoa;

}
