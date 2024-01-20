package br.com.dbc.vemser.pessoaapi.mapper;

import br.com.dbc.vemser.pessoaapi.dto.CreatePessoaDto;
import br.com.dbc.vemser.pessoaapi.dto.ResponsePessoaDto;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;

public class PessoaMapper {
    public static Pessoa createPessoaDtoToPessoa(CreatePessoaDto createPessoaDto) {
        Pessoa pessoa = new Pessoa();
        pessoa.setIdPessoa(createPessoaDto.getIdPessoa());
        pessoa.setNome(createPessoaDto.getNome());
        pessoa.setDataNascimento(createPessoaDto.getDataNascimento());
        pessoa.setCpf(createPessoaDto.getCpf());
        return pessoa;
    }

    public static ResponsePessoaDto pessoaToPessoaResponseDto(Pessoa pessoa) {
        ResponsePessoaDto responsePessoaDto = new ResponsePessoaDto();
        responsePessoaDto.setIdPessoa(pessoa.getIdPessoa());
        responsePessoaDto.setNome(pessoa.getNome());
        responsePessoaDto.setDataNascimento(pessoa.getDataNascimento());
        responsePessoaDto.setCpf(pessoa.getCpf());
        return responsePessoaDto;
    }
}
