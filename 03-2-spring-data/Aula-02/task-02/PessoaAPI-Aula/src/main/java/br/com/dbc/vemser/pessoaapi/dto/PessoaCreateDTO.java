package br.com.dbc.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(description = "Objeto de criação de ContatoEntity")
public class PessoaCreateDTO {

    @Schema(description = "Id da PessoaEntity", hidden = true, example = "1")
    @NotNull(message = "O id da pessoa não pode ser nulo")
    private Integer idPessoa = 0;

    @Schema(description = "Nome da PessoaEntity", required = true, example = "David Kirsch")
    @Pattern(regexp = "^[a-zA-Z ]*$", message = "O nome deve conter apenas letras")
    @NotBlank(message = "O nome da pessoa não pode ser vazio nem nulo")
    private String nome;

    @Schema(description = "Data de nascimento da PessoaEntity", required = true, example = "1990-01-01")
    @Past(message = "A data de nascimento deve ser uma data passada")
    @NotNull(message = "A data de nascimento não pode ser nula")
    private LocalDate dataNascimento;

    @Schema(description = "CPF da PessoaEntity", required = true, example = "80709737068")
    @CPF(message = "O CPF deve ser válido")
    @NotNull(message = "O CPF não pode ser nulo")
    private String cpf;

    @Schema(description = "E-mail da PessoaEntity", required = true, example = "john_doe@example.com")
    @Email(message = "O e-mail deve ser válido")
    private String email;

}
