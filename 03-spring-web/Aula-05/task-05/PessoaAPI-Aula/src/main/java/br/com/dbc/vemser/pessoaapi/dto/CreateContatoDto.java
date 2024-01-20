package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.TipoContato;
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
public class CreateContatoDto {

    @NotNull(message = "O id do contato não pode ser nulo")
    private Integer idContato = 0;

    @NotNull(message = "O id da pessoa não pode ser nulo")
    private Integer idPessoa;

    @NotNull(message = "O tipo de contato não pode ser nulo")
    private TipoContato tipoContato;

    @NotBlank(message = "O número não pode ser em branco")
    @Pattern(regexp = "\\d+", message = "O número deve conter apenas dígitos")
    @Size(max = 13, message = "O número deve conter no máximo 13 dígitos")
    private String numero;

    @Size(max = 200, message = "A descrição não pode ter mais de 200 caracteres")
    @NotBlank(message = "A descrição não pode ser vazia ou nula")
    private String descricao;

}
