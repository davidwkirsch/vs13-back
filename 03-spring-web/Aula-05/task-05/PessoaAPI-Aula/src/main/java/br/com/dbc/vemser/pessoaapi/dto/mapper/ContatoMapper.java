package br.com.dbc.vemser.pessoaapi.dto.mapper;

import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Contato;

public class ContatoMapper {

    public static Contato createContatoDtoToContato(ContatoCreateDTO contatoCreateDTO) {
        Contato contato = new Contato();
        contato.setIdContato(contatoCreateDTO.getIdContato());
        contato.setIdPessoa(contatoCreateDTO.getIdPessoa());
        contato.setTipoContato(contatoCreateDTO.getTipoContato());
        contato.setNumero(contatoCreateDTO.getNumero());
        contato.setDescricao(contatoCreateDTO.getDescricao());
        return contato;
    }

    public static ContatoDTO contatoToContatoResponseDto(Contato contato) {
        ContatoDTO contatoDto = new ContatoDTO();
        contatoDto.setIdContato(contato.getIdContato());
        contatoDto.setIdContato(contato.getIdContato());
        contatoDto.setIdPessoa(contato.getIdPessoa());
        contatoDto.setTipoContato(contato.getTipoContato());
        contatoDto.setNumero(contato.getNumero());
        contatoDto.setDescricao(contato.getDescricao());
        return contatoDto;
    }
}
