package br.com.dbc.vemser.pessoaapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity(name = "ENDERECO_PESSOA")
public class EnderecoEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENDERECO_CONTATO_SEQ")
        @SequenceGenerator(name = "ENDERECO_CONTATO_SEQ", sequenceName = "seq_endereco_contato", allocationSize = 1)
        @Column(name = "id_endereco")
        private Integer idEndereco;

        @Enumerated(EnumType.ORDINAL)
        private TipoEndereco tipo;

        @Column(name = "logradouro")
        private String logradouro;

        @Column(name = "numero")
        private Integer numero;

        @Column(name = "complemento")
        private String complemento;

        @Column(name = "cep")
        private String cep;

        @Column(name = "cidade")
        private String cidade;

        @Column(name = "estado")
        private String estado;

        @Column(name = "pais")
        private String pais;

//        @JsonIgnore
        @ManyToMany(mappedBy = "enderecos", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
        private Set<PessoaEntity> pessoas;

}
