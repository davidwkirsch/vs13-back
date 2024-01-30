package br.com.dbc.vemser.pessoaapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Endereco {

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
