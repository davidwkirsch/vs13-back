package br.com.dbc.vemser.pessoaapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum TipoContato {
    RESIDENCIAL(1),
    COMERCIAL(2);

    private final Integer tipo;

    public static TipoContato ofTipo(Integer tipo){
        return Arrays.stream(TipoContato.values())
                .filter(tp -> tp.getTipo().equals(tipo))
                .findFirst()
                .orElse(null);
    }
}
