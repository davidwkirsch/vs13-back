package br.com.dbc.vemser.pessoaapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PessoaDadosPessoaisDTO {
    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    private String email;
    private String rg;
    private String cnh;
    private String nomeMae;
    private String nomePai;
    private String tituloEleitor;
    private Sexo sexo;

}

