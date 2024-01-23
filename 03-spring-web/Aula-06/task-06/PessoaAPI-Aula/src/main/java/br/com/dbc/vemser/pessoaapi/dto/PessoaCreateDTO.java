package br.com.dbc.vemser.pessoaapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PessoaCreateDTO {

    @NotNull(message = "O id da pessoa não pode ser nulo")
    private Integer idPessoa = 0;

    @Pattern(regexp = "^[a-zA-Z ]*$", message = "O nome deve conter apenas letras")
    @NotBlank(message = "O nome da pessoa não pode ser vazio nem nulo")
    private String nome;

    @Past(message = "A data de nascimento deve ser uma data passada")
    @NotNull(message = "A data de nascimento não pode ser nula")
    private LocalDate dataNascimento;

    @CPF(message = "O CPF deve ser válido")
    @NotNull(message = "O CPF não pode ser nulo")
    private String cpf;

    @Email(message = "O e-mail deve ser válido")
    private String email;

}
