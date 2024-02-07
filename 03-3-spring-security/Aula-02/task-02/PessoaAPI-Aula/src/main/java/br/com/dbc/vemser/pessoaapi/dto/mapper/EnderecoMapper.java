package br.com.dbc.vemser.pessoaapi.dto.mapper;


import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaEnderecoDTO;
import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;

import java.util.HashSet;
import java.util.Set;

public class EnderecoMapper {

    public static EnderecoEntity createEnderecoDtoToEndereco(EnderecoCreateDTO enderecoCreateDTO) {
    EnderecoEntity enderecoEntity = new EnderecoEntity();
    enderecoEntity.setIdEndereco(enderecoCreateDTO.getIdEndereco());
    enderecoEntity.setTipo(enderecoCreateDTO.getTipo());
    enderecoEntity.setLogradouro(enderecoCreateDTO.getLogradouro());
    enderecoEntity.setNumero(enderecoCreateDTO.getNumero());
    enderecoEntity.setComplemento(enderecoCreateDTO.getComplemento());
    enderecoEntity.setCidade(enderecoCreateDTO.getCidade());
    enderecoEntity.setEstado(enderecoCreateDTO.getEstado());
    enderecoEntity.setCep(enderecoCreateDTO.getCep());
    enderecoEntity.setPais(enderecoCreateDTO.getPais());

    if (enderecoEntity.getPessoas() == null) {
        enderecoEntity.setPessoas(new HashSet<>());
    }
    enderecoEntity.getPessoas().add(enderecoCreateDTO.getPessoaEntity());

    return enderecoEntity;
}

    public static EnderecoDTO enderecoToEnderecoResponseDto(EnderecoEntity enderecoEntity) {
        EnderecoDTO enderecoDto = new EnderecoDTO();
        enderecoDto.setIdEndereco(enderecoEntity.getIdEndereco());
        enderecoDto.setTipo(enderecoEntity.getTipo());
        enderecoDto.setLogradouro(enderecoEntity.getLogradouro());
        enderecoDto.setNumero(enderecoEntity.getNumero());
        enderecoDto.setComplemento(enderecoEntity.getComplemento());
        enderecoDto.setCidade(enderecoEntity.getCidade());
        enderecoDto.setEstado(enderecoEntity.getEstado());
        enderecoDto.setCep(enderecoEntity.getCep());
        enderecoDto.setPais(enderecoEntity.getPais());
        return enderecoDto;
    }

    public static PessoaEnderecoDTO enderecoToPessoaEnderecoDto(EnderecoEntity enderecoEntity) {
        PessoaEnderecoDTO enderecoDto = new PessoaEnderecoDTO();
        enderecoDto.setIdPessoa(enderecoEntity.getPessoas().stream().map(PessoaEntity::getIdPessoa).findFirst().orElseThrow());
        enderecoDto.setNome(enderecoEntity.getPessoas().stream().map(PessoaEntity::getNome).findFirst().orElseThrow());
        enderecoDto.setDataNascimento(enderecoEntity.getPessoas().stream().map(PessoaEntity::getDataNascimento).findFirst().orElseThrow());
        enderecoDto.setCpf(enderecoEntity.getPessoas().stream().map(PessoaEntity::getCpf).findFirst().orElseThrow());
        enderecoDto.setEmail(enderecoEntity.getPessoas().stream().map(PessoaEntity::getEmail).findFirst().orElseThrow());
        enderecoDto.setEnderecos(Set.of(enderecoEntity));
        return enderecoDto;
    }

}
