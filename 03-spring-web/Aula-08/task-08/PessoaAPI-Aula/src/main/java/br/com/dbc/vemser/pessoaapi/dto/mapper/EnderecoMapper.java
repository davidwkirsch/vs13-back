package br.com.dbc.vemser.pessoaapi.dto.mapper;


import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;

public class EnderecoMapper {

    public static Endereco createEnderecoDtoToEndereco(EnderecoCreateDTO enderecoCreateDTO) {
        Endereco endereco = new Endereco();
        endereco.setIdPessoa(enderecoCreateDTO.getIdPessoa());
        endereco.setIdEndereco(enderecoCreateDTO.getIdEndereco());
        endereco.setTipo(enderecoCreateDTO.getTipo());
        endereco.setLogradouro(enderecoCreateDTO.getLogradouro());
        endereco.setNumero(enderecoCreateDTO.getNumero());
        endereco.setComplemento(enderecoCreateDTO.getComplemento());
        endereco.setCidade(enderecoCreateDTO.getCidade());
        endereco.setEstado(enderecoCreateDTO.getEstado());
        endereco.setCep(enderecoCreateDTO.getCep());
        endereco.setPais(enderecoCreateDTO.getPais());
        return endereco;
    }

    public static EnderecoDTO enderecoToEnderecoResponseDto(Endereco endereco) {
        EnderecoDTO enderecoDto = new EnderecoDTO();
        enderecoDto.setIdPessoa(endereco.getIdPessoa());
        enderecoDto.setIdEndereco(endereco.getIdEndereco());
        enderecoDto.setTipo(endereco.getTipo());
        enderecoDto.setLogradouro(endereco.getLogradouro());
        enderecoDto.setNumero(endereco.getNumero());
        enderecoDto.setComplemento(endereco.getComplemento());
        enderecoDto.setCidade(endereco.getCidade());
        enderecoDto.setEstado(endereco.getEstado());
        enderecoDto.setCep(endereco.getCep());
        enderecoDto.setPais(endereco.getPais());
        return enderecoDto;
    }

}
