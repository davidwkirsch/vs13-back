package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.TipoEndereco;
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
public class CreateEnderecoDto {

        @NotNull(message = "O id da pessoa não pode ser nulo")
        private Integer idPessoa = 0;

        @NotNull(message = "O id do endereço não pode ser nulo")
        private Integer idEndereco = 0;

        @NotNull(message = "O tipo de endereço não pode ser nulo")
        private TipoEndereco tipo;

        @NotBlank(message = "O logradouro não pode ser em branco")
        @Size(max = 250, message = "O logradouro não pode ter mais de 250 caracteres")
        private String logradouro;

        @NotNull(message = "O número não pode ser nulo")
        private Integer numero;

        @NotNull(message = "O complemento não pode ser nulo")
        private String complemento;

        
        @NotBlank (message = "O CEP não pode ser em branco")
        @Pattern(regexp = "\\d{8}", message = "O CEP deve conter 8 dígitos")
        private String cep;

        @NotBlank(message = "A cidade não pode ser em branco")
        @Size(max = 250, message = "O logradouro não pode ter mais de 250 caracteres")
        private String cidade;

        @NotBlank(message = "O estado não pode ser em branco")
        private String estado;

        @NotBlank(message = "O país não pode ser em branco")
        private String pais;

}
