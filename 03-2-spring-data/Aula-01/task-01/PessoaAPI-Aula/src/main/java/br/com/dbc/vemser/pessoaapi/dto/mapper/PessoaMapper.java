package br.com.dbc.vemser.pessoaapi.dto.mapper;

import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDadosPessoaisDTO;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;

public class PessoaMapper {
    public static PessoaEntity createPessoaDtoToPessoa(PessoaCreateDTO pessoaCreateDTO) {
        PessoaEntity pessoaEntity = new PessoaEntity();
        pessoaEntity.setIdPessoa(pessoaCreateDTO.getIdPessoa());
        pessoaEntity.setNome(pessoaCreateDTO.getNome());
        pessoaEntity.setDataNascimento(pessoaCreateDTO.getDataNascimento());
        pessoaEntity.setCpf(pessoaCreateDTO.getCpf());
        pessoaEntity.setEmail(pessoaCreateDTO.getEmail());
        return pessoaEntity;
    }

    public static PessoaDTO pessoaToPessoaResponseDto(PessoaEntity pessoaEntity) {
        PessoaDTO pessoaDto = new PessoaDTO();
        pessoaDto.setIdPessoa(pessoaEntity.getIdPessoa());
        pessoaDto.setNome(pessoaEntity.getNome());
        pessoaDto.setDataNascimento(pessoaEntity.getDataNascimento());
        pessoaDto.setCpf(pessoaEntity.getCpf());
        pessoaDto.setEmail(pessoaEntity.getEmail());
        return pessoaDto;
    }

    public static PessoaEntity pessoaDadosPessoaisToPessoaDto(PessoaDadosPessoaisDTO pessoa) {
        PessoaEntity pessoaEntityNova = new PessoaEntity();
        pessoaEntityNova.setNome(pessoa.getNome());
        pessoaEntityNova.setDataNascimento(pessoa.getDataNascimento());
        pessoaEntityNova.setCpf(pessoa.getCpf());
        pessoaEntityNova.setEmail(pessoa.getEmail());
        return pessoaEntityNova;
    }

    public static PessoaCreateDTO pessoaDadosPessoaisToPessoaCreateDto(PessoaDadosPessoaisDTO pessoa) {
        PessoaCreateDTO pessoaNova = new PessoaCreateDTO();
        pessoaNova.setNome(pessoa.getNome());
        pessoaNova.setDataNascimento(pessoa.getDataNascimento());
        pessoaNova.setCpf(pessoa.getCpf());
        pessoaNova.setEmail(pessoa.getEmail());
        return pessoaNova;
    }

}
