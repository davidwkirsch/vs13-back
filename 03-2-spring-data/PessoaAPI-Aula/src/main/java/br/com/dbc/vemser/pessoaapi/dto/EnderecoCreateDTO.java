package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.TipoEndereco;
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
public class EnderecoCreateDTO {


        @Schema(description = "Id do Endereço (obrigatório somente ao editar)", example = "1")
        @NotNull(message = "O id do endereço não pode ser nulo")
        private Integer idEndereco = 0;

        @Schema(description = "Tipo do Endereço", required = true, example = "RESIDENCIAL")
        @NotNull(message = "O tipo de endereço não pode ser nulo")
        private TipoEndereco tipo;

        @Schema(description = "Logradouro do Endereço", required = true, example = "Rua dos Bobos")
        @NotBlank(message = "O logradouro não pode ser em branco")
        @Size(max = 250, message = "O logradouro não pode ter mais de 250 caracteres")
        private String logradouro;

        @Schema(description = "Número do Endereço", required = true, example = "0")
        @NotNull(message = "O número não pode ser nulo")
        private Integer numero;

        @Schema(description = "Complemento do Endereço", required = true, example = "Casa 1")
        @NotNull(message = "O complemento não pode ser nulo")
        private String complemento;

        @Schema(description = "CEP do Endereço", required = true, example = "00000000")
        @NotBlank (message = "O CEP não pode ser em branco")
        @Pattern(regexp = "\\d{8}", message = "O CEP deve conter 8 dígitos")
        private String cep;

        @Schema(description = "Cidade do Endereço", required = true, example = "São Paulo")
        @NotBlank(message = "A cidade não pode ser em branco")
        @Size(max = 250, message = "O logradouro não pode ter mais de 250 caracteres")
        private String cidade;

        @Schema(description = "Estado do Endereço", required = true, example = "São Paulo")
        @NotBlank(message = "O estado não pode ser em branco")
        private String estado;

        @Schema(description = "País do Endereço", required = true, example = "Brasil")
        @NotBlank(message = "O país não pode ser em branco")
        private String pais;

}
