package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.TipoPet;
import lombok.Data;

@Data
public class PetDTO {

    private Integer idPet;

    private String nome;

    private TipoPet tipo;

    private PessoaDTO pessoa;

}
