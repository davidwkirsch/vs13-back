package br.com.dbc.vemser.pessoaapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum CargosEnum {
    ROLE_ADMIN(1),
    ROLE_USUARIO(2),
    ROLE_MARKETING(3);

    private final Integer id;

}





