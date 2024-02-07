package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@ToString
public class PessoaEnderecoDTO extends PessoaDTO {
    private Set<EnderecoEntity> enderecos;
}