package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
import lombok.Data;

import java.util.Set;

@Data
public class PessoaEnderecoDTO extends PessoaDTO {
    private Set<EnderecoEntity> enderecos;
}