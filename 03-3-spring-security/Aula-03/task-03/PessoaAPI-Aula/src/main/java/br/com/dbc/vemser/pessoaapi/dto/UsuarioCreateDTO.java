package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.CargosEnum;
import lombok.Data;

import java.util.Set;

@Data
public class UsuarioCreateDTO {
    private String login;
    private String senha;
    private Set<CargosEnum> cargos;
}