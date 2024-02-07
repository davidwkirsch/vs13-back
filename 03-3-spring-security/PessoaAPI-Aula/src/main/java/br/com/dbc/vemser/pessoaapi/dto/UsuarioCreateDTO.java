package br.com.dbc.vemser.pessoaapi.dto;

import lombok.Data;

@Data
public class UsuarioCreateDTO {
    private String login;
    private String senha;
}