package br.com.dbc.vemser.pessoaapi.mapper;


import br.com.dbc.vemser.pessoaapi.dto.CreateEnderecoDto;
import br.com.dbc.vemser.pessoaapi.dto.ResponseEnderecoDto;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;

public class EnderecoMapper {

    public static Endereco createEnderecoDtoToEndereco(CreateEnderecoDto createEnderecoDto) {
        Endereco endereco = new Endereco();
        endereco.setIdPessoa(createEnderecoDto.getIdPessoa());
        endereco.setIdEndereco(createEnderecoDto.getIdEndereco());
        endereco.setTipo(createEnderecoDto.getTipo());
        endereco.setLogradouro(createEnderecoDto.getLogradouro());
        endereco.setNumero(createEnderecoDto.getNumero());
        endereco.setComplemento(createEnderecoDto.getComplemento());
        endereco.setCidade(createEnderecoDto.getCidade());
        endereco.setEstado(createEnderecoDto.getEstado());
        endereco.setCep(createEnderecoDto.getCep());
        endereco.setPais(createEnderecoDto.getPais());
        return endereco;
    }

    public static ResponseEnderecoDto enderecoToEnderecoResponseDto(Endereco endereco) {
        ResponseEnderecoDto responseEnderecoDto = new ResponseEnderecoDto();
        responseEnderecoDto.setIdPessoa(endereco.getIdPessoa());
        responseEnderecoDto.setIdEndereco(endereco.getIdEndereco());
        responseEnderecoDto.setTipo(endereco.getTipo());
        responseEnderecoDto.setLogradouro(endereco.getLogradouro());
        responseEnderecoDto.setNumero(endereco.getNumero());
        responseEnderecoDto.setComplemento(endereco.getComplemento());
        responseEnderecoDto.setCidade(endereco.getCidade());
        responseEnderecoDto.setEstado(endereco.getEstado());
        responseEnderecoDto.setCep(endereco.getCep());
        responseEnderecoDto.setPais(endereco.getPais());
        return responseEnderecoDto;
    }

}
