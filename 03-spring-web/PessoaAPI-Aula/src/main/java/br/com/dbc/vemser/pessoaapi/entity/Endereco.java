package br.com.dbc.vemser.pessoaapi.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Endereco {


        @NotNull(message = "O id da pessoa não pode ser nulo")
        private Integer idPessoa;

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

    public Endereco(Integer idPessoa, Integer idEndereco, TipoEndereco tipo,
                    String logradouro, Integer numero, String complemento,
                    String cep, String cidade, String estado, String pais) {
        this.idPessoa = idPessoa;
        this.idEndereco = idEndereco;
        this.tipo = tipo;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }

    public Endereco() {
    }
    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public TipoEndereco getTipoEndereco() {
        return tipo;
    }

    public void setTipoEndereco(TipoEndereco tipo) {
        this.tipo = tipo;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
