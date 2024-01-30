package br.com.dbc.vemser.pessoaapi.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum EmailTemplates {
    BEM_VINDO("email-bem-vindo.ftl"),
    EDITAR_CONTA("email-conta-editada.ftl"),
    DELETAR_CONTA("email-conta-deletada.ftl"),
    ENDERECO_CRIADO("email-endereco-criado.ftl"),
    ENDERECO_EDITADO("email-endereco-editado.ftl"),
    ENDERECO_DELETADO("email-endereco-deletado.ftl");

    private final String fileName;

}

