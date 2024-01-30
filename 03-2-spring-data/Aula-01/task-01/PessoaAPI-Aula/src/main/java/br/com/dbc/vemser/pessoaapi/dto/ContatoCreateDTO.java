package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.TipoContato;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(description = "Objeto de criação de ContatoEntity")
public class ContatoCreateDTO {

    @Schema(description = "Id do ContatoEntity", hidden = true, example = "1")
    @NotNull(message = "O id do contato não pode ser nulo")
    private Integer idContato = 0;

    @Schema(description = "Id da PessoaEntity", required = true, example = "1")
    @NotNull(message = "O id da pessoa não pode ser nulo")
    private Integer idPessoa;

    @Schema(description = "Tipo do ContatoEntity", required = true, example = "COMERCIAL")
    @NotNull(message = "O tipo de contato não pode ser nulo")
    private TipoContato tipoContato;

    @Schema(description = "Número do ContatoEntity", required = true, example = "11999999999")
    @NotBlank(message = "O número não pode ser em branco")
    @Pattern(regexp = "\\d+", message = "O número deve conter apenas dígitos")
    @Size(max = 13, message = "O número deve conter no máximo 13 dígitos")
    private String numero;

    @Schema(description = "Descrição do ContatoEntity", required = true, example = "Telefone comercial")
    @Size(max = 200, message = "A descrição não pode ter mais de 200 caracteres")
    @NotBlank(message = "A descrição não pode ser vazia ou nula")
    private String descricao;

}
