package br.com.dbc.vemser.pessoaapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity(name = "ENDERECO_PESSOA")
public class EnderecoEntity {

        @Id
        private Integer idPessoa;
        private Integer idEndereco;
        private TipoEndereco tipo;
        private String logradouro;
        private Integer numero;
        private String complemento;
        private String cep;
        private String cidade;
        private String estado;
        private String pais;

}
