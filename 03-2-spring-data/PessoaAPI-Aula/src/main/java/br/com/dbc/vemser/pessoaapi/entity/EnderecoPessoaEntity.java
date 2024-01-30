package br.com.dbc.vemser.pessoaapi.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity(name = "PESSOA_X_PESSOA_ENDERECO")
public class EnderecoPessoaEntity {

    @Id
    @Column(name = "id_pessoa")
    private Integer idPessoa;

    @Column(name = "id_endereco")
    private Integer idEndereco;

}
