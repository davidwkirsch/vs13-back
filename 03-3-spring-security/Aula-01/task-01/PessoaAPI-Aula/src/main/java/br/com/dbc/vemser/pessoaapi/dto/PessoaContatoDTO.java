package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.ContatoEntity;
import lombok.*;

import java.util.Set;


@Getter
@Setter
@ToString
public class PessoaContatoDTO extends PessoaDTO {
    private Set<ContatoEntity> contatos;
}
