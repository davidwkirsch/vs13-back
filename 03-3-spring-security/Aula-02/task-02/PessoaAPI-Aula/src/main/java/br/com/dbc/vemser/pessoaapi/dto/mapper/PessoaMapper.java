package br.com.dbc.vemser.pessoaapi.dto.mapper;

import br.com.dbc.vemser.pessoaapi.dto.*;
import br.com.dbc.vemser.pessoaapi.entity.ContatoEntity;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;

import java.util.Set;

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

    public static PessoaEnderecoDTO pessoaToPessoaEnderecoDto(PessoaEntity pessoaEntity) {
        PessoaEnderecoDTO pessoaDto = new PessoaEnderecoDTO();
        pessoaDto.setIdPessoa(pessoaEntity.getIdPessoa());
        pessoaDto.setNome(pessoaEntity.getNome());
        pessoaDto.setDataNascimento(pessoaEntity.getDataNascimento());
        pessoaDto.setCpf(pessoaEntity.getCpf());
        pessoaDto.setEmail(pessoaEntity.getEmail());
        pessoaDto.setEnderecos(pessoaEntity.getEnderecos());
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

    public static PessoaContatoDTO toPessoaContatoDto(ContatoEntity contatoEntity) {
        PessoaContatoDTO pessoaContatoDto = new PessoaContatoDTO();
        pessoaContatoDto.setIdPessoa(contatoEntity.getPessoaEntity().getIdPessoa());
        pessoaContatoDto.setNome(contatoEntity.getPessoaEntity().getNome());
        pessoaContatoDto.setDataNascimento(contatoEntity.getPessoaEntity().getDataNascimento());
        pessoaContatoDto.setCpf(contatoEntity.getPessoaEntity().getCpf());
        pessoaContatoDto.setEmail(contatoEntity.getPessoaEntity().getEmail());
        pessoaContatoDto.setContatos(Set.of(contatoEntity));
        return pessoaContatoDto;
    }

    public static PessoaContatoDTO toPessoaContatoDto(PessoaEntity pessoaEntity) {
        PessoaContatoDTO pessoaContatoDto = new PessoaContatoDTO();
        pessoaContatoDto.setIdPessoa(pessoaEntity.getIdPessoa());
        pessoaContatoDto.setNome(pessoaEntity.getNome());
        pessoaContatoDto.setDataNascimento(pessoaEntity.getDataNascimento());
        pessoaContatoDto.setCpf(pessoaEntity.getCpf());
        pessoaContatoDto.setEmail(pessoaEntity.getEmail());
        pessoaContatoDto.setContatos(pessoaEntity.getContatos());
        return pessoaContatoDto;
    }

    public static PessoaPetDTO toPessoaPetDto(PessoaEntity pessoaEntity) {
        PessoaPetDTO pessoaPetDto = new PessoaPetDTO();
        pessoaPetDto.setIdPessoa(pessoaEntity.getIdPessoa());
        pessoaPetDto.setNome(pessoaEntity.getNome());
        pessoaPetDto.setDataNascimento(pessoaEntity.getDataNascimento());
        pessoaPetDto.setCpf(pessoaEntity.getCpf());
        pessoaPetDto.setEmail(pessoaEntity.getEmail());
        pessoaPetDto.setPets(pessoaEntity.getPets());
        return pessoaPetDto;
    }

}
