package br.com.dbc.vemser.pessoaapi.entity;

import javax.validation.constraints.*;

public class Contato {

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

    public Contato() {
    }

    public Contato(Integer idContato, Integer idPessoa, TipoContato tipoContato, String numero, String descricao) {
        this.idContato = idContato;
        this.idPessoa = idPessoa;
        this.tipoContato = tipoContato;
        this.numero = numero;
        this.descricao = descricao;
    }

    public Integer getIdContato() {
        return idContato;
    }

    public void setIdContato(Integer idContato) {
        this.idContato = idContato;
    }

    public TipoContato getTipoContato() {
        return tipoContato;
    }

    public void setTipoContato(TipoContato tipoContato) {
        this.tipoContato = tipoContato;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    @Override
    public String toString() {
        return "Contato{" +
                "idContato=" + idContato +
                ", idPessoa=" + idPessoa +
                ", tipoContato=" + tipoContato +
                ", numero='" + numero + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
