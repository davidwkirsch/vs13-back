package br.com.dbc.vemser.pessoaapi.dto.mapper;

import br.com.dbc.vemser.pessoaapi.dto.DadosPessoaisDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDadosPessoaisDTO;

public class PessoaDadosPessoaisMapper {

    public static PessoaDadosPessoaisDTO mergeIntoPessoaDadosPessoaisDTO(PessoaDTO pessoa, DadosPessoaisDTO dadosPessoais) {
        PessoaDadosPessoaisDTO merged = new PessoaDadosPessoaisDTO();
        merged.setNome(pessoa.getNome());
        merged.setDataNascimento(pessoa.getDataNascimento());
        merged.setCpf(dadosPessoais.getCpf());
        merged.setEmail(pessoa.getEmail());
        merged.setRg(dadosPessoais.getRg());
        merged.setCnh(dadosPessoais.getCnh());
        merged.setNomeMae(dadosPessoais.getNomeMae());
        merged.setNomePai(dadosPessoais.getNomePai());
        merged.setTituloEleitor(dadosPessoais.getTituloEleitor());
        merged.setSexo(dadosPessoais.getSexo());
        return merged;
    }

    public static PessoaDadosPessoaisDTO mergeIntoPessoaDadosPessoaisDTO(PessoaDTO pessoa) {
        PessoaDadosPessoaisDTO merged = new PessoaDadosPessoaisDTO();
        merged.setNome(pessoa.getNome());
        merged.setDataNascimento(pessoa.getDataNascimento());
        merged.setCpf(pessoa.getCpf());
        merged.setEmail(pessoa.getEmail());
        return merged;
    }

    public static PessoaDadosPessoaisDTO mergeIntoPessoaDadosPessoaisDTO(DadosPessoaisDTO dadosPessoais) {
        PessoaDadosPessoaisDTO merged = new PessoaDadosPessoaisDTO();
        merged.setNome(dadosPessoais.getNome());
        merged.setCpf(dadosPessoais.getCpf());
        merged.setRg(dadosPessoais.getRg());
        merged.setCnh(dadosPessoais.getCnh());
        merged.setNomeMae(dadosPessoais.getNomeMae());
        merged.setNomePai(dadosPessoais.getNomePai());
        merged.setTituloEleitor(dadosPessoais.getTituloEleitor());
        merged.setSexo(dadosPessoais.getSexo());
        return merged;
    }
}
