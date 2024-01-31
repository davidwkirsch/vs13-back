package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.entity.TipoPet;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
public class PetDTO {

    private Integer idPet;

    private String nome;

    private TipoPet tipo;

    private PessoaDTO pessoa;

}
