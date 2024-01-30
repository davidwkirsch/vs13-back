package br.com.dbc.vemser.pessoaapi.dto.mapper;

import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;

public class PessoaMapper {
    public static Pessoa createPessoaDtoToPessoa(PessoaCreateDTO pessoaCreateDTO) {
        Pessoa pessoa = new Pessoa();
        pessoa.setIdPessoa(pessoaCreateDTO.getIdPessoa());
        pessoa.setNome(pessoaCreateDTO.getNome());
        pessoa.setDataNascimento(pessoaCreateDTO.getDataNascimento());
        pessoa.setCpf(pessoaCreateDTO.getCpf());
        return pessoa;
    }

    public static PessoaDTO pessoaToPessoaResponseDto(Pessoa pessoa) {
        PessoaDTO pessoaDto = new PessoaDTO();
        pessoaDto.setIdPessoa(pessoa.getIdPessoa());
        pessoaDto.setNome(pessoa.getNome());
        pessoaDto.setDataNascimento(pessoa.getDataNascimento());
        pessoaDto.setCpf(pessoa.getCpf());
        return pessoaDto;
    }
}
