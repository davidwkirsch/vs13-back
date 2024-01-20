package br.com.dbc.vemser.pessoaapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponsePessoaDto {

    private Integer idPessoa;
    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
}
