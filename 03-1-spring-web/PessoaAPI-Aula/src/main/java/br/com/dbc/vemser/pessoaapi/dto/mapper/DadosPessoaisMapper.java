package br.com.dbc.vemser.pessoaapi.dto.mapper;

import br.com.dbc.vemser.pessoaapi.dto.DadosPessoaisDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDadosPessoaisDTO;

public class DadosPessoaisMapper {

    public static DadosPessoaisDTO pessoaDadosPessoaisDtoToDadosPessoaisDto(PessoaDadosPessoaisDTO pessoa) {
        DadosPessoaisDTO pessoaNova = new DadosPessoaisDTO();
        pessoaNova.setNome(pessoa.getNome());
        pessoaNova.setCpf(pessoa.getCpf());
        pessoaNova.setRg(pessoa.getRg());
        pessoaNova.setCnh(pessoa.getCnh());
        pessoaNova.setNomeMae(pessoa.getNomeMae());
        pessoaNova.setNomePai(pessoa.getNomePai());
        pessoaNova.setTituloEleitor(pessoa.getTituloEleitor());
        pessoaNova.setSexo(pessoa.getSexo());
        return pessoaNova;

    }
}
