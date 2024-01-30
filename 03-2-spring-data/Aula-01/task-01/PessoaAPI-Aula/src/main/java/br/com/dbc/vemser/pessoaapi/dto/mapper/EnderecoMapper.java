package br.com.dbc.vemser.pessoaapi.dto.mapper;


import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;

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

}
